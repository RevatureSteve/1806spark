<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flash Card</title>
<%@ include file="shared/headers.jsp" %>
</head>
<body>
<%@ include file="shared/navbar.jsp" %>
FlashCard Pulled: <%= session.getAttribute("fc") %>

</body>
</html>