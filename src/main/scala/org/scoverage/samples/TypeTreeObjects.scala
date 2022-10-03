package org.scoverage.samples

class TypeTreeObjects {
  class Container {
    def typeParamAndDefaultArg[C](name: String = "sammy"): String = name
  }
  new Container().typeParamAndDefaultArg[Any]()
}
