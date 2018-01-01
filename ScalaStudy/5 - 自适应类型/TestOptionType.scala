
/* 用来验证Option类型和它的子类Some和None*/

object TestOptionType {
   def main(args: Array[String]) {
      val a:Option[Int] = Some(5) //Some类型
      val b:Option[Int] = None   //None类型
      
      println("a.getOrElse(0): " + a.getOrElse(0) )
      println("b.getOrElse(10): " + b.getOrElse("the element is None.") )
   }
}