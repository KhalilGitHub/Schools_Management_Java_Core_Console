package com.cameroun.objis.smc.utils;

import java.sql.*;


public class ConnectMysql {
	
	
	public static Connection getConnection()
	{
		Connection myConn = null;
		try {
			
			String url = "jdbc:mysql://localhost/db_sm_console";
			String username = "root";
			String password = "hamsaad12";

			myConn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return myConn;
		
		
	}
	
}
