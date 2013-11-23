package org.scalescc.test

import java.util.UUID

/** @author Stephen Samuel */
case class SpotQuote(instrument: Instrument,
                     currency: Currency,
                     bid: BigDecimal,
                     ask: BigDecimal)

case class Instrument(symbol: String,
                      name: String)

case class Currency(symbol: String)

object Currency {
  val USD = Currency("USD")
}

case class Order(req: MarketOrderRequest,
                 amount: BigDecimal,
                 id: String = UUID.randomUUID.toString)