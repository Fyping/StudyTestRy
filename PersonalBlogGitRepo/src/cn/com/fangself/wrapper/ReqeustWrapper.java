package cn.com.fangself.wrapper;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ReqeustWrapper extends HttpServletRequestWrapper {

	public HttpServletRequest reqeust = null;
	///编码失败，下次再写
	public ReqeustWrapper(HttpServletRequest request) {
		super(request);
		this.reqeust = request;
	}
	public HttpServletRequest getRequest(){
		return this.reqeust;
	}
	@Override
	public String getParameter(String name) {
		try{
			name  = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		}catch(Exception e){
		}
		return super.getParameter(name);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return super.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return super.getParameterValues(name);
	}
	
}
