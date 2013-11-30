package com.sksamuel.scoverage.samples

import scala.util.Random

/** @author Stephen Samuel */
trait QuoteGenerator {
  def generate: SpotQuote
}

class RandomQuoteGenerator extends QuoteGenerator {
  def generate: SpotQuote = SpotQuote(
    InstrumentLoader.randomInstrument,
    Currency.USD,
    BigDecimal.valueOf(Random.nextDouble() * 100),
    BigDecimal.valueOf(Random.nextDouble() * 100)
  )
}
