<c:if test="${sessionScope.currentUser.role.nomRole == 'Admin' }">                      

<h3 class="display-3 font-weight-bold mt-5 pt-5 text-dark">Liste des films</h3>
<hr class="hr-light my-4 w-75">
<form method="POST" action="<c:url value="/accesrestreint/filmList" />">
	<input type="text" name="keyword" required  placeholder="rechercher" size="50">
       	<select  name ="type">
       				   	<option selected value="titre">Titre</option>
       				   	<option value="genre">Genre</option>
			        	<option value="personne">Acteur/Realisateur</option>
			        	<option value="csa">CSA</option>
			        	<option value="annee">Année</option>
			        	<option value="personnage">Personnage</option>
						<option value="pays">Pays</option>									        	
		</select>
		<button type="submit" class="btn btn-primary btn-lg">Search</button>       		
</form>

<div class="container">
        <div class="table-wrapper">

            
        <div class="col-sm-5">
			<h2>Long metrage</h2>
		</div>            
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Isan</th>
                        <th scope="col">Titre</th>						
						<th scope="col">annee</th>
						<th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${filmList}" var="film" varStatus="status">
                	<c:if test="${film.metrage=='long' }">

                        <td>${status.index }</td>
                        <td><a href="#"><img src="${pageContext.request.contextPath}/inc/images/avatars/avatar.png" width="35" height="35"class="avatar" alt="Avatar">${film.numIsan}</a></td>
                        <td>${film.titreOriginal}</td>
                        <td>${film.anneeProduction}</td>
						<td>
                            <a href="<c:url value="/accesrestreint/detailsfilm">
		<c:param name="idfilm" value="${film.idFilm}"/>
		</c:url>"> <button class="btn btn-sm btn-info"><i class="fa fa-info-circle"></i> </button>
                             </a>
						</td>
                    
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
                
            </table>
           

          		 <div class="col-sm-7">
					<a href="<c:url value="/admin/filmAdmin"/>" class="btn btn-primary"><i class="material-icons">&#xE147;</i> <span>Ajouter un film</span></a>				
				</div>  
             
			<br>
			<hr class="hr-light my-4 w-75">
       		<div class="col-sm-5">
				<h2>Court metrage</h2>
			</div>
                 <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Isan</th>
                        <th scope="col">Titre</th>						
						<th scope="col">annee</th>
						<th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${filmList}" var="film" varStatus="status">
                	<c:if test="${film.metrage=='court' }">

                        <td>${status.index }</td>
                        <td><a href="#"><img src="${pageContext.request.contextPath}/inc/images/avatars/avatar.png" width="35" height="35"class="avatar" alt="Avatar">${film.numIsan}</a></td>
                        <td>${film.titreOriginal}</td>
                        <td>${film.anneeProduction}</td>
						<td>
                           <a href="<c:url value="/accesrestreint/detailsfilm">
		<c:param name="idfilm" value="${film.idFilm}"/>
		</c:url>"> <button class="btn btn-sm btn-info"><i class="fa fa-info-circle"></i> </button>
                             </a>
						</td>
                    
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>     
</c:if>

<c:if test="${sessionScope.currentUser.role.nomRole == 'Utilisateur' }"> 
<h3 class="display-3 font-weight-bold mt-5 pt-5 text-dark">Liste des films</h3>
<hr class="hr-light my-4 w-75">
          
    <!-- Card package -->
   <form method="POST" action="<c:url value="/accesrestreint/filmList" />">
	<input type="text" name="keyword" required placeholder="rechercher" size="50">
       	<select  name ="type">
       				   	<option selected value="titre">Titre</option>
       				   	<option value="genre">Genre</option>
			        	<option value="personne">Acteur/Realisateur</option>
			        	<option value="csa">CSA</option>
			        	<option value="annee">Année</option>
			        	<option value="personnage">Personnage</option>
						<option value="pays">Pays</option>									        	
		</select>
		<button type="submit" class="btn btn-primary btn-lg">Search</button>       		
