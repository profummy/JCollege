package com.fdmgroup.JCollegeAppProject.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Department;

public class ProjectRunner {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoPersistence");
//		
//		CourseDAO courseDao = new CourseDAOImpl(factory);
//		StudentDAO studentDao = new StudentDAOImpl(factory);
//		AbsenceDAO absenceDao = new AbsenceDAOImpl(factory);
//		UserDAO userDao = new UserDAOImpl(factory);
		DepartmentDAO depDao = new DepartmentDAOImpl(factory);
		Department dep = new Department();
		dep.setDepartmentName("Biology");
		
		depDao.addDepartment(dep);
		
//		List<User> list = userDao.getAllBlockedUsers();
		
//		for (User user : list){
//			System.out.println(user.getUsername());
//		}
//		
//		Student student = studentDao.getStudent("ABC");
//		Absence absence = absenceDao.getAbsence(1);
//		System.out.println(absence.isAbsenceApproved());
		
//		GradeDAO gradeDao = new GradeDAOImpl(factory);
//		ProfessorDAO professorDao = new ProfessorDAOImpl(factory);
//		
//		Professor professor = professorDao.getProfessor("professor");
//		
//		List<Course> courseList = courseDao.getAllCoursesByProfessor(professor);
//		
//		System.out.println(courseList);
		
//		Map<Weekday, Calendar> lessons = new HashMap<Weekday, Calendar>();
//		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.HOUR_OF_DAY, 13);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.SECOND, 0);
//		
//		lessons.put(Weekday.TUESDAY, cal);
//		
//		Course course = new Course();
//		course.setCourseName("Game Theory");
//		course.setLessons(lessons);
//		courseDao.addCourse(course);
//		
//		Course course = courseDao.getCourse(3);
//		
//		Calendar calendar = course.getLessons().get(Weekday.TUESDAY);
//		
//		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
//		
//		System.out.println("Time");
//		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
//		System.out.println(cal.get(Calendar.MINUTE));
//		System.out.println(cal.get(Calendar.SECOND));
		
		
//		factory.close();
	}

}
