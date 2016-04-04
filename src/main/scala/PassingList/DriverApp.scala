package PassingList

import PassingList.DelegadoAct.InitSystem
import akka.actor.{Props, ActorSystem, Actor}
import scala.concurrent._


/**
  * Created by gschiavon on 1/04/16.
  */
object DriverAppPassingList extends App {

  val system = ActorSystem("Universidad")
  val teacherActor = system.actorOf(Props[TeacherAct], "teacherActor")
  val delegadoActor = system.actorOf(Props(new DelegadoAct(teacherActor)), "DelegadoActor")

  println(delegadoActor.path)
  println(teacherActor.path)
  delegadoActor ! InitSystem
  Thread.sleep(2000)
  system.shutdown
}
