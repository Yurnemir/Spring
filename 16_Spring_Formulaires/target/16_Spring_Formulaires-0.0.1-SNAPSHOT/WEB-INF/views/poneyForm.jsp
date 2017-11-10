<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="POST" action="soumettreForm" commandName="formPoney"><!-- commandName ou modelAttribute, équivalent -->

	<!-- path indique l'attribut associé (objet.sousobjet.sousousobjet...) -->
	Nom: <form:input path="nom"/>
	<form:errors path="nom" cssStyle="color:red"/><!-- pour afficher les erreurs issues de la soumission du formulaire -->
	
	Couleur: <form:input path="couleur"/>
	<form:errors path="couleur" cssStyle="color:red"/>
	
	Age: <form:input path="age"/>
	<form:errors path="age" cssStyle="color:red"/>
	
	Taille: <form:input path="taille"/>
	<form:errors path="taille" cssStyle="color:red"/>
	
	<input type="submit" value="Soumettre le formulaire"/>
	
</form:form>

</body>
</html>