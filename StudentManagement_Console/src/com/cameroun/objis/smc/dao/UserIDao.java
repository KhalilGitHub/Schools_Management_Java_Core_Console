package com.cameroun.objis.smc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cameroun.objis.smc.domaine.User;

public interface UserIDao {
	
	public  List<User> queryUser(Connection conn) throws SQLException;
	public  User findUser(Connection conn, String user_ref) throws SQLException;
	public  void updateUser(Connection conn, User user) throws SQLException;
	public  void saveUser(Connection conn, User user) throws SQLException;
	public  void deleteUser(Connection conn, String user_ref) throws SQLException;
	public  List<User> getAllUsers() throws ClassNotFoundException;

}
