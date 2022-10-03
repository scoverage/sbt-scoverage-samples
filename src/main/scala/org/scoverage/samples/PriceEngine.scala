package org.scoverage.samples

import akka.actor.{Cancellable, Actor}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

class PriceEngine(generator: QuoteGenerator) extends Actor {

  var cancellable: Cancellable = _

  def receive = {
    case StartService =>
      stop()

      val quoter: Runnable = () => {
          val quote = generator.generate
          context.system.eventStream.publish(quote)
        }

      cancellable =
        context.system.scheduler.scheduleWithFixedDelay(100 milliseconds, 100 milliseconds){quoter}

    case StopService =>
      stop()
  }

  def stop(): Unit = {
    if (cancellable != null)
      cancellable.cancel()
  }

  override def preStart(): Unit = {
    self ! StartService
  }
}
