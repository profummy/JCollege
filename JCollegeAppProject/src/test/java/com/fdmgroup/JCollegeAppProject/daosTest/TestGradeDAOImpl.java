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

import com.fdmgroup.JCollegeAppProject.daos.GradeDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class TestGradeDAOImpl {

	private String username;
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private GradeDAOImpl gradeDao;
	private TypedQuery query;
	private List list;
	private User user;
	private Grade grade;
	private Student student;
	private Professor professor;
	private Course course;

	@Before
	public void setUp() {
		course = mock(Course.class);
		manager = mock(EntityManager.class);
		professor = mock(Professor.class);
		grade = new Grade();
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		student = mock(Student.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		gradeDao = new GradeDAOImpl(factory);
		
	}

	@Test
	public void testAddUserAddsAUser() {
		GradeDAOImpl g = new GradeDAOImpl();
		gradeDao.addGrade(grade);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(grade);
	}
	
	@Test
	public void testAddUseraAddsAUser() {
		gradeDao.removeGrade(1);
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).find(Grade.class, 1);
	}
	
	@Test
	public void asdf() {
		gradeDao.updateGrade(grade);
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).merge(grade);
	}
	
	@Test
	public void asddf() {
		gradeDao.getGrade(1);
	}
	
	@Test
	public void asdaf() {
		List<Grade> l = new ArrayList<Grade>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Grade g", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getAllGrades();
	}
	
	@Test
	public void asdaaf() {
		List<Grade> l = new ArrayList<Grade>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("SELECT g FROM Grade g WHERE g.student=?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getAllGradesByStudent(student);
	}
	
	@Test
	public void asdaafa() {
		List<Grade> l = new ArrayList<Grade>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("SELECT g FROM Grade g WHERE g.student=?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getAllGradesByStudent(student);
	}
	
	@Test
	public void asdaaafa() {
		List<Grade> l = new ArrayList<Grade>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Grade g WHERE g.professor.username =?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getAllGradesByProfessor(professor);
	}
	
	@Test
	public void asdaaaafa() {
		List<Grade> l = new ArrayList<Grade>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Grade g WHERE g.course.courseCode =?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getAllGradesByCourse(course);
	}
	
	@Test
	public void asdaaaaafa() {
		List<Grade> l = new ArrayList<Grade>();
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Grade g WHERE g.course.courseCode =? AND g.student.username =?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getGradeForStudentForCourse(course, student);
	}
	
	@Test
	public void asdaaabaafa() {
		List<Grade> l = new ArrayList<Grade>();
		l.add(grade);
		l.add(new Grade());
		l.add(new Grade());
		l.add(new Grade());
		l.add(new Grade());
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Grade g WHERE g.course.courseCode =? AND g.student.username =?", Grade.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(l);
		gradeDao.getGradeForStudentForCourse(course, student);
	}

}


