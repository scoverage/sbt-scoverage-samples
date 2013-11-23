package org.scalescc.test

import akka.actor.{ActorRef, Actor}

/** @author Stephen Samuel */
class OrderEngine(creditEngine: ActorRef) extends Actor with QuoteCache {

  def receive: PartialFunction[Any, Unit] = behaviour orElse {

    case req: MarketOrderRequest =>
      println("Market Order Request: " + req)
      // send a credit request only if we have a price for the instrument
      map.get(req.instrument) foreach (quote => {
        val amount = quote.ask * req.units
        creditEngine ! CreditRequest(amount, req, sender)
      })

    case approve: CreditApprove =>
      println("Credit Approved: " + approve)
      val order = Order(approve.req, approve.amount)
      approve.client ! MarketOrderAccept(order, approve.req)

    case reject: CreditReject =>
      println("Credit Rejected: " + reject)
      reject.client ! MarketOrderReject(reject.req)
  }
}
