package netStudy;
/*java����UDPЭ���ͨ�ż�ʵ��*/
//��Ϊ�����,�˴������������,�Ⱥ�ͻ��˵�ͨ��
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * A:�������Ͷ�socket����
 * B:�������ݰ�
 * C:����
 * D:�ͷ���Դ
 * @throws IOException 
 * **/
public class ReceiveDemo {

	public static void main(String[] args) throws IOException {
			while(true){
				new Receive();
			}
		}
}
class Receive{
	Receive() throws IOException{
		try {
			DatagramSocket ds = new DatagramSocket(54321);
			byte str[]= new byte[1024];
			DatagramPacket dp = new DatagramPacket(str,1024);
			System.out.println("�ȴ��ͻ�������..............");
				ds.receive(dp);//����ʽ����,ֻ�з���ִ�н������ִ�к���Ĵ���
			String ip = dp.getAddress().getHostAddress();
			byte []info = dp.getData();
			String str1 = new String (info,0,info.length).trim();
			System.out.print("����IPΪ"+ip+"��");
			System.out.println("ͨ������,����֮��Ϊ"+str1);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
	}
}















