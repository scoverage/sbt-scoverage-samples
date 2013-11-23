package org.scalescc.test

import akka.actor.{Props, ActorSystem}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/** @author Stephen Samuel */
object Platform extends App {

  val generator = new RandomQuoteGenerator
  val system = ActorSystem("scales-test")

  val priceEngine = system.actorOf(Props[PriceEngine])

  val clients = for ( k <- 0 until 10 ) yield system.actorOf(Props(classOf[ClientActor], priceEngine))


}
