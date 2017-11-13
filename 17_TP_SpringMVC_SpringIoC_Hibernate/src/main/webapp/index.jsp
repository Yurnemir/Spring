<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Toto</h1>
<!-- appel de la méthode du controller Redirection vers la page d'accueil -->
<% response.sendRedirect("etudiant/listeEtudiants"); %>

<ul class="nav">
  <li class="active">
    <a href="#">">Home</a>
  </li>
  <li><a href="<c:url value="/WEB-INF/pages/accueil.jsp"/>">Etudiants</a></li>
  <li><a href="#">Autre</a></li>
</ul>

</body>
</html>