<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página JSP</title>
</head>
<body>
<p>Primeira página JSP</p>
<h1>
<%
String msg = "Hello World!";

out.println(msg);
%>
</h1>
<%=msg %>
</body>
</html>