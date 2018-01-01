//建立一个公共超类来方便
abstract class Trade()
case class Sell( stockSymbol: String, quantity: Int) extends Trade 
case class Buy( stockSymbol: String, quantity: Int) extends Trade 
case class Hedge( stockSymbol: String, quantity: Int) extends Trade

object testCaseMatch extends App {

	def processTrade (input: Trade) {

		input match {

			case Sell (stock, 1000) => println ("selling 1000-units of " + stock)
			case Sell (stock, quantity) => printf ("selling %d unit of %s.\n", quantity, stock)
			//带有过滤的case class过滤
			case Buy (stock, quantity) if (quantity > 2000) => printf("Buying %d (large) unit of %s. \n", quantity, stock )
			case Buy (stock, quantity) => printf("Buying %d unit of %s. \n", quantity, stock)
		}
	}

	//case类使用的时候如果没有参数就一定要有括号，否则会被判断为他的伴生对象
	processTrade(Sell("IBM", 1000))
	processTrade(Sell("Apple", 200))
	processTrade(Buy("Intel", 50000))
	processTrade(Buy("Adobe", 1500))
}

 