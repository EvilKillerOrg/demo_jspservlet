package com.ekstudy.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	private static String user = "sa";
	private static String password = "sasa";
	private static String dirverClassName="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private static String url="jdbc:microsoft:sqlserver://192.168.56.101:1433;databaseName=jdbcdemo";
 
	
	/**
	 *  @author ek
	 *  @return JDBC-Connection : java.sql.connection
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(dirverClassName);
			conn =  DriverManager.getConnection(url, user, password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 *@author ek
	 * close JDBC ResultSet Statement Connection
	 */
	public static void close(Connection conn , Statement st , ResultSet rst){
		if(rst!=null){
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	}

}