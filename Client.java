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
		System.out.println("�����յ����������ַ�Ϊ\"OK\"��ʱ��,�ͻ�����ֹ.");
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
				System.out.println("����˷�Ӧ����������Ϊ:"+ret);
				if("OK".equals(ret)){
					System.out.println("����˹ر�!");
					Thread.sleep(10000);
					break;
				}
				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("�ͻ����쳣:"+e.getMessage());
			}finally{
				if (socket!=null) {
					try {
						socket.close();
					} catch (IOException e){
						socket= null;
						System.out.println("�ͻ���finally�쳣:"+e.getMessage());
					}
				}
			}
		}
	}
}