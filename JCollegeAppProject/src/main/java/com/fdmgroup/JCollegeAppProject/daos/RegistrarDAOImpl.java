package com.fdmgroup.JCollegeAppProject.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;

public class RegistrarDAOImpl implements RegistrarDAO {

	@Autowired
	private EntityManagerFactory factory;

	public RegistrarDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public RegistrarDAOImpl() {
		super();
	}
	@Override
	public Registrar getRegistrar(String username) {
		EntityManager manager = factory.createEntityManager();
		Registrar registrar = manager.find(Registrar.class, username);
		return registrar;
	}

	@Override
	public void updateRegistrar(Registrar registrar) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(registrar);
		manager.getTransaction().commit();
	}
	@Override
	public void addRegistrar(Registrar registrar) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(registrar);
		manager.getTransaction().commit();
	}
	@Override
	public void removeRegistrar(String username) {
		EntityManager manager = factory.createEntityManager();
		Registrar registrar = manager.find(Registrar.class, username);
		manager.getTransaction().begin();
		manager.remove(registrar);
		manager.getTransaction().commit();
	}
	

		
	}


