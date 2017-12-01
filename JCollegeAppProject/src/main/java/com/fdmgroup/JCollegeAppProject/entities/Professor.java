package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Professor")
public class Professor extends User implements Serializable {

	private String address;
	private String phone;
	private String fax;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="professor")
	private Set<Course> courses=new HashSet<Course>();
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Department department;
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	private List<Grade> gradeList;

	public Professor() {
		super();
	}

	public Professor(String address, String phone, String fax,
			Set<Course> course, Department department) {
		super();
		this.address = address;
		this.phone = phone;
		this.fax = fax;
		this.courses = course;
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Set<Course> getCourse() {
		return courses;
	}

	public void setCourse(Set<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course course){
		courses.add(course);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
