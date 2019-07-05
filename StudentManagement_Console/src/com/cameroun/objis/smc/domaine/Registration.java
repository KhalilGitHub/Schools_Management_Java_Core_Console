package com.cameroun.objis.smc.domaine;

import java.math.BigDecimal;

public class Registration {
	
	private int id;
	private String registerRef;
	private Student student;
    private BigDecimal fees;
    private String date;
    
    public Registration() {
		super();
	}

    public Registration(Student student, BigDecimal fees, String date) {
		super();
		this.student = student;
		this.fees = fees;
		this.date = date;
	}
    
	public Registration(String registerId, Student student, BigDecimal fees, String date) {
		super();
		this.registerRef = registerId;
		this.student = student;
		this.fees = fees;
		this.date = date;
	}


	public Registration(int id, String registerId, Student student, BigDecimal fees, String date) {
		super();
		this.id = id;
		this.registerRef = registerId;
		this.student = student;
		this.fees = fees;
		this.date = date;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	public String getRegisterRef() {
		return registerRef;
	}

	public void setRegisterRef(String registerRef) {
		this.registerRef = registerRef;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "registerId=" + registerRef + ", student=" + student + ", fees=" + fees + ", String=" + date;
	}
    
}
