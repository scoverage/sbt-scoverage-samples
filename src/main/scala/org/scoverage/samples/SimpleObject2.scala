package org.scoverage.samples

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

/** https://github.com/scoverage/scalac-scoverage-plugin/issues/4
  */
object SimpleObject2 {

  def method1(input: Int): Unit = {
    for {
      auth <- method2(input)
    } yield auth match {
      case LoginSignupResult(Some(result), _, _, _) =>
        result
      case LoginSignupResult(_, Some(url), _, Some(session)) =>
        url
      case LoginSignupResult(_, Some(url), _, _) =>
        url
      case LoginSignupResult(_, _, Some(authUser), _) =>
        authUser
      case _ =>
        throw new RuntimeException("Unknown case")
        ""
    }
  }

  private def method2(input: Int): Future[LoginSignupResult] =
    Future(input match {
      case 1 => LoginSignupResult(Some("result"))
      case 2 => LoginSignupResult(None, Some("url"), None, Some("session"))
      case 3 => LoginSignupResult(None, Some("url"), None, None)
      case 4 => LoginSignupResult(None, None, Some("authuser"))
    })

  private case class LoginSignupResult(
      result: Option[String] = None,
      url: Option[String] = None,
      authUser: Option[String] = None,
      session: Option[String] = None
  ) {}

}
