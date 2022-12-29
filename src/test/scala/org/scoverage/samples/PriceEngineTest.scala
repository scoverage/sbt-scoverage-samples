package org.scoverage.samples

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest
import akka.actor.{ActorSystem, Props}
import akka.testkit.TestProbe

class PriceEngineTest extends AnyFlatSpec with OneInstancePerTest {

  val system = ActorSystem("scales-test")
  val priceEngine =
    system.actorOf(Props(classOf[PriceEngine], new RandomQuoteGenerator))
  val probe = TestProbe()(system)

  "a price engine" should "broadcast on startup" in {
    system.eventStream.subscribe(probe.ref, classOf[SpotQuote])
    probe.expectMsgType[SpotQuote]
  }

  it should "stop broadcasting on StopService msg" in {
    system.eventStream.subscribe(probe.ref, classOf[SpotQuote])
    priceEngine ! StopService
    Thread.sleep(2000) // enough time to shutdown
    probe.expectNoMessage()
  }

  it should "restart broadcasting on StartService message" in {
    system.eventStream.subscribe(probe.ref, classOf[SpotQuote])
    priceEngine ! StopService
    priceEngine ! StartService
    probe.expectMsgType[SpotQuote]
  }
}
