package com.sksamuel.scoverage.samples

import java.util.UUID

/** @author Stephen Samuel */
case class SpotQuote(instrument: Instrument,
                     currency: Currency,
                     bid: BigDecimal,
                     ask: BigDecimal)

case class Instrument(symbol: String,
                      name: String)

case class Currency(symbol: String)

case class Order(req: MarketOrderRequest,
                 amount: BigDecimal,
                 id: String = UUID.randomUUID.toString)

// testing that scoverage handles multiple packages in the same file
package subpackage1 {

case class SiegeException(msg: String) extends RuntimeException

}

package subpackage2 {

import com.sksamuel.scoverage.samples.subpackage1.SiegeException

class Castle(name: String) {
  def siege = throw new SiegeException("trebuchet explosion")
}

}