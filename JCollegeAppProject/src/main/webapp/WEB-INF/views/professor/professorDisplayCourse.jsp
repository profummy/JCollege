<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Course</title>
</head>
<body>

	<h2>Edit Course</h2>

	<a href="/JCollegeAppProject/logout">Logout</a>

	<br /> ${username} please choose a course to edit.


	<sf:form method="post" action="EditCourse" modelAttribute="course">


Course Code: 	${courseCode}
		<br />
		<br />
Course Name: 	${courseName}
		<br />
		<br />
Course Information: ${courseInfo}"
        <br />
		<br />
Course Start Date:  	${startDate}
		<br />
		<br />
Course End Date: ${endDate}




	</sf:form>
	
	<a href="leaveCourse"> Leave Course</a>



</body>
</html>