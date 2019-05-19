<h1>Vos commandes</h1>
<p>
<c:forEach items="${commandes}" var="commande">
Numéro de commande: ${commande.idCommande}
<a href="<c:url value="/accesrestreint/detailscommande">
	<c:param name="idcommande" value="${commande.idCommande }"/>
</c:url>">
Details</a>
<br>
</c:forEach>
</p>