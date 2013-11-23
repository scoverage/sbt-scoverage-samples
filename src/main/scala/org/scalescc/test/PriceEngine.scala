package org.scalescc.test

import akka.actor.Actor

/**
 * Receives quotes and caches the latest quote for each instrument.
 * Can be queried for latest quote
 *
 * @author Stephen Samuel */
class PriceEngine extends Actor {
  val map = scala.collection.mutable.Map.empty[Instrument, SpotQuote]
  def receive = {
    case quote: SpotQuote => map.put(quote.instrument, quote)
    case rfq: RequestForQuote => map.get(rfq.instrument) foreach (sender ! QuoteResponse(_, rfq.id))
  }
}
