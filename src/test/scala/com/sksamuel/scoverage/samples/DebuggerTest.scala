package com.sksamuel.scoverage.samples

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest

/** @author Stephen Samuel */
class DebuggerTest extends AnyFlatSpec with OneInstancePerTest {

  "a debugger" should "be parsed" in {
    Debugger.debug("Debug", "me", "for", "a", "greater", "good")
  }
}
