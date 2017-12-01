<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and Update Prof</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}
table {
	border-collapse: collapse;
	margin-top: 10px;
	border="0";
	border-color:#000000;
	border-style: solid;
	border-width: 0.5px;
	column-rule-style: solid;
	}
	
table td {
    border-left: 1px solid #000;
    border-right: 1px solid #000;
}

table td:first-child {
    border-left: none;
}

table td:last-child {
    border-right: none;
}
		
table tr:nth-child(even){background-color: white}		

.edit {
			text-align: left;
		}
p { margin-bottom: -1px;
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
                	<li><a href="MyProfile">My Profile</a></li>
					<li><a href="SystemUsers">System Users</a></li>
					<li><a href="Courses">Courses</a></li>
					<li><a href="Departments">Departments</a></li>
					<li><a href="Timetable">Timetable</a></li>
					<li><a href="Grades">Grades</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="mainContent">
    
    
	<form align="left" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
		
	<h2 align="left" >Profile Information</h2>
	 
	<div align="left">
	<form name="form1" method="post" action="EditInformationProf?username=${professor.username}">
		<label class="EditInformationLblPos"> 
			<input name="submit2" type="submit" id="submit2" value="Edit Information">
		</label>
	</form>
   </div>
    
	<table>
		<tr>
			<td>Username</td>
			<td><input type="hidden" id="username" value="${professor.username}">${professor.username}</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td>${professor.firstName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${professor.lastName}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${professor.address}</td>
      	</tr>
		<tr>
			<td>Phone Number</td> 
        	<td>${professor.phone}</td>
		<tr>
			<td>Fax</td>
			<td>${professor.fax}</td>
		</tr>
		<tr>
			<td>Email address</td>
			<td>${professor.emailAddress}</td>
		</tr>
		<tr>
			<td>Department</td>
			<td>${professor.department.departmentName}</td>
		</tr>
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