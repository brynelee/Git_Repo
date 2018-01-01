object Symble {

	def unapply(symble: String): Boolean = symble == "GOOG" || symble == "IBM"

	//通常查询数据库，这里只支持GOOG和IBM
}

object ReceiveStockPrice {

	//返回对象是Option[(String, Double)]
	def unapply	(input: String): Option[(String, Double)] = {

		try {
			if (input contains ":"){
				val splitQuote = input split ":"
				Some(splitQuote(0),splitQuote(1).toDouble)
			}
			else{
				None
			}

		}catch{
			case _ : NumberFormatException => None
		}
	}
}

object testExtractor extends App {

	def process(input: String) {

		input match {

			//标识过滤器
			case Symble() => println ("Look up price for valid symble " + input)
			//标识:价格过滤器，其中使用了标识过滤器来对非法标识进行过滤，过滤相当于与的关系
			case ReceiveStockPrice(symble @Symble(), price) => printf("Received price %f for symble %s\n", price, symble)
			case _ => println ("invalid input " + input)
		}
	}

	process("GOOG")
	process("INTEL")
	process("IBM:187.55")
	process("GOOG:206.33")
	process("ERR:22.56")

}