<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">

body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}
</style>


</head>
<body>
<div id="mainWrapper">
  <header> 
    <!-- This is the header content. It contains Logo and links -->
    <div id="logo"> 
      <!-- Company Logo text --> 
      <a href="../home"> <img src="../img/logo.png"/> </a></div>
    <div id="headerLinks"><a href="../logout" title="Logout">Logout</a></div>
    <div class="titletext">
		  <h2>Judge College</h2>
    </div>
  </header>


<div id="content">
    <nav class="sidebar"> 
      <div id="menubar">
      	<div class="menu">
          <ul>
					<li><a href = "viewCourses">Courses</a></li>
          			<li><a href = "viewProfile">My Profile</a></li>
          			<li><a href = "viewTimetable">Timetable</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="mainContent">


	<h2>Student Course Options</h2>

	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Taught by</th>
			<th>Number of Students</th>
			
			<th> </th>
		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th>${c.courseName}</th>
			<th><c:choose>
						<c:when test="${empty c.professor}">
							N/A
						</c:when>
						<c:otherwise>
					${c.professor.firstName} ${c.professor.lastName}
					</c:otherwise>
					</c:choose></th>
				<th>${fn:length(c.studentList)}</th>
				<th>
				<c:choose>
					<c:when test="${empty c.professor.username }">
						<a href="processChooseCourse?courseCode=${c.courseCode}"> Teach</a>
					</c:when>
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
				</th>
		</c:forEach>
	</table>
<br/>
<br />
<br />
<h2>My courses</h2>
<table>
		<tr>
			<th>Course Code</th>
			<th>Course Name</th>
		</tr>

		<c:forEach items="${taughtCourseList}" var="t">
			<tr>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseCode}</a></th>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseName}</a></th>
				<th><a href="unassignCourse?courseCode=${t.courseCode}">Remove Course</a></th>
		</c:forEach>
	</table>

</div>
</div>


<footer> 
    <!-- This is the footer with default 3 divs -->
    <div><span style="line-height: 5px"> <p><strong>Judge College</strong></p>
      <p>Cottons Centre</p>
      <p> Cottons Lane</p>
      <p> London SE1 2QG</p></span>
    </div>
    <div id="2col">
    	<span style="line-height: 10px"><p>Tel: 020 3141 5926</p> 
    	<p>Email: info@judgecollege.co.uk</p></span>
    </div>
    <div>
      <span style="line-height: 10px"><p>&copy; 2017 Judge College Inc.</p>
      <p>All Rights Reserved</p></span>
    </div>
  </footer>
</div>






</body>
</html>