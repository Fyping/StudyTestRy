package cn.com.fangself.test;

public class MainTestClass {

	static{
		System.out.println("helloworld static block !!!!");
	}
	public  static  synchronized void main(String[] args) {
		System.out.println("abcdefghijklmnlpqrstuvwxyz"+MainTestClass.a);
		
	}
	static{
		System.out.println("hello world block in main method ");
	}
	/*static public void main(String [] args){
		System.out.println("hello "+args.getClass().getName());
	}*/
	static{
		System.out.println("helloworld static block !!!! afterhellolololl");
	}
	static final int a=100;
		
	
}