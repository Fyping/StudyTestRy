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

import cn.com.fangself.dao.SqlSessionManager;

/**
 * Servlet Filter implementation class CountUserInfo
 */
@WebFilter("/")
public class CountUserInfo implements Filter {

    /**
     * Default constructor. 
     */
    public CountUserInfo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("filter");
		HttpServletRequest req = (HttpServletRequest) request;
		String remoteIp = request.getRemoteAddr();
		(new SqlSessionManager()).insertAUser(remoteIp);
		int timesOfVisit = (new SqlSessionManager()).CountAUser(remoteIp);
		request.setAttribute("timesOfVisit", timesOfVisit);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
