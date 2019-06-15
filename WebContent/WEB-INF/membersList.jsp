<h3 class="display-3 font-weight-bold  mt-5 pt-5 text-dark">Liste des membres</h3>
<hr class="hr-light my-4 w-75">

<div class="container">
        <div class="table-wrapper">

            
        <div class="col-sm-5">
			<h2>Administrateur</h2>
		</div>            
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nom</th>						
						<th scope="col">Email</th>
						<th scope="col">Role</th>
						<th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${listUtilisateur}" var="user" varStatus="status">
                	<c:if test="${user.role.nomRole=='Admin' }">

                        <td>${status.index }</td>
                        <td><a href="#"><img src="${pageContext.request.contextPath}/inc/images/avatars/avatar.png" width="35" height="35"class="avatar" alt="Avatar"> ${user.nom} ${user.prenom} </a></td>
                        <td>${user.email}</td>
                        <td>${user.role.nomRole}</td>


						<td>
                            <a href="<c:url value="/admin/deleteUser">
		<c:param name="idutilisateur" value="${user.idUtilisateur}"/>
		</c:url>" class="delete" title="Delete" data-toggle="tooltip"><i class="fa fa-trash" style="color:red" aria-hidden="true"></i>
                             </a>
						</td>
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
                
            </table>
           <div class="col-sm-7">
				<a href="<c:url value="/registerForms"/>" class="btn btn-primary"><i class="material-icons">&#xE147;</i> <span>Ajouter un utilisateur</span></a>				
			</div>
			<br>
				<hr class="hr-light my-4 w-75">
			
			
			<div class="col-sm-5">
				<h2>Comptable</h2>
			</div>
                 <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nom</th>						
						<th>Email</th>
						<th>Role</th>
						<th>Action</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${listUtilisateur}" var="user" varStatus="status">
                	<c:if test="${user.role.nomRole=='Comptable' }">

                        <td>${status.index }</td>
                        <td><a href="#"><img src="${pageContext.request.contextPath}/inc/images/avatars/avatar.png" width="35" height="35"class="avatar" alt="Avatar"> ${user.nom} ${user.prenom} </a></td>
                        <td>${user.email}</td>
                        <td>${user.role.nomRole}</td>


						<td>
                            <a href="<c:url value="/admin/deleteUser">
		<c:param name="idutilisateur" value="${user.idUtilisateur}"/>
		</c:url>" class="delete" title="Delete" data-toggle="tooltip"><i class="fa fa-trash" style="color:red" aria-hidden="true"></i></a>
						</td>
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
            </table>
			
			
			<hr class="hr-light my-4 w-75">
       		<div class="col-sm-5">
				<h2>Utilisateur</h2>
			</div>
                 <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nom</th>						
						<th>Email</th>
						<th>Role</th>
						<th>Action</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${listUtilisateur}" var="user" varStatus="status">
                	<c:if test="${user.role.nomRole=='Utilisateur' }">

                        <td>${status.index }</td>
                        <td><a href="#"><img src="${pageContext.request.contextPath}/inc/images/avatars/avatar.png" width="35" height="35"class="avatar" alt="Avatar"> ${user.nom} ${user.prenom} </a></td>
                        <td>${user.email}</td>
                        <td>${user.role.nomRole}</td>


						<td>
                            <a href="<c:url value="/admin/deleteUser">
		<c:param name="idutilisateur" value="${user.idUtilisateur}"/>
		</c:url>" class="delete" title="Delete" data-toggle="tooltip"><i class="fa fa-trash" style="color:red" aria-hidden="true"></i></a>
						</td>
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>     