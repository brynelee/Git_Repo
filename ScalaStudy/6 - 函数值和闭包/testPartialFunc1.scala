// converts 1 to "one", etc., up to 5 

object testPartialFunc1 extends App {

	val convertLowNumToString = new PartialFunction[Int, String] {
		val nums = Array("one", "two", "three", "four", "five") 
		def apply(i: Int) = nums(i- 1) 
		def isDefinedAt(i: Int) = i > 0 && i < 6 
	}

	println("input 3, output is " + convertLowNumToString(3))
	println("input 4, output is " + convertLowNumToString(4))
}
