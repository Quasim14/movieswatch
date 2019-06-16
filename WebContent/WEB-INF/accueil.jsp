<h1 class="h1-responsive font-weight-bold text-center mt-5 pt-5 text-dark "><c:out value="Bienvenue ${sessionScope.currentUser.prenom }"></c:out></h1><br>

<div class="carousel" class="carousel slide" data-ride="carousel">
	<div class="carousel-inner">
    	<div class="carousel-item active">
      		<img src="${pageContext.request.contextPath}/inc/images/slides/avenger.jpg" class="d-block w-100" alt="...">
    	</div>
	    <div class="carousel-item">
	      	<img src="${pageContext.request.contextPath}/inc/images/slides/everest.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      	<img src="${pageContext.request.contextPath}/inc/images/slides/labyrinthe.jpg" class="d-block w-100" alt="...">
	    </div>
	</div>
  	<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    	<span class="sr-only">Previous</span>
  	</a>
  	<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    	<span class="carousel-control-next-icon" aria-hidden="true"></span>
    	<span class="sr-only">Next</span>
  	</a>
</div>
<script src="https://unpkg.com/scrollreveal/dist/scrollreveal.min.js"></script>