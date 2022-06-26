package com.sksamuel.scoverage.samples

import org.scalatest.FunSuite

/** @author Stephen Samuel */
class SimpleObject2Test extends FunSuite {

  test("invoking simpleobject2") {
    SimpleObject2.method1(3)
    SimpleObject2.method1(4)
  }
}
