package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class GradeDAOImpl implements GradeDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	

	public GradeDAOImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public GradeDAOImpl() {
		super();
	}

	@Override
	public void addGrade(Grade grade) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(grade);
		manager.getTransaction().commit();
	}

	@Override
	public void removeGrade(int gradeId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Grade grade = manager.find(Grade.class, gradeId);
		manager.remove(grade);
		manager.getTransaction().commit();
	}

	@Override
	public void updateGrade(Grade grade) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(grade);
		manager.getTransaction().commit();
		
	}

	@Override
	public Grade getGrade(int gradeId) {
		EntityManager manager = factory.createEntityManager();
		Grade grade = manager.find(Grade.class, gradeId);
		manager.close();
		return grade;
	}

	@Override
	public List<Grade> getAllGrades() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery <Grade> query = manager.createQuery("FROM Grade g", Grade.class);
		List<Grade> gradeList = query.getResultList();
		return gradeList;
	}

	@Override
	public List<Grade> getAllGradesByStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Grade> query = manager.createQuery("SELECT g FROM Grade g WHERE g.student=?", Grade.class);
		query.setParameter(1, student);
		List <Grade> gradeList = query.getResultList();
		manager.close();
		return gradeList;
	}

	@Override
	public List<Grade> getAllGradesByProfessor(Professor professor) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Grade> query = manager.createQuery("FROM Grade g WHERE g.professor.username =?", Grade.class);
		query.setParameter(1, professor.getUsername());
		List <Grade> gradeList = query.getResultList();
		manager.close();
		return gradeList;
	}
	
	public List<Grade> getAllGradesByCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Grade> query = manager.createQuery("FROM Grade g WHERE g.course.courseCode =?", Grade.class);
		query.setParameter(1, course.getCourseCode());
		List <Grade> gradeList = query.getResultList();
		manager.close();
		return gradeList;
	}
	
	public Grade getGradeForStudentForCourse(Course course, Student student){
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Grade> query = manager.createQuery("FROM Grade g WHERE g.course.courseCode =? AND g.student.username =?", Grade.class);
		query.setParameter(1, course.getCourseCode());
		query.setParameter(2, student.getUsername());
		List<Grade> listOfGrades = query.getResultList();
		
		Grade grade = null;
		if (listOfGrades.size() > 0){
			grade = query.getResultList().get(0);
		}
		return grade;
	}

}
