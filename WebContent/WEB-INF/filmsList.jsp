<h3 class="display-3 font-weight-bold mt-5 pt-5 text-dark">Liste des films</h3>
<hr class="hr-light my-4 w-75">

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
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
                
            </table>
           

			<c:if test="${sessionScope.currentUser.role.nomRole == 'Admin' }">                      
          		 <div class="col-sm-7">
					<a href="<c:url value="/admin/filmAdmin"/>" class="btn btn-primary"><i class="material-icons">&#xE147;</i> <span>Ajouter un film</span></a>				
				</div>  
             </c:if>
             
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
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>     