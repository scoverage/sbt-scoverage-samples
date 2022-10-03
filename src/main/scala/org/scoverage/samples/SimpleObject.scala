package org.scoverage.samples

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

object SimpleObject {

  private def getSomething = Future.successful(3)

  private def getOtherSomething = Future.successful(5)

  def method(input1: Boolean, input2: Boolean): Future[Option[Boolean]] = {
    for {
      b <-
        if (input1) getSomething
        else getOtherSomething // this else should not be covered
    } yield {
      if (input1 && input2) {
        Some(true)
      } else if (input1 && !input2) {
        Some(false) // this too
      } else {
        None // this too
      }
    }
  }

}
