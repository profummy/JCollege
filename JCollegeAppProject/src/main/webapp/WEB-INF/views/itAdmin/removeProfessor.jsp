<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Professor</title>
</head>
<body>

<title>Select Professor</title>
</head>
<body>

     <h2>Remove professor</h2>

     <a href="/JCollegeAppProject/logout">Logout</a>

 
     ${message} <br/> <br/>
     
     are you sure you want to remove ${p.username}
     
     
     <a href="processRemoveProfessor">Remove ${p.username}</a>
     
     
     <a href="HomePage"> Back To Home  </a>
     


</body>
</html>