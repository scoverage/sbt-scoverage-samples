package org.scoverage.samples

import akka.actor.Actor

class CreditEngine extends Actor {
  val MaxCredit = BigDecimal.valueOf(2000)

  def receive = { case req: CreditRequest =>
    println("Received a credit request")
    if (req.amount < MaxCredit)
      sender() ! CreditApprove(req.req, req.amount, req.client)
    else sender() ! CreditReject(req.req, req.client)
    if (System.currentTimeMillis < 0) {
      println("Don't want to see this invoked") // should not see this covered
    }
  }
}
