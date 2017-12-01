package com.fdmgroup.JCollegeAppProject.daosTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import com.fdmgroup.JCollegeAppProject.daos.UserDAOImpl;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class UserDAOImplTest {

	private String username;
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	private UserDAOImpl userDao;
	private TypedQuery query;
	private List list;
	private User user;

	@Before
	public void setUp() {
		manager = mock(EntityManager.class);
		factory = mock(EntityManagerFactory.class);
		transaction = mock(EntityTransaction.class);
		query = mock(TypedQuery.class);
		when(factory.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		userDao = new UserDAOImpl(factory);
		
	}

	@Test
	public void testAddUserAddsAUser() {
		User user = new User();
		userDao.addUser(user);

		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).persist(user);
	}

	@Test
	public void testRemoveUserRemovesAUser() {
		String username = new String();
		userDao.removeUser(username);
		when(manager.find(User.class, "user")).thenReturn(user);
		verify(transaction).begin();
		verify(transaction).commit();
		verify(manager).remove(user);
	}
	
	@Test
	public void testGetUserGetsAUser() {
		userDao.getUser("username");
		verify(manager).find(User.class, "username");
		}

	@Test
	public void testUpdateUserUpdatesAUser() {
		UserDAOImpl u = new UserDAOImpl();
		User user = new User();
		userDao.updateUser(user);
		verify(manager).merge(user);
	}
	

	@Test
	public void testGetAllUsersReturnsUserList(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("FROM User p", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getAllUsers());
	}
	@Test
	public void testGetAllUsersReturnsAllProfessors(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("select p FROM Professor p", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getAllProfessors());
	}
	@Test
	public void testGetAllUsersReturnsAllStudents(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("select s FROM Student s", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getAllStudents());
	}
	@Test
	public void testGetAllUsersReturnsAllRegistrars(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("select r From Registrar r", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getAllRegistrars());
	}
	
	@Test
	public void testGetAllUsersReturnsAllITAdmins(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("select i FROM ITAdmin i", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getAllITAdmins());
	}
	
	@Test
	public void testGetAllBlockedUsersReturnsBlockedList(){
		List<User> list = new ArrayList <User>();
		when(manager.createQuery("select u FROM User u WHERE u.noOfIncorrectAttempts > ?", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getAllBlockedUsers());
	}
	
	@Test
	public void testGetUserByNameReturnsUserByName(){
		List<User> list = new ArrayList <User>();
		String name = new String();
		when(manager.createQuery("select u FROM User u WHERE u.firstName like ? OR u.lastName like ? OR u.username like ?", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(list);
		assertEquals(list, userDao.getUserByName(name));
	}
}


