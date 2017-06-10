package cn.com.fangself.service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("starting method");
		Enumeration<String> params = request.getParameterNames();
		HashMap<String,String> memberHash = new HashMap<String,String>();
			while(params.hasMoreElements()){
				String name = params.nextElement();
				String value = request.getParameter(name);
				memberHash.put(name,value);
			}
		try{
			(new SqlSessionManager()).insertAMemberAndMessage(memberHash);
		}catch(RuntimeException ex){
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
		response.sendRedirect("index.jsp");
	}

}
