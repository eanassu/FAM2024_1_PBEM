<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�gina JSP</title>
</head>
<body>
<p>Primeira p�gina JSP</p>
<h1>
<%
String msg = "Hello World!";

out.println(msg);
%>
</h1>
<%=msg %>
</body>
</html>