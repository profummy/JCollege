package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public interface StudentDAO {

	public void addStudent(Student student);

	public void removeStudent(String username);

	public void updateStudent(Student student);

	public Student getStudent(String username);

	public List<Student> getAllStudents();

	public List<Student> getAllStudentsByProfessor(Professor professor);

	public List<Student> getAllStudentsByCourse(Course course);
}
