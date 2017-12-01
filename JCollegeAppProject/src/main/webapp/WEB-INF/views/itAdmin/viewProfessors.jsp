<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Professors</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}

td {
	border: 1px solid grey;
	width: 20%;
	font-weight: bold;
}

th {
	font-size: 10pt;
	font-weight: normal;
	border: 1px solid grey;
}

table {
	margin-left: -5%;
	border: 1px solid grey;
}
</style>
</head>
<body>
	<div id="mainWrapper">
		<header> <!-- This is the header content. It contains Logo and links -->
		<div id="logo">
			<!-- Company Logo text -->
			<a href="../home"> <img src="../img/logo.png" />
			</a>
		</div>
		<div id="headerLinks">
			<a href="../logout" title="Logout">Logout</a>
		</div>
		<div class="titletext">
			<h2>Judge College</h2>
		</div>
		</header>
		<div id="content">
			<nav class="sidebar">
			<div id="menubar">
				<div class="menu">
					<ul>
						<li><a href="viewStudents">Students</a></li>
						<li><a href="viewProfessors">Professors</a></li>
						<li><a href="viewRegistrars">Registrars</a></li>
						<li><a href="viewItAdmins">IT Admins</a></li>
						<li><a href="viewBlockedUsers">View Blocked Users</a></li>
					</ul>
				</div>
			</div>
			</nav>
			<div class="mainContent">

				<h2>All Professors</h2>

				${message} <br /> <br /> <a href="addProfessor"> Add Professor </a>

				<table>
					<tr>

						<th>Professor User Name</th>
						<th>Professor password</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Fax</th>
						<th>Department</th>
						<th>Remove Professor</th>

					</tr>

					<c:forEach items="${professorList}" var="p">
						<tr>
							<th>${p.username}</th>
							<th>${p.password}</th>
							<th>${p.firstName}</th>
							<th>${p.lastName}</th>
							<th>${p.address}</th>
							<th>${p.phone}</th>
							<th>${p.fax}</th>
							<th>${p.department.departmentName}</th>
							<th><a href="processRemoveProfessor?username=${p.username}">Remove</a></th>
					</c:forEach>
				</table>


			</div>
		</div>
		<footer> <!-- This is the footer with default 3 divs -->
		<div>
			<span style="line-height: 5px">
				<p>
					<strong>Judge College</strong>
				</p>
				<p>Cottons Centre</p>
				<p>Cottons Lane</p>
				<p>London SE1 2QG</p>
			</span>
		</div>
		<div id="2col">
			<span style="line-height: 10px"><p>Tel: 020 3141 5926</p>
				<p>Email: info@judgecollege.co.uk</p></span>
		</div>
		<div>
			<span style="line-height: 10px"><p>&copy; 2017 Judge
					College Inc.</p>
				<p>All Rights Reserved</p></span>
		</div>
		</footer>
	</div>


</body>
</html>