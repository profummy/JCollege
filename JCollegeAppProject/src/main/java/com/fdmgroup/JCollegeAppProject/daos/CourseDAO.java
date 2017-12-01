package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public interface CourseDAO {

	public void addCourse(Course course);

	public void removeCourse(int courseCode);

	public void updateCourse(Course course);

	public Course getCourse(int courseCode);

	public List<Course> getAllCourses();

	public List<Course> getAllCoursesByDepartment(Department department);
	
	public List<Course> getAllCoursesByStudent(Student student);
	
	public List<Course> getAllNonEnrolledCoursesByStudent(Student student);
	
	public List<Course>getAllCoursesByProfessor(Professor professor);

	public List<Course> getCourseByName(String name);

	public List<Course> getEmptyCourses(String name);


}
