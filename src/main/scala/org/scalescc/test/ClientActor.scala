package org.scalescc.test

import akka.actor.{ActorRef, Actor}
import scala.util.Random
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/** @author Stephen Samuel */
class ClientActor(priceEngine: ActorRef, orderEngine: ActorRef) extends Actor {

  def receive = {
    case quote: SpotQuote =>
      println("Quote received: " + quote)
      if (Random.nextBoolean()) {
        orderEngine ! MarketOrderRequest(quote.instrument, BigDecimal.valueOf(Random.nextInt()))
      }
  }
  override def preStart(): Unit = {
    // ask for a quote every 500 millis
    context.system.scheduler.schedule(500 milliseconds, 500 milliseconds) {
      priceEngine ! RequestForQuote(InstrumentLoader.randomInstrument)
    }
  }
}
