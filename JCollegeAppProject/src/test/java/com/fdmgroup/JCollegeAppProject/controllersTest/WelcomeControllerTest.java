package com.fdmgroup.JCollegeAppProject.controllersTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.JCollegeAppProject.controllers.RegistrarController;
import com.fdmgroup.JCollegeAppProject.daos.AbsenceDAO;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.DepartmentDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.ITAdminDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.UserDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Department;
import com.fdmgroup.JCollegeAppProject.entities.Grade;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.StudentController;
import com.fdmgroup.JCollegeAppProject.controllers.WelcomeController;
import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.daos.GradeDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;
import com.fdmgroup.JCollegeAppProject.entities.Student;

public class WelcomeControllerTest {
        
        WelcomeController welcomeController;
        String username = "ABC";
        int courseCode;
        
        @Mock
        Model model;
        HttpSession session;
        Principal principal;
        Grade grade;
        RedirectAttributes ra;
        CourseDAO courseDao;
        StudentDAO studentDao;
        Department department;
        Registrar registrar;
        ITAdmin itAdmin;
        ProfessorDAO professorDao;
        RegistrarDAO registrarDao;
        ITAdminDAO itAdminDao;
        GradeDAO gradeDao;
        Student student;
        Professor professor;
        ArrayList<Course> courseList;
        Course course;
        UserDAO userDao;
        User user;
        DepartmentDAO departmentDao;
        AbsenceDAO absenceDao;
        HttpServletRequest request;
        
        @Before
        public void setUp(){
                model = mock(Model.class);
                principal = mock(Principal.class);
                grade = mock(Grade.class);
                session = mock(HttpSession.class);
                itAdmin = mock(ITAdmin.class);
                department = mock(Department.class);
                ra = mock(RedirectAttributes.class);
                studentDao = mock(StudentDAO.class);
                courseDao = mock(CourseDAO.class);
                user = mock(User.class);
                registrar = mock(Registrar.class);
                request = mock(HttpServletRequest.class);
                gradeDao = mock(GradeDAO.class);
                itAdminDao = mock(ITAdminDAO.class);
                registrarDao = mock(RegistrarDAO.class);
                userDao = mock(UserDAO.class);
                departmentDao = mock(DepartmentDAO.class);
                professorDao = mock(ProfessorDAO.class);
                absenceDao = mock(AbsenceDAO.class);
                welcomeController = new WelcomeController(studentDao, professorDao, itAdminDao, registrarDao, userDao);
                student = mock(Student.class);
                professor = mock(Professor.class);
                courseList = new ArrayList<Course>();
                course = mock(Course.class);
        }
        
        @Test
        public void testToIndex(){
        	String pageName = welcomeController.goToIndex();
        	assertEquals("redirect:/", welcomeController.goBackToIndex());
        }
        
        @Test
        public void testToLoginFailureReturnsLoginFailure(){
        	String pageName = welcomeController.goToLoginFailure(username, model);
        	assertEquals("index", welcomeController.goToLoginFailure(username, model));
        }
        

        @Test
        public void testLogOutReturnsRedirect(){
        	String pageName = welcomeController.doLogOut(session);
        	verify(session).invalidate();
        	assertEquals("redirect:/", welcomeController.doLogOut(session));
        	
        }
        
        @Test
        public void testGoToForgotPasswordReturnsForgottenPassword(){
        	String pageName = welcomeController.goToForgotPassword();
        	assertEquals("forgotPassword", welcomeController.goToForgotPassword());
        }
        
        @Test
        public void testGoToResetPasswordRedirectsConfirmPasswordReset(){
        	WelcomeController w = new WelcomeController();
        	String pageName = welcomeController.doResetPassword(username);
        	when(userDao.getUser(username)).thenReturn(null);
        	assertEquals("confirmPasswordReset", welcomeController.doResetPassword(username));
        }
        
        @Test
        public void test_GoToLoginFialure_ReturnsIndex(){
        	when(userDao.getUser("ABC")).thenReturn(user);
        	assertEquals("index", welcomeController.goToLoginFailure("ABC", model));
        }
        
        @Test
        public void test_GoToLoginFialure_ReturnsIndex2(){
        	when(userDao.getUser("ABC")).thenReturn(professor);
        	when(professor.getNoOfIncorrectAttempts()).thenReturn(4);
        	assertEquals("index", welcomeController.goToLoginFailure("ABC", model));
        }
        
        @Test
        public void test_GoToLogin(){
        	when(principal.getName()).thenReturn(username);
        	when(userDao.getUser(username)).thenReturn(student);
        	when(request.isUserInRole("Student")).thenReturn(true);
        	when(user.getNoOfIncorrectAttempts()).thenReturn(4);
        	assertEquals("redirect:student/home", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void test_GoToLogin2(){
        	when(principal.getName()).thenReturn(username);
        	when(userDao.getUser(username)).thenReturn(registrar);
        	when(request.isUserInRole("Registrar")).thenReturn(true);
        	when(registrar.getNoOfIncorrectAttempts()).thenReturn(5);
        	assertEquals("index", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void test_GoToLogin3(){
        	when(principal.getName()).thenReturn(username);
        	when(userDao.getUser(username)).thenReturn(registrar);
        	when(request.isUserInRole("Registrar")).thenReturn(true);
        	when(registrar.getNoOfIncorrectAttempts()).thenReturn(2);
        	assertEquals("redirect:registrar/home", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void test_GoToLogin4(){
        	when(principal.getName()).thenReturn(username);
        	when(userDao.getUser(username)).thenReturn(user);
        	when(request.isUserInRole("ITAdmin")).thenReturn(true);
        	assertEquals("redirect:itAdmin/HomePage", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void test_GoToLogin6(){
        	when(principal.getName()).thenReturn(username);
        	when(userDao.getUser(username)).thenReturn(user);
        	assertEquals("redirect:/", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void test_GoToLogin7(){
        	when(principal.getName()).thenReturn(username);
        	when(userDao.getUser(username)).thenReturn(professor);
        	when(request.isUserInRole("Professor")).thenReturn(true);
        	assertEquals("redirect:professor/home", welcomeController.goToLogin(model, session, principal, request));
        }
        
        @Test
        public void test_GoToStudentHome(){
        	when(session.getAttribute("username")).thenReturn(username);
        	when(studentDao.getStudent(username)).thenReturn(student);
        	assertEquals("redirect:ViewProfile", welcomeController.goToStudentHome(session));
        }
        
        @Test
        public void test_GoToProfessorHome(){
        	when(session.getAttribute("username")).thenReturn(username);
        	when(professorDao.getProfessor(username)).thenReturn(professor);
        	assertEquals("professor/professorHome", welcomeController.goToProfessorHome(session));
        }
        
        @Test
        public void test_GoToRegistrarHome(){
        	when(session.getAttribute("username")).thenReturn(username);
        	when(registrarDao.getRegistrar(username)).thenReturn(registrar);
        	assertEquals("redirect:MyProfile", welcomeController.goToRegistrarHome(session));
        }
        
        @Test
        public void test_GoToITAdminHome(){
        	when(session.getAttribute("username")).thenReturn(username);
        	when(itAdminDao.getITAdmin(username)).thenReturn(itAdmin);
        	assertEquals("itadmin/itadminHome", welcomeController.goToITAdminHome(session));
        }
        
        @Test
        public void test_DoResetPassword(){
        	when(userDao.getUser(username)).thenReturn(user);
        	assertEquals("confirmPasswordReset", welcomeController.doResetPassword(username));
        }
        
}
