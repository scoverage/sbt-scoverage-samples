package org.scoverage.samples

import scala.util.Random
import scala.concurrent.Future

trait QuoteGenerator {
  def generate: SpotQuote
}

class RandomQuoteGenerator extends QuoteGenerator {

  def this(flibble: String) = {
    this()
    println("A fantastic constructor")
  }

  def generate: SpotQuote = {

    import scala.concurrent.ExecutionContext.Implicits.global
    // I want to test for loops, this seems like a good place to waste some cycles
    for {
      s <- Future.successful("mystery")
      t <- Future.successful("machine")
    } yield {
      "yield me"
    }

    SpotQuote(
      InstrumentLoader.randomInstrument,
      if (System.currentTimeMillis() == 0) new Currency("Flibble")
      else new Currency("USD"),
      BigDecimal.valueOf(Random.nextDouble() * 100),
      BigDecimal.valueOf(Random.nextDouble() * 100)
    )
  }
}
