package com.sksamuel.scoverage.samples

import org.scalatest.{FreeSpec, Matchers}

class CharmaxTest extends FreeSpec with Matchers {

  "a char max" - {
    "should not crash the XML writer" in {
      Charmax.foo('5') shouldBe true
    }
  }
}
