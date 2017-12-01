<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
	body {
			background-color: #1A1A1A;
			background-image: url();
			background-repeat: repeat-x;
		}
	<style>
 		.allcourses #courses {
			border="0";
			border-color:#000000;
			border-style: solid;
			border-width: 0.5px;
		}
		.allcourses table a {
			text-decoration: none;
			color: black;
			display: block;
		}
		
		.allcourses table {
			margin-top: 10px;
		}
		
		.allcourses	 a:hover {
		background-color: white;
		}
		#courses a:live { background:yellow;}
		#courses a: visited {background:black;}
		#courses a: hover { background:color;}
		
		.allcourses {
			text-align: left;
			width: 20%;
			position: relative;
			float: left;
		}
		
		.allcourses table {
			border="0";
			border-color:#000000;
			border-style: solid;
			border-width: 0.5px;
		}
		
		.allcourses table tr:nth-child(even){background-color: white}		
		
		.search {
			text-align: left;
		}
		
		.coursedetails {
			width: 60%;
			margin-left: auto;
			margin-right: auto;
		}
		
		.coursedetails table {
			margin-top: -10px;
			width: 70%;
			margin-left: auto;
			margin-right: auto;
			border: 1px solid black;
		}
		
		.coursedetails table tr:nth-child(even){background-color: white}	
		
		.coursedetails table td {
		    border-left: 1px solid #000;
		    border-right: 1px solid #000;
		}
		
		.coursedetails table td:first-child {
		    border-left: none;
		}
		
		.coursedetails table td:last-child {
		    border-right: none;
		}
				
		.coursedetails table tr:nth-child(even){background-color: white}		
				
				form {
					position: relative;
					display: inline;
		}
		
		.buttonsdiv {
			margin-top: 10px;
			margin-right: 7%;
			margin-bottom: 30px;
		}
		
	</style>
	<script  type="text/javascript">
			function getConfirmation() {
				var courseName = document.getElementById("courseName").value;
				var isOk = confirm("Are you sure you want to update the course " + courseName + "?");
				return isOk;
			}
	</script>
	<script  type="text/javascript">
			function getConfirmationForCancelling() {
				var courseName = document.getElementById("courseName").value;
				var isOk = confirm("Are you sure you want to cancel the course " + courseName + "?");
				return isOk;
			}
	</script>
</head>
<body>
 	<c:if test="${message eq 'Course is cancelled!'}">
  	<script>
 		alert("Successfully removed course!");
  	</script>
 	</c:if> 

	<c:if test="${message5 eq 'Empty course is cancelled!'}">
  	<script>
 		alert("Successfully removed course!");
  	</script>
 	</c:if> 
 	
 	<c:if test="${message eq 'Course added successfully!'}">
  	<script>
 		alert("Successfully added course!");
  	</script>
 	</c:if> 
 	
 	<c:if test="${message eq 'Professer has been updated!'}">
  	<script>
 		alert("Successfully updated professor!");
  	</script>
 	</c:if> 
 	
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
      
<h2>Course Catalogue</h2>
		
		<div class="search">
		<form action="searchCourse" method="post">
				<input name="search" width="50px" placeholder="Search for Courses"/>
				<input type="submit" value="Go!"/>
		</form>
		</div>
		
		<div class="allcourses">
		<a href="showAllCourses">Show all courses</a><br/>
		<a href="viewEmptyCourses">View Empty Courses</a><br/><br/>
		<table class="courses">
		<c:forEach items="${courseList}" var="c">
			<tr><td><a href="processChooseCourse?courseId=${c.courseCode}">
				${c.courseName}</a> </td></tr>
		</c:forEach>
		</table>
		</div>

	  <div class="coursedetails">
			<h3>Course Details</h3>
		<table class="table" style="border-collapse: collapse;">
			<tr><td>Course Name</td>
				<td><input type="hidden" id="courseName" value="${course.courseName}">${course.courseName}</td>
			</tr>
			<tr><td>Course Code</td>
				<td>${course.courseCode}</td>
			</tr>
			<tr><td>Assigned Professor</td>
				<td>
					<form name="updateProfForm" action="updateProfessor" onSubmit="return getConfirmation()">
						<select name="professorUsername">
							<option value="empty" selected></option>
							<c:forEach items="${professorList}" var="prof">
								<c:choose>
									<c:when test="${prof.username eq course.professor.username }">
										<option value="${prof.username}" selected>${prof.firstName} ${prof.lastName}</option>
									</c:when>
									<c:otherwise>
										<option value="${prof.username}">${prof.firstName} ${prof.lastName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> <input type="hidden" name="code" value="${course.courseCode}" />
						<input type="submit" value="Update">
					</form></td>
			</tr>
			<tr>
				<td>Department</td>
				<td>${course.department.departmentName}</td>
			</tr>
		</table>
	  </div>
		
		<div class="buttonsdiv">
		<form name="form1" method="post" action="AddCourse">
			<label class="addCourse"> <input name="submit3"
				type="submit" id="submit2" value="Add Course">
			</label>
		</form>
		<form name="CancelCourse" action="cancelCourse?courseId=${course.courseCode}" onSubmit="return getConfirmationForCancelling()">
			<input type="hidden" name="code" value="${course.courseCode}" /> 
			<input name="cancelCourse" type="submit" value="Cancel Course">
		</form>
		</div>
		
		<div class="coursedetails">
			<h3>Enrolled Students</h3>
		<table class="table" style="border-collapse: collapse;">
			<tr style="background-color: lightgrey; border:2px solid black;">
				<td style="background-color: lightgrey; border:2px solid black;">Student Id</td>
				<td>Name</td>
			</tr>
			<c:forEach items="${studentList}" var="s">
				<tr><td>${s.username}</td> 
				<td>${s.firstName}${s.lastName}</td></tr>
			</c:forEach>
		</table>
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