package cn.com.fangself.test;

/**
 * 业务：
 * student1 、student2 teacher 
 * student1准备睡10分钟再继续上课，teacher喊三声上课之后吵醒student1,student1 吵醒student2
 * 
 * **/
class Person extends Thread{
	Thread attachThread = null;
	public Person(Thread attachThread){
		this.attachThread = attachThread;
	}
	public Person(){
		
	}
	public void run(){
		
		sync();
	}
	private synchronized void sync() {
		// TODO Auto-generated method stub

		
		if(Thread.currentThread().getName().equals("teacher")){
			System.out.println("上课");
			this.attachThread.interrupt();
		}else if(Thread.currentThread().getName().equals("student1")){
			System.out.println("先谁10分钟");
			if(this.isInterrupted()){
				System.out.println("已经在睡着 student11");
			}else{
				try {
					this.sleep(1000*60*10);
				
				} catch (InterruptedException e) {
					System.out.println("好吧我上课去了");
					this.attachThread.interrupt();
				}
				
			}
			
		}else if(Thread.currentThread().getName().equals("student2")){
			System.out.println("我本来就睡着了");
				if(this.isInterrupted()){
					System.out.println("已经在睡着");
					
				}else{
					try {
						this.sleep(1000*60*10);
						
					} catch (InterruptedException e) {
						System.out.println("我也上课去了");
					}
				}
		}
	
	}
}
public class StudentSleepThread extends Thread {

	
	public static void main(String[] args) {
		Thread student2 = new Person();
		student2.setName("student2");
		Thread student1 = new Person(student2);
		student1.setName("student1");
		Thread teacher = new Person(student1);
		teacher.setName("teacher");
	
		
		student1.start();
		student2.start();
		
	
		teacher.start();
	
	}
}
