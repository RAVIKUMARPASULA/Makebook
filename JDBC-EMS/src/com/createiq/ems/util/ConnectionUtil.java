package com.createiq.ems.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {
	static Properties properties=null;
	static {
		try {
			properties=new Properties();
			properties.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("com/createiq/ems/resource/db.properties"));
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(properties.getProperty("Driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		Connection con=null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","root");

			con=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("Admin"), properties.getProperty("Password"));
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
public static void close(Connection con) {
	try {
		if(con!=null) {
		con.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void close(Statement s, Connection con) {
	try {
		if(s!=null) {
		s.close();
		}
//		if(con!=null) {
//		con.close();
//		}
		close(con);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void  close(ResultSet rs, Statement s, Connection con) {
	try {
		if(rs!=null) {
		rs.close();
		}
//		if(s!=null) {
//		s.close();
//		}
//		if(con!=null) {
//		con.close();
//		}
		close(s, con);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
