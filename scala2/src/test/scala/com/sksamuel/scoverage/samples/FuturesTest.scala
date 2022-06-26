package com.sksamuel.scoverage.samples

import org.scalatest.{MustMatchers, FunSuite}
import scala.concurrent.Await
import scala.concurrent.duration._

/** @author Stephen Samuel */
class FuturesTest extends FunSuite with MustMatchers {

  lazy val futures = new Futures
  val timeout = 10.seconds

  import scala.concurrent.ExecutionContext.Implicits.global
  implicit val name = "sammy"

  test("futures happy path") {
    val person = new Person("sammy")
    Await.result(futures.insert(person), timeout).success mustEqual true
    Await.result(futures.insert(person), timeout).status mustEqual 421
  }

}

case class Person(name: String)