</form>

    
<h2>Long metrage</h2>
<div class="card-columns col-lg-6 ">
	 <c:forEach items="${filmList}" var="film" varStatus="status">
	 	<c:if test="${film.metrage=='long' }">
			<div class="card card-cascade wider mt-2 mb-2">
		    <!-- Card image -->
		    	<div class="view view-cascade overlay">
		      		<img  class="card-img-top img-fluid " style="min-height : 130px; max-height: 130px" src="${film.urlAffiche}" alt="Card image cap">
		      		<a href="#!">
		        	<div class="mask rgba-white-slight"></div>
		      		</a>
		    	</div>		
		   	 <!-- Card content -->
		    	<div class="card-body card-body-cascade text-center">		
		     	 <!-- Title -->
		      		<h4 class="card-title"><strong>${film.titreOriginal}</strong></h4>
		      		<!-- Subtitle -->
		      		<h5 class="blue-text pb-2"><strong>Année : ${film.anneeProduction}</strong></h5>
		      		<!-- Text -->
		      		<div class="collapse-content">
		      		<p class="card-text collapse" id="collapseContent">${film.synopsis}</p>
      				<i class="fa fa-play text-muted float-right p-1 my-1" data-toggle="tooltip" data-placement="top" title="regarder"></i>
      				<i class="fa fa-heart text-muted float-right p-1 my-1 mr-3" data-toggle="tooltip" data-placement="top" title="favoris"></i>
      				<a class="nav-link" href=" <c:url value="/accesrestreint/detailsfilm?idfilm=${film.idFilm}"/>" ><i class="fa fa-cart-plus text-muted float-right p-1 my-1 mr-3"  data-toggle="tooltip" data-placement="top" title="Panier"></i>		    		
					</a>
					<a class="fa fa-angle-down red-text p-1 my-1 mr-0 mml-1 collapsed" data-toggle="collapse" href="#collapseContent" aria-expanded="false" aria-controls="collapseContent"></a>
					
					</div>
		    	</div>				
	  		</div>
		</c:if>
	</c:forEach>	
</div>
<!-- Card package -->
<hr class="hr-light my-4 w-75">

<h2>Court metrage</h2>

    <!-- Card package -->
<div class="card-columns col-lg-5 ">
	 <c:forEach items="${filmList}" var="film" varStatus="status">
	 	<c:if test="${film.metrage=='court' }">
			<div class="card card-cascade wider mt-2 mb-2">
		    <!-- Card image -->
		    	<div class="view view-cascade overlay">
		      		<img  class="card-img-top img-fluid " style="max-height: 130px" src="${film.urlAffiche}" alt="Card image cap">
		      		<a href="#!">
		        	<div class="mask rgba-white-slight"></div>
		      		</a>
		    	</div>		
		   	 <!-- Card content -->
		    	<div class="card-body card-body-cascade text-center">		
		     	 <!-- Title -->
		      		<h4 class="card-title"><strong>${film.titreOriginal}</strong></h4>
		      		<!-- Subtitle -->
		      		<h5 class="blue-text pb-2"><strong>Année : ${film.anneeProduction}</strong></h5>
		      		<!-- Text -->
		      		<div class="collapse-content">
		      		<p class="card-text collapse" id="collapseContent">${film.synopsis} </p>
      				<i class="fa fa-play text-muted float-right p-1 my-1" data-toggle="tooltip" data-placement="top" title="regarder"></i>
      				<i class="fa fa-heart text-muted float-right p-1 my-1 mr-3" data-toggle="tooltip" data-placement="top" title="favoris"></i>
      				<i class="fa fa-cart-plus text-muted float-right p-1 my-1 mr-3" data-toggle="tooltip" data-placement="top" title="Panier"></i>		    		
					<a class="fa fa-angle-down red-text p-1 my-1 mr-0 mml-1 collapsed" data-toggle="collapse" href="#collapseContent" aria-expanded="false" aria-controls="collapseContent"></a>
					
					</div>
		    	</div>				
	  		</div>
		</c:if>
	</c:forEach>	
</div>                     
</c:if>
    