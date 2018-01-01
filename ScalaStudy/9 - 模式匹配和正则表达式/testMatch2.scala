
object testMatch2 extends App {

	class Sample1 {

		val max = 100
		val MIN = 0

		def process(input: Int){

			input match {

				//使用this来限定max是作为字段引用，而不是模式变量
				case this.max => println("you matched max")
				//大写的MIN按照约定可以直接使用，作为常量
				case MIN => println("you matched MIN")
				case _ => println("unmatched")

			}
			
		}

	}

	val sampleMatchTest = new Sample1

	sampleMatchTest.process(100)
	sampleMatchTest.process(0)
	sampleMatchTest process 25
}