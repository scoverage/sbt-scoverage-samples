package org.scoverage.samples

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest
import akka.actor.{ActorSystem, Props}
import akka.testkit.TestProbe
import scala.concurrent.duration._
import scala.language.postfixOps

class ClientActorTest extends AnyFlatSpec with OneInstancePerTest {

  val req =
    MarketOrderRequest(Instrument("CVX", "Chevron"), BigDecimal.valueOf(400))

  val system = ActorSystem("scales-test")
  val priceEngine = TestProbe()(system)
  val orderEngine = TestProbe()(system)
  val client = system.actorOf(
    Props(classOf[ClientActor], priceEngine.ref, orderEngine.ref)
  )

  "a client actor" should "ask for a quote" in {
    priceEngine.expectMsgType[RequestForQuote]
  }

  it should "send a market order request if ask under minimum" in {
    val quote = SpotQuote(
      Instrument("CVX", "Chevron"),
      Currency("USD"),
      BigDecimal.valueOf(49.99),
      BigDecimal.valueOf(49.99)
    )
    client ! quote
    orderEngine.expectMsgType[MarketOrderRequest]
  }

  it should "not send an order request if ask is over minimum" in {
    val quote = SpotQuote(
      Instrument("CVX", "Chevron"),
      Currency("USD"),
      BigDecimal.valueOf(50.01),
      BigDecimal.valueOf(50.01)
    )
    client ! quote
    orderEngine.expectNoMessage(2 seconds)
  }
}
