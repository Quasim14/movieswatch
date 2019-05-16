<p>
Affichage d'un abonnements:
${abo.intitule }
${abo.tarif }
</p>

<p>
Affichage de tout les abonnements:
<c:forEach items="${abos}" var="abon">
<br>
${abon.idAbonnement}
${abon.intitule}
${abon.tarif}
</c:forEach>
</p>