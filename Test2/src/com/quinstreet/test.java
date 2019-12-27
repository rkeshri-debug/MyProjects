package com.quinstreet;

public class test{

	
	static int i;   //instance variable
	public static boolean count;  //static variable

	{
		System.out.println("Instance block exected..!!");
	};

	static {
		System.out.println("static block exected..!!");
	};

	test(int x,float t) {
		System.out.println("paramterized constructor exected..!!");
	};

	test() {
		System.out.println("defualt constructor..!!");
	};


	
	public static void main(String[] args) {
		System.out.println("Main method..!!!!");
		test obj=new test();
		
		System.out.println("value of i..."+obj.i);
		System.out.println("value of count..."+obj.count);
		System.out.println("value of count..."+test.count);
	
		test obj1=new test(2,1.3f);

		Test1.salary=122;
		Test1 obj2=new Test1();
		System.out.println(obj2.j);
	}

}
