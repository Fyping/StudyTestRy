package cn.com.fangself.test;
/**
 * �ŷɺ����������ӰƱ����ƱԱֻ������5Ԫ��Ǯ���ŷ���һ��20Ԫ������ң�������һ��5Ԫ�ģ�
 * ��ӰƱ5Ԫһ��
 * */
public class TicketHouse extends Thread {

	public TicketHouse(String officerName){
	}
	public void run(){
		
		synchronizedMethod(this.currentThread().getName());
	}
	private synchronized void synchronizedMethod(String names) {
		if(names.equals("�ŷ�")){
			System.out.println("û����Ǯ��"+"  �ȿ��ߵ���");
			try {
				//this.wait();
				wait();
				System.out.println("�ðɣ�������Ǯ�ˣ�20���ң�����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else if(names.equals("����")){
			System.out.println("��ӰƱ������");
			
		}
		//this.notifyAll();
		notifyAll();
	}
	public static void main(String[] args) {
		Thread zhangfei = new Thread(new TicketHouse("�ŷ�"));
		zhangfei.setName("�ŷ�");
		Thread likui = new Thread(new TicketHouse("����"));
		likui.setName("����");
		zhangfei.start();
		likui.start();
	}
}
