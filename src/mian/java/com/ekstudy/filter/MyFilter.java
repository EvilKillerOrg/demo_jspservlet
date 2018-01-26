package com.ekstudy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy");//销毁的时候调用

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("doFilter");//过滤器拦截到的东西
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		
//		String url = request.getRequestURI();
//		if(url.endsWith("login.jsp")){
//			//访问login.jsp时不走过滤器
//			arg2.doFilter(arg0, arg1);
//			return;
//		}
//		
//		if(request.getSession().getAttribute("username")==null){
//			response.sendRedirect(request.getContextPath()+"/login.jsp");
//			return;
//		}
		arg2.doFilter(arg0, arg1);//交给下一个filter

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init"); //初始化的时候调用

	}

}