package com.ekstudy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFillter implements Filter {

	//用过滤器设置字符集只对post起效	
	//对get只能用:下面:
//	String checkid="";
//	checkid = new String(checkid.getBytes("ISO-8859-1"),"GB2312");
	
	private String encoding = "";
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
//		arg0.setCharacterEncoding("GB2312");
		arg2.doFilter(arg0, arg1);
		//或者在init的时候就设置字符集 往下看
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		encoding = arg0.getInitParameter("encoding"); //web.xml 配置
	}

}