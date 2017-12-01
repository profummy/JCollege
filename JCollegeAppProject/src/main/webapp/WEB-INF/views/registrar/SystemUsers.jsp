<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Users</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}

table tr input {
	opacity: 0;
	float: right
}

table tr:hover input {
	opacity: 1
}

table tr:nth-child(even){background-color: white}

.searchUser { text-align: left;
}

.allusers table {
			margin-left: auto;
			margin-right: auto;
			margin-top: 15px;
			text-align: left;
			border="0";
			border-color:#000000;
			border-style: solid;
			border-width: 0.5px;
			width: 90%;
		}
		
</style>
<script type="text/javascript">
	function getConfRemoveUser() {
		var userid = document.getElementById("usernameid").value;
		var isOk = confirm("Are you sure you want to remove the user?");
		return isOk;
	}
</script>
</head>
<body>
 	<c:if test="${message eq 'User is removed!'}">
  	<script>
 		alert("User is removed!");
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
    
      	<div class="searchUser">
      	<form action="searchUser" method="post">
				<input name="search" width="50px" placeholder="Search for User"/>
				<input type="submit" value="Go!"/>
		</form>
		</div>
      
		<a href="SystemUsers">Show All Users</a><br/>
		<a href="ShowProfessors">Professors only</a><br/>
		<a href="ShowStudents">Students only</a><br/>
		
		<div class="allusers">
		<table class="table" style="border-collapse: collapse;">
			<tr style="background-color: lightgrey; border:2px solid black;">
				<td style="padding: 8px;"><b>Username</b></td>
				<td style="padding: 8px;"><b>Name</b></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${userList}" var="u">
				<tr>
					<td style="padding: 5px;">${u.username}</td>
					<td>${u.firstName} ${u.lastName}</td>

					<td style="padding: 4px;">
						<form name="ViewAndUpdate" method="post" action="ViewAndUpdate">
							<input type="hidden" name="username" value="${u.username}" /> <input
								name="submit3" type="submit" id="submit3"
								value="View and Update">
						</form>
					</td>
					<td style="padding: 4px;">
						<form id="formRemove" action="RemoveUser" onsubmit="return getConfRemoveUser()">
							<input type="hidden" id="usernameid" name="username" value="${u.username}" >
							<input name="removeUser" type="submit" value="Remove">
						</form>
					</td>
				</tr>
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