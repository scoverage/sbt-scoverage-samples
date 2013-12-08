package com.sksamuel.scoverage.samples

import scala.util.Random

/** @author Stephen Samuel */
trait QuoteGenerator {
  def generate: SpotQuote
}

class RandomQuoteGenerator extends QuoteGenerator {
  def generate: SpotQuote = SpotQuote(
    InstrumentLoader.randomInstrument,
    if (System.currentTimeMillis() == 0) new Currency("Flibble") else new Currency("USD"),
    BigDecimal.valueOf(Random.nextDouble * 100),
    BigDecimal.valueOf(Random.nextDouble * 100)
  )
}
