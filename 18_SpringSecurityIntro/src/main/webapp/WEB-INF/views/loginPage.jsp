<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Login</title>
</head>
<body>

<form action="testLogin" method="post">
	Identifiant:<input type="text" name="j_username"/><br/>
	Mot de Passe:<input type="password" name="j_password"/><br/>
	<input type="submit" value="Se Connecter">

</form>

<c:if test="${not empty erreur}">
	<h1>Login ou Mot de Passe erronn�</h1>
</c:if>

</body>
</html>