package com.cameroun.objis.smc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseConnection {
	
	public static void close(Connection conn, PreparedStatement preparedStatement, ResultSet resultset) throws SQLException {
		
		conn.close();
		preparedStatement.close();
		resultset.close();
	}	
	
		public static void close(Connection conn, PreparedStatement preparedStatement) throws SQLException {
		
		conn.close();
		preparedStatement.close();
	}	

	public static void close(Connection conn) throws SQLException {
	
	conn.close();
	
	}	

}
