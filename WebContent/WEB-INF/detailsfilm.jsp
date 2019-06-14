<h1 class="h1-responsive font-weight-bold text-center mt-5 pt-5 text-dark">Film</h1>
<p>
${film.titreOriginal}
</p>
<a href="<c:url value="/accesrestreint/addpanier">
	<c:param name="idfilm" value="${film.idFilm}"/>
</c:url>">
Ajouter au panier</a>