import scala.io.Source 

object ReadingFile extends App {

	println("*** The content of the file you read is:") 
	Source.fromFile("ReadingFile.scala").foreach { print } 

	//to get each line call getLines() on Source instance

}


