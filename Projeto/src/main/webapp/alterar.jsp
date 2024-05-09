<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração</title>
</head>
<body>
<form action='Controller'>
RA:<input type='text' name='ra' value='${aluno.ra}'/><br/>
nome:<input type='text' name='nome' value='${aluno.nome}'/><br/>
data de nascimento:<input type='text' name='dataNascimento'
  value='<fmt:formatDate value="${aluno.dataNascimento}" pattern="dd/MM/yyyy"/>'/><br/>
renda:<input type='text' name='renda' value='${aluno.renda}'/><br/>
<input type='hidden' name='op' value='Alterar'/>
<input type='submit' value='alterar'/>
</form>
<a href='/Projeto'>voltar</a>
</body>
</html>













