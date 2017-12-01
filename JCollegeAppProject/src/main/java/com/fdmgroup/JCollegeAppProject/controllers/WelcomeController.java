 ;[.;'lpackage com.fdmgroup.JCollegeAppProject.controllers;

import java.security.Principal;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.JCollegeAppProject.daos.ITAdminDAO;
import com.fdmgroup.JCollegeAppProject.daos.ProfessorDAO;
import com.fdmgroup.JCollegeAppProject.daos.RegistrarDAO;
import com.fdmgroup.JCollegeAppProject.daos.StudentDAO;
import com.fdmgroup.JCollegeAppProject.daos.UserDAO;
import com.fdmgroup.JCollegeAppProject.entities.ITAdmin;
import com.fdmgroup.JCollegeAppProject.entities.Professor;
import com.fdmgroup.JCollegeAppProject.entities.Registrar;
import com.fdmgroup.JCollegeAppProject.entities.Student;
import com.fdmgroup.JCollegeAppProject.entities.User;
import com.fdmgroup.JCollegeAppProject.utilities.RandomString;

@Controller
public class WelcomeController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	StudentDAO studentDao;
	@Autowired
	ProfessorDAO professorDao;
	@Autowired
	ITAdminDAO itAdminDao;
	@Autowired
	RegistrarDAO registrarDao;
	@Autowired
	UserDAO userDao;

	public WelcomeController() {
		super();
	}
	
	public WelcomeController(StudentDAO studentDao, ProfessorDAO professorDao, ITAdminDAO itAdminDao,
			RegistrarDAO registrarDao, UserDAO userDao) {
		super();
		this.studentDao = studentDao;
		this.professorDao = professorDao;
		this.itAdminDao = itAdminDao;
		this.registrarDao = registrarDao;
		this.userDao = userDao;
	}

	@RequestMapping("/")
	public String goToIndex() {
		return "index";
	}

	@RequestMapping("/index")
	public String goBackToIndex() {
		return "redirect:/";
	}

	@RequestMapping("/loginFailure")
	public String goToLoginFailure(@RequestParam String j_username, Model model) {
		User user = userDao.getUser(j_username);

		if (user != null) {
			user.setNoOfIncorrectAttempts(user.getNoOfIncorrectAttempts() + 1);
			if (user.getNoOfIncorrectAttempts() < 3) {
				model.addAttribute("message",
						"The data you entered is wrong.\nPlease provide a valid username and password for entry into the C-Registration System.");
			} else {
				model.addAttribute("message",
						"You have entered incorrect details on 3 occasions. Your account has been locked. Please contact IT Support.");
			}
			userDao.updateUser(user);
		}
		return "index";
	}

	@RequestMapping("/login")
	public String goToLogin(Model model, HttpSession session, Principal principal, HttpServletRequest request) {

		session.setAttribute("username", principal.getName());
		User user = userDao.getUser(principal.getName());
		
		if (user.getNoOfIncorrectAttempts() >= 3){
			session.invalidate();
			model.addAttribute("message",
					"You have entered incorrect details on 3 occasions. Your account has been locked. Please contact IT Support.");
			return "index";
		}

		if (request.isUserInRole("Student")) {
			return "redirect:student/home";
		} else if (request.isUserInRole("Professor")) {
			return "redirect:professor/home";
		} else if (request.isUserInRole("Registrar")) {
			return "redirect:registrar/home";
		} else if (request.isUserInRole("ITAdmin")) {
			return "redirect:itAdmin/HomePage";
		}

		return "redirect:/";
	}

	@RequestMapping("/student/home")
	public String goToStudentHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Student student = studentDao.getStudent(username);
		student.setNoOfIncorrectAttempts(0);
		studentDao.updateStudent(student);
		return "redirect:ViewProfile";
	}

	@RequestMapping("/professor/home")
	public String goToProfessorHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Professor professor = professorDao.getProfessor(username);
		professor.setNoOfIncorrectAttempts(0);
		professorDao.updateProfessor(professor);
		return "professor/professorHome";
	}

	@RequestMapping("/registrar/home")
	public String goToRegistrarHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		Registrar registrar = registrarDao.getRegistrar(username);
		registrar.setNoOfIncorrectAttempts(0);
		registrarDao.updateRegistrar(registrar);
		return "redirect:MyProfile";
	}

	@RequestMapping("/itadmin/home")
	public String goToITAdminHome(HttpSession session) {
		String username = (String) session.getAttribute("username");
		ITAdmin itAdmin = itAdminDao.getITAdmin(username);
		itAdmin.setNoOfIncorrectAttempts(0);
		itAdminDao.updateITAdmin(itAdmin);
		return "itadmin/itadminHome";
	}

	@RequestMapping("/logout")
	public String doLogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/forgotPassword")
	public String goToForgotPassword() {
		return "forgotPassword";
	}
	
	
	@RequestMapping("/doResetPassword")
	public String doResetPassword(@RequestParam String username) {
		User user = userDao.getUser(username);
		
		if (user != null){
			RandomString randomString = new RandomString(12, new Random(), RandomString.alphanum);
			String newPassword = randomString.nextString();
			
			user.setPassword(newPassword);
			userDao.updateUser(user);
		}
		
		return "confirmPasswordReset";
	}

}
