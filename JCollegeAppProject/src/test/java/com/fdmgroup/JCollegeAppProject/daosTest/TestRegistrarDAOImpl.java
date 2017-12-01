package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;

public class TestRegistrarDAOImpl {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	private RegistrarDAOImpl registrarDao;
	private TypedQuery query;
	private List list;
	private Department department;
	private Registrar registrar;

	@Before
	public void setUp() {
		registrar = mock(Registrar.class);
		department = mock(Department.class);
		factory = mock(EntityManagerFactory.class);
		manager = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		registrarDao = new RegistrarDAOImpl(factory);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
	}
	@Test
	public void testAddingDepartmentsOntoDatabase(){
		RegistrarDAOImpl r = new RegistrarDAOImpl();
		registrarDao.addRegistrar(registrar);
	}
	
	@Test
	public void testAddingaDepartmentsOntoDatabase(){
		registrarDao.getRegistrar("ABC");
	}
	
	@Test
	public void testAddingaaDepartmentsOntoDatabase(){
		registrarDao.updateRegistrar(registrar);
	}
	
	@Test
	public void testAddingabaDepartmentsOntoDatabase(){
		registrarDao.removeRegistrar("ABC");
	}
	
}
