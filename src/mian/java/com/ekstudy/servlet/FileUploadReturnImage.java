package com.ekstudy.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekstudy.model.service.FileUploadService;
import com.ekstudy.vo.FileUploadVO;

public class FileUploadReturnImage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uuid = request.getParameter("uuid");
		 FileUploadService fileUploadService = new FileUploadService();
		 FileUploadVO fileUploadVO = fileUploadService.queryFileUploadVOByID(uuid);
		 
		 response.setContentType("image/jpeg");
		 OutputStream ops =  response.getOutputStream();
		 ops.write(fileUploadVO.getMyFile());
		 ops.flush();
	}

	
}
