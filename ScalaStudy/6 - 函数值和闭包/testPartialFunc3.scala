object testPartialFunc3 extends App {
	
	val isEven = new PartialFunction[Int, String]{

		def apply(x: Int) = x + " is Even"
		def isDefinedAt(x: Int) = x % 2 == 0
	}

	val isOdd: PartialFunction[Int, String] = {

		case x if x % 2 == 1 => x + " is Odd"
	}

	val sample = 1 to 6

	val result = sample map (isEven orElse isOdd)

	result.foreach(println)
}