package org.scoverage.samples

import akka.actor.{ActorRef, Actor}

class OrderEngine(creditEngine: ActorRef) extends Actor with QuoteCache {

  def receive: PartialFunction[Any, Unit] = behaviour orElse {

    case req: MarketOrderRequest =>
      // send a credit request only if we have a price for the instrument
      map.get(req.instrument) foreach (quote => {
        val amount = quote.ask * req.units
        creditEngine ! CreditRequest(amount, req, sender())
      })

    case approve: CreditApprove =>
      val order = Order(approve.req, approve.amount)
      approve.client ! MarketOrderAccept(order, approve.req)

    case reject: CreditReject =>
      reject.client ! MarketOrderReject(reject.req)
  }
}
