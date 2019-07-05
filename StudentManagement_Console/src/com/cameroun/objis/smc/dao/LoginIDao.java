package com.cameroun.objis.smc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.cameroun.objis.smc.domaine.User;


public interface LoginIDao {
	
	public  User loginUser(Connection conn, String login, String password) throws SQLException;
	public  User loginUser(Connection conn, String login) throws SQLException;

}
