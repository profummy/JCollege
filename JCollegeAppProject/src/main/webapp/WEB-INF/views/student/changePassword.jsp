<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
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
      
<h3>View Personal Details</h3>

<form method="post" action="updatePassword">
	<h2 style="text-align:left"> Update Your Password </h2>
	<p style="text-align:left">Current Password : <input type="password" name="password"/><br/></p>
	<p style="text-align:left">New Password : <input type="password" name="newPassword"/></p>
	<p style="text-align:left">Confirm Password : <input type="password" name="confirmPassword"/></p>
	
	${message}<br/>
	
<input style="text-align:left" type="submit" value="Submit"/>
</form>
      
      
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