<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>

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

	<h2>List of all students enrolled on ${course.courseName}</h2>


	<table>
		<tr>

			<th>Student Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Address</th>
			<th>Grade</th>
			<th> New Comment </th>
			
		</tr>

		<c:forEach items="${studentList}" var="s">
			<tr>
				<td><a href="viewStudent?username=${s.username}">${s.username}</a></td>
				<td>${s.firstName}</td>
				<td>${s.lastName}</td>
				<td>${s.emailAddress}</td>
 				
					<!--  <select name="gradeDropdown"> -->
					
			 		 <c:forEach items="${s.gradeList}" var="grade">
			 		 <c:set scope="request" var="grade" value="${grade }"/>
 				<form method="post" action="updateGrade?courseCode=${course.courseCode}&username=${s.username}">
			 		 	
			  			<c:if test="${grade.course.courseCode eq course.courseCode}"> 
							<td> <input name="gradeValue" type="text" value= "${grade.gradeValue}"/> </td>
						 	<td> <input name="gradeComment" value="${grade.gradeComment}"/> </td>
							<td><input type="submit" value="Update"/></td>
			  			</c:if>
			  </form>
			  		</c:forEach>
			  		
 				</tr>
			  </c:forEach>
			  
			  
				<!--   		<c:choose>
							<c:when test="${tester eq 'has' }">
			  			<th><input name="gradeComment" value="${comment}"/> </th>
			  				</c:when>
			  		</c:choose>  
			  			
			  			
			  <c:set var="tester" value="has"/>
						<c:set var="comment" value="${grade.gradeComment}"/> -->
			  
			 <!--  <c:choose>
			  <%-- Display entire list when the student has no grades assigned to them --%>
				<c:when test="${empty s.gradeList}">
				<c:forEach items="${gradeList}" var="g">
						<option value="${g}" selected>${g}</option>
				</c:forEach>
				<th><input name="gradeComment" value=""/> </th>
				<th><input type="submit" value="Update"/></th>
				</c:when>
				
				<%-- Display assigned grade as selected when the student has at least one grade assigned to them  --%>
				<c:otherwise>
 				<c:forEach items="${s.gradeList}" var="grade">
					<c:choose>
						<c:when test="${grade.course.courseCode eq course.courseCode }">
							<c:set var="tester" value="has"/>
							<c:forEach items="${gradeList}" var="g">
							  <c:choose>
								<c:when test="${grade.gradeValue eq g }">
									<option value="${g}" selected>${g}</option>
								</c:when>
								<c:otherwise>
									<option value="${g}">${g}</option>
								</c:otherwise>
							  </c:choose>
							</c:forEach>
					<th><input name="gradeComment" value="${grade.gradeComment }"/> </th>
					<th><input type="submit" value="Update"/></th>
						 </c:when>
						<c:otherwise>
						<c:forEach items="${gradeList}" var="g">
							<option value="${g}" selected>${g}</option>
						</c:forEach>
						<c:choose>
							<c:when test="${tester ne 'has' }">
								<th><input name="gradeComment" value=""/> </th>
								<th><input type="submit" value="Update"/></th>
							</c:when>
						</c:choose>
						</c:otherwise>
 					</c:choose>
 				</c:forEach>
				</c:otherwise>
				</c:choose>
 			<!-- </select> -->
 					
				
 				<%--<th><a href="updateGrade?courseCode=${course.courseCode}&username=${s.username}&grade=${pageScope[gradeDropdown]}">Update</a></th> --%>
	
		
	
	
	
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