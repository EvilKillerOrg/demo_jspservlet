package com.ekstudy.model.service;

import java.util.List;

import com.ekstudy.model.dao.FileUploadDAO;
import com.ekstudy.vo.FileUploadVO;

public class FileUploadService {
	private FileUploadDAO fileUploadDAO = new FileUploadDAO();
	
	public void addFileUpload(FileUploadVO fileUpload){
		fileUploadDAO.addFileUpload(fileUpload);
	}
	
	public List<FileUploadVO> queryFileUploadList(){
		return fileUploadDAO.queryFileUploadList();
	}
	
	public FileUploadVO queryFileUploadVOByID(String uuid){
		return fileUploadDAO.queryFileUploadVOByID(uuid);
	}
}
