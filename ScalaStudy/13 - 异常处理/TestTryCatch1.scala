object TestTryCatch1 extends App {


	def taxFor( amount: Double) : String = { 
		if (amount < 0) throw new IllegalArgumentException("Amount must be greater than zero") 
		if (amount < 0.1) throw new RuntimeException("Amount too small to be taxed") 
		if (amount > 1000000) throw new Exception("Amount too large...") 
		"Tax for $" + amount + " is $"+ amount * 0.08 
	} 


	for (amount <- List( 100.0, 0.09, -2.0, 1000001.0)) { 
		try { 
			println(taxFor(amount)) 
		} catch { 
			case ex: IllegalArgumentException => println( ex. getMessage()) 
			case ex: RuntimeException => { 
			// if you need a block of code to handle exception 
			println(" Don' t bother reporting..." + ex. getMessage()) 
			} 
		} 
	}

}



