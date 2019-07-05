package com.cameroun.objis.smc.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.cameroun.objis.smc.domaine.Recrutment;
import com.cameroun.objis.smc.domaine.Registration;
import com.cameroun.objis.smc.domaine.Student;
import com.cameroun.objis.smc.domaine.Teacher;

public class ReadInput {
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	private static Date date = new Date();
	private static String dateStr = sdf.format(date);;
    
	
	public static Registration SaveRegistration() {
		
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
		
		System.out.println("Please enter a Student Registration input...");
		System.out.println("\n");
        System.out.println("Enter a Register Id --Example LK001---: ");
        registerId = ReadKeyboard.readString();
        
        System.out.println("\n");
        System.out.println("Enter the first name: ");
        firstName = ReadKeyboard.readString();
        
        System.out.println("\n");
        System.out.println("Enter the last name: ");
        lastName = ReadKeyboard.readString();
        
        System.out.println("\n");
        System.out.println("Enter the gender: ");
        gender = ReadKeyboard.readString();
        
        System.out.println("\n");
        System.out.println("Enter the adress: ");
        adress = ReadKeyboard.readString();
        
        System.out.println("\n");
        System.out.println("Enter the age: ");
        age = ReadKeyboard.readInt();
        
        System.out.println("\n");
        System.out.println("Enter the class Room: ");
        classRoom = ReadKeyboard.readString();
        
        System.out.println("\n");
        System.out.println("Enter the Fees for Registration: ");
        fees = ReadKeyboard.readBigDecimal();

        student = new Student(firstName, lastName, gender, adress, age, classRoom);
        registration = new Registration(registerId, student, fees, dateStr); 
        
		return registration;
	}
	
	
	public static Registration updateRegistration() {
			
			Registration updateRegistration = null;
			
			Student student = null;
			String registerId = null;
			String firstName = null;
			String lastName = null;
			String gender = null;
			String adress = null;
			int age = 0;
			String classRoom = null;
			BigDecimal fees = null;
			
			System.out.println("Please enter a Student Registration input...");
			System.out.println("\n");
	        System.out.println("Enter a Register Id to be Modify---: ");
	        registerId = ReadKeyboard.readString();
	
	        System.out.println("\n");
	        System.out.println("Enter the first name: ");
	        firstName = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the last name: ");
	        lastName = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the gender: ");
	        gender = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the adress: ");
	        adress = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the age: ");
	        age = ReadKeyboard.readInt();
	        
	        System.out.println("\n");
	        System.out.println("Enter the class Room: ");
	        classRoom = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the Fees for Registration: ");
	        fees = ReadKeyboard.readBigDecimal();
	        
	        student = new Student(firstName, lastName, gender, adress, age, classRoom);
	        updateRegistration = new Registration(registerId, student, fees, dateStr); 
	        
			return updateRegistration;
		}
	
		public static Recrutment SaveRecrutment() {
			
			Recrutment recrutment = null;
			
			Teacher teacher = null;
			String teacherRef;
			String firstName = null;
			String lastName = null;
			String gender = null;
			String adress = null;
			
			int  subjectsNumber;
			String firstSubjects;
			String secondSubjects;

			int numberHourTeached;
		    BigDecimal hourFees;
		    BigDecimal salary;
		
			
			System.out.println("Please enter a Teacher Informations ...");
			System.out.println("\n");
	        System.out.println("Enter a Teacher Id --Example LK001---: ");
	        teacherRef = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the first name: ");
	        firstName = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the last name: ");
	        lastName = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the gender: ");
	        gender = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the adress: ");
	        adress = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the Number of subjects teaching by this Teacher: ");
	        subjectsNumber = ReadKeyboard.readInt();
	        
	        System.out.println("\n");
	        System.out.println("Enter the first Subject: ");
	        firstSubjects = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the second Subject: ");
	        secondSubjects = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the Number of Hour Teached by this Teacher: ");
	        numberHourTeached = ReadKeyboard.readInt();
	        
	        System.out.println("\n");
	        System.out.println("How much is the cost of Hour teached: ");
	        hourFees = ReadKeyboard.readBigDecimal();
	        System.out.println("\n");
	         
	        salary = hourFees.multiply(new BigDecimal(numberHourTeached * 4));
	
	        teacher = new Teacher(firstName, lastName, gender, adress, subjectsNumber, firstSubjects, secondSubjects);
	        recrutment = new Recrutment(teacherRef, teacher, numberHourTeached, hourFees, salary, dateStr); 
	        
			return recrutment;
		}
		
		
		public static Recrutment updateRecrutment() {
			
			Recrutment recrutment = null;
			
			Teacher teacher = null;
			String teacherRef;
			String firstName = null;
			String lastName = null;
			String gender = null;
			String adress = null;
			
			int  subjectsNumber;
			String firstSubjects;
			String secondSubjects;

			int numberHourTeached;
		    BigDecimal hourFees;
		    BigDecimal salary;
			
			System.out.println("Please enter a Teacher Informations ...");
			System.out.println("\n");
	        System.out.println("Enter a Teacher Id to be Modify---: ");
	        teacherRef = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the first name: ");
	        firstName = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the last name: ");
	        lastName = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the gender: ");
	        gender = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the adress: ");
	        adress = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the Number of subjects teaching by this Teacher: ");
	        subjectsNumber = ReadKeyboard.readInt();
	        
	        System.out.println("\n");
	        System.out.println("Enter the first Subject: ");
	        firstSubjects = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the second Subject: ");
	        secondSubjects = ReadKeyboard.readString();
	        
	        System.out.println("\n");
	        System.out.println("Enter the Number of Hour Teached by this Teacher: ");
	        numberHourTeached = ReadKeyboard.readInt();
	        
	        System.out.println("\n");
	        System.out.println("How much is the cost of Hour teached: ");
	        hourFees = ReadKeyboard.readBigDecimal();
	        
	        salary = hourFees.multiply(new BigDecimal(numberHourTeached * 4));
	
	        teacher = new Teacher(firstName, lastName, gender, adress, subjectsNumber, firstSubjects, secondSubjects);
	        recrutment = new Recrutment(teacherRef, teacher, numberHourTeached, hourFees, salary, dateStr); 
	        
			return recrutment;
		}
		
}