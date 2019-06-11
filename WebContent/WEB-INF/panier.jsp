<h1 class="h1-responsive font-weight-bold text-center mt-5 pt-5 text-dark">Panier</h1>
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Product</th>                      
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    
	<c:forEach items="${commandeFilms}" var="commandeFilm">
		                <tr>
                            <td><img src="${pageContext.request.contextPath}/inc/images/movies/${commandeFilm.film.urlAffiche}"width="50" height="50" /> </td>
                            <td>${commandeFilm.film.titreOriginal}</td>
                            <td class="text-right"><a href="<c:url value="/accesrestreint/deletemovie">
		<c:param name="idfilm" value="${commandeFilm.film.idFilm }"/>
		<c:param name="idpanier" value="${idpanier}"/>
		</c:url>"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </a></td>
                        </tr>		
		
		<br>

	</c:forEach>

                       
                    </tbody>
                </table>
     

	<c:choose>	
		<c:when test="${!empty commandeFilms}">
			<a href="<c:url value="/accesrestreint/paypanier">
			<c:param name="idpanier" value="${idpanier}"/>
			</c:url>">
			  <div class="col mb-2">
           
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
                </div>
            </div></a>
		</c:when>
		<c:when test="${empty commandeFilms}">
			Votre panier est vide
			
		</c:when>
	</c:choose>



            </div>
        </div>
      
        </div>
    </div>
</div>