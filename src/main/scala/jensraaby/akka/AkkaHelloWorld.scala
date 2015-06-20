package jensraaby.akka

import akka.actor.{Props, ActorSystem, ActorLogging, Actor}

case class Greeting(who: String)

class GreetingActor extends Actor with ActorLogging {
  def receive = {
    case Greeting(who) => log.info("Hello " + who)
  }
}

object AkkaHelloWorld extends App {

  val system = ActorSystem("AkkaHelloWorld")
  val greeter = system.actorOf(Props[GreetingActor], name = "greeter")

  greeter ! Greeting("Charlie Parker")

}
