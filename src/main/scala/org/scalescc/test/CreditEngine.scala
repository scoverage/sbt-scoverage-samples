package org.scalescc.test

import akka.actor.Actor

/** @author Stephen Samuel */
class CreditEngine extends Actor {

  val MaxCredit = BigDecimal.valueOf(2000)

  def receive = {
    case req: CreditRequest =>
      println("Received credit request: " + req)
      if (req.amount < MaxCredit) sender ! CreditApprove(req.req, req.amount, req.client)
      else sender ! CreditReject(req.req, req.client)
  }
}
