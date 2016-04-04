package PassingList

import PassingList.DelegadoAct.{InitSystem}
import PassingList.TeacherAct.{RequestToTeacher, ResponseToStudent}
import akka.actor.{Props, ActorLogging, Actor, ActorRef}


/**
  * Created by gschiavon on 1/04/16.
  */
class DelegadoAct(actorRef: ActorRef) extends Actor with ActorLogging{

  val student = context.actorOf(Props[StudentAct], "student")


 val students = (1 to 10) map(i => context.actorOf(Props[StudentAct], s"student$i"))

  def receive = {
    case InitSystem => actorRef ! RequestToTeacher
    case ResponseToStudent(message) => {
      students map(_ ! PassNotes(message))
      log.info(s"The message is $message")

    }
  }
}

object DelegadoAct {
  case class InitSystem()
}
