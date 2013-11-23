package org.scalescc.test

/** @author Stephen Samuel */
case class SpotQuote(instrument: Instrument, currency: Currency, bid: BigDecimal, ask: BigDecimal)
case class Instrument(symbol: String, name: String)
case class Currency(symbol: String, name: String)
object Currency {
  val USD = Currency("USD", "US Dollar")
}
case class Order(id: String, instrument: Instrument, units: BigDecimal, price: BigDecimal)