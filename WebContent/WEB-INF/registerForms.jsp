
<link href="${pageContext.request.contextPath}/inc/css/connexion.css" rel="stylesheet">


<div class="signup-form">
    <form method="post" action="<c:url value="/registerForms" />">
		<h2>Inscription</h2>
        <div class="form-group">
        	<input type="text" class="form-control" name="nom" value="<c:out value="${utilisateur.nom}"/>" placeholder="Nom" required="required">
        <span class="erreur">${form.erreurs['nom']}</span>
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" placeholder="Prenom">
        <span class="erreur">${form.erreurs['prenom']}</span>
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="adresseRue" value="<c:out value="${utilisateur.ADrue}"/>" placeholder="Adresse Rue">
        <span class="erreur">${form.erreurs['adresseRue']}</span>       
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="codepostal" value="<c:out value="${codepostal.numero}"/>" placeholder="code postal">
        <span class="erreur">${form.erreurs['codepostal']}</span>
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="telephone" value="<c:out value="${utilisateur.numMobile}"/>" placeholder="Num�ro de t�l�phone">
        <span class="erreur">${form.erreurs['adresseRue']}</span>
        </div>
        <div class="form-group">
        	<input type="date" class="form-control" name="datenaissance" value="<c:out value="${utilisateur.dateNaissance}"/>" placeholder="Date de naissance">
        <span class="erreur">${form.erreurs['datenaissance']}</span>
        </div>
        <div class="form-group">
        	<input type="email" class="form-control" name="email"  value="<c:out value="${utilisateur.email}"/>" placeholder="Email Address" required="required">
        <span class="erreur">${form.erreurs['email']}</span>
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="motdepasse" placeholder="Mot de passe" required="required">
        <span class="erreur">${form.erreurs['motdepasse']}</span>
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="confirmation" placeholder="Confirmer votre mot de passe" required="required">
        <span class="erreur">${form.erreurs['confirmation']}</span>
        </div>

		<div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">Valider</button>       
        </div>
    </form>
	<div class="text-center">Already have an account? <a href="<c:url value="/connexion"/>">Se connecter</a></div>
	<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</div>
