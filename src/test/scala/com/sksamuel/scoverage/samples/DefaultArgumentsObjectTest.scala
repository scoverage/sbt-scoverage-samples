package com.sksamuel.scoverage.samples

/** @author Stephen Samuel */

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration._
import org.scalatest.{OneInstancePerTest, FlatSpec}

/**
 * Tests for the DefaultArgumentsObject class
 */
class DefaultArgumentsObjectTest extends FlatSpec with OneInstancePerTest {

  "DefaultArgumentsObject" should "execute the default block if no arg is given" in {
    val result = DefaultArgumentsObject.makeGreeting()
    assert(result === "Hello, world")
  }
}
