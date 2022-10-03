package org.scoverage.samples

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest
import akka.actor.{ActorSystem, Props}
import akka.testkit.TestProbe

class OrderEngineTest extends AnyFlatSpec with OneInstancePerTest {

  val quote = SpotQuote(
    Instrument("CVX", "Chevron"),
    Currency("USD"),
    BigDecimal.valueOf(14.56),
    BigDecimal.valueOf(14.89)
  )

  val req = MarketOrderRequest(quote.instrument, BigDecimal.valueOf(400))

  val system = ActorSystem("scales-test")
  val creditEngine = TestProbe()(system)
  val client = TestProbe()(system)
  val orderEngine =
    system.actorOf(Props(classOf[OrderEngine], creditEngine.ref))

  "an order engine" should "create an order if credit approved" in {
    orderEngine ! CreditApprove(req, BigDecimal.valueOf(100), client.ref)
    client.expectMsgType[MarketOrderAccept]
  }

  it should "reject order if credit denied " in {
    orderEngine ! CreditReject(req, client.ref)
    client.expectMsgType[MarketOrderReject]
  }

  it should "send a credit request if a quote is available" in {
    orderEngine ! quote
    orderEngine ! req
    creditEngine.expectMsgType[CreditRequest]
  }

}
