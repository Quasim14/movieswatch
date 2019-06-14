<style>
.erreur{
	color: black;
}
.deepshd {
  color: #e0dfdc;
  text-shadow: 0 -1px 0 #fff, 
  0 1px 0 #2e2e2e, 
  0 2px 0 #2c2c2c, 
  0 3px 0 #2a2a2a, 
  0 4px 0 #282828, 

  0 22px 30px rgba(0, 0, 0, 0.3);
} 
</style>

 <div class="view" style="background-image: url('./inc/images/background/backgroundConnectionPage.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
 	<div class="view">
    <!-- Mask & flexbox options-->
		<div class=" d-flex justify-content-center align-items-center">
     	 <!-- Content -->
			<div class="container px-md-3 px-sm-0">
        	<!--Grid row-->
        		<div class="row wow fadeIn">
          		<!--Grid column-->
          			<div class="col-md-12 mb-4 white-text text-center wow fadeIn">
						<!-- Full Page Intro -->
						<h6 class="deepshd display-3 font-weight-bold white-text mt-5 pt-5  ">Bienvenus Sur MoviesWatch</h6>
						<hr class="hr-light my-4 w-75">
						<div class="signup-form">
							<form method="post" action="<c:url value="/connexion" />">
								<fieldset>
									<h2>Connexion</h2>
									<p>Vous pouvez vous connecter via ce formulaire.</p>
									<div class="form-group">
										<input type="email" class="form-control" id="email" name="email" 
												value="<c:out value="${utilisateur.email}"/>" placeholder="Email Address"  />
									</div>
									<div class="form-group">
										<input type="password" class="form-control" id="motdepasse" name="motdepasse" 
												value="" placeholder="Mot de passe" />
									</div>
								        <div class="form-group">
										<input type="submit" value="Connexion" class="btn btn-primary btn-lg" /><br>
										<span class="erreur">${form.erreurs['user']}</span>
									</div>
								</fieldset>
							</form>
						</div>
						<hr class="hr-light my-4 w-75">
						<h4 class="subtext-header mt-2 mb-4">Un service de qualité jamais égaler</h4>
       				</div>
        		</div>
      		</div>
    	</div>
  	</div>
</div>

