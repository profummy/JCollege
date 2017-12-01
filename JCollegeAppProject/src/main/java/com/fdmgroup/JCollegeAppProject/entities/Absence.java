package com.fdmgroup.JCollegeAppProject.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "JC_ABSENCES")
public class Absence {
	
	@Id
	@SequenceGenerator(name = "absenceid_sequence", sequenceName = "absenceid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "absenceid_sequence")
	private int absenceId;
	private Calendar dateOfAbsence;
	private String reasonForAbsence;
	@Type(type="yes_no")
	private boolean absenceApproved;
	@ManyToOne
	@JoinColumn(name="STUDENT_USERNAME")
	private Student student;
	
	public Calendar getDateOfAbsence() {
		return dateOfAbsence;
	}
	
	public void setDateOfAbsence(Calendar dateOfAbsence) {
		this.dateOfAbsence = dateOfAbsence;
	}
	
	public String getReasonForAbsence() {
		return reasonForAbsence;
	}
	
	public void setReasonForAbsence(String reason) {
		this.reasonForAbsence = reason;
	}
	
	public boolean isAbsenceApproved() {
		return absenceApproved;
	}
	
	public void setAbsenceApproved(boolean absenceApproved) {
		this.absenceApproved = absenceApproved;
	}
	
	public int getAbsenceId() {
		return absenceId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
