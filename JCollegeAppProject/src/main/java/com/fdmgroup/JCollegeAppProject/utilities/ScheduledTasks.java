package com.fdmgroup.JCollegeAppProject.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.JCollegeAppProject.daos.CourseDAO;
import com.fdmgroup.JCollegeAppProject.entities.Course;

public class ScheduledTasks {
	
	@Autowired
	CourseDAO courseDao;
	
	public void cleanUpCourses(){
		List<Course> courseList = courseDao.getAllCourses();
		List<Course> emptyCourses = new ArrayList<Course>();
		
		for (Course course : courseList){
			if (course.getStudentList().size() < 3){
				courseDao.removeCourse(course.getCourseCode());
			}
		}
	}

}
