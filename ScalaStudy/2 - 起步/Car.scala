class Car( val year: Int) { 

	private var milesDriven: Int = 0 

	def miles() = milesDriven 

	def drive( distance: Int) { 

		milesDriven += Math.abs(distance) 

	} 

}

object Sample { 
	def main( args: Array[ String]) = {
		var car = new Car(10)
		println ("the car is of year " + car.year)
		car.drive(10)
		println ("the car has been driven for " + car.miles + " miles.")
	}
}




