package org.scoverage.samples

import akka.actor.{ActorRef, Actor}
import scala.util.Random
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

class ClientActor(
  priceEngine: ActorRef,
  orderEngine: ActorRef
) extends Actor {

  val MinPrice = BigDecimal.valueOf(50)

  // testing for custom setters and getters
  private var _clientName: String = "DoIHaveAName?"
  def clientName = _clientName
  def clientName_=(n: String): Unit = _clientName = n
  clientName = "sammy"
  clientName = if (System.currentTimeMillis() < 0) "charlie" else "bobby"

  def receive = {
    case quote: SpotQuote =>
      if (quote.ask < MinPrice) {
        println("Sending order request")
        orderEngine ! MarketOrderRequest(
          quote.instrument,
          BigDecimal.valueOf(Random.nextInt(100))
        )
      }
    case r: MarketOrderReject =>
      println("Order was rejected :(" + r)
    case a: MarketOrderAccept =>
      println("Order was accepted :)" + a)
  }

  override def preStart(): Unit = {
    val quoter: Runnable = () =>
      priceEngine ! RequestForQuote(InstrumentLoader.randomInstrument)
    
    // ask for a quote every second for a random equity
    context.system.scheduler.scheduleWithFixedDelay(100 milliseconds, 1000 milliseconds){quoter} 
    ()
  }
}
