<c:choose>
	<c:when test="${empty sessionScope.currentUser}">
		<nav class="op navbar navbar-expand-lg navbar-dark  fixed-top scrolling-navbar">
	</c:when>
	<c:when test="${!empty sessionScope.currentUser}">
		<nav class="op navbar navbar-expand-lg navbar-dark elegant-color fixed-top scrolling-navbar">
	</c:when>
</c:choose>
    <div class="container">
        <a class="navbar-brand" href="#">Movieswatch</a>
     	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
       		<span class="navbar-toggler-icon"></span>
       	</button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto smooth-scroll">
                <c:if test="${empty sessionScope.currentUser}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/connexion"/>">
                        	Connexion
                        	<span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/registerForms"/>" data-offset="90">Inscription</a>
                    </li>
                </c:if>
                <c:if test="${!empty sessionScope.currentUser}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/accesrestreint/accueil"/>" data-offset="90">Accueil</a>
                    </li>
                                        
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/accesrestreint/edituser"/>" data-offset="90">edit profil</a>
                    </li>                 
				</c:if>
                <c:choose>
                    <c:when test="${sessionScope.currentUser.role.nomRole == 'Utilisateur' }">    
	                     <li class="nav-item">
	                        <a class="nav-link" href="<c:url value="/accesrestreint/filmList"/>" data-offset="90">Films</a>
	                    </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/accesrestreint/panier"/>" data-offset="30">Panier</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/accesrestreint/mescommandes"/>" data-offset="90">Vos commandes</a>
                        </li>
                    </c:when>
                    <c:when test="${sessionScope.currentUser.role.nomRole == 'Admin' }">
                       <li class="nav-item">
                       		 <a class="nav-link" href="<c:url value="/accesrestreint/filmList"/>" data-offset="90">Films</a>
                   		</li> 
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/membersList"/>" data-offset="90">membres</a>
                        </li>
                          <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/accounting"/>" data-offset="90">Commandes</a>
                        </li>
                    </c:when>
                    
                    <c:when test="${sessionScope.currentUser.role.nomRole == 'Comptable' }">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/accounting"/>" data-offset="90">Commandes</a>
                        </li>
                    </c:when>     
                </c:choose>                           
			</ul>
            <ul class="navbar-nav nav-flex-icons">
	            <li class="nav-item">
	                <a class="nav-link">
	                	<i class="fa fa-facebook-f light-green-text-2"></i>
	                </a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link">
	                	<i class="fa fa-twitter light-green-text-2"></i>
	                </a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href=" <c:url value="/accesrestreint/deconnexion"/>">
	                    <i class="fa fa-sign-out light-green-text-2"></i>
	                </a>
	            </li>
            </ul> 
        </div>
    </div>
</nav>

