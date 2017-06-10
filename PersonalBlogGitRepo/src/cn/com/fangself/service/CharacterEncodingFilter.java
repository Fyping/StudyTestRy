package cn.com.fangself.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import cn.com.fangself.wrapper.ReqeustWrapper;

public class CharacterEncodingFilter implements Filter {

    public CharacterEncodingFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do character encoding ");
		HttpServletRequest requests = (HttpServletRequest)request;
		requests = (HttpServletRequest) (new ReqeustWrapper(requests)).getRequest();  
		chain.doFilter(requests, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
