<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/css/bootstrap.css"/>" />
<meta charset="ISO-8859-1">
<title>Moviewatch</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/accesrestreint/accueil"/>">Accueil <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/connexion"/>">Connexion</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/registerForms"/>">Inscription</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/filmAdmin"/>">Ajout film</a>
      </li>
      
    </ul>
  </div>
</nav>
