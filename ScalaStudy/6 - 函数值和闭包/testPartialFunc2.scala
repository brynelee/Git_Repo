

object testPartialFunc2 extends App {

	// converts 1 to "one", etc., up to 5 

	val convert1to5 = new PartialFunction[Int, String] { 
		
		val nums = Array("one", "two", "three", "four", "five") 

		def apply(i: Int) = nums(i- 1) 

		def isDefinedAt( i: Int) = i > 0 && i < 6 

	} 

	// converts 6 to "six", etc., up to 10 

	val convert6to10 = new PartialFunction[Int, String] {

		val nums = Array("six", "seven", "eight", "nine", "ten") 

		def apply(i: Int) = nums( i- 6) 

		def isDefinedAt( i: Int) = i > 5 && i < 11 
	}

	//combine the above 2 functions into one using orElse
	val handle1to10 = convert1to5 orElse convert6to10

	println("input 3, output is " + handle1to10(3))
	println("input 8, output is " + handle1to10(8))

}
