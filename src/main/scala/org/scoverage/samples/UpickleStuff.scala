package org.scoverage.samples

import org.scoverage.samples.CustomPicklers.OptionPickler.{
  ReadWriter => RW,
  macroRW
}

object UpickleStuff {
  case class Person(
      name: String
  )

  object Person {
    implicit val rw: RW[Person] = macroRW
  }
}
