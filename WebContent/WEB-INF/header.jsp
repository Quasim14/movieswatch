<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Moviewatch</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      
      <c:if test="${empty sessionScope.currentUser}">
      	 <li class="nav-item">
        	<a class="nav-link" href="<c:url value="/connexion"/>">Connexion</a>
     	 </li>
      
      	<li class="nav-item">
        	<a class="nav-link" href="<c:url value="/registerForms"/>">Inscription</a>
     	</li>
      </c:if>
      
     <c:if test="${!empty sessionScope.currentUser}">
     	<li class="nav-item active">
        	<a class="nav-link" href="<c:url value="/accesrestreint/accueil"/>">Accueil <span class="sr-only">(current)</span></a>
      	</li>
      	
      <c:choose>
      	<c:when test="${sessionScope.currentUser.role.nomRole == 'Utilisateur' }">
      		<li class="nav-item active">
        		<a class="nav-link" href="<c:url value="/accesrestreint/panier"/>">Panier <span class="sr-only">(current)</span></a>
      		</li>
      		
      		<li class="nav-item active">
        		<a class="nav-link" href="<c:url value="/accesrestreint/mescommandes"/>">Vos commandes <span class="sr-only">(current)</span></a>
      		</li>
      	</c:when>
      	
      	<c:when test="${sessionScope.currentUser.role.nomRole == 'Admin' }">
      		<li class="nav-item">
        		<a class="nav-link" href="<c:url value="/admin/filmAdmin"/>">Ajout film</a>
      		</li>
      		
      		<li class="nav-item">
        		<a class="nav-link" href="<c:url value="/admin/registerAdmin"/>">Ajouter un utilisateur</a>
      		</li>
      	</c:when>
      </c:choose>
           		
     </c:if>
      
      
    </ul>
  </div>
</nav>
