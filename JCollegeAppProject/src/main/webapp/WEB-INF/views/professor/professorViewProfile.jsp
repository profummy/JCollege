<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor Profile Screen</title>
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

<h1>My Profile Details</h1>

<strong>Username:</strong> ${professor.username}<br/>
			<strong>First Name:</strong> ${professor.firstName}<br/>
			<strong>Last Name:</strong> ${professor.lastName}<br/>
			<strong>Registration Date:</strong> ${professor.registrationDate}<br/>
			<strong>Address:</strong> ${professor.address}<br/>
			<strong>Phone Number:</strong> ${professor.phone}<br/>
			<strong>Email Address:</strong> ${professor.emailAddress}<br/>
			<strong>Fax:</strong> ${professor.fax}<br/>
			<strong>Department:</strong> ${professor.department.departmentName}<br/>

<a href="editProfile">Edit Contact Information</a>








<!--  
<c:if test="${not empty username}">
 <div align="center">

        <table border="1" cellpadding="5">
            <caption> <h2>${username}'s Profile</h2></caption>
            <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User Name</th>
            <th>Registration Date</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th> Email Address </th>
                <th>Fax</th>
                <th>Department</th>
            
            </tr>
            
                <tr>
                <th>${professor.firstName}</th>
                <th>${professor.lastName}</th>
                <th>${professor.username}</th>
                <th>${professor.registrationDate}</th>
                    <th>${professor.address}</th>
                    <th>${professor.phone}</th>
                    <th>${professor.emailAddress}</th>
                    <th>${professor.fax}</th>
                    <th>${professor.department.departmentName}</th>
      
                </tr>
            
        </table>
    </div>
<a href="editProfile">Edit Contact information</a>

</c:if>
-->

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