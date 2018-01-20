import org.scalatest.FlatSpec
import org.scalatest.Assertions._

//use: "scalac -cp scalatest-app_2.12.4-3.0.4.jar StackSpec.scala" to compile
//use: "scala -cp scalatest-app_2.12.4-3.0.4.jar org.scalatest.run StackSpec" to run the test

class ListTest extends FlatSpec { 
	

	"A List" should "be empty if just initiated without adding anything" { 
		val left = 1
		val right = 1
		assert(left == right) 
	} 

	it should "be counted as 2 for added two items" { 
		val a = 5
		val b = 3
		assertResult(2) {
			a - b
		}
	} 
}

