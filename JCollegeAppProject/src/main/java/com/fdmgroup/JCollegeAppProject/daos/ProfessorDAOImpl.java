package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Professor;


public class ProfessorDAOImpl implements ProfessorDAO {

	@Autowired
	private EntityManagerFactory factory;

	public ProfessorDAOImpl() {
	}

	public ProfessorDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addProfessor(Professor professor) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(professor);
		manager.getTransaction().commit();
	}

	@Override
	public void removeProfessor(String username) {
		EntityManager manager = factory.createEntityManager();
		Professor professor = manager.find(Professor.class, username);
		manager.getTransaction().begin();
		manager.remove(professor);
		manager.getTransaction().commit();
	}

	@Override
	public void updateProfessor(Professor professor) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(professor);
		manager.getTransaction().commit();
	}

	@Override
	public Professor getProfessor(String username) {
		EntityManager manager = factory.createEntityManager();
		Professor professor = manager.find(Professor.class, username);
		manager.close();
		return professor;
	}

	@Override
	public List<Professor> getAllProfessors() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Professor> query = manager.createQuery("FROM Professor p", Professor.class);
		List<Professor> professorList = query.getResultList();
		manager.close();
		return professorList;
	}

	@Override
	public Professor getProfessorByCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Professor> query = manager.createQuery("SELECT p FROM Professor p WHERE p.course =?", Professor.class);
		query.setParameter(1, course);
		Professor professor = query.getSingleResult();
		manager.close();
		return professor;
	}

	@Override
	public List<Professor> getAllProfessorsByDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Professor> query = manager.createQuery("SELECT p FROM professor p WHERE p.department =?", Professor.class);
		query.setParameter(1, department);
		List<Professor> professorList = query.getResultList();
		manager.close();
		return professorList;
	}



}
