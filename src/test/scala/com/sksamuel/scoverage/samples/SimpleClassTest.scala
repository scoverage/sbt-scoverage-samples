package com.sksamuel.scoverage.samples

/** @author Stephen Samuel */

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest

// This test was added for clauses that show green when they were never executed.
class SimpleClassTest extends AnyFlatSpec with OneInstancePerTest {

  "a SimpleClassTest" should "test 1" in {
    val result = Await.result(SimpleObject.method(true, true), Duration(1, TimeUnit.SECONDS))
    assert(Some(true) === result)
  }
}
