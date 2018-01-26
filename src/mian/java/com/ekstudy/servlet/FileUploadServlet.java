package com.ekstudy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ekstudy.model.service.FileUploadService;
import com.ekstudy.vo.FileUploadVO;

public class FileUploadServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request); //判断是否存在文件上传域
		 try {
			if(isMultipart){ 
				FileUploadVO fileUpload = new FileUploadVO();
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
			    List<FileItem> items = upload.parseRequest(request); //这里得到的不是只是文件域 是页面所有类型的域
			    for(FileItem fileItem : items){
			    	if(fileItem.isFormField()){ //true普通域false文件域
			    		popludata(fileUpload,fileItem);
			    	}else{
			    		popludataFile(fileUpload,fileItem);
			    	}
			    }
			    FileUploadService fileUploadService = new FileUploadService();
				fileUploadService.addFileUpload(fileUpload);
			}
		 } catch (FileUploadException e) {
			e.printStackTrace();
		 }
		 response.sendRedirect(request.getContextPath()+"/servlet/FileUploadReturnListServlet");//sendRedirect到这个页面,断开一次请求以避免重复数据提交
	}
	
	
	private void popludata(FileUploadVO fileUpload , FileItem fileItem){
		if("myname".equals(fileItem.getFieldName())){//获得普通域的名称
			fileUpload.setMyName(fileItem.getString());//获得普通域的值
			return;
		}
	}
	
	
	private void popludataFile(FileUploadVO fileUpload , FileItem fileItem){ 
		fileUpload.setMyFile(fileItem.get());//获得文件域的值
		System.out.println("FileName: "+fileItem.getName());
		System.out.println("FileSize: "+fileItem.getSize());
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/fileupload.jsp");
	}
	
	
	
	
}