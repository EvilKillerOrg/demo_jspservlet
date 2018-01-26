package com.ekstudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}

	String username = "";
	@Override
	public void init(ServletConfig config) throws ServletException {
		username = config.getInitParameter("username");
		System.out.println("init-config");
	}


	int count = 0; //servlet 实例化一次 所以可以这样统计 访问次数
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
		count++;
		PrintWriter out = response.getWriter();
		//out.println("UserName: "+super.getInitParameter("username")); //看上面有参的init方法
		out.println("UserName "+username);
		out.print("This is "+count+" times accessing.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}