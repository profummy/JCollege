package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;

public interface ProfessorDAO {

	public void addProfessor(Professor professor);

	public void removeProfessor(String username);

	public void updateProfessor(Professor professor);

	public Professor getProfessor(String username);

	public List<Professor> getAllProfessors();

	public Professor getProfessorByCourse(Course course);

	public List<Professor> getAllProfessorsByDepartment(Department department);
	

}
