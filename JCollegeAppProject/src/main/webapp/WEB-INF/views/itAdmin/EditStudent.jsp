<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student</title>
</head>
<body>

<br />
     <br />

     <br /> ${message}

     <br />
     <br /> edit the details of a student

     <sf:form method="post" action="processEditStudent" modelAttribute="student">

           
           
First Name: <sf:input path="firstName" value="${student.firstName}" />
           <br />
           <br />
Last Name: <sf:input path="lastName" value="${student.lastName}" />
           <br />
           <br />
User Name: <sf:input path="username"  value="${student.username}" />
           <br />
           <br />
Address <sf:input path="address" value="${student.address}" />
           <br />
           <br />
Phone: <sf:input path="phoneNumber"  value="${student.phone}" />
           <br />
           <br />
Gender:       <sf:input path="gender"  value="${student.fax}" />
           <br />
           <br />


           <input type="submit" value="Edit" />
           
     </sf:form>
     
     ${message}
     
<a href="processRemoveStudent?username=${student.username}">Remove Student</a>

<a href="HomePage"> Back To Home  </a>

</body>
</html>
