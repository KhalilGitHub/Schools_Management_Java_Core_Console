package com.cameroun.objis.smc.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cameroun.objis.smc.domaine.Recrutment;
import com.cameroun.objis.smc.domaine.Teacher;
import com.cameroun.objis.smc.utils.CloseConnection;
import com.cameroun.objis.smc.utils.ConnectionMysql;

public class RecrutmentDao implements RecrutmentIDao{
	
	@Override
	public  void saveRecrutment(Connection conn, Recrutment recrutment) throws SQLException 
	{        
		String sql = "INSERT  INTO `tbl_recrutment`(`teacherRef`,`firstName`,`lastName`,`gender`,`adress`,`subjectsNumber`,`firstSubjects`,`lastSubjects`,`numberHourTeached`,`hourFees`,`salary`,`date`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";         
		       
		PreparedStatement pstm = conn.prepareStatement(sql);    
		
		try
		{
			pstm.setString(1, recrutment.getTeacherId());
			pstm.setString(2, recrutment.getTeacher().getFirstName());
			pstm.setString(3, recrutment.getTeacher().getLastName());
			pstm.setString(4, recrutment.getTeacher().getGender());
			pstm.setString(5, recrutment.getTeacher().getAdress());
			
			pstm.setInt(6, recrutment.getTeacher().getSubjectsNumber());
			pstm.setString(7, recrutment.getTeacher().getFirstSubjects());
			pstm.setString(8, recrutment.getTeacher().getLastSubjects());
			pstm.setInt(9, recrutment.getNumberHourTeached());
			pstm.setBigDecimal(10, recrutment.getHourFees());
			pstm.setBigDecimal(11, recrutment.getSalary());
			pstm.setString(12, recrutment.getDate());
		
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      e.printStackTrace();
		  } 
		    
	}     

	@Override
	public  List<Recrutment> queryRecrutment(Connection conn) throws SQLException 
	{     
		
		Recrutment recrutment = null;
		Teacher teacher = null;
		
		String teacher_id = null;
		String firstName = null;
		String lastName = null;
		String gender = null;
		String adress = null;
		
		
		int subjectNumber = 0;
		String firstSubject = null;
		String lastSubject = null;
		int numberHourTeached = 0;
		BigDecimal hourFees = null;
		BigDecimal salary = null;
		
		String date = null; 
		
		
			String sql = "Select  a.teacherRef, a.firstName, a.lastName, a.gender, a.adress, a.subjectsNumber, a.firstSubjects, a.lastSubjects, a.numberHourTeached, a.hourFees, a.salary, a.Date from tbl_recrutment a;";         
			PreparedStatement pstm = conn.prepareStatement(sql);         
			ResultSet rs = pstm.executeQuery();        
			List<Recrutment> list = new ArrayList<Recrutment>();  
			
			try
			{
				while (rs.next()) 
				{      
						
					teacher_id = rs.getString("teacherRef");
					firstName = rs.getString("firstName");
					lastName = rs.getString("lastName");
					gender = rs.getString("gender");
					adress = rs.getString("adress");
					subjectNumber = rs.getInt("subjectsNumber");
					firstSubject = rs.getString("firstSubjects");
					lastSubject = rs.getString("lastSubjects");
					numberHourTeached = rs.getInt("numberHourTeached");
					hourFees = rs.getBigDecimal("hourFees");
					salary = rs.getBigDecimal("salary");
					date = rs.getString("Date");
				
					recrutment = new Recrutment();
					teacher = new Teacher();
					
					recrutment.setTeacherId(teacher_id);
					teacher.setFirstName(firstName);
					teacher.setLastName(lastName);
					teacher.setGender(gender);
					teacher.setAdress(adress);
					teacher.setSubjectsNumber(subjectNumber);
					teacher.setFirstSubjects(firstSubject);
					teacher.setLastSubjects(lastSubject);
					
					recrutment.setTeacher(teacher);
					recrutment.setNumberHourTeached(numberHourTeached);
					recrutment.setHourFees(hourFees);
					recrutment.setSalary(salary);
					recrutment.setDate(date);
						
				
					
					list.add(recrutment); 					
				}        
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } finally {
			  CloseConnection.close(conn, pstm, rs);
		  }
		return list;    
	}     
	
	
	@Override
	public  Recrutment findRecrutment(Connection conn, String recruitment_ref) throws SQLException 
	{        
	
		Recrutment recrutment = null;
		Teacher teacher = null;
		
		String firstName = null;
		String lastName = null;
		String gender = null;
		String adress = null;
		
		int subjectNumber = 0;
		String firstSubject = null;
		String lastSubject = null;
		int numberHourTeached = 0;
		BigDecimal hourFees = null;
		BigDecimal salary = null;
		
		String date = null; 
		
		String sql = "Select a.firstName, a.lastName, a.gender, a.adress, a.subjectsNumber, a.firstSubjects, a.lastSubjects, a.numberHourTeached, a.hourFees, a.salary, a.date from tbl_recrutment a Where teacherRef = ?";         
		PreparedStatement pstm = conn.prepareStatement(sql);        
				
		pstm.setString(1, recruitment_ref);         
		ResultSet rs = pstm.executeQuery();   
		
		try
		{
			while (rs.next()) 
			{       
			
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
				gender = rs.getString("gender");
				adress = rs.getString("adress");
				
				subjectNumber = rs.getInt("subjectsNumber");
				firstSubject = rs.getString("firstSubjects");
				lastSubject = rs.getString("lastSubjects");
				numberHourTeached = rs.getInt("numberHourTeached");
				hourFees = rs.getBigDecimal("hourFees");
				salary = rs.getBigDecimal("salary");
				date = rs.getString("date");
						
				recrutment = new Recrutment();
				teacher = new Teacher();
				
				teacher.setFirstName(firstName);
				teacher.setLastName(lastName);
				teacher.setGender(gender);
				teacher.setAdress(adress);
				
				teacher.setSubjectsNumber(subjectNumber);
				teacher.setFirstSubjects(firstSubject);
				teacher.setLastSubjects(lastSubject);
				recrutment.setNumberHourTeached(numberHourTeached);
				recrutment.setHourFees(hourFees);
				recrutment.setSalary(salary);
				recrutment.setDate(date);
				
	   			recrutment = new Recrutment(recruitment_ref, teacher, subjectNumber, hourFees, salary, date);            
				       
			}       
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } finally {
			  CloseConnection.close(conn, pstm, rs);
		  }
		
		return recrutment;
	}   
	
	
	@Override
	public  void updateRecrutment(Connection conn, Recrutment recrutment) throws SQLException 
	{        
		String sql = "UPDATE tbl_recrutment SET firstName = ?, lastName = ?, gender = ?, adress = ?, subjectsNumber = ?, firstSubjects = ?, lastSubjects = ?, numberHourTeached = ?, hourFees = ?, salary = ?, date = ? WHERE teacherRef = ?";         
		
		PreparedStatement pstm = conn.prepareStatement(sql);         
		
		try
		{
			pstm.setString(1, recrutment.getTeacher().getFirstName());
			pstm.setString(2, recrutment.getTeacher().getLastName());
			pstm.setString(3, recrutment.getTeacher().getGender());
			pstm.setString(4, recrutment.getTeacher().getAdress());
			
			pstm.setInt(5, recrutment.getTeacher().getSubjectsNumber());
			pstm.setString(6, recrutment.getTeacher().getFirstSubjects());
			pstm.setString(7, recrutment.getTeacher().getLastSubjects());
			pstm.setInt(8, recrutment.getNumberHourTeached());
			pstm.setBigDecimal(9, recrutment.getHourFees());
			pstm.setBigDecimal(10, recrutment.getSalary());
			pstm.setString(11, recrutment.getDate());

			pstm.setString(12, recrutment.getTeacherId());
			
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } 
	}   
	
	
	
