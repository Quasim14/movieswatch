<h1>Panier</h1>
<p>
<c:forEach items="${films}" var="film">
${film.titreOriginal}

<a href="<c:url value="/accesrestreint/deletemovie">
	<c:param name="idfilm" value="${film.idFilm }"/>
	<c:param name="idpanier" value="${idpanier}"/>
</c:url>">

Supprimer</a>
<br>
</c:forEach>
</p>