package com.ekstudy.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekstudy.smartupload.File;
import com.ekstudy.smartupload.Request;
import com.ekstudy.smartupload.SmartUpload;
import com.ekstudy.smartupload.SmartUploadException;

public class FileSmartUploadServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//request.getParameter("myname"); //这里由于enctype="multipart/form-data"request取不到值了
			//可以用SmartUpload提供的一个request
			SmartUpload smartUpload = new SmartUpload();
			Request myRequest =  smartUpload.getRequest();
			myRequest.getParameter("myname");
			
			smartUpload.initialize(super.getServletConfig(), request, response);
			smartUpload.upload();
			int filecount = smartUpload.getFiles().getCount();
			if(filecount>0){
				File file = smartUpload.getFiles().getFile(0);
				System.out.println("FieldName: "+file.getFieldName()); //上传域名
				System.out.println("FileName: "+file.getFileName()); //文件名
				System.out.println("Size: "+file.getSize()); //文件大小
				
				byte[] fileContent = new byte[file.getSize()];
				//System.arraycopy(src, srcPos, dest, destPos, length); srcPos 源文件开始位置 , destPos目标文件开始位置
				System.arraycopy(smartUpload.m_binArray, file.getStartData(), fileContent, 0, file.getSize());
				//System.out.println(super.getServletContext().getRealPath("/"));//物理目录
				//System.out.println(super.getServletContext().getResource("/").getPath());//应用目录
				java.io.File upFile = new java.io.File(super.getServletContext().getRealPath("/")+"upfile/"+file.getFileName()); //没有这个文件要先创建文件对象
				if(!upFile.exists()){
					upFile.createNewFile();//创建文件
				}
				OutputStream output = new FileOutputStream(upFile);
				output.write(fileContent);
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/smartupfile.jsp");
	}
	
	
	

}