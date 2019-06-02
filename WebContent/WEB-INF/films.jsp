
<div class="container">
<c:forEach items="${listeFilm}" var="pFilm" varStatus="idx">

<c:if test="${idx.index % 3 == 0}">
	<div class="row">
</c:if>
  
	    <div class="col">
		 ${pFilm.titreOriginal }
	    </div>

</c:forEach>

</div>

</div>