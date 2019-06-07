<h1>Panier</h1>
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Product</th>
                            <th scope="col">Available</th>
                            <th scope="col" class="text-center">Quantity</th>
                            <th scope="col" class="text-right">Price</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    
	<c:forEach items="${commandeFilms}" var="commandeFilm">
		${commandeFilm.film.titreOriginal}
                        <tr>
                            <td><img src="${pageContext.request.contextPath}${commandeFilm.film.urlAffiche}"width="50" height="50" /> </td>
                            <td>${commandeFilm.film.titreOriginal}</td>
                            <td>In stock</td>
                            <td><input class="form-control" type="text" value="1" /></td>
                            <td class="text-right">124,90 euro</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
		<a href="<c:url value="/accesrestreint/deletemovie">
		<c:param name="idfilm" value="${commandeFilm.film.idFilm }"/>
		<c:param name="idpanier" value="${idpanier}"/>
		</c:url>">
		Supprimer</a>
		<br>

	</c:forEach>


	<c:choose>
		<c:when test="${!empty commandeFilms}">
			<a href="<c:url value="/accesrestreint/paypanier">
			<c:param name="idpanier" value="${idpanier}"/>
			</c:url>">
			payer</a>
		</c:when>
		<c:when test="${empty commandeFilms}">
			Votre panier est vide
			
		</c:when>
	</c:choose>

</p>


                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Total</strong></td>
                            <td class="text-right"><strong>0 euro</strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-block btn-light">Continue Shopping</button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
                </div>
            </div>
        </div>
    </div>
</div>