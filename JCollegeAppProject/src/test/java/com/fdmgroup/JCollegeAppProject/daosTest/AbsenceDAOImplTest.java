package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.AbsenceDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Absence;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class AbsenceDAOImplTest {
	
	private int absenceId;
	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	private AbsenceDAOImpl absenceDao;
	private TypedQuery query;
	private List list;

	@Before
	public void setUp(){
		factory = mock(EntityManagerFactory.class);
		manager = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		absenceDao = new AbsenceDAOImpl(factory);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);		
	}

	
	@Test
	public void testAddAbsenceAddsAnAbsence(){
		Absence absence = new Absence();
		absenceDao.addAbsence(absence);
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(absence);		
	}
	
	@Test
	public void testRemoveAbsenceRemovesAnAbsence() {
		AbsenceDAOImpl a = new AbsenceDAOImpl();
		Absence absence = new Absence();
		absenceDao.removeAbsence(absence.getAbsenceId());
		verify(transaction).begin();
		verify(transaction).commit();	
	}
	
	@Test
	public void testUpdateAbsenceUpdatesAnAbsence() {
		Absence absence = new Absence();
		absenceDao.updateAbsence(absence);
		verify(manager).merge(absence);		
	}
	
	@Test
	public void testGetAbsenceActuallyGetsAnAbsence() {
		absenceDao.getAbsence(absenceId);
		verify(manager).find(Absence.class, absenceId);
		}
	
	@Test
	public void testGetAbsencesByStudentGetsAbsencesByStudent() {
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("FROM Absence a WHERE a.student.username =?", Absence.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		absenceDao.getAbsencesByStudent(new Student());
		
	}
	
	
}
