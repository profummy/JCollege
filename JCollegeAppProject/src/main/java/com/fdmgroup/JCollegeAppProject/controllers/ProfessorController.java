package com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAOImpl;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Student;

@Controller
public class ProfessorController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ProfessorDAO professorDao;

	@Autowired
	private StudentDAO studentDao;

	@Autowired
	private DepartmentDAO departmentDao;

	@Autowired
	private GradeDAO gradeDao;

	@Autowired
	private CourseDAO courseDao;

	public ProfessorController() {
	}

	public ProfessorController(ProfessorDAO professorDao, StudentDAO studentDao, DepartmentDAO departmentDao,
			GradeDAO gradeDao, CourseDAO courseDao) {
		super();
		this.professorDao = professorDao;
		this.studentDao = studentDao;
		this.departmentDao = departmentDao;
		this.gradeDao = gradeDao;
		this.courseDao = courseDao;
	}

	@RequestMapping("/professor/professorHome")
	public String goToProfessorHome() {
		logger.trace("Client request to url : /professor/professorHome");
		return "professor/professorHome";

	}

	@RequestMapping("/professor/logout") //
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

	@RequestMapping("/professor/viewCourses")
	public String goToShowCourses(Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		Department department = professor.getDepartment();
		List<Course> courseList = courseDao.getAllCoursesByDepartment(department);
		List<Course> taughtCourseList = courseDao.getAllCoursesByProfessor(professor);

		model.addAttribute("courseList", courseList);
		model.addAttribute("taughtCourseList", taughtCourseList);
		return "professor/professorViewCourses";
	}

	@RequestMapping("/professor/processChooseCourse")
	public String processChooseCourse(Model model, int courseCode, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		Course course = courseDao.getCourse(courseCode);
		course.setProfessor(professor);
		courseDao.updateCourse(course);
		logger.info("Course is chosen :" + courseCode);
		return "redirect:viewCourses";
	}

	@RequestMapping("/professor/viewTaughtCourses")
	public String goToTaughtCourses(Model model, HttpSession session, Principal principal) {
		String username = principal.getName();
		Professor professor = professorDao.getProfessor(username);
		List<Course> taughtCourseList = courseDao.getAllCoursesByProfessor(professor);
		model.addAttribute("taughtCourseList", taughtCourseList);
		return "professor/professorViewCourses";

	}

	@RequestMapping("/professor/processViewTaughtCourses")
	public String processTaughtCourses(HttpSession session, Principal principal) {
		String username = principal.getName();
		Professor professor = professorDao.getProfessor(username);
		courseDao.getAllCoursesByProfessor(professor);
		return "professor/professorViewCourses";
	}

	@RequestMapping("/professor/processViewStudents")
	public String processShowStudents() {
		studentDao.getAllStudents();
		return "professor/professorViewStudents";
	}

	@RequestMapping("/professor/viewProfile")
	public String goToViewProfile(Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		model.addAttribute("professor", professor);
		return "professor/professorViewProfile";
	}

	@RequestMapping("/professor/editProfile")
	public String goToEditProfilepage(Model model, Principal principal) {

		Professor professor = professorDao.getProfessor(principal.getName());
		professorDao.updateProfessor(professor);
		model.addAttribute("professor", professor);
		return "professor/professorEditProfile";
	}

	@RequestMapping("/professor/processEditProfile")
	public String editProfile(Model model, HttpSession session, Principal principal, Professor professor) {
		Professor oldProfessor = professorDao.getProfessor(principal.getName());

		oldProfessor.setAddress(professor.getAddress());
		oldProfessor.setPhone(professor.getPhone());
		oldProfessor.setFax(professor.getFax());
		oldProfessor.setEmailAddress(professor.getEmailAddress());

		professorDao.updateProfessor(oldProfessor);
		model.addAttribute("message", "Details successfully updated");
		return "professor/professorEditProfile";
	}

	@RequestMapping("/professor/unassignCourse")
	public String doUnassignCourse(@RequestParam int courseCode, Model model, HttpSession session,
			Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		Course course = courseDao.getCourse(courseCode);
		course.setProfessor(null);
		courseDao.updateCourse(course);

		return "redirect:viewCourses";
	}

	@RequestMapping("/professor/viewStudents")
	public String goToViewStudents(@RequestParam int courseCode, Model model, HttpSession session,
			Principal principal) {
		Course course = courseDao.getCourse(courseCode);
		List<Student> studentList = studentDao.getAllStudentsByCourse(course);

		model.addAttribute("course", course);
		model.addAttribute("studentList", studentList);
		return "professor/professorViewStudentsOnTaughtCourse";
	}

	@RequestMapping("/professor/updateGrade")
	public String doUpdateGrade(@RequestParam int courseCode, @RequestParam String gradeValue, @RequestParam String gradeComment, @RequestParam String username, Model model,
		HttpSession session, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		Student student = studentDao.getStudent(username);
		Course course = courseDao.getCourse(courseCode);
		
		Grade oldGrade = gradeDao.getGradeForStudentForCourse(course, student);
		
		Grade grade = new Grade();
		grade.setGradeValue(gradeValue.charAt(0));
		grade.setGradeComment(gradeComment);
		grade.setStudent(student);
		grade.setProfessor(professor);
		grade.setCourse(course);
		student.addGrade(grade);
		
		gradeDao.removeGrade(oldGrade.getGradeId());
		
		gradeDao.addGrade(grade);

		List<Student> studentList = studentDao.getAllStudentsByCourse(course);

		model.addAttribute("course", course);
		model.addAttribute("studentList", studentList);
		return "professor/professorViewStudentsOnTaughtCourse";
	}

	@RequestMapping("/professor/viewStudent")
	public String goToViewStudent(@RequestParam String username, Model model, HttpSession session,
			Principal principal) {

		Student student = studentDao.getStudent(username);

		Set<Course> courseList = student.getCourseList();
		List<Course> courseArrayList = new ArrayList<Course>();
		for (Course course : courseList) {
			courseArrayList.add(course);
		}

		model.addAttribute("courseList", courseList);
		model.addAttribute("student", student);
		return "professor/viewStudent";
	}

	@RequestMapping("/professor/viewGrades")
	public String goToViewGrades(Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());
		Department department = professor.getDepartment();
		List<Course> courseList = courseDao.getAllCoursesByDepartment(department);
		List<Course> taughtCourseList = courseDao.getAllCoursesByProfessor(professor);

		model.addAttribute("courseList", courseList);
		model.addAttribute("taughtCourseList", taughtCourseList);

		return "professor/grades";
	}

	@RequestMapping("/professor/viewTimetable")
	public String goToViewTimetable(Model model, Principal principal) {
		Professor professor = professorDao.getProfessor(principal.getName());

		List<Course> courseList = courseDao.getAllCoursesByProfessor(professor);

		model.addAttribute("courseList", courseList);

		return "professor/timetable";
	}

}