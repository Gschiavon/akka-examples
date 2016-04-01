package ActorMessaging

import akka.actor.Actor
import akka.actor.ActorLogging

/**
  * Created by gschiavon on 31/03/16.
  */
class StudentActor1 extends Actor with ActorLogging {

  def receive = {
    case TellFriends =>
      log.info(s"Yo, $self, he recibido los apuntes")
  }

}
case class TellFriends()