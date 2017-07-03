package netStudy;
/*java基于UDP协议的通信简单实现*/
//作为服务端,此代码必须先运行,等候客户端的通信
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * A:创建发送端socket对象
 * B:创建数据包
 * C:发送
 * D:释放资源
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
			System.out.println("等待客户端连接..............");
				ds.receive(dp);//阻塞式方法,只有返回执行结果才能执行后面的代码
			String ip = dp.getAddress().getHostAddress();
			byte []info = dp.getData();
			String str1 = new String (info,0,info.length).trim();
			System.out.print("来自IP为"+ip+"的");
			System.out.println("通信数据,解析之后为"+str1);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
	}
}















