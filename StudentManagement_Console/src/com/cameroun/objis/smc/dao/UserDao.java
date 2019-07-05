package com.cameroun.objis.smc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cameroun.objis.smc.domaine.User;
import com.cameroun.objis.smc.utils.CloseConnection;
import com.cameroun.objis.smc.utils.ConnectionMysql;

public class UserDao implements UserIDao{
	
	
	@Override
	public void saveUser(Connection conn, User user) throws SQLException {

		String sql = "INSERT  INTO `tbl_user`(`userRef`,`firstName`,`lastName`,`login`,`password`,`gender`,`email`,`adress`,`level`, `date`) \r\n" + 
				"		VALUES (?,?,?,?,?,?,?,?,?,?)";         
	       
		PreparedStatement pstm = conn.prepareStatement(sql);    
		
		try
		{
			pstm.setString(1, user.getUserRef());
			pstm.setString(2, user.getFirstName());
			pstm.setString(3, user.getLastName());			
			pstm.setString(4, user.getLogin());
			pstm.setString(5, user.getPassword());			
			pstm.setString(6, user.getGender());
			pstm.setString(7, user.getAdress());						
			pstm.setString(8, user.getEmail());
			pstm.setString(9, user.getLevel());			
			pstm.setDate(10, new Date(user.getDate().getTime()));
		
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      e.printStackTrace();
		  } finally {
			  CloseConnection.close(conn, pstm);
		  }
		
	}

	@Override
	public List<User> queryUser(Connection conn) throws SQLException {

		User user = null;
		
		String user_ref = null;
		String firstName = null;
		String lastName = null;
		String gender = null;
		String adress = null;
		
		
		String login = null;
		String password = null;
		String level = null;
		String email = null;

		Date date = null; 
		
		
			String sql = "Select a.userRef, a.firstName, a.lastName, a.login, a.password, a.gender, a.email, a.adress, a.level, a.Date from tbl_user a;";         
			PreparedStatement pstm = conn.prepareStatement(sql);         
			ResultSet rs = pstm.executeQuery();        
			List<User> list = new ArrayList<User>();  
			
			try
			{
				while (rs.next()) 
				{      
						
					user_ref = rs.getString("userRef");
					firstName = rs.getString("firstName");
					lastName = rs.getString("lastName");
					login = rs.getString("login");
					password = rs.getString("password");
					gender = rs.getString("gender");
					email = rs.getString("email");
					level = rs.getString("level");
					date = rs.getDate("Date");
				
					user = new User();
					
					user.setUserRef(user_ref);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setGender(gender);
					user.setAdress(adress);
					user.setLogin(login);
					user.setPassword(password);
					user.setLevel(level);	
					user.setEmail(email);
					user.setDate(date);
						
				
					
					list.add(user); 					
				}        
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } finally {
			  CloseConnection.close(conn, pstm, rs);
		  }
		
		return null;
	}

	
	@Override
	public User findUser(Connection conn, String user_ref) throws SQLException {

		User user = null;
		
		String firstName = null;
		String lastName = null;
		String gender = null;
		String adress = null;
		
		String login = null;
		String password = null;
		String level = null;
		String email = null;
		
		Date date = null; 
		
		String sql = "SELECT a.firstName, a.lastName, a.login, a.password, a.gender, a.email, a.adress, a.level, a.Date FROM tbl_user a WHERE userRef = ?";         
		PreparedStatement pstm = conn.prepareStatement(sql);        
				
		pstm.setString(1, user_ref);         
		ResultSet rs = pstm.executeQuery();   
		
		try
		{
			while (rs.next()) 
			{       
			
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				login = rs.getString("login");
				password = rs.getString("password");
				
				gender = rs.getString("gender");
				email = rs.getString("email");
				adress = rs.getString("adress");
				level = rs.getString("level");
		
				date = rs.getDate("Date");
						
				user = new User();
				
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setGender(gender);
				user.setAdress(adress);
				user.setLogin(login);
				user.setPassword(password);
				user.setLevel(level);
				user.setEmail(email);

				user.setDate(date);
				
	   			user = new User(user_ref, firstName, lastName, gender, adress, login, password, level, email, date);            
				       
			}       
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } finally {
			  CloseConnection.close(conn, pstm, rs);
		  }
		
		return user;
	}   
	
	

	@Override
	public void updateUser(Connection conn, User user) throws SQLException {

		String sql = "update tbl_user set `password`=?, email = ?, adress = ?, level = ?, date = ? where login = ?;";         
		
		PreparedStatement pstm = conn.prepareStatement(sql);         
		
		try
		{
			pstm.setString(1, user.getFirstName());
			pstm.setString(2, user.getLastName());
			pstm.setString(3, user.getGender());
			pstm.setString(4, user.getAdress());
			
			pstm.setString(5, user.getLogin());
			pstm.setString(6, user.getPassword());
			pstm.setString(7, user.getLevel());
			pstm.setString(8, user.getEmail());
			
			pstm.setDate(9, new Date(user.getDate().getTime()));
			
			pstm.setString(10, user.getUserRef());
		
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      e.printStackTrace();
		  } finally {
			  CloseConnection.close(conn, pstm);
		  }
		
	}


	@Override
	public void deleteUser(Connection conn, String login) throws SQLException {

		try
		{
			
			String sql = "Delete From tbl_user WHERE login = ?;";         
			PreparedStatement pstm = conn.prepareStatement(sql);         
			
			pstm.setString(1, login);         
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } finally {
			  CloseConnection.close(conn);
		  }
	}

	@Override
	public List<User> getAllUsers() throws ClassNotFoundException {

		 List<User> listUsers = new ArrayList<User>();
		 Connection con = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 
		 try{
		 con = ConnectionMysql.getInstance();
		 String sql="SELECT * FROM tbl_user ";
		 
		 pst = con.prepareStatement(sql);
		 
		 rs = pst.executeQuery();
		 
		 while(rs.next()){
		 
			 	User user = new User();			 
				
				user.setUserRef(rs.getString(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setAdress(rs.getString(5));

				user.setLogin(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setLevel(rs.getString(8));
				user.setEmail(rs.getString(9));
				
				user.setDate(rs.getDate(10));
				
				listUsers.add(user);		
			 }
			 
		 }
		 catch(SQLException e){
		 e.printStackTrace();
		 }
		 finally {
				 try {
					 CloseConnection.close(con, pst, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		 return listUsers;
	}
	

}
