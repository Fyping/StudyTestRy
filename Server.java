package netTest;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ParseStr{
	private String info;
	ParseStr(String s){
		if(s.matches(".*name.*")){
			this.info="my name is FangYanping";
		}else if(s.matches(".*sex.*")){
			this.info="Male";
		}else if(s.matches(".*^h([i]|[ello]).*")){
			this.info="hello ,welcome to this world!";
		}else if(s.matches(".*[Ll]ove|[Mm]iss|[Ll]ike.*")){
			this.info="Me too!";
		}else if(s.matches(".*[Gg]ood ([mM]orning|[aA]fternoon|[Ee]vening|[Nn]ight).*")){
			this.info="Great!"+s+"Have a good day!";
		}else if(s.matches(".*hate|[fF]uck.*")){
			this.info=s+"\nBeing a university student \t I think you shouldn\'t be so rude!";
		}else{
			this.info="Just a small program!Still need to finish!";
		}
	}
	String getString(){
		return this.info;
	}
}
public class Server {
	public static final int PORT=12345;
	public static final int MsgCount=20;
	public void init(){
		int count=0;
/*		String s[] = new String[4];
		for(int i =0;i<MsgCount;i++){
			s[i]= new String();
		}
		s[0]="Hello this is Fang Yan ping !\n";
		s[1]= "welcome to this world\n";
		s[2]="I can \'t watch your writing \nSo you can just write anything !";
		s[3]="Oh ,my god!\n";*/
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while (count<MsgCount) {
				Socket socket =serverSocket.accept();
				//new HandlerThread(client);
				
/***********************************************************************************/
				try {
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String clientInputStr = input.readUTF();
			System.out.println("Server tansents:"+clientInputStr);
			String trans= new ParseStr(clientInputStr).getString();
			DataOutputStream out= new DataOutputStream(socket.getOutputStream());
			System.out.print("please input :");
			//String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
			
			//out.writeUTF(s[count]);
			out.writeUTF(trans);
			count++;
			out.close();
			input.close();
		} catch (Exception e) {
			System.out.println("Server Exception  RUn  ex:"+e.getMessage());
			e.printStackTrace();
		}finally{
			if (socket!=null) {
				try {
					socket.close();
				} catch (Exception e) {
					socket = null;
					System.out.println("Server Exception: finally ---"+e.getMessage());
				}
			}
		}
		
/****************************************************************************************/			
			}
		} catch (IOException e) {
			System.out.println("Server Exception:"+e.getMessage());
		}
	}
/* protected class HandlerThread implements Runnable{
	private Socket socket;
	public HandlerThread(Socket client){
		socket =client;
		new Thread(this).start();
	}
	public void run(){
		}
}	 */
	public static void main(String[] args) {
		System.out.println("Server starting............");
		Server server =new Server();
		server.init();
	}
}


