package com.cameroun.objis.smc.domaine;


public class Student extends Person{

	// Les instances de la classe
	private int age;
	private String classRoom;

	
	public Student() {
		super();
	}
	
	


	public Student(String firstName, String lastName, String gender, String adress,int age, String classRoom) {
		super(firstName, lastName, gender, adress);
		this.age = age;
		this.classRoom = classRoom;
	}

	



	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}


	@Override
	public String toString() {
		return "Name=" + firstName + ", Last Name=" + lastName + ", Age=" + age + ", classRoom=" + classRoom + 
				", Gender=" + gender + ", Adress=" + adress ;
	}

	

	/*
	@Override
	public String toString() {
		return "Nom=" + nom + ", Prenom=" + prenom + ", Genre=" + genre + ", Adresse=" + adresse + ", Naissance=" + age + ", Classe=" + classe ;
	}
	*/
			
}
