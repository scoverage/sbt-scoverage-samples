package org.scoverage.samples

import java.util.UUID
import akka.actor.ActorRef

case class RequestForQuote(
    instrument: Instrument,
    id: String = UUID.randomUUID.toString
)
case class MarketOrderRequest(
    instrument: Instrument,
    units: BigDecimal,
    id: String = UUID.randomUUID.toString
)
case class MarketOrderAccept(order: Order, req: MarketOrderRequest)
case class MarketOrderReject(request: MarketOrderRequest)
case object StartService
case object StopService
case class CreditRequest(
    amount: BigDecimal,
    req: MarketOrderRequest,
    client: ActorRef
)
case class CreditApprove(
    req: MarketOrderRequest,
    amount: BigDecimal,
    client: ActorRef
)
case class CreditReject(req: MarketOrderRequest, client: ActorRef)
