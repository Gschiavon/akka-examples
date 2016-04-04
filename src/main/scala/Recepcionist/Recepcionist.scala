package Recepcionist

import akka.actor.Actor

/**
  * Created by gschiavon on 4/04/16.
  */
class Recepcionist extends Actor {

def receive = {
    case AskForRoom(room) => sender ! Utils.checkAvailability(room)
  }
}
