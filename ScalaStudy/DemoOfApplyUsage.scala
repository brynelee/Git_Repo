class ApplyOperation {

}

class ApplyTest{
    def apply() = println("This is the apply() method in the class ApplyTest.")
    def haveATry: Unit ={
        println("have a try on apply in the class method.")
    }
}

object ApplyTest{
     def apply() = {
          println("This is the apply() method in the object ApplyTest")
        new ApplyTest
     }
}

object ApplyOperation{
     def main (args: Array[String]) {
        val array= Array(1,2,3,4)
        val a = ApplyTest() //这里就是使用object 的使用

         a.haveATry

         a() // 这里就是 class 中 apply使用
    }
}