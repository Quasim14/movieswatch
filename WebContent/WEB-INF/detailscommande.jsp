<h2 class="h1-responsive font-weight-bold text-center mt-5 pt-5text-dark">Vos Achats</h2>
<c:forEach var="film" items="${films}">
	<section class="my-5">
		<div class="row">
	    	<div class="col-lg-5 col-xl-4">
		      	<div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
        			<img class="img-fluid" src="${film.urlAffiche}"alt="${film.titreOriginal }">
			        <a>
			          <div class="mask rgba-white-slight"></div>
			        </a>
		      	</div>
	    	</div>
		    <div class="col-lg-7 col-xl-8">
		      <h3 class="font-weight-bold mb-3"><strong>${film.titreOriginal }</strong></h3>
		      <p class="dark-grey-text">${film.synopsis}</p>
		      <p>by <a class="font-weight-bold">Jessica Clark</a>, ${film.anneeProduction }</p>
		    </div>
	  	</div>
	  	<hr class="my-5">
  	</section>
</c:forEach>

