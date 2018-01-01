
//通用编辑类

abstract class Writer { 
	def writeMessage( message: String) 
}

//两个trait，用来完成不同的功能

trait UpperCaseWriter extends Writer {

	abstract override def writeMessage (message: String) = {
		super.writeMessage(message.toUpperCase)
	}
}

trait ProfanityFilteredWriter extends Writer { 
	abstract override def writeMessage( message: String) = {
		super.writeMessage( message.replace("stupid", "s-----")) 
	}
	

}

//用来编辑实际的类

class StringWriterDelegate extends Writer {
	
	val writer = new java.io.StringWriter

	override def writeMessage (message: String) = writer.write(message)

	override def toString() : String = writer.toString
}

//执行对象
object WriterDemo {

	def main (args: Array[String]){

		val myWriterProfanityFirst = new StringWriterDelegate with UpperCaseWriter with ProfanityFilteredWriter

		val myWriterProfanityLast = new StringWriterDelegate with ProfanityFilteredWriter with UpperCaseWriter

		myWriterProfanityFirst writeMessage "There is no sin except stupidity"

		myWriterProfanityLast writeMessage "There is no sin except stupidity"

		println(myWriterProfanityFirst)
		println(myWriterProfanityLast)
	}
}