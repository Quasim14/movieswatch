 
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
<h6 class="display-3 font-weight-bold white-text mt-5 pt-5  ">Bienvenus Sur MoviesWatch</h6>
<hr class="hr-light my-4 w-75">
<div class="signup-form">
	<form method="post" action="<c:url value="/connexion" />">
		<fieldset>
			<h2>Connexion</h2>
			<p>Vous pouvez vous connecter via ce formulaire.</p>
			<div class="form-group">
			<input type="email" class="form-control" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" placeholder="Email Address"  />
			</div>
	
			<div class="form-group">
			<input type="password" class="form-control" id="motdepasse" name="motdepasse" value="" placeholder="Mot de passe" />
			</div>
	        <div class="form-group">
			<input type="submit" value="Connexion" class="btn btn-primary btn-lg" />
			<span class="erreur">${form.erreurs['user']}</span>
				</div>
			</fieldset>
		</form>
</div>
<hr class="hr-light my-4 w-75">
         <h4 class="subtext-header mt-2 mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit deleniti consequuntur nihil.</h4>

          </div>
          <!--Grid column-->
        </div>
        <!--Grid row-->
      </div>
      <!-- Content -->
    </div>
    <!-- Mask & flexbox options-->
  </div>
</div>

