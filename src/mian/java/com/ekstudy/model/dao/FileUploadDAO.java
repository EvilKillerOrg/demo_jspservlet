package com.ekstudy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ekstudy.model.utils.DBUtil;
import com.ekstudy.vo.FileUploadVO;

public class FileUploadDAO {
	
	public void addFileUpload(FileUploadVO fileUpload){
		String sql ="insert into fileupload (myname , myfile) values (?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, fileUpload.getMyName());
			pst.setBytes(2, fileUpload.getMyFile());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public List<FileUploadVO> queryFileUploadList(){
		String sql = "select * from fileupload";
		List<FileUploadVO> voList = new ArrayList<FileUploadVO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rst = null;
		
		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rst = st.executeQuery(sql);
			while(rst.next()){
				FileUploadVO filevo = new FileUploadVO();
				filevo.setUuid(rst.getInt("uuid"));
				filevo.setMyName(rst.getString("myname"));
				//filevo.setMyFile(rst.getBytes("myFile"));
				voList.add(filevo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return voList;
	}

	
	public FileUploadVO queryFileUploadVOByID(String uuid){
		String sql ="select myfile from fileupload where uuid = "+uuid;
		FileUploadVO fileUploadVO = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rst = null;
		
		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			rst = st.executeQuery(sql);
			if(rst.next()){
				fileUploadVO = new FileUploadVO();
				fileUploadVO.setMyFile(rst.getBytes("myfile"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return fileUploadVO;
	}
	
}
