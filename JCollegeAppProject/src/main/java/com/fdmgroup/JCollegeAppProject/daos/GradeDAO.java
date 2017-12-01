package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public interface GradeDAO {
	
	public void addGrade (Grade grade);
	public void removeGrade (int gradeId);
	public void updateGrade (Grade grade);
	public Grade getGrade (int gradeId);
	public List <Grade> getAllGrades();
	public List <Grade> getAllGradesByStudent(Student student);
	public List <Grade> getAllGradesByProfessor(Professor professor);
	public List<Grade> getAllGradesByCourse(Course course);
	public Grade getGradeForStudentForCourse(Course course, Student student);
}

