object forTest3 extends App {

	//for中可以使用多个生成器，会形成多重循环
	for (i <- 1 to 3; j <- 4 to 6) print("[" + i + "," + j + "]")
}