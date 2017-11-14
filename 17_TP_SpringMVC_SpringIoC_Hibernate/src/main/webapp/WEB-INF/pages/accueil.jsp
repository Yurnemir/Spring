<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>La liste des etudiants</title>

<!-- Ajouter la librairie de bootstrap -->
<link href="<c:url value="/static/css/bootstrap.css"/>" rel="stylesheet" />



</head>
<body>

<div>
	<nav class="navbar navbar-inverse">
	
		<ul class="nav nav-tabs">
		
			<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/etudiant/listeEtudiants">Accueil</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheAjout">Ajouter</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheModif">Modifier</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheSuppr">Supprimer</a></li>
  			<li role="presentation"><a href="#">Rechercher</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Déconnection</a></li>
  			
		</ul>
	
	</nav>

</div>




<div align="center">
<table class="table table-bordered">
	<tr>
		<th> ID </th>
		<th> Nom </th>
		<th> Prenom </th>
		<th> Mail </th>
		<th> Opérations </th>
	</tr>

<c:forEach var="etudiant" items="${listeEtudiants}">
	<tr>
		<td>${etudiant.id}</td>
		<td>${etudiant.nom}</td>
		<td>${etudiant.prenom}</td>
		<td>${etudiant.mail}</td>
		<td><a href="${pageContext.request.contextPath}/etudiant/supprimeViaLien/${etudiant.id}">Supprimer</a>|
		<a href="${pageContext.request.contextPath}/etudiant/modifViaLien?pId=${etudiant.id}">Modifer</a></td>
	</tr>
</c:forEach>	

</table>
</div>

</body>
</html>