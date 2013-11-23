package org.scalescc.test

import akka.actor.{ActorRef, Actor}

/** @author Stephen Samuel */
class OrderEngine(priceEngine: ActorRef) extends Actor {

  def receive = {
    case req: MarketOrderRequest =>
      priceEngine ! RequestForQuote(req.instrument, req.id)
    case resp: QuoteResponse =>

  }
}
