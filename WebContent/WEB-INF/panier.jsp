<h1>Panier</h1>
<p>
<c:forEach items="${commandeFilms}" var="commandeFilm">
${commandeFilm.film.titreOriginal}

<a href="<c:url value="/accesrestreint/deletemovie">
	<c:param name="idfilm" value="${commandeFilm.film.idFilm }"/>
	<c:param name="idpanier" value="${idpanier}"/>
</c:url>">

Supprimer</a>
<br>
</c:forEach>

<a href="<c:url value="/accesrestreint/paypanier">
	<c:param name="idpanier" value="${idpanier}"/>
</c:url>">
payer</a>
</p>