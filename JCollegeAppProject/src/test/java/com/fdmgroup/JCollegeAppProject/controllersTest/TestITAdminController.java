package com.fdmgroup.JCollegeAppProject.controllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import com.fdmgroup.JCollegeAppProject.controllers.ITAdminController;
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
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;

public class TestITAdminController {
        
        ITAdminController itAdminController;
        String username;
        int courseCode;
        
        @Mock
        Model model;
        HttpSession session;
        Principal principal;
        CourseDAO courseDao;
        StudentDAO studentDao;
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
        
        @Before
        public void setUp(){
                model = mock(Model.class);
                principal = mock(Principal.class);
                session = mock(HttpSession.class);
                itAdmin = mock(ITAdmin.class);
                studentDao = mock(StudentDAO.class);
                courseDao = mock(CourseDAO.class);
                user = mock(User.class);
                registrar = mock(Registrar.class);
                gradeDao = mock(GradeDAO.class);
                itAdminDao = mock(ITAdminDAO.class);
                registrarDao = mock(RegistrarDAO.class);
                userDao = mock(UserDAO.class);
                departmentDao = mock(DepartmentDAO.class);
                professorDao = mock(ProfessorDAO.class);
                itAdminController = new  ITAdminController(userDao, studentDao, professorDao, registrarDao, itAdminDao, departmentDao);
                student = mock(Student.class);
                professor = mock(Professor.class);
                courseList = new ArrayList<Course>();
                course = mock(Course.class);
        }
        
        @Test
        public void test_ITAdminHomePage_ReturnsITAdminITAdminHome(){
                assertEquals("itAdmin/itAdminHome", itAdminController.ITAdminHomePage(session, model));
        }
        
        @Test
        public void test_GoToAddStudent_ReturnsITAdminAddStudent(){
                assertEquals("itAdmin/addStudent", itAdminController.goToAddStudent(model));
        }
        
        @Test
        public void test_ProcessAddStudent_ReturnsITAdminViewStudents(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewStudents", itAdminController.processAddStudent(model, student));
        }
        
        @Test
        public void test_GoToViewStudents_ReturnsITAdminViewStudents(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewStudents", itAdminController.goToViewStudents(session, model, principal));
        }
        
        @Test
        public void test_ProcessRemoveStudent_ReturnsITAdminViewStudents(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewStudents", itAdminController.processRemoveStudent(username, model));
        }
        
        @Test
        public void test_GoToAddProfessor_ReturnsITAdminAddProfessor(){
                List<Department> list = new ArrayList<Department>();
                when(departmentDao.getAllDepartments()).thenReturn(list);
                assertEquals("itAdmin/addProfessor", itAdminController.goToAddProfessor(model));
        }
        
        @Test
        public void test_ProcessAddProfessor_ReturnsITAdminViewProfessors(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewProfessors", itAdminController.processAddProfessor(1, model, professor));
        }
        
        @Test
        public void test_ProcessRemoveProfessor_ReturnsITAdminViewProfessors(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewProfessors", itAdminController.processRemoveProfessor(username, model));
        }
        
        @Test
        public void test_ProcessAddRegistrar_ReturnsITAdminViewRegistrars(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewRegistrars", itAdminController.processAddRegistar(model, registrar));
        }
        
        @Test
        public void test_ProcessGoToAddRegistrar_ReturnsITAdminAddRegistrar(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/addRegistrar", itAdminController.goToAddRegistrar(model));
        }
        
        @Test
        public void test_GoToViewRegistrar_ReturnsITAdminViewRegistrars(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewRegistrars", itAdminController.goToViewRegistrar(session, model, principal));
        }
        
        @Test
        public void test_ProcessRemoveRegistrar_ReturnsITAdminViewRegistrars(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewRegistrars", itAdminController.processRemoveRegistrar(username, model));
        }
        
        @Test
        public void test_GoToAddITAdmin_ReturnsITAdminAddITAdmin(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/addItAdmin", itAdminController.goToAddITAdmin(model));
        }
        
        @Test
        public void test_ProcessAddITAdmin_ReturnsITAdminViewITAdmins(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewItAdmins", itAdminController.processAddITadmin(model, itAdmin));
        }
        
        @Test
        public void test_GoToViewITAdmin_ReturnsITAdminViewITAdmins(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewItAdmins", itAdminController.goToViewITAdmin(session, model, principal));
        }
        
        @Test
        public void test_ProcessRemoveITAdmin_ReturnsITAdminViewITAdmins(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewItAdmins", itAdminController.processRemoveITAdmin(username, model));
        }
        
        @Test
        public void test_GoToBlockedUsers_ReturnsITAdminBlokedUsers(){
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/blockedUsers", itAdminController.goToBlockedUsers(model));
        }
        
        @Test
        public void test_ProcessUnblockUser_ReturnsITAdminBlockedUsers(){
                when(userDao.getUser(username)).thenReturn(user);
                List<User> list = new ArrayList<User>();
                when(userDao.getAllBlockedUsers()).thenReturn(list);
                assertEquals("itAdmin/blockedUsers", itAdminController.processUnblockUser(username, model));
        }
        
        @Test
        public void test_GoToViewProfessors_ReturnsITAdminViewProfessors(){
                ITAdminController i = new ITAdminController();
                List<User> list = new ArrayList<User>();
                when(userDao.getAllStudents()).thenReturn(list);
                assertEquals("itAdmin/viewProfessors", itAdminController.goToViewProfessors(session, model, principal));
        }

}
