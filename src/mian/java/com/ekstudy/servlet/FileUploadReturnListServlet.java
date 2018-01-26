package com.ekstudy.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekstudy.model.service.FileUploadService;
import com.ekstudy.vo.FileUploadVO;

public class FileUploadReturnListServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用来跳转到List页面以避免出现重复数据提交
		
		FileUploadService fileUploadService = new FileUploadService();
		
		List<FileUploadVO> fileUploadList = fileUploadService.queryFileUploadList();
		request.setAttribute("fileUploadList", fileUploadList);
		
		request.getRequestDispatcher("/fileupload_list.jsp").forward(request, response);;
		
	}

}