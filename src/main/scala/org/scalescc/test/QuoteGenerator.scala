package org.scalescc.test

import scala.util.Random

/** @author Stephen Samuel */
trait QuoteGenerator {
  def generate: SpotQuote
}

class RandomQuoteGenerator extends QuoteGenerator {
  def generate: SpotQuote = SpotQuote(
    InstrumentLoader.randomInstrument,
    Currency.USD,
    BigDecimal.valueOf(Random.nextDouble()),
    BigDecimal.valueOf(Random.nextDouble())
  )
}
