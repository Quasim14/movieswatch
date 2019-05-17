<form method="post" action="<c:url value="/connexion" />">
	<fieldset>
		<legend>Connexion</legend>
		<p>Vous pouvez vous connecter via ce formulaire.</p>
		<label for="nom">Adresse email <span class="requis">*</span></label>
		<input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
		<br />

		<label for="motdepasse">Mot de passe <span class="requis">*</span></label>
		<input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
		<br />
                            
		<input type="submit" value="Connexion" class="sansLabel" />
		<br />
        <span class="erreur">${form.erreurs['user']}</span>  
	</fieldset>
</form>