package com.sksamuel.scoverage.samples

import org.scalatest.{FlatSpec, OneInstancePerTest}
import subpackage1.exceptions.OrderException
import subpackage2.validators.OrderValidator

/** @author Stephen Samuel */
class OrderValidatorTest extends FlatSpec with OneInstancePerTest {

  "an order validator" should "throw exception" in {
    val e = intercept[OrderException] {
      new OrderValidator("CreditSuisse").validate
    }
    assert(e != null)
  }
}
