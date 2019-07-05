package com.cameroun.objis.smc.domaine;

import java.util.Date;


public class User extends Person{
	
	private int id;
	private String userRef;
	private String login;
	private String password;
	private String level;
	private String email;
	private Date date;
	
	public User() {
		super();
	}


	public User(String userRef, String firstName, String lastName, String gender, String adress, String login, String password, String level, String email, Date date) {
		
		super(firstName, lastName, gender, adress);
		this.userRef = userRef;
		this.login = login;
		this.password = password;
		this.level = level;
		this.email = email;
		this.date = date;
	}

	public User(int id, String userRef, String login, String password, String level, String email, Date date) {
		super();
		this.id = id;
		this.userRef = userRef;
		this.login = login;
		this.password = password;
		this.level = level;
		this.email = email;
		this.date = date;
	}


	public String getUserRef() {
		return userRef;
	}

	public void setUserRef(String userRef) {
		this.userRef = userRef;
	}

	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdUser() {
		return userRef;
	}

	public void setIdUser(String idUser) {
		this.userRef = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User" + ", userRef=" + userRef + ", login=" + login + ", password=" + password + ", level="
				+ level + ", email=" + email + ", date=" + date + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", adress=" + adress;
	}


}
