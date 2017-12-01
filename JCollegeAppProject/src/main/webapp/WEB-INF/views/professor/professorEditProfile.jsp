<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
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


<h3>Edit your details below:</h3>

	<sf:form method="post" action="processEditProfile" modelAttribute="professor">
		Address <sf:input path="address" value="${professor.address}" />
		<br />
		Phone Number <sf:input path="phone" value="${professor.phone}"/>
		<br /> 
		Email Address  <sf:input path="emailAddress" value="${professor.emailAddress}"/>
		<br /> 
		Fax <sf:input path="fax" value="${professor.fax}"/>
		<br />
		<input type="submit" value="Edit">
		
		${message}
		
	</sf:form>


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