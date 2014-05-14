package com.sksamuel.scoverage.samples

import akka.actor.Actor
import com.typesafe.scalalogging.Logger
import com.typesafe.scalalogging.slf4j.StrictLogging

/** @author Stephen Samuel */
class CreditEngine extends Actor with StrictLogging {

  val MaxCredit = BigDecimal.valueOf(2000)

  def receive = {
    case req: CreditRequest =>
      logger.debug("Received a credit request")
      if (req.amount < MaxCredit) sender ! CreditApprove(req.req, req.amount, req.client)
      else sender ! CreditReject(req.req, req.client)
  }
}
