import java.io._ 

object WriteToFile extends App {

	val writer = new PrintWriter(new File("symbols.txt")) 
	writer write "AAPL" 
	writer.close()

}



