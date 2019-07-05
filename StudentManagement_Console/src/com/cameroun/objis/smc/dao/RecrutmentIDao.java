package com.cameroun.objis.smc.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.cameroun.objis.smc.domaine.Recrutment;

public interface RecrutmentIDao {

	public  List<Recrutment> queryRecrutment(Connection conn) throws SQLException;
	public  Recrutment findRecrutment(Connection conn, String recruitment_ref) throws SQLException;
	public  void updateRecrutment(Connection conn, Recrutment recrutement) throws SQLException;
	public  void saveRecrutment(Connection conn, Recrutment recrutement) throws SQLException;
	public  void deleteRecrutment(Connection conn, String recruitment_ref) throws SQLException;
	public  List<Recrutment> getAllRecrutments() throws ClassNotFoundException;
	
}
