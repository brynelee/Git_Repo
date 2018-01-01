object testFuncDef extends App {
	
	//有等号，有返回值
	def aAndb(a:Int, b:Int)  = {
		a + b
	}

	val returnValue = aAndb(2,3)
	println("a + b = " + returnValue)

	//没有等号，只执行语句，返回（）
	def aAndb2(a:Int, b:Int)  {
		a + b
	}

	val returnValue2 = aAndb2(2,3)
	println("a + b = " + returnValue2)

	//简化到一行
	def aAndb4 (a:Int, b:Int) = a + b

	val returnValue4 = aAndb4(2,3)
	println("a + b = " + returnValue4)	


	//最简化写法
	val aAndb3 = (a:Int, b:Int) => a + b

	val returnValue3 = aAndb3(2,3)
	println("a + b = " + returnValue3)
}