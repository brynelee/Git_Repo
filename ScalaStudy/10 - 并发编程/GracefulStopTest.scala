import akka.actor._ 
import akka.pattern.gracefulStop 
import scala.concurrent.{ Await, ExecutionContext, Future} 
import scala.concurrent.duration._
import scala.language.postfixOps 

class TestActor extends Actor { 
	def receive = { 
		case _ => println(" TestActor got message") 
	} 
	override def postStop { println(" TestActor: postStop") } 

} 

object GracefulStopTest extends App { 
	val system = ActorSystem("GracefulStopTest") 
	val testActor = system.actorOf(Props[TestActor], name = "TestActor") 
	testActor ! "hello"
	Thread.sleep(1000)
	// try to stop the actor gracefully 
	try { 
		val stopped: Future[Boolean] = gracefulStop(testActor, 2 seconds, system) 
		Await.result(stopped, 3 seconds)
		println("testActor was stopped") 
	} catch { 
		case e: Exception => e.printStackTrace 
	} finally { 
		system.terminate 
	} 
}

