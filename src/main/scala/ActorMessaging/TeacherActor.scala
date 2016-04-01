package ActorMessaging

import akka.actor.{Actor, Props, ActorSystem}
import util.Random

/**
  * Created by gschiavon on 31/03/16.
  */
class TeacherActor extends Actor {

  val quotes =  List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")
  def receive = {
    case QuoteRequest =>
      val quotesResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
      sender ! quotesResponse
  }
}
case class QuoteRequest()
case class QuoteResponse(quote: String)
