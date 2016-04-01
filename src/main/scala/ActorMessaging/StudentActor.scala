package ActorMessaging

import akka.actor.{Actor, ActorRef}
import akka.actor.ActorLogging
/**
  * Created by gschiavon on 31/03/16.
  */
class StudentActor(teacherActorRef: ActorRef, studentActor1Ref: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case InitSignal => teacherActorRef ! QuoteRequest
    case QuoteResponse(quoteString) =>{
      log.info("Received QuoteResponse from teacher")
      log.info(s"Printing from student Actor $quoteString")
    studentActor1Ref ! TellFriends
    }
  }
}
case class InitSignal()

