object testRegularExpression extends App {

	val pattern = "(S|s)cala".r
	var str = "Scala is a scalable and cool"
	
	//查找某个
	println(pattern findFirstIn str)

	//查找全部
	println((pattern findAllIn str).mkString(", "))

	//查找并replace
	println("cool".r replaceFirstIn(str, "awesome"))

	//使用正则表达式对象Regex作为提取器的例子
	val matchStock = """^(.+):(\d*\.\d+)""".r

	def process(input: String) {

		input match {

			case matchStock("GOOG", price) => println("Price of GOOG is " + price)
			case matchStock("IBM", price) => println("Price of IBM is " + price)
			case matchStock(symbol , price) => printf("The price of %s is %s.\n ", symbol, price)
			case _ => printf("The input of %s is not valid.\n", input)
		}
	}

	process("GOOG:126.34")
	process("IBM:185.24")
	process("INTEL:26.34")
	process("ATEST:34")
}