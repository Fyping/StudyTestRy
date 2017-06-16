package cn.com.fangself.test;

public class MainTest {

public static void main(String []args ){
		
		TicketHouseYes officer = new TicketHouseYes();
		Thread zhangfei,likui;
		zhangfei = new Thread(officer);
		likui = new Thread(officer);
		zhangfei.setName("zhangfei");
		likui.setName("likui");
		zhangfei.start();
		likui.start();
		System.out.println("main thread ending");
	}
}
