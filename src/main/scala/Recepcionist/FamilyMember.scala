package Recepcionist

import akka.actor.Actor

/**
  * Created by gschiavon on 4/04/16.
  */
class FamilyMember extends Actor {

  def receive =
  {
    case RoomAvailability(availability) => println(s"Soy el hijo ${self.path} y la habitación esta libre: $availability")
  }
}
