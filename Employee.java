package com.jwt.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Employee {

	@Id
	private int empid;
	@Column
	private String name;
	@Column
	private String job;
	public Employee() {
		super();
	}
	public Employee(int empid, String name, String job) {
		super();
		this.empid = empid;
		this.name = name;
		this.job = job;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", job=" + job + "]";
	}
	
}
