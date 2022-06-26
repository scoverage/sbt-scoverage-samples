package com.sksamuel.scoverage.samples

import org.scalatest.{OneInstancePerTest, FlatSpec}

/** @author Stephen Samuel */
class DebuggerTest extends FlatSpec with OneInstancePerTest {

  "a debugger" should "be parsed" in {
    Debugger.debug("Debug", "me", "for", "a", "greater", "good")
  }
}
