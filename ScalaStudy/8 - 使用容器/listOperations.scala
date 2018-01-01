object listOperations extends App {

	val feeds = List("blog.toolshed.com", "pragdave.pragprog.com", "dimsumthinking.com/blog")

	//filter针对集合进行过滤，生成子List集合
	println("Feeds with blog: " + feeds.filter( _ contains "blog" ).mkString(", ")) 

	//forall检查是否都满足某一特定条件
	println(" All feeds have com: " + feeds.forall( _ contains "com" )) 
	println(" All feeds have dave: " + feeds.forall( _ contains "dave" )) 

	//exist检查是否存在某个元素满足某条件
	println(" Any feed has dave: " + feeds.exists( _ contains "dave" )) 
	println(" Any feed has bill: " + feeds.exists( _ contains "bill" ))

	//map针对每个元素都进行处理
	println(" All elements length are： " + feeds.map(_.length).mkString(", "))

	//foldLeft针对所有元素进行累加类处理
	//val totalChars = feeds.foldLeft(0) { (total, feed) => total + feed.length }
	//val totalChars = (0/:feeds) { (total, feed) => total + feed.length }
	val totalChars = (0/:feeds) { _ + _.length}
	println("All elements length in total is " + totalChars)
}

