package com.ekstudy.model.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	private static String driverClassName="";
	private static String url="";
	private static String user="";
	private static String password="";
	
	 static{
		InputStream input = null;
		Properties properties = new Properties();
		
		try {
			input = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(input);
			driverClassName = properties.getProperty("driverClassName");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 }
	 
	 
	 public static Connection getConnection(){
		 try {
			Class.forName(driverClassName);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	 }
}
