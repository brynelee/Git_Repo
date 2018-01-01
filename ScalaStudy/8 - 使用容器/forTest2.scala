class Person( val firstName: String, val lastName: String)

//用来验证不用new来创建Person实例的方法，即“类名（）”的方式调用apply方法
object Person{

	def apply(firstName: String, lastName: String): Person = new Person(firstName,lastName)

}

object forTest2 extends App {

	//初始化friends集合
	val friends = List(Person("Bryne", "Lee"), Person("Bill", "Lobig"), Person("Wu", "Wang"))

	//for语句的definition的使用，变量lastName在每次循环过程中被定义成一个val
	val lastNames = for (friend <- friends; lastName = friend.lastName) yield lastName

	println("The lastNames set elements are " + lastNames.mkString(", "))

}