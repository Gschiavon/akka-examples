package PassingList

import akka.actor.{Props, Actor}

/**
  * Created by gschiavon on 4/04/16.
  */
class StudentAct extends Actor {


  def receive = {
    case PassNotes(message) => {
      println("el padre es " + context.parent + s"y el mensaje $message")
      println("mi path es " + self.path)
    }
  }

}

case class PassNotes(message: String)
