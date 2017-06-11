package netTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
public static  final String IP_ADDR="localhost";
public static final int PORT=12345;
	public static void main(String[] args) {
		System.out.println("Client starting.......");
		System.out.println("当接收到服务器端字符为\"OK\"的时候,客户端终止.");
		while (true) {
			Socket socket = null;
			try {
				socket = new Socket(IP_ADDR,PORT);
				DataInputStream input = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				System.out.print("Please input :");
				String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
				out.writeUTF(str);
				String ret = input.readUTF();
				System.out.println("服务端反应过来的数据为:"+ret);
				if("OK".equals(ret)){
					System.out.println("服务端关闭!");
					Thread.sleep(10000);
					break;
				}
				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("客户端异常:"+e.getMessage());
			}finally{
				if (socket!=null) {
					try {
						socket.close();
					} catch (IOException e){
						socket= null;
						System.out.println("客户端finally异常:"+e.getMessage());
					}
				}
			}
		}
	}
}