package com.fdmgroup.JCollegeAppProject.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private EntityManagerFactory factory;

	public CourseDAOImpl() {
	}

	public CourseDAOImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(course);
		manager.getTransaction().commit();
	}

	@Override
	public void removeCourse(int courseCode) {
		EntityManager manager = factory.createEntityManager();
		Course course = manager.find(Course.class, courseCode);
		manager.getTransaction().begin();
		manager.remove(course);
		manager.getTransaction().commit();
	}

	@Override
	public void updateCourse(Course course) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(course);
		manager.getTransaction().commit();
	}

	@Override
	public Course getCourse(int courseCode) {
		EntityManager manager = factory.createEntityManager();
		Course course = manager.find(Course.class, courseCode);
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery("FROM Course c", Course.class);
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	@Override
	public List<Course> getAllCoursesByDepartment(Department department) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery("SELECT c FROM Course c WHERE c.department=?", Course.class);
		query.setParameter(1, department);
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	public List<Course> getAllCoursesByStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager
				.createQuery("select c FROM Course as c join fetch c.studentList s WHERE s.username =?", Course.class);
		query.setParameter(1, student.getUsername());
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	public List<Course> getAllNonEnrolledCoursesByStudent(Student student) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager
				.createQuery("select c FROM Course as c join fetch c.studentList s WHERE s.username !=?", Course.class);
		query.setParameter(1, student.getUsername());
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	@Override
	public List<Course> getAllCoursesByProfessor(Professor professor) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery("SELECT c FROM Course c WHERE c.professor.username=?",
				Course.class);
		query.setParameter(1, professor.getUsername());
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	@Override
	public List<Course> getCourseByName(String name) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery(
				"SELECT c FROM Course c WHERE c.courseName like ? or c.department.departmentName like ?", Course.class);
		query.setParameter(1, "%" + name + "%");
		query.setParameter(2, "%" + name + "%");
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

	@Override
	public List<Course> getEmptyCourses(String name) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Course> query = manager.createQuery(
				"SELECT c FROM Course c WHERE c.courseName like ? or c.department.departmentName like ?", Course.class);
		query.setParameter(1, "%" + name + "%");
		query.setParameter(2, "%" + name + "%");
		List<Course> courseList = query.getResultList();
		manager.close();
		return courseList;
	}

}
