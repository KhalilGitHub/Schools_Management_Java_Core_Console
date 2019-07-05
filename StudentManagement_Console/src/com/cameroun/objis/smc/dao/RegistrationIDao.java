package com.cameroun.objis.smc.dao;

import java.util.List;

import com.cameroun.objis.smc.domaine.Registration;

import java.sql.Connection;
import java.sql.SQLException;



public interface RegistrationIDao {
	
	
	public  List<Registration> queryRegistration(Connection conn) throws SQLException;
	public  Registration findRegistration(Connection conn, String registration_ref) throws SQLException;
	public  void updateRegistration(Connection conn, Registration registration) throws SQLException;
	public  void saveRegistration(Connection conn, Registration registration) throws SQLException;
	public  void deleteRegistration(Connection conn, String registration_ref) throws SQLException;
	public  List<Registration> getAllRegistrations() throws ClassNotFoundException;
	
}
