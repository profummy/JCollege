package com.fdmgroup.JCollegeAppProject.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fdmgroup.JCollegeAppProject.utilities.Weekday;

@Entity
@Table(name = "JC_COURSES")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "courseid_sequence", sequenceName = "courseid", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseid_sequence")
	private int courseCode;
	private String courseName;
	private String courseInfo;
	private Date startDate;
	private Date endDate;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<String, Calendar> lessons = new HashMap<String, Calendar>();

	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private Set<Student> studentList;

	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;

	@ManyToOne
	@JoinColumn(name="PROFFESSOR_USERNAME")
	private Professor professor;

	public Course() {
		
		for(int i=0;i<5;i++){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017,9,30);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		lessons.put( Weekday.values()[i].name(), calendar);
		}
//		lessons.put(Weekday.TUESDAY.name(), calendar);
//		lessons.put(Weekday.WEDNESDAY.name(), calendar);
//		lessons.put(Weekday.THURSDAY.name(), calendar);
//		lessons.put(Weekday.FRIDAY.name(), calendar);
	}

	public Course(String courseName, String courseInfo, Date startDate, Date endDate, Department department, Professor professor) {
		super();
		this.courseName = courseName;
		this.courseInfo = courseInfo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.department = department;
		this.professor = professor;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public String getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
		if (professor != null){
			professor.addCourse(this);
		}
		
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", courseInfo=" + courseInfo
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", department=" + department + ", professor="
				+ professor + "]";
	}
	
	public Set<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void addStudent(Student student){
		studentList.add(student);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseCode != other.courseCode)
			return false;
		return true;
	}

	public void removeStudent(Student student) {
		studentList.remove(student);
	}
	
	public void removeProfessor(){
		this.professor = null;
	}

	public Map<String, Calendar> getLessons() {
		return lessons;
	}

	public void setLessons(Map<String, Calendar> lessons) {
		this.lessons = lessons;
	}
}
