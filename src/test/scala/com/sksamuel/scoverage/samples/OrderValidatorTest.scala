package com.sksamuel.scoverage.samples

import org.scalatest.{FlatSpec, OneInstancePerTest}
import subpackage1.OrderException
import subpackage2.OrderValidator

/** @author Stephen Samuel */
class OrderValidatorTest extends FlatSpec with OneInstancePerTest {

  "an order validator" should "throw exception" in {
    val e = intercept[OrderException] {
      new OrderValidator("CreditSuisse").validate
    }
    assert(e != null)
  }
}
