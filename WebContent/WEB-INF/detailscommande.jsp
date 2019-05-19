<h1>Voici les films que vous avez achetés</h1>
<p>
<c:forEach var="film" items="${films}">
	${film.titreOriginal } <br>
</c:forEach>
</p>