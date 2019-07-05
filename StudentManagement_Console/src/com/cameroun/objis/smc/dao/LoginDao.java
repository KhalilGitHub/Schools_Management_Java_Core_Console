package com.cameroun.objis.smc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cameroun.objis.smc.domaine.User;


public class LoginDao implements LoginIDao{
	
	public  User loginUser(Connection conn, String login, String password) throws SQLException 
	{         
		String sql = "SELECT a.login, a.password FROM tbl_user a  WHERE a.login = ? AND a.password = ?"; 
		
		PreparedStatement pstm = conn.prepareStatement(sql);   
		
		pstm.setString(1, login);        
		pstm.setString(2, password);        
		
		ResultSet rs = pstm.executeQuery();         
		try {
			if (rs.next()) 
			{                        
				User user = new User();            
				user.setLogin(login);            
				user.setPassword(password);                      
				return user;        
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;    
	}     
	public  User loginUser(Connection conn, String login) throws SQLException 
	{         
		String sql = "SELECT a.login, a.password FROM tbl_user a  WHERE a.login = ?"; 
		
		PreparedStatement pstm = conn.prepareStatement(sql); 
		pstm.setString(1, login);         
		ResultSet rs = pstm.executeQuery(); 
		
		try {
			if (rs.next()) 
			{            
				String password = rs.getString("Password");            
				String gender = rs.getString("Gender");            
				User user = new User();            
				user.setLogin(login);            
				user.setPassword(password);            
				user.setGender(gender);            
				return user;        
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
		return null;    
	}     
	

}
