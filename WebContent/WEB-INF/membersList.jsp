<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
						<h2>User <b>Management</b></h2>
					</div>
					<div class="col-sm-7">
						<a href="#" class="btn btn-primary"><i class="material-icons">&#xE147;</i> <span>Ajouter un utilisateur</span></a>				
					</div>
                </div>
            </div>
            
                    <div class="col-sm-5">
						<h2>Liste administrateur</h2>
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
                	<c:if test="${user.role.nomRole=='Admin' }">

                        <td>${status.index }</td>
                        <td><a href="#"><img src="${pageContext.request.contextPath}/inc/images/avatars/avatar.png" width="35" height="35"class="avatar" alt="Avatar"> ${user.nom} ${user.prenom} </a></td>
                        <td>${user.email}</td>
                        <td>${user.role.nomRole}</td>


						<td>
                            <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
						</td>
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
            </table>
                                <div class="col-sm-5">
						<h2>Liste Utilisateur</h2>
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
                            <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
						</td>
                    </tr>
					<tr>
                	</c:if>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>     