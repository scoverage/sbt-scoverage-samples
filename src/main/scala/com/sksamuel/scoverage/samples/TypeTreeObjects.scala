package com.sksamuel.scoverage.samples

/** @author Stephen Samuel */
class TypeTreeObjects {
  class Container {
    def typeParamAndDefaultArg[C](name: String = "sammy"): String = name
  }
  new Container().typeParamAndDefaultArg[Any]()
}
