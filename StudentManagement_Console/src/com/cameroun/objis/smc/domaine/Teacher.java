package com.cameroun.objis.smc.domaine;

public class Teacher extends Person{
	
	private int  subjectsNumber;
	private String firstSubjects;
	private String secondSubjects;
	
	
	public Teacher() {
		
		super();
		
	}


	public Teacher(String firstName, String lastName, String gender, String adress, int subjectsNumber, String firstSubjects, String lastSubjects) {
		super(firstName, lastName, gender, adress);
		this.subjectsNumber = subjectsNumber;
		this.firstSubjects = firstSubjects;
		this.secondSubjects = lastSubjects;
	}


	public int getSubjectsNumber() {
		return subjectsNumber;
	}


	public void setSubjectsNumber(int subjectsNumber) {
		this.subjectsNumber = subjectsNumber;
	}


	public String getFirstSubjects() {
		return firstSubjects;
	}


	public void setFirstSubjects(String firstSubjects) {
		this.firstSubjects = firstSubjects;
	}


	public String getLastSubjects() {
		return secondSubjects;
	}


	public void setLastSubjects(String lastSubjects) {
		this.secondSubjects = lastSubjects;
	}


	@Override
	public String toString() {
		return ", First Name=" + firstName + ", Last Name=" + lastName + ", Gender=" + gender + ", Subjects Number=" + subjectsNumber + 
				", First Subjects=" + firstSubjects + ", Last Subjects=" + secondSubjects + ", adress=" + adress;			
	}
}
