package GitBub;
import javax.swing.JOptionPane;
/***
 * @author:FangYanPing   from JXAU ,in China;
 * @version:1.0
 * function:建立一个可视化框架,显示一个视图,
 * 该视图提示从键盘输入一段字符串,
 * 该类通过GetString 函数返回从键盘获取的字符
 * @param:tx,提供在框架中显示的提示信息,
 * @param:str,返回的字符串信息
 * **/
public class OptionGUI {
	String text ;
	public OptionGUI(String tx){
		text = JOptionPane.showInputDialog(tx);	
	}
	public String getInputInfo(){
		return text;
	}
	
	public static void main(String[] args) {
		//This is test infomation:
		/*OptionGUI gui = */;
		String str= new OptionGUI("Please input issue of what you want: ").getInputInfo();
		System.out.println(str);
	}

}
