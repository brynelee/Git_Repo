import scala.collection.parallel.immutable.ParVector

object testParVector extends App {

	//Single thread version first

	println ("normal version ...")

	val v = Vector.range (0, 10)
	v.foreach(print)
	println("===================")

	//parallel version of vector

	println("v.par version ...")
	v.par.foreach(print)
	println("===================")

	println ("Let's try the parallel version ParVector ...")

	val vPar = ParVector.range(0, 10)
	vPar.foreach { e => Thread.sleep(100); print(e)}
}