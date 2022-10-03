package org.scoverage.samples

import scala.concurrent.{Promise, Future, ExecutionContext}
import scala.language.implicitConversions

class Futures {

  import EitherMappableFuture._

  def insert[T](
      doc: T
  )(implicit name: String, executor: ExecutionContext): Future[Result] = {
    val promise = Promise[Result]()
    Future {
      Thread.sleep(300)
    }.onComplete { case _ =>
      promise.success(Result(true, 421))
    }
    promise.future.mapEither(meaningful)
  }

  def check(result: Result): Either[Exception, Result] = Right(result)

  def meaningful(result: Result) = {
    check(result) match {
      case Left(e)  => Left(e)
      case Right(r) => Right(r)
    }
  }
}

case class Result(
    success: Boolean = true,
    status: Int = 200,
    timestamp: Long = System.currentTimeMillis
)

case class EitherMappableFuture[A](future: Future[A]) {
  def mapEither[E <: Throwable, B](
      f: A => Either[E, B]
  )(implicit ec: ExecutionContext): Future[B] = {
    future.flatMap(f(_) match {
      case Left(e)  => Future.failed(e)
      case Right(b) => Future.successful(b)
    })
  }
}
object EitherMappableFuture {
  implicit def futureToEitherMappable[A](
      future: Future[A]
  ): EitherMappableFuture[A] = EitherMappableFuture(future)
}
