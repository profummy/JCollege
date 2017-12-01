<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
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
      
	<div style="padding: 1px 16px; height: 1000px;">
	<form align="left" name="form1" method="post" action="Courses">
			<label class="CoursesLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
		${message}
	<h2>Add Course</h2>
	<sf:form method="post" action="doAddCourse" modelAttribute="course">
		 Course Name : <br /> <sf:input type="text" path="courseName" /> <br />
		<div class="form-group">
		<sf:label path="department" class="col-lg-3 control-label">Department :</sf:label>
		<div class="col-lg-8">
		<div class="ui-select">
				<select name="departmentId">
						<option value="0" selected="selected"/>
					<c:forEach items="${departmentList}" var="dep">
						<option value="${dep.departmentId}">${dep.departmentName}</option>
					</c:forEach>
				</select>
		</div>
		</div>
		</div>
		
		Monday :<br/>
		<select name="monday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Tuesday :<br/>
		<select name="tuesday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Wednesday :<br/>
		<select name="wednesday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Thursday :<br/>
		<select name="thursday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Friday :<br/>
		<select name="friday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		
		
		<sf:input path="" type="submit" value="Add Course" />
	</sf:form>	
	</div>
      
      
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