  <!-- Section heading -->
  <h2 class="h1-responsive font-weight-bold text-center my-5">Vos Achats</h2>
  <!-- Section description -->
  <p class="text-center dark-grey-text w-responsive mx-auto mb-5">Duis aute irure dolor in reprehenderit in
    voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<c:forEach var="film" items="${films}">

<section class="my-5">
  <!-- Grid row -->
  <div class="row">

    <!-- Grid column -->
    <div class="col-lg-5 col-xl-4">

      <!-- Featured image -->
      <div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
        <img class="img-fluid" src="${pageContext.request.contextPath}${film.urlAffiche}"alt="${film.titreOriginal }">
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
</p>