package com.cameroun.objis.smc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cameroun.objis.smc.domaine.Recrutment;
import com.cameroun.objis.smc.domaine.Registration;
import com.cameroun.objis.smc.domaine.User;


public interface IService {
	
	public  User loginUserService(Connection conn, String userName, String password) throws SQLException;
	public  User loginUserService(Connection conn, String userName) throws SQLException;
	
	public  List<User> queryUserService(Connection conn) throws SQLException;
	public  User findUserService(Connection conn, String matricule) throws SQLException;
	public  void updateUserService(Connection conn, User user) throws SQLException;
	public  void saveUserService(Connection conn, User user) throws SQLException;
	public  void deleteUserService(Connection conn, String login) throws SQLException;
	public  List<User> getAllUsersService() throws ClassNotFoundException;

	public  List<Recrutment> queryRecrutmentService(Connection conn) throws SQLException;
	public  Recrutment findRecrutmentService(Connection conn, String matricule) throws SQLException;
	public  void updateRecrutmentService(Connection conn, Recrutment recrutement) throws SQLException;
	public  void saveRecrutmentService(Connection conn, Recrutment recrutement) throws SQLException;
	public  void deleteRecrutmentService(Connection conn, String mat) throws SQLException;
	public  List<Recrutment> getAllRecrutmentsService() throws ClassNotFoundException;
	
	public  List<Registration> queryRegistrationService(Connection conn) throws SQLException;
	public  Registration findRegistrationService(Connection conn, String matricule) throws SQLException;
	public  void updateRegistrationService(Connection conn, Registration Inscription) throws SQLException;
	public  void saveRegistrationService(Connection conn, Registration inscription) throws SQLException;
	public  void deleteRegistrationService(Connection conn, String mat) throws SQLException;
	public  List<Registration> getAllRegistrationsService() throws ClassNotFoundException;
    
}
