<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Professor</title>
</head>
<body>

	<br />
	<br />

	<br /> ${message}
	<br />
	<br />

	<br />
	<br /> edit the details of a professor

	<sf:form method="post" action="processEditProfessor"
		modelAttribute="professor">

           
           
First Name: <sf:input path="firstName" value="${professor.firstName}" />
		<br />
		<br />
Last Name: <sf:input path="lastName" value="${professor.lastName}" />
		<br />
		<br />
User Name: <sf:input path="username" value="${professor.username}" />
		<br />
		<br />
Address <sf:input path="address" value="${professor.address}" />
		<br />
		<br />
Phone: <sf:input path="phone" value="${professor.phone}" />
		<br />
		<br />
Fax:       <sf:input path="fax" value="${professor.fax}" />
		<br />
		<br />


		<input type="submit" value="Edit" />

	</sf:form>

	${message}

	<a href="processRemoveProfessor?username=${professor.username}">Remove
		Professor</a>

	<a href="HomePage"> Back To Home </a>

</body>
</html>
