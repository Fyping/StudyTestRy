package cn.com.fangself.test;
/**
 * 
 * ����:
 * ģ����������Ʊ����ĳ����ĳ����ĳ���ӰƱ����ƱԱֻ��3��5Ԫ�������
 * ��ӰƱ5Ԫһ�ţ�
 * ��ĳ��20Ԫһ�ŵ������������ĳ��ǰ����Ʊ����ĳ������ĳ��ǰ����һ��10Ԫ���������Ʊ��
 * ��ĳ��һ��5Ԫ���������Ʊ
 * */
class Pperson extends Thread{
	String name ="";
	public Pperson(String name){
		this.name = name;
	}
	public String getNames(){
		return this.name;
	}
}
class Ticket extends Thread {
	
	int fiveAmount = 3;
	int tenAmount = 0;
	int twentyAmount = 0;
	Pperson t[] = null;
	public Ticket(Pperson[] t){
		this.t = t;
	}
	public void run(){
		for(int i=0;i<3;i++){
			if(this.t[i].getNames().equals("��ĳ")){
				sale(20,this.t[i]);
			}else if(this.t[i].getNames().equals("��ĳ")){
				sale(10,this.t[i]);
			}else if(this.t[i].getNames().equals("��ĳ")){
				sale(5,this.t[i]);
			}
		}
	}
	public synchronized void  sale(int money,Pperson temp){
		if(money == 5){
			System.out.println(temp.getName()+"��Ʊ�ɹ�");
		}
		else if(money==10){
			if(fiveAmount>1){
				fiveAmount--;
				tenAmount ++;
				System.out.println(temp.getName()+"��Ʊ�ɹ���");
			}else{
				System.out.println("Ǯ�������ȵȵ�");
				try {
					temp.wait();
				} catch (InterruptedException e) {
					System.out.println("�õ�");
					System.out.println(temp.getName()+"��Ʊ�ɹ���");
				}
			}
		}else if(money==20){
			if(fiveAmount>3){
				fiveAmount-=3;
				twentyAmount++;
				System.out.println(temp.getName()+"��Ʊ�ɹ���");
			}else{
				try{
					temp.wait();
				}catch(InterruptedException e){
					System.out.println(temp.getName()+"��Ʊ�ɹ���");
				}
			}
		}
		
		this.notifyAll();
	}
}
public class TicketItem {
	public static void main(String []args){
	
		Pperson zhangmou = new Pperson("zhangmou");
		Pperson limou = new Pperson("limou");
		Pperson zhaomou = new Pperson("zhaomou");
		Pperson array [] = {zhangmou,limou, zhaomou};
		Ticket ticket =new Ticket(array);
		ticket.start();
	}
}