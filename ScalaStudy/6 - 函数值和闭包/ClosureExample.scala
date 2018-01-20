
class Foo { 
	// a method that takes a function and a string, and passes the string into 
	// the function, and then executes the function 
	def exec(f:(String) => Unit, name: String) { 
		f(name) 
	} 
} 


object ClosureExample extends App {

	//hello这个变量就是被sayHello引用（不是参数），从而在sayHello在后续调用过程中可以影响其执行结果
	var hello = "Hello" 
	def sayHello(name: String) { 
		println(s"$hello, $name") 
	} 

	// execute sayHello from the exec method foo 
	val foo = new Foo 
	foo.exec(sayHello, "Al") 

	// change the local variable 'hello', then execute sayHello from 
	// the exec method of foo, and see what happens 
	hello = "Hola" 
	foo.exec(sayHello, "Lorenzo") 
}





