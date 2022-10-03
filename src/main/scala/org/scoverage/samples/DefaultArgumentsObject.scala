package org.scoverage.samples

/** An example Object which has some methods with default arguments.
  *
  * This does not take part in the sample application.
  */
object DefaultArgumentsObject {

  val defaultName = "world"

  def makeGreeting(name: String = defaultName): String = {
    s"Hello, $name"
  }
}
