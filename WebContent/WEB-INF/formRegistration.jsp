<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>page Enregitrement</p>

<form method="post" action="<c:url value="/formRegistration" />">
	    <div>
           <label for="nom">Nom : </label>
           <input type="text" name="nom" id="nom" value="<c:out value="${utilisateur.nom}"/>"/>
        </div>
     	 <div>
           <label for="email">Email : </label>
           <input type="email" name="email" id="email" value="<c:out value="${utilisateur.email}"/>"/>
        </div>
     <input type="submit" />

</form>
<p>
${utilisateur.nom}
</p>
<p>
${utilisateur.email}
</p>
</body>
</html>