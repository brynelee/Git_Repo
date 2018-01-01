object forTest extends App {

	//for的普通使用
	for (i <- 1 to 3) print("ho ")
	println()
	println ("=================")

	//for语句中的yield使用
	val result = for (i <- 1 to 10) yield i * 2
	println("the result set elements are " + result.mkString(", "))
	println ("=================")

	//使用generator和map对上面同样的实现
	val result2 = (1 to 10).map(_ * 2)
	println("the result2 set elements are " + result2.mkString(", "))
	println ("=================")

	//for中使用过滤功能
	val doubleEven = for (i <- 1 to 10; if i%2 == 0 ) yield i * 2
	println("the double even set elements are " + doubleEven.mkString(", "))
	println ("=================")


}