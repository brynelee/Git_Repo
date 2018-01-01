class Cow {

	def ^(moon: Moon) = println("The Cow jumped over the Moon.")
}

class Moon {

	def ^:(cow: Cow) = println("This Cow jumped over the Moon too.")
}


object operatorTest extends App {

	val cow = new Cow
	val moon = new Moon

	cow ^ moon
	cow ^: moon //这个调用相当于moon.^:(cow)

}