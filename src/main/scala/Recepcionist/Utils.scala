package Recepcionist

/**
  * Created by gschiavon on 4/04/16.
  */
object Utils {

  val rooms = Map((1, "available"), (2, "not available") ,(3, "available"), (4, "not available"))

  def checkAvailability(roomReq: Int): Boolean = {
    var availability: Boolean = false
    rooms map (room => {
      if(room._1 == roomReq && room._2 == "available"){
        availability = true
      }
    })
    availability
  }
}
