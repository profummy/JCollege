<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
</head>
<body>

<h2>My courses</h2>

<table>
		<tr>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Start Date</th>
			<th>End Date</th>
		</tr>

		<c:forEach items="${taughtCourseList}" var="t">
			<tr>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseCode}</a></th>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseName}</a></th>
				<th>${t.courseInfo}</th>
				<th>${t.startDate}</th>
				<th>${t.endDate}</th>
		</c:forEach>
	</table>


<a href="professorHome"> Go back Home</a>
<a href="/JCollegeAppProject/logout">Logout</a>
</body>
</html>