package com.fdmgroup.JCollegeAppProject.controllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.ProfessorController;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class ProfessorControllerTest {
	
	ProfessorController professorController;
	String username = "USERNAME";
	int courseCode = 101;
	int gradeID = 101;
	String gradeComment = "Comment";
	String gradeDropdown = "ABC";
	
	
	@Mock
	Model model;
    HttpSession session;
    Principal principal;
    CourseDAO courseDao;
    ProfessorDAO professorDao;
    StudentDAO studentDao;
    DepartmentDAO departmentDao;
    GradeDAO gradeDao;
    Professor professor;
    Student student;
    ArrayList<Course> courseList;
    ArrayList<Student> studentList;
    Course course;
    Grade grade;
   
	
	@Before
	public void setUp(){
		model = mock(Model.class);
        principal = mock(Principal.class);
        session = mock(HttpSession.class);
        professorDao = mock(ProfessorDAO.class);
        courseDao = mock(CourseDAO.class);
        gradeDao = mock(GradeDAO.class);
        studentDao = mock(StudentDAO.class);
        departmentDao = mock(DepartmentDAO.class);
        professorController = new ProfessorController(professorDao, studentDao, departmentDao, gradeDao, courseDao);
        professor = mock(Professor.class);
        courseList = new ArrayList<Course>();
        course = mock(Course.class);
        student = mock(Student.class);
        grade = mock(Grade.class);
        studentList = new ArrayList<Student>();
	}
	
	
	@Test
	public void testGoToShowCoursesShowsTheCourses(){
		 when(principal.getName()).thenReturn(username);
		 when(professorDao.getProfessor(username)).thenReturn(professor);
		 when(courseDao.getAllCoursesByProfessor(professor)).thenReturn(courseList);
		 assertEquals("professor/professorViewCourses", professorController.goToShowCourses(model, principal));
	}
	
	@Test
	public void testProcessChooseCourseAllowsYouToChooseACourse(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("Darryl");
		assertEquals("redirect:viewCourses", professorController.processChooseCourse(model, courseCode, principal));		
	}
	
	@Test
	public void testGoToTaughtCoursesGoesToTheTaughtCourses() {
		when(principal.getName()).thenReturn(username);
        when(professorDao.getProfessor(username)).thenReturn(professor);
        assertEquals("professor/professorViewCourses", professorController.goToTaughtCourses(model, session, principal));
		}
	
	@Test
	public void testProcessTaughtCoursesProcessesTheTaughtCourses(){
		when(principal.getName()).thenReturn(username);
        when(professorDao.getProfessor(username)).thenReturn(professor);
        when(courseDao.getCourse(courseCode)).thenReturn(course);
        when(course.getCourseName()).thenReturn("Chizh");
        assertEquals("professor/professorViewCourses", professorController.processTaughtCourses(session, principal));
		}
	
	@Test
	public void testProcessShowStudentsShowsTheStudents(){
		when(studentDao.getAllStudents()).thenReturn(studentList);
		assertEquals("professor/professorViewStudents", professorController.processShowStudents());
		}
	
	@Test
	public void testViewProfileGoesToViewProfiles(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		assertEquals("professor/professorViewProfile", professorController.goToViewProfile(model, principal));
	}
	
	@Test
	public void testGoToEditProfilePageGoesToViewEditPage(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		assertEquals("professor/professorEditProfile", professorController.goToEditProfilepage(model, principal));
	}
	
	@Test
	public void testEditProfileReturnsEditProfile(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		assertEquals("professor/professorEditProfile", professorController.editProfile(model, session, principal, professor));
	}
	
	@Test
	public void testUnassignCourseReturnsViewCourses(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(course.getCourseName()).thenReturn("123");
		assertEquals("redirect:viewCourses", professorController.doUnassignCourse(courseCode, model, session, principal));
	}
	
	@Test
	public void testGoToViewStudentReturnsProfessorViewStudentOnTaughtCourse(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		assertEquals("professor/professorViewStudentsOnTaughtCourse", professorController.goToViewStudents(courseCode, model, session, principal));
	}
	
//	@Test
//	public void testDoUpdateGradeUpdatesTheGrades(){
//		when(principal.getName()).thenReturn(username);
//		when(professorDao.getProfessor(username)).thenReturn(professor);
//		when(studentDao.getStudent(username)).thenReturn(student);
//		assertEquals("professor/professorViewStudentsOnTaughtCourse", professorController.doUpdateGrade(courseCode, "A", "ABC", username, model, session, principal));			
//	}
	
	@Test
	public void testViewStudentReturnsViewStudents(){
		ProfessorController p = new ProfessorController();
		when(principal.getName()).thenReturn(username);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(studentDao.getStudent(username)).thenReturn(student);
	
		assertEquals("professor/viewStudent", professorController.goToViewStudent(username, model, session, principal));
	}
	
	@Test
	public void testViewGradesReturnsGrades(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		assertEquals("professor/grades", professorController.goToViewGrades(model, principal));
	}
	
	@Test
	public void testViewTimetableReturnsTimetableView(){
		when(principal.getName()).thenReturn(username);
		when(professorDao.getProfessor(username)).thenReturn(professor);
		when(courseDao.getAllCoursesByProfessor(professor)).thenReturn(courseList);
		assertEquals("professor/timetable", professorController.goToViewTimetable(model, principal));		
	}
	
	@Test
	public void testGoToProfessorHome(){
		assertEquals("professor/professorHome", professorController.goToProfessorHome());		
	}
	
	@Test
	public void test1(){
		assertEquals("redirect:/", professorController.logout(session));		
	}
	
	@Test
	public void testDoUpdateGradeUpdatesTheGrades1(){
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(studentDao.getStudent(username)).thenReturn(student);
		when(gradeDao.getGradeForStudentForCourse(course, student)).thenReturn(grade);
		assertEquals("professor/professorViewStudentsOnTaughtCourse", professorController.doUpdateGrade(courseCode, "A", "ABC", username, model, session, principal));			
	}
	
	@Test
	public void testDoUpdateGradeUpdatesTheGrades2(){
		when(studentDao.getStudent(username)).thenReturn(student);
		Set<Course> list = new HashSet<Course>();
		list.add(course);
		when(student.getCourseList()).thenReturn(list);
		assertEquals("professor/viewStudent", professorController.goToViewStudent(username, model, session, principal));			
	}
	
	@Test
	public void testDoUpdateGradeUpdatesTheGrades3(){
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(gradeDao.getGradeForStudentForCourse(course, student)).thenReturn(grade);
		assertEquals("professor/professorViewStudentsOnTaughtCourse", professorController.doUpdateGrade(courseCode, "B", "ABC", username, model, session, principal));			
	}
	
	@Test
	public void testDoUpdateGradeUpdatesTheGrades4(){
		when(studentDao.getStudent(username)).thenReturn(student);
		when(courseDao.getCourse(courseCode)).thenReturn(course);
		when(gradeDao.getGradeForStudentForCourse(course, student)).thenReturn(grade);
		assertEquals("professor/professorViewStudentsOnTaughtCourse", professorController.doUpdateGrade(courseCode, "A", "ABC", username, model, session, principal));			
	}
		
		
}

