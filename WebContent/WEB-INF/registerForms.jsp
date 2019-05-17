<form method="post" action="RegisterForms">
	<fieldset>
    	<legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="nom">Nom</label>
        <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['nom']}</span>
        <br />
        <label for="prenom">Prénom</label>
        <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['prenom']}</span>
        <br />
                
        <label for="adresseRue">Adresse</label>
        <input type="text" id="adresseRue" name="adresseRue" value="<c:out value="${utilisateur.ADrue}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['adresseRue']}</span>
        <br />
        <label for="codepostal">Code postal</label>
        <input type="text" id="codepostal" name="codepostal" value="<c:out value="${codepostal.numero}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['codepostal']}</span>
        <br />
               
 
                
        <label for="telephone">Telephone</label>
        <input type="text" id="telephone" name="telephone" value="<c:out value="${utilisateur.numMobile}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['adresseRue']}</span>
        <br />
                
        <label for="datenaissance">Date de naissance</label>
        <input type="date" id="datenaissance" name="datenaissance" value="<c:out value="${utilisateur.dateNaissance}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['datenaissance']}</span>
        <br />
                
        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['email']}</span>
        <br />
                
        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['motdepasse']}</span>
        <br />

        <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['confirmation']}</span>
        <br />
                

        <input type="submit" value="Inscription" class="sansLabel" />
        <br />
                
        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	</fieldset>
</form>
    