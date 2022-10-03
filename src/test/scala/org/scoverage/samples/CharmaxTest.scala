package org.scoverage.samples

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should._

class CharmaxTest extends AnyFreeSpec with Matchers {

  "a char max" - {
    "should not crash the XML writer" in {
      Charmax.foo('5') shouldBe true
    }
  }
}
