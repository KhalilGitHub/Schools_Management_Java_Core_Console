package com.cameroun.objis.smc.domaine;

import java.math.BigDecimal;

public class Recrutment {
	
	private int id;
	private int numberHourTeached;
	private String teacherRef;
	private Teacher teacher;
    private BigDecimal hourFees;
    private BigDecimal salary;
    private String date;
   
    
	public Recrutment() {
		super();
		
		
	}


	public Recrutment(String teacherId, Teacher teacher, int numberHourTeached, BigDecimal hourFees, BigDecimal salary,
			String date) {
		super();
		this.numberHourTeached = numberHourTeached;
		this.teacherRef = teacherId;
		this.teacher = teacher;
		this.hourFees = hourFees;
		this.salary = salary;
		this.date = date;
	}

	

	public Recrutment(int id, int numberHourTeached, String teacherId, Teacher teacher, BigDecimal hourFees,
			BigDecimal salary, String date) {
		super();
		this.id = id;
		this.numberHourTeached = numberHourTeached;
		this.teacherRef = teacherId;
		this.teacher = teacher;
		this.hourFees = hourFees;
		this.salary = salary;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumberHourTeached() {
		return numberHourTeached;
	}


	public void setNumberHourTeached(int numberHourTeached) {
		this.numberHourTeached = numberHourTeached;
	}


	public String getTeacherId() {
		return teacherRef;
	}


	public void setTeacherId(String teacherId) {
		this.teacherRef = teacherId;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public BigDecimal getHourFees() {
		return hourFees;
	}


	public void setHourFees(BigDecimal hourFees) {
		this.hourFees = hourFees;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "[id=" + id + numberHourTeached + ", teacherId=" + teacherRef
				+ teacher + ", numberHourTeached=" + ", hourFees=" + hourFees + ", salary=" + salary + ", date=" + date + "]";
	}
	
}
