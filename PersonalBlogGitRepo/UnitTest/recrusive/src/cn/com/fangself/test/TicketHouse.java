package cn.com.fangself.test;
/**
 * 张飞和李逵来买电影票，售票员只有两张5元的钱，张飞有一张20元的人民币，李逵有一张5元的，
 * 电影票5元一张
 * */
public class TicketHouse extends Thread {

	public TicketHouse(String officerName){
	}
	public void run(){
		
		synchronizedMethod(this.currentThread().getName());
	}
	private synchronized void synchronizedMethod(String names) {
		if(names.equals("张飞")){
			System.out.println("没有零钱找"+"  先靠边等着");
			try {
				//this.wait();
				wait();
				System.out.println("好吧，我有零钱了，20给我，找你");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else if(names.equals("李逵")){
			System.out.println("电影票给李逵");
			
		}
		//this.notifyAll();
		notifyAll();
	}
	public static void main(String[] args) {
		Thread zhangfei = new Thread(new TicketHouse("张飞"));
		zhangfei.setName("张飞");
		Thread likui = new Thread(new TicketHouse("李逵"));
		likui.setName("李逵");
		zhangfei.start();
		likui.start();
	}
}
