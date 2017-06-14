package cn.com.fangself.test;

public class TicketHouseYes implements Runnable{
	
	public int fiveAmount = 2;
	public int tenMount = 0;
	public int twentyAmount = 0;
	public void run(){
		
		if(Thread.currentThread().getName().equals("zhangfei")){
			saleTicket(20);
		}else if(Thread.currentThread().getName().equals("likui")){
			saleTicket(5);
		}
	}
	private synchronized void saleTicket(int money){
		
		if(money==5){
			fiveAmount = fiveAmount +1;
			System.out.println("give " + Thread.currentThread().getName()+" ticket money is suitable");
		}else if(money ==20){
			
			while(fiveAmount <3){
				try{
					System.out.println("\n "+Thread.currentThread().getName()+"¿¿±ßµÈ");
					wait();
					System.out.println("continue buy ticket");
				}catch(InterruptedException e){
					
				}
			}
		}
		notifyAll();
	}
	
}