package org.scoverage.samples

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest
import akka.actor.{ActorSystem, Props}
import akka.pattern.{Patterns => TestImportAliasPatterns}
import scala.concurrent.duration._
import scala.concurrent.Await
import scala.language.postfixOps
import akka.testkit.TestProbe

class CreditEngineTest extends AnyFlatSpec with OneInstancePerTest {

  val quote = SpotQuote(
    Instrument("CVX", "Chevron"),
    Currency("USD"),
    BigDecimal.valueOf(49.99),
    BigDecimal.valueOf(49.99)
  )

  assert(getClass.getResource("/scroobius.txt") != null)

  val req =
    MarketOrderRequest(Instrument("CVX", "Chevron"), BigDecimal.valueOf(400))

  val system = ActorSystem("scales-test")
  val creditEngine = system.actorOf(Props(classOf[CreditEngine]))
  val client = TestProbe()(system)

  "a credit engine" should "approve amounts under the minimum" in {
    val future = TestImportAliasPatterns
      .ask(
        creditEngine,
        CreditRequest(BigDecimal.valueOf(1999), req, client.ref),
        2 seconds
      )
    Await.result(future, 2 seconds).asInstanceOf[CreditApprove]
  }

  it should "reject amounts over the min" in {
    val future = TestImportAliasPatterns
      .ask(
        creditEngine,
        CreditRequest(BigDecimal.valueOf(2001), req, client.ref),
        2 seconds
      )
    Await.result(future, 2 seconds).asInstanceOf[CreditReject]
  }
}
