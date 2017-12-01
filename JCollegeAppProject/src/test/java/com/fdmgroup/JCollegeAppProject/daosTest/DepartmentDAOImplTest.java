package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.junit.Assert.*;
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

import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Department;

public class DepartmentDAOImplTest {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private EntityTransaction transaction;
	private DepartmentDAOImpl departmentDao;
	private TypedQuery query;
	private List list;
	private Department department;

	@Before
	public void setUp() {
		department = mock(Department.class);
		factory = mock(EntityManagerFactory.class);
		manager = mock(EntityManager.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		departmentDao = new DepartmentDAOImpl(factory);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
	}
	@Test
	public void testAddingDepartmentsOntoDatabase(){
		DepartmentDAOImpl d = new DepartmentDAOImpl();
		departmentDao.addDepartment(department);
	}
	
	@Test
	public void testUpdatingDepartmentOnDatabase(){
		departmentDao.updateDepartment(department);
	}
	
	@Test
	public void testUpbdatingDepartmentOnDatabase(){
		departmentDao.removeDepartment(1);
	}
	
	@Test
	public void testUpbdabtingDepartmentOnDatabase(){
		departmentDao.getDepartment(1);
	}
	
	@Test
	public void testUpbdatinbgDepartmentOnDatabase(){
		List<Department> list = mock(List.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.createQuery("select d from Department d", Department.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		departmentDao.getAllDepartments();
	}
	
}
