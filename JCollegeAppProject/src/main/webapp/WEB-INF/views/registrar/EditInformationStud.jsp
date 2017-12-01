<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Infomation Stud</title>
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
      
      ${message}
      
<div style="padding: 1px 16px; height: 1000px;">
	
	<form align="centre" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
	<h2>Edit Information</h2>
	<sf:form method="post" action="processEditStud" modelAttribute="student">
			<sf:hidden path="username" value="${student.username}"/>
			<sf:hidden path="password" value="${student.password }"/>
			<sf:hidden path="registrationDate" value="${student.registrationDate }"/>
			<sf:hidden path="noOfIncorrectAttempts" value="${student.noOfIncorrectAttempts }"/>
	
			First Name <br/> <sf:input type="text" path="firstName" />
           <br/>
 			Last Name <br/> <sf:input type="text" path="lastName" />
           <br/>
           	Address <br/> <sf:input type="text" path="address" />
           <br/>
           	Phone Number <br/> <sf:input type="text" path="phoneNumber" />
           <br/>
            Email address <br/> <sf:input type="text" path="emailAddress" />
           <br/>
           Date of Birth <br/> <input name="dob" type="text" value="<fmt:formatDate value="${student.dOB}" type="both" pattern="dd/MM/yyyy"/>"/>
           <br/>
           Gender
           <br/>
           <select name="gender">
							<c:forEach items="${genders}" var="g">
								<c:choose>
									<c:when test="${student.genderString eq g}">
										<option value="${student.gender}" selected>${student.gender}</option>
									</c:when>
									<c:otherwise>
										<option value="${g}">${g}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
           </select>
           <br/>
           <input type="submit" value="Edit" />
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