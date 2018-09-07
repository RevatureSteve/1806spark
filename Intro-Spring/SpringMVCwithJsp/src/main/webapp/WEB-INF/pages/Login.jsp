<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<link rel="stylesheet" href="/SpringMVC/resources/css/k_strap.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Login</title>
</head>
<body>
<h1>Please Login</h1>
<c:if test="${ errorMessage != null}">
	<div class="alert alert-danger">${errorMessage }</div>
</c:if>

<!-- Spring Tag Library - form -->
<form:form action="login" method="POST" commandName="user">
	Username: <form:input path="username"/>
	password:<form:input path="password"/>
	<input type="submit" value="Login" />
</form:form>



<!-- Regular html form -->
<!-- 

<form action="login" method="post">
	Username: <input type="text" name="username" /> <br>
	password: <input type="text" name="password" />	<br>
	<input type="submit" value="Login" />
</form>


 -->
</body>
</html>