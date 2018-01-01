import akka.actor._ 

case object ActNormalMessage 
case object TryToFindSolution 
case object BadGuysMakeMeAngry 

class DavidBanner extends Actor {
	var counter = 0

	import context._ 
	
	def angryState: Receive = {
		case ActNormalMessage => 
			println("Phew, I' m back to being David.") 
			become(normalState) 
	} 

	def normalState: Receive = { 
		case TryToFindSolution => 
			println("Looking for solution to my problem ...") 
		case BadGuysMakeMeAngry => 
			println("I' m getting angry...") 
			become(angryState) 
	} 

	def receive = { 
		case BadGuysMakeMeAngry => 
			become(angryState) 
		case ActNormalMessage => 
			counter += 1
			println("I'm started with normal with counter of ..." + counter)
			become(normalState) 
	} 
} 

object BecomeHulkExample extends App { 
	val system = ActorSystem("BecomeHulkExample") 
	val davidBanner = system.actorOf(Props[DavidBanner], name = "DavidBanner") 
	davidBanner ! ActNormalMessage 
	// init to normalState 
	davidBanner ! TryToFindSolution 
	davidBanner ! BadGuysMakeMeAngry 
	Thread.sleep(1000) 
	davidBanner ! ActNormalMessage 
	system.terminate 
}

