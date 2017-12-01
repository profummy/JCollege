package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
		
	public DepartmentDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}
	public DepartmentDAOImpl() {
		super();
	}
	@Override
	public void addDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(department);
		manager.getTransaction().commit();
	}
	@Override
	public void updateDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(department);
		manager.getTransaction().commit();
	}
	@Override
	public void removeDepartment(int departmentId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Department department = manager.find(Department.class, departmentId);
		manager.remove(department);
		manager.getTransaction().commit();
	}
	@Override
	public Department getDepartment(int departmentId) {
		EntityManager manager = factory.createEntityManager();
		Department department = manager.find(Department.class, departmentId);
		return department;
	}
	@Override
	public List<Department> getAllDepartments() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Department> query = manager.createQuery("select d from Department d", Department.class);
		List<Department> departmentList = query.getResultList();
		manager.close();
		return departmentList;
	}

}
