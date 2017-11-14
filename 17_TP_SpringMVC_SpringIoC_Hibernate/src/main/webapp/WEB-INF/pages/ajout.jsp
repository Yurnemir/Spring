<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/static/css/bootstrap.css"/>" rel="stylesheet" />

</head>
<body>

<div>
	<nav class="navbar navbar-inverse">
	
		<ul class="nav nav-tabs">
		
			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/listeEtudiants">Accueil</a></li>
  			<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/etudiant/afficheAjout">Ajouter</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheModif">Modifier</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheSuppr">Supprimer</a></li>
  			<li role="presentation"><a href="#">Rechercher</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Déconnection</a></li>
		</ul>
	
	</nav>

</div>
<br/>
<h1 style="color:red; text-align:center">Formulaire d'ajout</h1>

<form:form class="form-horizontal" method="POST" action="insereEtudiant" modelAttribute="etudiantAjout">
  <div class="form-group">
    <form:label path="nom" class="col-sm-2 control-label">Nom</form:label>
    <div class="col-sm-10">
      <form:input class="form-control" path="nom"/>
      <form:errors path="nom"/>
    </div>
  </div>
  <div class="form-group">
    <form:label path="prenom" class="col-sm-2 control-label">Prenom</form:label>
    <div class="col-sm-10">
      <form:input class="form-control" path="prenom"/>
      <form:errors path="prenom"/>
    </div>
  </div>
    <div class="form-group">
    <form:label path="mail" class="col-sm-2 control-label">Mail</form:label>
    <div class="col-sm-10">
      <form:input class="form-control" path="mail"/>
      <form:errors path="mail"/>
    </div>
  </div>
  <input type="submit" value="Ajouter" class="btn btn-primary"/>
</form:form>

</body>
</html>