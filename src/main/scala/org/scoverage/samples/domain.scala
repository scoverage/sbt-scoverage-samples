import java.util.UUID

package org.scoverage.samples {

  case class SpotQuote(
      instrument: Instrument,
      currency: Currency,
      bid: BigDecimal,
      ask: BigDecimal
  )

  case class Instrument(symbol: String, name: String)

  case class Currency(symbol: String)

  case class Order(
      req: MarketOrderRequest,
      amount: BigDecimal,
      id: String = UUID.randomUUID.toString
  )
}

// testing that scoverage handles multiple packages in the same file
package subpackage1.exceptions {

  case class OrderException(msg: String) extends RuntimeException

}

package subpackage2.validators {

  import subpackage1.exceptions.OrderException

  class OrderValidator(name: String) {
    def validate = throw new OrderException("trebuchet explosion")
  }

}
