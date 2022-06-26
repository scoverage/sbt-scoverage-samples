package com.sksamuel.scoverage.samples

import akka.actor.Actor

/** @author Stephen Samuel */
trait QuoteCache {
  this: Actor =>

  val map = scala.collection.mutable.Map.empty[Instrument, SpotQuote]

  val behaviour: PartialFunction[Any, Unit] = {
    case quote: SpotQuote => map.put(quote.instrument, quote)
  }

  override def preStart(): Unit = {
    context.system.eventStream.subscribe(self, classOf[SpotQuote])
  }
}
