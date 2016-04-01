package ActorMessaging

import akka.actor.{Props, ActorSystem}

/**
  * Created by gschiavon on 31/03/16.
  */
object DriverApp extends App {

  val system = ActorSystem("UniversityMessageSystem")
  val teacherRef = system.actorOf(Props[TeacherActor], "teacherActor")
  val student1Ref = system.actorOf(Props[StudentActor1], "studentActor1")
  val studentRef = system.actorOf(Props(new StudentActor(teacherRef, student1Ref)), "studentActor")
  studentRef ! InitSignal
  Thread.sleep(2000)
  system.shutdown

}
