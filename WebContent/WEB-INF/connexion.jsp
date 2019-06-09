
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




