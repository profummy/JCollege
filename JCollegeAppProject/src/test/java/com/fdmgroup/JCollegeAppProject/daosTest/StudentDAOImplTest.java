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

import com.fdmgroup.JCollegeAppProject.daos.StudentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class StudentDAOImplTest {

	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private StudentDAOImpl studentDao;
	private TypedQuery query;
	private Professor professor;

	@Before
	public void setUp() {
		query = mock(TypedQuery.class);
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		studentDao = new StudentDAOImpl(factory);
		professor = mock(Professor.class);
	}

	@Test
	public void testAddStudentAddsAStudent() {
		Student student = new Student();
		studentDao.addStudent(student);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(student);
	}

	@Test
	public void testRemoveStudentRemovesAStudent() {
		StudentDAOImpl s = new StudentDAOImpl();
		Student student = new Student();

		when(manager.find(Student.class, 47)).thenReturn(student);

//		studentDao.removeStudent(47);

	}

	@Test
	public void testGetStudentGetsAStudent() {
		StudentDAOImpl studentDao = new StudentDAOImpl(factory);
		Student student = new Student();
		when(manager.find(Student.class, 47)).thenReturn(student);

//		studentDao.getStudent(47);

	}

	@Test
	public void testUpdateStudentUpdatesAStudent() {
		StudentDAOImpl studentDao = new StudentDAOImpl(factory);
		Student student = new Student();

		studentDao.updateStudent(student);

		verify(manager).merge(student);

	}
	
	@Test
	public void taestUpdateStudentUpdatesAStudent() {
		studentDao.removeStudent("ABC");
	}
	
	@Test
	public void taestUpdateStudentUpdabtesAStudent() {
		studentDao.getStudent("ABC");
	}
	
	@Test
	public void taestUpdatebStudentUpdatesAStudent() {
		List<Student> list = new ArrayList<Student>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Student s", Student.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		studentDao.getAllStudents();
	}
	
	@Test
	public void taestUpdatebStudenbtUpdatesAStudent() {
		List<Student> list = new ArrayList<Student>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Student s", Student.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		studentDao.getAllStudents();
	}
	
	@Test
	public void taestUpdatebStudenbtUpdbatesAStudent() {
		List<Student> list = new ArrayList<Student>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Student s", Student.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		studentDao.getAllStudents();
	}
	
	@Test
	public void taestUpdatebStudenbtUpdbatesAStbudent() {
		List<Student> list = new ArrayList<Student>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Student s WHERE s.professor =?", Student.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		studentDao.getAllStudentsByProfessor(professor);
	}
	
	@Test
	public void taestUpdatebS3tudenbtUpdbatesAStbudent() {
		List<Student> list = new ArrayList<Student>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("select s FROM Student as s join fetch s.courseList c WHERE c.courseCode =?", Student.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		studentDao.getAllStudentsByCourse(new Course());
	}

}
