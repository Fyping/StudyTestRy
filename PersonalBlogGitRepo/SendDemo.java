package netStudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/*java基于UDP协议的通信简单实现*/
/*每执行一次代码, 将发送一条指定String语句
UDP协议的特性之一就是高效,但是由于其不稳定,
只能用它来传输不太重要的数据
*/
/**
 * A:创建发送端socket对象 DatagramSocket(12345);
 * B:创建数据,并打包Datagrampacket 
 * C:发送
 * D:释放资源
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