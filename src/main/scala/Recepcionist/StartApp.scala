package Recepcionist

import akka.actor.{Props, ActorSystem}

/**
  * Created by gschiavon on 4/04/16.
  */
object StartApp extends App {
  val system = ActorSystem("RecepcionistProblem")
  val recepcionist = system.actorOf(Props[Recepcionist], "Recepcionist")
  val matriarca = system.actorOf(Props(new Matriarca(recepcionist)), "Matriarca")

  matriarca ! InitSystem
}
