package com.ekstudy.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadFileServlet extends HttpServlet {
	private ServletContext application;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		application = config.getServletContext();
	}



	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream input = null; 
		input = ReadFileServlet.class.getClassLoader().getResourceAsStream("a.txt");//读取a.txt 就是存class的路径
//		input = application.getResourceAsStream("b.txt"); //读取b.txt 就是读web应用根目录
		StringBuffer fileContent = new StringBuffer();
		int temp;
		while((temp = input.read())!=-1){
			fileContent.append((char)temp);
		}
		//System.out.println(new String(fileContent , "GB2312"));
		System.out.println(new String(fileContent));
		
//-----------------------------------------------------------------------------------------------------------------------------		
		
		//上面的效率低 高效的读应该用BufferedReader读文本信息 带Reader的都是读文本
		BufferedReader in = new BufferedReader(new FileReader(ReadFileServlet.class.getClassLoader().getResource("/").getPath()+"a.txt"));
		//in.readLine(); //可以读一行
		String tmp;
		if((tmp=in.readLine())!=null){
			fileContent.append(tmp);
		}
		System.out.println(new String(fileContent));
	}

}