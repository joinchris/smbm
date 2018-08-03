package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("/Login")
public class Login implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
		HttpServletRequest newRequest = (HttpServletRequest) request;
		HttpServletResponse newResponse = (HttpServletResponse) response;
		HttpSession session = newRequest.getSession();
		String url = newRequest.getServletPath();
		if(session.getAttribute("userName") == null) {
			if(url.equals("/user/qy.com")) {
				newRequest.getRequestDispatcher("/user/qy.com").forward(newRequest, newResponse);
			}else if(url.equals("/user/login.com")) {
				newRequest.getRequestDispatcher("/user/login.com").forward(newRequest, newResponse);
			}else {
				throw new RuntimeException("页面不存在");
			}
		}else {
			filter.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
