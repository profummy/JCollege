<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/login.css" rel="stylesheet" type="text/css">
<head>
  <link rel="shortcut icon" type="image/x-icon" href="https://image.ibb.co/j2Oa5m/Judge_College.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Judge College</title>
</head>
<body>

	
	<form action="j_security_check" method="post">
	<h2>Judge College Registration System</h2>
	  <div class="imgcontainer">
	<div class="message">
		<p>${message}</p>
	</div>
    <img src="img/logo.png" alt="Avatar" class="avatar">
  </div>
  
	<div class="container">
		<label><b>Username</b></label>
		<input type="text" placeholder="Enter Username" name="j_username" required>
		<label><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="j_password" required>
		<button type="Submit">Login</button>
		<div class="forgotContainer">
			<span class="psw"><a href="forgotPassword">Forgot password?</a></span>
		</div>
	</div>
	</form>

</body>
</html>