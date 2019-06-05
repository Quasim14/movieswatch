<h1>Voici les films que vous avez achet�s</h1>
<p>
    <c:forEach var="film" items="${films}">
        ${film.titreOriginal } <br>
    </c:forEach>
</p>