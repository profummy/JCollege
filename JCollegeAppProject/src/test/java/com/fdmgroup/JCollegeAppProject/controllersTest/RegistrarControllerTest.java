package com.fdmgroup.JCollegeAppProject.controllersTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.RegistrarController;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RegistrarControllerTest {

	private RegistrarController rController;
	private CourseDAOImpl cDAO;
	private int courseId;
	private Course course;
	
	@Mock
	Model model;
	
	@Before
	public void setUp(){
		cDAO = mock(CourseDAOImpl.class);
//		rController = new RegistrarController(cDAO);
		model = mock(Model.class);
		course = mock(Course.class);		
	}
	
	@Test
	public void test_courseCancellation() {
		when(cDAO.getCourse(courseId)).thenReturn(course);
		//verify(cDAO).removeCourse(courseId);
//		String pageName = rController.courseCancellation(courseId, model, course);
//		assertEquals(pageName, "CourseCancellation");
	}
	
	@Test
	public void test_courseUpdate() {
		when(cDAO.getCourse(courseId)).thenReturn(course);
		//verify(cDAO).updateCourse(course);
//		String pageName = rController.courseUpdate(courseId, model);
//		assertEquals(pageName, "CourseUpdate");
	}
	
	@Test
	public void test_CourseAdding() {
		when(cDAO.getCourse(courseId)).thenReturn(course);
		
		//verify(cDAO).addCourse(course);
		//String pageName = rController.courseAdding(model, courseId);
		//assertEquals(pageName, "CourseAdding");
	}
}
