<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}
td, th {
	width: 20%;
	border-right: 1px solid grey;
}

table {
	margin-top: 10px;
	margin-left: -5%;
	border: 1px solid grey;
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
					<li><a class="selected" href="ViewCourses">View Courses</a></li>
                	<li><a href="ViewGrades">View Grades</a></li>
                	<li><a href="ViewProfile">View Profile</a></li>
                	<li><a href="viewTimetable">View Timetable</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="mainContent">
      
<h2>Student Course Options</h2>

	<a href="ViewCourses">Show All Available Courses</a>

	<form action="searchCourse" method="post">
		<input name="search" width="50px" placeholder="Search for Course"/>
		<input type="submit" value="Go!"/>
	</form>

	<table>
		<tr>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>Department</th>
			<th>Professor</th>
			<th>Enroll</th>

		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<td>${c.courseCode}</td>
				<td><a href="viewCourse?courseCode=${c.courseCode}">${c.courseName}</a></td>
				<td>${c.department.departmentName}
				<td>
				<c:choose>
				<c:when test="${empty c.professor}">
				N/A
			</c:when>
			<c:otherwise>
				${c.professor.firstName} ${c.professor.lastName}
			</c:otherwise>
				</c:choose>
				</td>
				<th><a href="enrollOnCourse?courseCode=${c.courseCode}&courseName=${c.courseName}">Enroll</a></td>
		</c:forEach>
	</table>
	${message}
		<br/>
		<br/>
		<br/>

	My Courses
	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Professor</th>
			<th>Remove</th>

		</tr>

		<c:forEach items="${enrolledCourses}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th>${c.courseName}</th>
				<th>
				<c:choose>
				<c:when test="${empty c.professor}">
				N/A
			</c:when>
			<c:otherwise>
				${c.professor.firstName} ${c.professor.lastName}
			</c:otherwise>
				</c:choose>
				</th>
				<th><a href="vacateCourse?courseCode=${c.courseCode}">Remove Course</a></th>
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