	@Override
	public  void deleteRecrutment(Connection conn, String recruitment_ref) throws SQLException 
	{    
		try
		{
			
			String sql = "Delete From tbl_recrutment WHERE teacherRef = ?";         
			PreparedStatement pstm = conn.prepareStatement(sql);         
			
			pstm.setString(1, recruitment_ref);         
			pstm.executeUpdate();
			
		}
		catch (SQLException e) {
		      throw new SQLException(e);
		  } 
	} 
	
	@Override
	public  List<Recrutment> getAllRecrutments() throws ClassNotFoundException {
		
		 List<Recrutment> lrecrutment = new ArrayList<Recrutment>();
		 Connection con = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 
		 try{
		 con = ConnectionMysql.getInstance();
		 String sql="SELECT * FROM tbl_recrutment";
		 
		 pst = con.prepareStatement(sql);
		 
		 rs = pst.executeQuery();
		 
		 while(rs.next()){
		 
			 	Recrutment recrutment = new Recrutment();			 	
			 	
			 	
			 	Teacher teacher = new Teacher();
				
				recrutment.setTeacherId(rs.getString(2));
				teacher.setFirstName(rs.getString(3));
				teacher.setLastName(rs.getString(4));
				teacher.setGender(rs.getString(5));
				teacher.setAdress(rs.getString(6));
				teacher.setSubjectsNumber(rs.getInt(7));
				recrutment.setNumberHourTeached(rs.getInt(8));
				teacher.setFirstSubjects(rs.getString(9));
				
				teacher.setLastSubjects(rs.getString(10));
				
				recrutment.setTeacher(teacher); 
				
				recrutment.setHourFees(rs.getBigDecimal(11));
				recrutment.setSalary(rs.getBigDecimal(12));
				recrutment.setDate(rs.getString(13));
				
				lrecrutment.add(recrutment);		
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
		 return lrecrutment;
	 }	 
	
}

