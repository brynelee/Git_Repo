object testArrayMatch2 extends App {

	//类型匹配的例子
	def processTypes (input: Any) {

		input match {

			case (a: Int, b: Int) => println (" Processing (int, int) ...")
			case (a: Double, b: Double) => println ("Processing (double, double) ...")
			//卫述句guard if （msg > 1000000)的例子
			case msg: Int if (msg > 1000000) => println ("Processing int > 1000000 ...")
			case msg: Int => println("Process int ...")	
			case msg: String => println ("Process String ...")
			case _ => printf ("Can't process %s ...", input)
		}

	}

	processTypes((34.2, -59.3))
	processTypes(10,25)
	processTypes(520)
	processTypes("here I am")
	processTypes(10000001)
	processTypes(10,20.2)
	println ("===================")


}