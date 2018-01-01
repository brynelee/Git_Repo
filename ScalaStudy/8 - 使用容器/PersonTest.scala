class Person( val firstName: String, val lastName: String)



object PersonTest extends App {
	val person1 = new Person("Bryne", "Lee")
	println("The person's name is " + person1.firstName + " " + person1.lastName)
}

//用来验证不用new来创建Person实例的方法，即“类名（）”的方式调用apply方法
object Person{

	def apply(firstName: String, lastName: String): Person = new Person(firstName,lastName)

}

//用来验证List集合的head、last和索引的使用方式
object PersonTest2 extends App {
	val personList = List(Person("Bryne", "Lee"), Person("Bill", "Lobig"), Person("Wu", "Wang"))
	println("The 1st person's name is " + personList.head.firstName + " " + personList.head.lastName)
	println("The 2nd person's name is " + personList(1).firstName + " " + personList(1).lastName)
	println("The last person's name is " + personList.last.firstName + " " + personList.last.lastName)
}