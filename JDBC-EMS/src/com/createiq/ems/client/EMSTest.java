package com.createiq.ems.client;

import java.sql.Connection;
import java.sql.SQLException;

import com.createiq.ems.util.ConnectionUtil;

public class EMSTest {
public static void main(String[] args) {
	Connection con= ConnectionUtil.getConnection();
	System.out.println(con);
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
