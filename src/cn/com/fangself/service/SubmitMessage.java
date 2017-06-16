package cn.com.fangself.service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.fangself.dao.SqlSessionManager;
import cn.com.fangself.mapper.UserMapper;

public class SubmitMessage extends HttpServlet {
	
	SqlSessionManager sqlSessionManager = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("starting method");
		Enumeration<String> params = request.getParameterNames();
		Hashtable<String,String> memberHash = new Hashtable<String,String>();
			while(params.hasMoreElements()){
				String name = params.nextElement();
				String value = request.getParameter(name);
				memberHash.put(name,value);
				//System.out.println("name =="+name+"  value=="+value);
			}
		try{
			sqlSessionManager.insertAMemberAndMessage(memberHash);
			response.sendRedirect("index.jsp");
		}catch(RuntimeException ex){
			System.out.println(ex.getStackTrace()+"\n-------------------------------\n"+ex.getMessage());
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
		
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy");
		sqlSessionManager.sqlSessionFactory = null;
		sqlSessionManager = null;
	}
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init");
		sqlSessionManager  = new SqlSessionManager();
	}
	
}
