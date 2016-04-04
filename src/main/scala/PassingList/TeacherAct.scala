package PassingList

import PassingList.TeacherAct.{RequestToTeacher, ResponseToStudent}
import akka.actor.Actor

/**
  * Created by gschiavon on 1/04/16.
  */
class TeacherAct extends Actor {

  def Message: String = "Hello MOFO"

  def receive = {
    case RequestToTeacher => sender ! ResponseToStudent(Message)

  }
}

object TeacherAct {
  case class ResponseToStudent(message: String)
  case class RequestToTeacher()
}