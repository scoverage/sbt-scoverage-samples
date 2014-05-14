package com.sksamuel.scoverage.samples

import akka.actor.{Props, ActorSystem}

/** @author Stephen Samuel */
object Platform extends App {

  val system = ActorSystem("scoverage-test")

  val priceEngine = system.actorOf(Props(classOf[PriceEngine], new RandomQuoteGenerator))
  val creditEngine = system.actorOf(Props[CreditEngine])
  val orderEngine = system.actorOf(Props(classOf[OrderEngine], creditEngine))

  val clients = for ( k <- 0 until 10 ) yield system.actorOf(Props(classOf[ClientActor], priceEngine, orderEngine))
}