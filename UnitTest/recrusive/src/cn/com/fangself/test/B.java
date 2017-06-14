package cn.com.fangself.test;

public class B extends Object {
	static {
		System.out.println("Load B");
	}
	public B(){
		System.out.println("Create B");
	}
	public static void main(String []args ){
		new A();
	}
}
class A extends B{
	static {
		System.out.println("Load A");
	}
	public A(){
		System.out.println("Create A");
	}
}