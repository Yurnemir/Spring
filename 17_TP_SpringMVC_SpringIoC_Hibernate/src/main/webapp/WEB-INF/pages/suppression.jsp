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
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheAjout">Ajouter</a></li>
  			<li role="presentation"><a href="${pageContext.request.contextPath}/etudiant/afficheModif">Modifier</a></li>
  			<li role="presentation" class="active"><a href="#">Supprimer</a></li>
  			<li role="presentation"><a href="#">Rechercher</a></li>
  			
		</ul>
	
	</nav>

</div>
<br/>
<h1 style="color:red; text-align:center">Formulaire de suppression</h1>

<form:form class="form-horizontal" method="POST" action="supprimerEtudiant" modelAttribute="etudiantSuppr">
  <div class="form-group">
    <form:label path="id" class="col-sm-2 control-label">Id</form:label>
    <div class="col-sm-10">
      <form:input class="form-control" path="id"/>
      <form:errors path="nom"/>
    </div>
  </div>
  <input type="submit" value="Supprimer" class="btn btn-primary"/>
</form:form>

</body>
</html>