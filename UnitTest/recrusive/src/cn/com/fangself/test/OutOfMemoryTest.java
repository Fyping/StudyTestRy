package cn.com.fangself.test;

import java.util.Vector;

public class OutOfMemoryTest {

	public static void main(String []args){
		Vector<Object> vec = new Vector<Object>();
		for(int i=0;i<10;i++){
			Object o = new String ("abc");
			vec.add(o);
			
		}//Object O ¶ÔÏóÄÚ´æÐ¹Â¶l
		vec.clear();
	}
}
