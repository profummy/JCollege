package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import com.fdmgroup.JCollegeAppProject.entities.Absence;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public interface AbsenceDAO {

	public void addAbsence(Absence absence);

	public void removeAbsence(int absenceId);

	public void updateAbsence(Absence absence);

	public Absence getAbsence(int absenceId);

	List<Absence> getAbsencesByStudent(Student student);

}
