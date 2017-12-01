<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Course</title>
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
					<li><a class="selected" href="ViewCourses">View Courses</a></li>
                	<li><a href="ViewGrades">View Grades</a></li>
                	<li><a href="ViewProfile">View Profile</a></li>
                	<li><a href="viewTimetable">View Timetable</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="mainContent">
      
	<h2>Edit Course</h2>

	<a href="/JCollegeAppProject/logout">Logout</a>

	<br /> ${username} please chose a course to edit.


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
Professor: ${professor}
		<br />
		<br />
Course Start Date:  	${startDate}
		<br />
		<br />
Course End Date: ${endDate}

	</sf:form>

	<a href="studentHome"> Edit Course </a>
	
	<a href="leaveCourse"> Leave Course</a>

      
      
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