class EquipmentA(val routineA: Int => Int) {
	
	def simulate (input: Int) = {

		println("Running simulation ...")
		routineA(input)
	}
}

class EquipmentB(val routineB: (Int, Int) => Unit) {
	
	def simulate (input1: Int, input2: Int) = {

		println("Running simulation ...")
		routineB(input1, input2)
	}
}

object ReuseFuncValue extends App {

	val calculatorA = {input: Int => println("calculation with " + input); input}

	val equipment1 = new EquipmentA(calculatorA)

	equipment1.simulate(4)

	//注意使用val calculatorB的函数值定义方式，和def的定义方式，效果类似。
	//def定义的calculatorB也是一个对于该函数值的引用
	//val calculatorB = {(input1:Int, input2: Int) => println("calculatorB with input1: " + input1 + " input2: " + input2)}
	def calculatorB(input1: Int, input2: Int) = {
		println("calculatorB with input1: " + input1 + " input2: " + input2)
	}

	val equipment2 = new EquipmentB(calculatorB)

	equipment2.simulate(6, 7)
}