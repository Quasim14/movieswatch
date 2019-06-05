<style>

    .carousel{
        background: #2f4357;
        margin-top: 20px;
    }
    .carousel-item{
        text-align: center;
        min-height: 280px; /* Prevent carousel from being distorted if for some reason image doesn't load */
    }
    .bs-example{
        margin: 20px;
    }
</style>

<c:out value="Bienvenue ${sessionScope.currentUser.prenom }"></c:out><br>

<a href=" <c:url value="/accesrestreint/deconnexion"/>">Se deconnecter</a>

<div class="bs-example">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Carousel indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for carousel items -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="/examples/images/slide1.png" alt="First Slide">
            </div>
            <div class="carousel-item">
                <img src="/examples/images/slide2.png" alt="Second Slide">
            </div>
            <div class="carousel-item">
                <img src="/examples/images/slide3.png" alt="Third Slide">
            </div>
        </div>
        <!-- Carousel controls -->
        <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</div>
