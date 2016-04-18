#!/usr/bin/ruby -w
# -*- coding: UTF-8 -*-

puts 'escape using "\\"';
puts 'That\'s right';

puts 'hello world!'

=begin
您可以使用序列 #{ expr } 替换任意 Ruby 表达式的值为一个字符串。在这里，expr 可以是任意的 Ruby 表达式。
=end

#example 1
puts "Multiplication Value : #{24*60*60}";

#example 2
name="Xiaodong Li" 
puts "#{name+",ok"}" 

=begin
数组字面量通过[]中以逗号分隔定义，且支持range定义。
（1）数组通过[]索引访问 
（2）通过赋值操作插入、删除、替换元素
（3）通过+，－号进行合并和删除元素，且集合做为新集合出现
（4）通过<<号向原数据追加元素
（5）通过*号重复数组元素
（6）通过｜和&符号做并集和交集操作（注意顺序）
=end

puts "\nhere is a demo for array:"
ary = [ "fred", 10, 3.14, "This is a string", "last element", ]
 ary.each do |i|
     puts i
 end 
 
#Ruby 哈希是在大括号内放置一系列键/值对，键和值之间使用逗号和序列 => 分隔。尾部的逗号会被忽略。

puts
 puts "here is a demo for hash:"
 hsh = { "red" => 0xf00, "green" => 0x0f0, "blue" => 0x00f }
 hsh.each do |key, value|
     print key, " is ", value, "\n"
 end
 
=begin
  一个范围表示一个区间。 范围是通过设置一个开始值和一个结束值来表示。
 范围可使用 s..e 和 s...e 来构造，或者通过 Range.new 来构造。
使用 .. 构造的范围从开始值运行到结束值（包含结束值）。
使用 ... 构造的范围从开始值运行到结束值（不包含结束值）。
当作为一个迭代器使用时，范围会返回序列中的每个值。
范围 (1..5) 意味着它包含值 1, 2, 3, 4, 5，范围 (1...5) 意味着它包含值 1, 2, 3, 4 。
=end

puts
(10..15).each do |n|
     print n, ' '
end
puts

=begin
Ruby 类中的变量:

Ruby 提供了四种类型的变量：

局部变量：局部变量是在方法中定义的变量。局部变量在方法外是不可用的。局部变量以小写字母或 _ 开始。

实例变量：实例变量可以跨任何特定的实例或对象中的方法使用。
这意味着，实例变量可以从对象到对象的改变。实例变量在变量名之前放置符号（@）。

类变量：类变量可以跨不同的对象使用。类变量属于类，且是类的一个属性。类变量在变量名之前放置符号（@@）。

全局变量：类变量不能跨类使用。如果您想要有一个可以跨类使用的变量，您需要定义全局变量。全局变量总是以美元符号（$）开始。

=end

class Customer
   @@no_of_customers=0
   def initialize(id, name, addr)
      @cust_id=id
      @cust_name=name
      @cust_addr=addr
	  @@no_of_customers +=	  1
   end
   
   def displayCustomerInfo
		puts "Customer ID is #@cust_id"
		puts "Customer Name is #@cust_name"
		puts "Customer Addr is #@cust_addr"
   end
   
   def displayCustomerNum
		puts "The total number currently is #@@no_of_customers"
   end
end

object = Customer.new(1,'Xiaodong Li','ABC Address')
object2 = Customer.new(2,"Ming Chen", "FA_Address")
object.displayCustomerInfo
object2.displayCustomerInfo
object.displayCustomerNum

#puts object:cust_name
#puts @@no_of_customers

=begin
Ruby 常量

常量以大写字母开头。定义在类或模块内的常量可以从类或模块的内部访问，定义在类或模块外的常量可以被全局访问。

常量不能定义在方法内。引用一个未初始化的常量会产生错误。对已经初始化的常量赋值会产生警告。

=end

class Example
   VAR1 = 100
   VAR2 = 200
   def show
       puts "第一个常量的值为 #{VAR1}"
       puts "第二个常量的值为 #{VAR2}"
   end
end

# 创建对象
puts
puts "=================="
puts "常量对象的显示"
object=Example.new()
object.show
puts "=================="

=begin
Ruby 伪变量

它们是特殊的变量，有着局部变量的外观，但行为却像常量。您不能给这些变量赋任何值。
self: 当前方法的接收器对象。
true: 代表 true 的值。
false: 代表 false 的值。
nil: 代表 undefined 的值。
__FILE__: 当前源文件的名称。
__LINE__: 当前行在源文件中的编号。

=end


=begin
defined? 是一个特殊的运算符，以方法调用的形式来判断传递的表达式是否已定义。它返回表达式的描述字符串，如果表达式未定义则返回 nil。
=end

puts
puts defined? puts #method
foo = 20
puts defined? foo	#local-variable

=begin
建立“多行”的字符串
在 << 之后，可以指定一个字符串或标识符来终止字符串，且当前行之后直到终止符为止的所有行是字符串的值。
=end

puts

print <<EOF
这是第一种方式创建here document 。
多行字符串。
EOF


print <<"EOF";                # 与上面相同
这是第二种方式创建here document 。
多行字符串。
EOF

print <<`EOC`                 # 执行命令
echo hi there
echo lo there
EOC

print <<"foo", <<"bar"	      # 您可以把它们进行堆叠
I said foo.
foo
I said bar.
bar


=begin

Ruby 点运算符 "." 和双冒号运算符 "::"

您可以通过在方法名称前加上模块名称和一条下划线来调用模块方法。您可以使用模块名称和两个冒号来引用一个常量。

:: 是一元运算符，允许在类或模块内定义常量、实例方法和类方法，可以从类或模块外的任何地方进行访问。

请记住：在 Ruby 中，类和方法也可以被当作常量。

您只需要在表达式的常量名前加上 :: 前缀，即可返回适当的类或模块对象。

如果未使用前缀表达式，则默认使用主 Object 类。


=end

puts

CONST = ' out there'
class Inside_one
   CONST = proc {' in there'}
   def where_is_my_CONST
      ::CONST + ' inside one'
   end
end
class Inside_two
   CONST = ' inside two'
   def where_is_my_CONST
      CONST
   end
end
puts Inside_one.new.where_is_my_CONST
puts Inside_two.new.where_is_my_CONST
puts Object::CONST + Inside_two::CONST
puts Inside_two::CONST + CONST
#puts Inside_one::CONST
puts Inside_one::CONST.call + Inside_two::CONST

=begin
##################################################
#Ruby的类定义
定义

attr_reader :name 只读（定义 name 方法）

attr_writer :name 只写（定义 name= 方法）

attr_accessor :name 读写（定义以上两个方法）

也可以像下面这样只写一行代码，其效果与刚才的 name 方法以及 name= 方法的效果是一样的。

class HelloWorld
  attr_accessor :name
end
##################################################
=end

puts
class Person
  attr_accessor :name
end

aPerson = Person.new
aPerson.name = "Xiaodong Li"
p aPerson.name + " by p"
puts aPerson.name+" by puts"

########################################
#88888
#99999
########################################
#pretend to fix an issue called issue_004



