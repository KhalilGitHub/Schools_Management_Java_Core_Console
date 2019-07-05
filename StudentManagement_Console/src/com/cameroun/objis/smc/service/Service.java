package com.cameroun.objis.smc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cameroun.objis.smc.dao.LoginDao;
import com.cameroun.objis.smc.dao.LoginIDao;
import com.cameroun.objis.smc.dao.RecrutmentDao;
import com.cameroun.objis.smc.dao.RecrutmentIDao;
import com.cameroun.objis.smc.dao.RegistrationDao;
import com.cameroun.objis.smc.dao.RegistrationIDao;
import com.cameroun.objis.smc.dao.UserDao;
import com.cameroun.objis.smc.dao.UserIDao;
import com.cameroun.objis.smc.domaine.Recrutment;
import com.cameroun.objis.smc.domaine.Registration;
import com.cameroun.objis.smc.domaine.User;



public  class Service implements IService {
	
	LoginIDao loginDao;
	UserIDao userIDao;
	RecrutmentIDao recrutmentIDao;
	RegistrationIDao registrationDao;
	
	public Service(){
		
		loginDao = new LoginDao();
		userIDao = new UserDao();
		recrutmentIDao = new RecrutmentDao();
		registrationDao = new RegistrationDao();
	}
	

	@Override
	public User loginUserService(Connection conn, String userName, String password) throws SQLException {
		
		return loginDao.loginUser(conn, userName, password);
	}

	@Override
	public User loginUserService(Connection conn, String userName) throws SQLException {
		
		return loginDao.loginUser(conn, userName);
	}

	@Override
	public List<User> queryUserService(Connection conn) throws SQLException {
		
		return userIDao.queryUser(conn);
	}

	@Override
	public User findUserService(Connection conn, String user_ref) throws SQLException {
		
		return userIDao.findUser(conn, user_ref);
	}

	@Override
	public void updateUserService(Connection conn, User user) throws SQLException {
		userIDao.updateUser(conn, user);
	}

	@Override
	public void saveUserService(Connection conn, User user) throws SQLException {
		userIDao.saveUser(conn, user);
	}

	@Override
	public void deleteUserService(Connection conn, String login) throws SQLException {
		userIDao.deleteUser(conn, login);
	}

	@Override
	public List<User> getAllUsersService() throws ClassNotFoundException {
		return userIDao.getAllUsers();
	}

	@Override
	public List<Recrutment> queryRecrutmentService(Connection conn) throws SQLException {
		return recrutmentIDao.queryRecrutment(conn);
	}

	@Override
	public Recrutment findRecrutmentService(Connection conn, String recruitment_ref) throws SQLException {
		return recrutmentIDao.findRecrutment(conn, recruitment_ref);
	}

	@Override
	public void updateRecrutmentService(Connection conn, Recrutment recrutement) throws SQLException {
		recrutmentIDao.updateRecrutment(conn, recrutement);
	}

	@Override
	public void saveRecrutmentService(Connection conn, Recrutment recrutement) throws SQLException {
		recrutmentIDao.saveRecrutment(conn, recrutement);
	}

	@Override
	public void deleteRecrutmentService(Connection conn, String recruitment_ref) throws SQLException {
		recrutmentIDao.deleteRecrutment(conn, recruitment_ref);
	}

	@Override
	public List<Recrutment> getAllRecrutmentsService() throws ClassNotFoundException {
		return recrutmentIDao.getAllRecrutments();
	}

	@Override
	public List<Registration> queryRegistrationService(Connection conn) throws SQLException {
		return registrationDao.queryRegistration(conn);
	}

	@Override
	public Registration findRegistrationService(Connection conn, String registration_ref) throws SQLException {
		return registrationDao.findRegistration(conn, registration_ref);
	}

	@Override
	public void updateRegistrationService(Connection conn, Registration registration) throws SQLException {
		registrationDao.updateRegistration(conn, registration);
	}

	@Override
	public void saveRegistrationService(Connection conn, Registration registration) throws SQLException {
		registrationDao.saveRegistration(conn, registration);
	}

	@Override
	public void deleteRegistrationService(Connection conn, String registration_ref) throws SQLException {
		registrationDao.deleteRegistration(conn, registration_ref);
	}

	@Override
	public List<Registration> getAllRegistrationsService() throws ClassNotFoundException {
		return registrationDao.getAllRegistrations();
	}

	
}


