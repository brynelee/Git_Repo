class Sample3 {

	
}


//此处使用了Java的Enumeration来生成枚举常量，但是需要定义object（单例对象）来继承使用
object DayOfWeek extends Enumeration { 
	
	val SUNDAY = Value("Sunday") 
	val MONDAY = Value("Monday") 
	val TUESDAY = Value("Tuesday") 
	val WEDNESDAY = Value("Wednesday")
	val THURSDAY = Value("Thursday") 
	val FRIDAY = Value("Friday") 
	val SATURDAY = Value("Saturday") 

}



object testMatch1 extends App {

	//此处=可以省略
	def activity (day: DayOfWeek.Value) {

		day match {

			case DayOfWeek.SUNDAY => print("Eat, Sleep, Repeat ...")
			case DayOfWeek.SATURDAY => print("Hang out with friends")
			case _ => print("... code for fun ...")
		}
	}

	activity(DayOfWeek.SUNDAY)
	activity(DayOfWeek.MONDAY)


}
