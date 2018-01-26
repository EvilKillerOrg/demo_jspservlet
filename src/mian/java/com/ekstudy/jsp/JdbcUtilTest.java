package com.ekstudy.jsp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilTest {
	
	public static void main(String[] args){
		 Connection conn = JdbcUtil.getConnection();
		 String sql = "select * from userinfo";
		 Statement st = null;
		 ResultSet rst = null;
		 
		 try {
			 st = conn.createStatement();
			 rst = st.executeQuery(sql);
			 
			 while(rst.next()){
				 System.out.println(rst.getInt(1));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close (conn, st, rst);
		}
				 
	}

}
