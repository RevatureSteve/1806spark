<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Java Home - JSPs: Java Server Pages</title>
	<%@ include file="shared/headers.jsp" %>
</head>
<body>
<%@ include file="shared/navbar.jsp" %>
<h1>Welcome to the Java</h1>
<!-- To write java code inside JSP we use Scriptlets -->
<%-- java comment scriptlet 
	%@ - Directive: 3 types page, taglib, include
	%= - Expression: print the html output
	%  - basic scriptlet for flow control
	%! - Declaration: to declare variables
--%>
<% //basic scriptlet
	if(true){%>
	<p>hello world:</p> <strong id="strongId"><%= request.getParameter("username") %></strong> <span class="byyee"> Goodbye</span>
	<p>hello world:</p> <strong id="strongId"><%= request.getParameter("username") %></strong> <span class="byyee"> Goodbye</span>
	<p>hello world:</p> <strong id="strongId"><%= request.getParameter("username") %></strong> <span class="byyee"> Goodbye</span>
	<%} %>
	
	<div>
		div tag
	</div>
</body>
</html>