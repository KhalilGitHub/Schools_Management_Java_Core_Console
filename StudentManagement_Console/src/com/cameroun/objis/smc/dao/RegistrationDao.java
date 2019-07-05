package com.cameroun.objis.smc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.cameroun.objis.smc.domaine.Registration;
import com.cameroun.objis.smc.domaine.Student;
import com.cameroun.objis.smc.utils.ConnectionMysql;

import java.util.List;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class RegistrationDao implements RegistrationIDao{

	@Override
	public List<Registration> queryRegistration(Connection conn) throws SQLException 
	{     
		
		Registration registration = null;
		Student student = null;
		String registerId = null;
		String firstName = null;
		String lastName = null;
		String gender = null;
		String adress = null;
		int age = 0;
		String classRoom = null;
		BigDecimal fees = null;
		String date = null; 
		
		
			String sql = "SELECT a.registerRef, a.firstName, a.lastName, a.gender, a.adress, a.age, a.classRoom, a.fees, a.Date FROM tbl_student_register a";         
			PreparedStatement pstm = conn.prepareStatement(sql);         
			ResultSet rs = pstm.executeQuery();        
			List<Registration> list = new ArrayList<Registration>();  
			
			try
			{
				while (rs.next()) 
				{      
						
					registerId = rs.getString("Matricule");
					firstName = rs.getString("Nom");
					lastName = rs.getString("Prenom");
					gender = rs.getString("Genre");
					adress = rs.getString("Adresse");
					age = rs.getInt("Age");
					classRoom = rs.getString("Classe");
					fees = rs.getBigDecimal("Frais");
					date = rs.getString("date");
				
					registration = new Registration();
					student = new Student();
					registration.setRegisterRef(registerId);;
					student.setFirstName(firstName);
					student.setLastName(lastName);
					student.setGender(gender);
					student.setAdress(adress);
					student.setAge(age);
					student.setClassRoom(classRoom);
					
					registration.setStudent(student);            
					registration.setFees(fees); 
					registration.setDate(date);
						
					list.add(registration); 					
				}        
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } 
		
		return list;    
	}     
	
	@Override
	public Registration findRegistration(Connection conn, String registration_ref) throws SQLException 
	{        
	
		Registration registration = null;
		Student student = null;
		String firstName = null;
		String lastName = null;
		String gender = null;
		String adress = null;
		int age = 0;
		String classRoom = null;
		BigDecimal fees = null;
		String date = null; 
		
		String sql = "Select a.firstName, a.lastName, a.gender, a.adress, a.age, a.classRoom, a.fees, a.Date from tbl_student_register a Where registerRef = ?";         
		PreparedStatement pstm = conn.prepareStatement(sql);        
				
		pstm.setString(1, registration_ref);         
		ResultSet rs = pstm.executeQuery();   
		
		try
		{
			while (rs.next()) 
			{       
			
				firstName = rs.getString("Nom");
				lastName = rs.getString("Prenom");
				gender = rs.getString("Genre");
				adress = rs.getString("Adresse");
				age = rs.getInt("Age");
				classRoom = rs.getString("Classe");
				fees = rs.getBigDecimal("Frais");
				date = rs.getString("date");
			
			
				registration = new Registration();
				student = new Student();
				
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setGender(gender);
				student.setAdress(adress);
				student.setAge(age);
				student.setClassRoom(classRoom);
				registration.setStudent(student);            
				registration.setFees(fees); 
				registration.setDate(date);             

				registration = new Registration(registration_ref, student, fees, date);            
				       
			}       
		}
		catch (SQLException e) {
		      throw new SQLException(e);
			  } 
			
		return registration;
	}     
	
	@Override
	public void updateRegistration(Connection conn, Registration registration) throws SQLException 
	{        
		String sql = "UPDATE tbl_student_register SET `firstName`= ?, lastName = ?, gender = ?, adress = ?, age = ?, classRoom = ?, fees = ?, DATE = ? WHERE registerRef = ?";         
		
		PreparedStatement pstm = conn.prepareStatement(sql);         
		
		try
		{
			pstm.setString(1, registration.getStudent().getFirstName());
			pstm.setString(2, registration.getStudent().getLastName());
			pstm.setString(3, registration.getStudent().getGender());
			pstm.setString(4, registration.getStudent().getAdress());
			pstm.setInt(5, registration.getStudent().getAge());
			pstm.setString(6, registration.getStudent().getClassRoom());
			pstm.setBigDecimal(7, registration.getFees());
			pstm.setString(8, registration.getDate());

			pstm.setString(9, registration.getRegisterRef());
			
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } 
		    
	}     
	
	@Override
	public void saveRegistration(Connection conn, Registration registration) throws SQLException 
	{        
		String sql = "INSERT  INTO `tbl_student_register`(`registerRef`,`firstName`,`lastName`,`gender`,`adress`,`age`,`classRoom`,`fees`,`date`) \r\n" + 
				"		VALUES (?,?,?,?,?,?,?,?,?)";         
		
		PreparedStatement pstm = conn.prepareStatement(sql);    
		
		try
		{
			
			pstm.setString(1, registration.getRegisterRef());
			pstm.setString(2, registration.getStudent().getFirstName());
			pstm.setString(3, registration.getStudent().getLastName());
			pstm.setString(4, registration.getStudent().getGender());
			pstm.setString(5, registration.getStudent().getAdress());
			pstm.setInt(6, registration.getStudent().getAge());
			pstm.setString(7, registration.getStudent().getClassRoom());
			pstm.setBigDecimal(8, registration.getFees());
			pstm.setString(9, registration.getDate());
		
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      e.printStackTrace();
		  } 
		    
	}     
	
	@Override
	public void deleteRegistration(Connection conn, String registration_ref) throws SQLException 
	{    
		try
		{
			String sql = "Delete From tbl_student_register WHERE registerRef =?";         
			PreparedStatement pstm = conn.prepareStatement(sql);         
			
			pstm.setString(1, registration_ref);         
			pstm.executeUpdate();
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  }
	} 
	
	@Override
	public  List<Registration> getAllRegistrations() throws ClassNotFoundException {
		
		 List<Registration> lregistration = new ArrayList<Registration>();
		 Connection conn = null;
		 
		 try{
		 conn = ConnectionMysql.getInstance();
		 String sql="SELECT * FROM tbl_student_register";
		 
		 PreparedStatement pst = conn.prepareStatement(sql);
		 
		 ResultSet rs = pst.executeQuery();
		 
		 while(rs.next()){
		 
			    Registration registration = new Registration();			 	
			 	Student student = new Student();
				registration.setRegisterRef(rs.getString(2));
				student.setFirstName(rs.getString(3));
				student.setLastName(rs.getString(4));
				student.setGender(rs.getString(5));
				student.setAdress(rs.getString(6));
				student.setAge(rs.getInt(7));
				student.setClassRoom(rs.getString(8));
				registration.setStudent(student);            
				registration.setFees(rs.getBigDecimal(9)); 
				registration.setDate(rs.getString(10));	
			 
				 lregistration.add(registration);	
			 }
			 
			 }
			 catch(SQLException e){
			 e.printStackTrace();
			  }
		 return lregistration;
	 }
	
} 