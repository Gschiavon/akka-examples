package Recepcionist

import akka.actor.{Props, ActorRef, Actor}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.util.{Failure, Success}
import scala.concurrent._
import ExecutionContext.Implicits.global
/**
  * Created by gschiavon on 4/04/16.
  */
class Matriarca(actorRef: ActorRef) extends Actor{

  implicit val timeout: Timeout = Timeout(3.seconds)
  val family_members = (1 to 5) map (i => context.actorOf(Props[FamilyMember], s"familyMember$i"))
  def receive = {
    case InitSystem => val result = (actorRef ? AskForRoom(3)).mapTo[Boolean]
      result.onComplete {
        case Success(availability) =>
          family_members map (_ ! RoomAvailability(availability))
        case Failure(ex) => throw new IllegalStateException(ex)
      }
  }
}

case class InitSystem()
case class AskForRoom(room: Int)
case class RoomAvailability(availability: Boolean)
