package netStudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/*java����UDPЭ���ͨ�ż�ʵ��*/
/*ÿִ��һ�δ���, ������һ��ָ��String���
UDPЭ�������֮һ���Ǹ�Ч,���������䲻�ȶ�,
ֻ�����������䲻̫��Ҫ������
*/
/**
 * A:�������Ͷ�socket���� DatagramSocket(12345);
 * B:��������,�����Datagrampacket 
 * C:����
 * D:�ͷ���Դ
 * @throws IOException 
 * **/
public class SendDemo {
	public static void main(String[] args)  {
		new Send();
		}
}
class Send{
	Send(){
		try {
			DatagramSocket ds = new DatagramSocket();
			byte [] info = new byte[1024];
			String s= new String("Myname !!!!!");
			info=s.getBytes();
			InetAddress address = InetAddress.getByName("127.0.0.1");
			DatagramPacket dp = new DatagramPacket(info,info.length,address , 54321);
		    ds.send(dp);
		    ds.close();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}