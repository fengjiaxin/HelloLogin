package com.jiaxin.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//定义数据库驱动程序
	private static final String DBDRIVER ="com.mysql.jdbc.Driver";
	//数据库连接地址
	private static final String DBURL ="jdbc:mysql://localhost:3306/example";
	private static final String DBUSER = "root";
	private static final String DBPASS = "123456";
	private Connection connection = null;
	
	public DatabaseConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			throw e;
		}finally{} 
		
	}
	public Connection getConnection(){
		return connection;
	}
	
	public void close() throws Exception{
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				throw e;
			}
	}
	

}
