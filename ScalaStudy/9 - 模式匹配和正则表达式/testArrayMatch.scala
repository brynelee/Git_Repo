

object testArrayMatch extends App {

	//对坐标进行处理，假设输入类型为(a,b)整数对作为坐标，如果不是整数对，而是其他的对，会抛出异常
	def processCoordinates (input: Any) {

		input match {

			case (a, b) => printf ("the coordinates is (%d, %d) ...  ", a, b)
			case "done" => println ("done")
			case _ => null
		}
	}

	processCoordinates (10, -57)
	//这样的语句会抛出异常
	//processCoordinates ("string1", "string2")
	processCoordinates (90)
	processCoordinates ("done")

	println("=======================")
	println("=======================")


	//列表匹配
	def processItems(items: List[String]) {

		items match {

			case List("apple", "ibm") => println ("Apples and IBM")
			case List("red", "blue", "white") => println("Stars and Stripes")
			//使用_*来对其余内容进行匹配
			case List("red", "blue", _*) => println("colors red, blue, ...")
			//otherFruits是为了引用其余的内容创建的变量
			case List("apple", "orange", otherFruits @ _*) => println("apples, orange, and " + otherFruits)
		}
	}

	processItems(List("apple","ibm"))
	processItems(List("red","blue", "green"))
	
	//执行会抛异常
	//processItems(List("red","white","blue"))
	//正常执行
	processItems(List("red","blue","white"))
	
	processItems(List("apple","orange", "grape", "dates"))
}