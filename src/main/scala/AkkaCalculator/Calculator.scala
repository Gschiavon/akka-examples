package AkkaCalculator

import AkkaCalculator.Calculator._
import akka.actor.{Props, ActorSystem, Actor}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.util.{Failure, Success}
import scala.concurrent._
import ExecutionContext.Implicits.global


/**
  * Created by gschiavon on 31/03/16.
  */
class Calculator extends Actor {

  def receive = {
    case sum(a,b) => sender ! sum(a,b)
    case sub(a,b) => sender ! sub(a,b)
    case prod(a,b) => sender ! prod(a,b)
    case div(a,b) => sender ! div(a,b)
  }

  def sum(a: Int, b: Int) = a+b
  def sub(a: Int, b: Int) = a-b
  def prod(a: Int, b: Int) = a*b
  def div(a: Int, b: Int) = a/b

}

object Calculator{
  case class sum(a: Int, b: Int)
  case class sub(a: Int, b: Int)
  case class prod(a: Int, b: Int)
  case class div (a: Int, b: Int)
}

object CalculatorTest extends App {
  implicit val timeout: Timeout = Timeout(3.seconds)
  val system = ActorSystem("Calculator")
  val calculate = system.actorOf(Props(new Calculator))
  val suma = (calculate ? sum (4,5)).mapTo[Int]


  suma.onComplete {
    case Success(x) => print(x)
    case Failure(ex) => throw new IllegalArgumentException(ex)
  }

}