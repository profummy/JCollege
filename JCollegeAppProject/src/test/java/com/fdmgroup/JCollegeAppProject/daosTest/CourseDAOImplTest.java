package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class CourseDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private CourseDAOImpl courseDao;
	private TypedQuery query;
	
	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		query = mock(TypedQuery.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		courseDao = new CourseDAOImpl(factory);
	}

	@Test
	public void testAddCourseAddsACourse() {
		CourseDAOImpl c = new CourseDAOImpl();
		Course course = new Course();
		courseDao.addCourse(course);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(course);
	}

	@Test
	public void testRemoveCourseRemovesACourse() {
		Course course = new Course();

		when(manager.find(Course.class, 47)).thenReturn(course);

		courseDao.removeCourse(47);

	}

	@Test
	public void testGetCourseGetsACourse() {
		CourseDAOImpl courseDao = new CourseDAOImpl(factory);
		Course course = new Course();
		when(manager.find(Course.class, 47)).thenReturn(course);

		courseDao.getCourse(47);

	}

	@Test
	public void testUpdateCourseUpdatesACourse() {
		CourseDAOImpl courseDao = new CourseDAOImpl(factory);
		Course course = new Course();

		courseDao.updateCourse(course);

		verify(manager).merge(course);

	}
	
	@Test
	public void test4(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Course c", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getAllCourses();
	}
	
	@Test
	public void tesat4(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("SELECT c FROM Course c WHERE c.department=?", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getAllCoursesByDepartment(new Department());
	}
	
	@Test
	public void tesat4b(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("select c FROM Course as c join fetch c.studentList s WHERE s.username =?", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getAllCoursesByStudent(new Student());
	}
	
	@Test
	public void teasat4b(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("select c FROM Course as c join fetch c.studentList s WHERE s.username !=?", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getAllNonEnrolledCoursesByStudent(new Student());
	}
	
	@Test
	public void teasdat4b(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("SELECT c FROM Course c WHERE c.professor.username=?", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getAllCoursesByProfessor(new Professor());
	}
	
	@Test
	public void teasdata4b(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("SELECT c FROM Course c WHERE c.courseName like ? or c.department.departmentName like ?", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getCourseByName("ABC");
	}
	
	@Test
	public void teasdataa4b(){
		List<Course> l = new ArrayList<Course>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("SELECT c FROM Course c WHERE c.courseName like ? or c.department.departmentName like ?", Course.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		courseDao.getEmptyCourses("ABC");
	}

}
