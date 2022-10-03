package org.scoverage.samples

import org.scalatest.funsuite.AnyFunSuite

class SimpleObject2Test extends AnyFunSuite {

  test("invoking simpleobject2") {
    SimpleObject2.method1(3)
    SimpleObject2.method1(4)
  }
}
