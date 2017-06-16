package cn.com.fangself.test;

/**
 * ҵ��
 * student1 ��student2 teacher 
 * student1׼��˯10�����ټ����ϿΣ�teacher�������Ͽ�֮����student1,student1 ����student2
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
			System.out.println("�Ͽ�");
			this.attachThread.interrupt();
		}else if(Thread.currentThread().getName().equals("student1")){
			System.out.println("��˭10����");
			if(this.isInterrupted()){
				System.out.println("�Ѿ���˯�� student11");
			}else{
				try {
					this.sleep(1000*60*10);
				
				} catch (InterruptedException e) {
					System.out.println("�ð����Ͽ�ȥ��");
					this.attachThread.interrupt();
				}
				
			}
			
		}else if(Thread.currentThread().getName().equals("student2")){
			System.out.println("�ұ�����˯����");
				if(this.isInterrupted()){
					System.out.println("�Ѿ���˯��");
					
				}else{
					try {
						this.sleep(1000*60*10);
						
					} catch (InterruptedException e) {
						System.out.println("��Ҳ�Ͽ�ȥ��");
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
