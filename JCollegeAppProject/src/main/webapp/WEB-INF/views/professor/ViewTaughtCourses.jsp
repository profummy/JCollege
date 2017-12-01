<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses You Teach</title>
</head>
<body>

	${username}

	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Start Date</th>
			<th>End Date</th>

		</tr>


		<c:forEach items="${courseList}" var="c">
			<tr>
				<th><a href="processChoseCourse?courseCode=${c.courseCode}">${c.courseCode}</a></th>
				<th>${c.courseName}</th>
				<th>${c.courseInfo}</th>
				<th>${c.startDate}</th>
				<th>${c.endDate}</th>
		</c:forEach>
	</table>
	<br />
	<br />
	<a href="professorHome">back home</a>


</body>
</html>