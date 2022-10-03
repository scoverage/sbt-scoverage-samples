package org.scoverage.samples

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.OneInstancePerTest

class SimpleClassTest extends AnyFlatSpec with OneInstancePerTest {

  "a SimpleClassTest" should "test 1" in {
    val result = Await.result(
      SimpleObject.method(true, true),
      Duration(1, TimeUnit.SECONDS)
    )
    assert(Some(true) === result)
  }
}
