object FoldFuncDemo {

	def main (args: Array[String]) {

		val array = Array( 2, 3, 5, 1, 6, 4) 
		
		// val sum = array.fold(0) { (sum, elem) => sum + elem } //fold函数的原始调用方式
		val sum = (0 /: array) { (sum, elem) => sum + elem }  //fold函数的简化调用方式
		
		val max = (Integer. MIN_VALUE /: array) { (large, elem) => Math.max( large, elem) } 

		println(" Sum of elements in array " + array. toString() + " is " + sum) 
		println(" Max of elements in array " + array. toString() + " is " + max)
	}
}

