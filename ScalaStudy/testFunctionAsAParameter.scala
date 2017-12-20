object testFunctionAsAParameter{

	def inject( arr: Array[ Int], initial: Int) (operation: (Int, Int) => Int) : Int = { //多个参数列表的写法
/*  def inject( arr: Array[ Int], initial: Int, operation: (Int, Int) => Int) : Int = { //一个参数列表的写法 */
		var carryOver = initial 
		arr.foreach( element => carryOver = operation(carryOver, element) )
		carryOver
	}

	def main (args: Array[String]){

		val arr = Array(1,2,3,4,5)
		/* val sum = inject(arr, 0, (carryOver, element) => carryOver + element) 一个参数列表的调用方法 */
		val sum = inject(arr, 0) {(carryOver, element) => carryOver + element}
		println ("The sum of the array " + arr.toString() + " is " + sum)
	
	}
}



