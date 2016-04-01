package PingPong

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage
/**
  * Created by gschiavon on 29/03/16.
  */
class Ping(pong: ActorRef) extends Actor {
  var count = 0
  def incrementAndPrint { count += 1; println("ping")}

  def receive = {
    case StartMessage =>
      pong ! PingMessage

    case PongMessage =>
      incrementAndPrint
      if (count > 99) {
        sender ! StopMessage
        println("pong stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }
  }
}

class Pong extends Actor {
  def receive = {
    case PingMessage =>
      println("  pong")
      sender ! PongMessage

    case StopMessage =>
      println("pong stopped")
      context.stop(self)
  }
}

object PingPongTest extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  ping ! StartMessage
}