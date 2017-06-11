package cn.com.fangself.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

class Spider implements Runnable{
	URL url = null;
	public Spider(String urlStr){
		try {
			this.url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		InputStream is = null;
		try {
			is = this.url.openStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte b[] = new byte[1024];
		int n=-1;
		try {
			while((n=is.read(b))!=-1){
				String str = new String(b,0,n);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class URLSpider {

	public static void main(String []args){
		Spider spider = new Spider("http://www.baidu.com");
		Thread thread = new Thread(spider);
		thread.start();
	}
}
