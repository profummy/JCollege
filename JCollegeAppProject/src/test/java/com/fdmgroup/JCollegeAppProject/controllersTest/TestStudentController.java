package com.fdmgroup.JCollegeAppProject.controllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.StudentController;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.utilities.Weekday;

public class TestStudentController {

	StudentController studentController;
	String username;
	int courseCode;

	@Mock
	Model model;
	HttpSession session;
	Principal principal;
	CourseDAO courseDao;
	StudentDAO studentDao;
	GradeDAO gradeDao;
	Student student;
	ArrayList<Course> courseList;
	Course course;

	@Before
	public void setUp() {
		model = mock(Model.class);
		principal = mock(Principal.class);
		session = mock(HttpSession.class);
		studentDao = mock(StudentDAO.class);
		courseDao = mock(CourseDAO.class);
		gradeDao = mock(GradeDAO.class);
		studentController = new StudentController(courseDao, studentDao, gradeDao);
		student = mock(Student.class);
		courseList = new ArrayList<Course>();
		course = mock(Course.class);
	}

	@Test
	public void test_GoToViewCourse_ReturnsStudentStudentViewCourse() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getAllCoursesByStudent(student)).thenReturn(courseList);
		assertEquals("student/studentViewCourses", studentController.goToViewCourses(session, model, principal));
	}

	@Test
	public void test_doEnrollOnCourse_ReturnsRedirectViewCourses() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("ABC");
		assertEquals("redirect:ViewCourses", studentController.doEnrollOnCourse(courseCode, session, model, principal));
	}

	@Test
	public void test_doVacateCourse_ReturnsRedirectViewCourses() {
		StudentController s = new StudentController();
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("ABC");
		assertEquals("redirect:ViewCourses", studentController.doVacateCourse(courseCode, session, model, principal));
	}

	@Test
	public void test_GoToViewProfile_ReturnsStudentStudentViewProfile() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("ABC");
		assertEquals("student/studentViewProfile", studentController.goToViewProfile(session, model, principal));
	}

	@Test
	public void test_GoToEditProfile_ReturnsStudentEditProfile() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("ABC");
		assertEquals("student/editProfile", studentController.goToEditProfile(model, principal));
	}

	@Test
	public void test_DoUpdateProfile_ReturnsStudentStudentViewProfile() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("ABC");
		assertEquals("student/studentViewProfile", studentController.doUpdateProfile(student, model, principal));
	}

	@Test
	public void test_GoToChangePassword_ReturnsStudentChangePassword() {
		assertEquals("student/changePassword", studentController.goToChangePassword(model, principal));
	}

	@Test
	public void test_DoChangePassword_ReturnsStudentEditProfile_WhenCorrectDetailsAreEntered() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(student.getPassword()).thenReturn("ABC");
		assertEquals("student/editProfile", studentController.doChangePassword("ABC", "DEF", "DEF", model, principal));
	}

	@Test
	public void test_DoChangePassword_ReturnsStudentChangePassword_WhenIncorrectCurrentPasswordIsEntered() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(student.getPassword()).thenReturn("ABD");
		assertEquals("student/changePassword",
				studentController.doChangePassword("ABC", "DEF", "DEF", model, principal));
	}

	@Test
	public void test_DoChangePassword_ReturnsStudentChangePassword_WhenPasswordsEnteredDoNotMatch() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(student.getPassword()).thenReturn("ABC");
		assertEquals("student/changePassword",
				studentController.doChangePassword("ABC", "DEF", "DEG", model, principal));
	}

	@Test
	public void test_GoToViewGrades_ReturnsStudentViewGrades() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		assertEquals("student/viewGrades", studentController.goToViewGrades(model, principal));
	}

	@Test
	public void test_DoSearchCourse_ReturnsStudentStudentViewcourses() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		assertEquals("student/studentViewCourses", studentController.doSearchCourse("ABC", model, principal));
	}

	@Test
	public void test_DoSearchCourse_ReturnsStudentStudentViewcourses_WhenCourseIdIsEntered() {
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		assertEquals("student/studentViewCourses", studentController.doSearchCourse("101", model, principal));
	}
	
	@Test
	public void test_Do2SearchCourse_ReturnsStudentStudentViewcourses_WhenCourseIdIsEntered() {
		Set<Course> set = new HashSet<Course>();
		set.add(course);
		when(principal.getName()).thenReturn(username);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(student.getCourseList()).thenReturn(set);
		assertEquals("student/viewTimetable", studentController.goToViewTimetable(session, model, principal));
	}
	
	@Test
	public void test_Do2SearchCourse1_ReturnsStudentStudentViewcourses_WhenCourseIdIsEntered() {
		Calendar calendar = Calendar.getInstance();
		Map<String, Calendar> map = mock(Map.class);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getLessons()).thenReturn(map);
		when(map.get(Weekday.MONDAY.name())).thenReturn(calendar);
		when(map.get(Weekday.TUESDAY.name())).thenReturn(calendar);
		when(map.get(Weekday.WEDNESDAY.name())).thenReturn(calendar);
		when(map.get(Weekday.THURSDAY.name())).thenReturn(calendar);
		when(map.get(Weekday.FRIDAY.name())).thenReturn(calendar);
		assertEquals("student/viewCourse", studentController.goToViewCourse(courseCode, model, principal));
	}

}
