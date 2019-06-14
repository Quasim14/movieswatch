<div class="container">
  <h3 class="display-3 font-weight-bold mt-5 pt-5 text-dark">Détail du film</h3>
  <div class="row justify-content-md-center">
    <div class="row">
      <div class="col">
        <div class="card-deck">
          <div class="card mb-4">
            <div class="view overlay">
              <img class="card-img-top" src="${film.urlAffiche}" alt="Card image cap">
              <a href="#!">
                <div class="mask rgba-white-slight">
                </div>
              </a>
            </div>
            <div class="card-body">
              <h4 class="card-title">${film.titreOriginal}</h4>
              <p class="card-text">${film.anneeProduction}</p>
            </div>
          </div>
        </div>
        <br>
        <br>
      </div>
      <div class="card bg-light mb-3 " style="max-width: 23rem;">
        <h2>Infos Film</h2>
        <div class="card-deck">
          <div class="card-body">
            <div class="fond_utile ">
              <div class="item-point-info">
                <h3 class="card-title">Synopsys</h3>
                <p class="card-text" style="">${film.synopsis}.</p>
                <div class="text-center"></div>
              </div>
              <div class="item-point-info">
                <h3 class="card-title">Date de sortie</h3>
                <div>${film.anneeProduction}</div>
                <p class="card-text" style=""></p>
                <div class="text-center">
                </div>
              </div>
              <div class="item-point-info">
                <h3 class="card-title">Budget</h3>
                <div>${film.budget}</div>
                <div class="text-center"></div>
              </div>
            </div>
            <div class="row">
              <div class="col-lg-12 text-right"></div>
            </div>
            <div class="text-right blanc visible-lg">
            
              
              <c:if test="${sessionScope.currentUser.role.nomRole == 'Utilisateur' }">                      
             	 <a href="<c:url value="/accesrestreint/addpanier"> <c:param name="idfilm" value="${film.idFilm}" />
              	</c:url>""><button class="btn btn-success" type="button">Ajouter au panier</button></a>	 
             </c:if>
             
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>