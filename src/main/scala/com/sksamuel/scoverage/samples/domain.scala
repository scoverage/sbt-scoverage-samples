import java.util.UUID

package com.sksamuel.scoverage.samples {

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
}

// testing that scoverage handles multiple packages in the same file
package subpackage1 {

case class OrderException(msg: String) extends RuntimeException

}

package subpackage2 {

import subpackage1.OrderException

class OrderValidator(name: String) {
  def validate = throw new OrderException("trebuchet explosion")
}

}