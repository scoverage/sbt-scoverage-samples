package org.scalescc.test

import java.util.UUID

/** @author Stephen Samuel */
case class RequestForQuote(instrument: Instrument, id: String = UUID.randomUUID.toString)
case class QuoteResponse(quote: SpotQuote, id: String = UUID.randomUUID.toString)
case class MarketOrderRequest(instrument: Instrument, units: BigDecimal, id: String = UUID.randomUUID.toString)
case class MarketOrderResponse(order: Option[Order], id: String = UUID.randomUUID.toString)