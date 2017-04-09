package com.example.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fresher")
public class Fresher implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "employee_id")	
	private String employeeId;
	
	@Basic(optional = false)
	@Column(name = "full_name")	
	private String fullName;
	
	@Basic(optional = false)
	@Column(name = "sex")	
	private String sex;
	
	@Basic(optional = false)
	@Column(name = "short_name")	
	private String shortName;
	
	@Basic(optional = false)
	@Column(name = "office")	
	private String office;
	
	@Basic(optional = false)
	@Column(name = "cube")	
	private int cube;
	
	Fresher(){}

	public Fresher(String employeeId, String fullName, String sex, String shortName, String office, int cube) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.sex = sex;
		this.shortName = shortName;
		this.office = office;
		this.cube = cube;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public int getCube() {
		return cube;
	}

	public void setCube(int cube) {
		this.cube = cube;
	}

	
}
