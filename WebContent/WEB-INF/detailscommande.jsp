  <!-- Section heading -->
  <h2 class="h1-responsive font-weight-bold text-center mt-5 pt-5text-dark">Vos Achats</h2>
  <!-- Section description -->

<c:forEach var="film" items="${films}">

<section class="my-5">
  <!-- Grid row -->
  <div class="row">

    <!-- Grid column -->
    <div class="col-lg-5 col-xl-4">

      <!-- Featured image -->
      <div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
        <img class="img-fluid" src="${pageContext.request.contextPath}/inc/images/movies/${film.urlAffiche}"alt="${film.titreOriginal }">
        <a>
          <div class="mask rgba-white-slight"></div>
        </a>
      </div>

    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-lg-7 col-xl-8">

      <!-- Post title -->
      <h3 class="font-weight-bold mb-3"><strong>${film.titreOriginal }</strong></h3>
      <!-- Excerpt -->
      <p class="dark-grey-text">${film.synopsis}</p>
      <!-- Post data -->
      <p>by <a class="font-weight-bold">Jessica Clark</a>, ${film.anneeProduction }</p>


    </div>
    <!-- Grid column -->

  </div>
  <!-- Grid row -->

  <hr class="my-5">




</section>

</c:forEach>

