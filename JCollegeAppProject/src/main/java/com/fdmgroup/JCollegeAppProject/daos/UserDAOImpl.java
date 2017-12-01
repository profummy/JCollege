package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class UserDAOImpl implements UserDAO {

     @Autowired
     private EntityManagerFactory factory;

     public UserDAOImpl() {
     }

     public UserDAOImpl(EntityManagerFactory factory) {
           this.factory = factory;
     }

     public void addUser(User user) {
           EntityManager manager = factory.createEntityManager();
           manager.getTransaction().begin();
           manager.persist(user);
           manager.getTransaction().commit();
     }

     @Override
     public void removeUser(String username) {
           EntityManager manager = factory.createEntityManager();
           User user = manager.find(User.class, username);
           manager.getTransaction().begin();
           manager.remove(user);
           manager.getTransaction().commit();
     }

     @Override
     public void updateUser(User user) {
           EntityManager manager = factory.createEntityManager();
           manager.getTransaction().begin();
           manager.merge(user);
           manager.getTransaction().commit();
     }

     @Override
     public User getUser(String username) {
           EntityManager manager = factory.createEntityManager();
           User user = manager.find(User.class, username);
           manager.close();
           return user;
     }

     @Override
     public List<User> getAllUsers() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("FROM User p", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }

     @Override
     public List<User> getAllProfessors() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("select p FROM Professor p", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }

     @Override
     public List<User> getAllStudents() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("select s FROM Student s", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }

     @Override
     public List<User> getAllRegistrars() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("select r From Registrar r", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }

     @Override
     public List<User> getAllITAdmins() {
           EntityManager manager = factory.createEntityManager();
           TypedQuery<User> query = manager.createQuery("select i FROM ITAdmin i", User.class);
           List<User> userList = query.getResultList();
           manager.close();
           return userList;
     }
     
     @Override
     public List<User> getAllBlockedUsers(){
    	 EntityManager manager = factory.createEntityManager();
         TypedQuery<User> query = manager.createQuery("select u FROM User u WHERE u.noOfIncorrectAttempts > ?", User.class);
         query.setParameter(1, 2);
    	 List<User> userList = query.getResultList();
    	 manager.close();
    	 return userList;
     }
     
     @Override
     public List<User> getUserByName(String name){
    	 EntityManager manager = factory.createEntityManager();
         TypedQuery<User> query = manager.createQuery("select u FROM User u WHERE u.firstName like ? OR u.lastName like ? OR u.username like ?", User.class);
         query.setParameter(1, "%" + name + "%");
         query.setParameter(2, "%" + name + "%");
         query.setParameter(3, "%" + name + "%");
    	 List<User> userList = query.getResultList();
    	 manager.close();
    	 return userList;
     }

}

