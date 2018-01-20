import scala.io.Source 
import java.net.URL 

object ReadingURL extends App {

	val source = Source.fromURL(new URL("http://www.scala-lang.org/docu/files/api/index.html"))

	//println(source.getLine(3)) 

	val content = source.mkString

	val VersionRegEx = """[\D\S]+ scaladoc\s+\(version\s+(.+)\)[\D\S]+""".r 

	content match { 
		case VersionRegEx(version) => println(" Scala doc for version: " + version) 
	}
}


