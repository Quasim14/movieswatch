<style type="text/css">
	body {
		color: #999;
		background: #fafafa;
		font-family: 'Roboto', sans-serif;
	}
	.form-control {
        min-height: 41px;
		box-shadow: none;
		border-color: #e6e6e6;
	}
	.form-control:focus {
		border-color: #00c1c0;
	}
    .form-control, .btn {        
        border-radius: 3px;
    }
	.signup-form {
		width: 425px;
		margin: 0 auto;
		padding: 30px 0;
	}
	.signup-form h2 {
		color: #333;
		font-weight: bold;
        margin: 0 0 25px;
    }
    .signup-form form {
    	margin-bottom: 15px;
        background: #fff;
		border: 1px solid #f4f4f4;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 40px 50px;
    }
	.signup-form .form-group {
		margin-bottom: 20px;
	}
	.signup-form label {
		font-weight: normal;
		font-size: 13px;
	}
	.signup-form input[type="checkbox"] {
		margin-top: 2px;
	}    
    .signup-form .btn {        
        font-size: 16px;
        font-weight: bold;
		background: #00c1c0;
		border: none;
		min-width: 140px;
        outline: none !important;
    }
	.signup-form .btn:hover, .signup-form .btn:focus {
		background: #00b3b3;
	}
	.signup-form a {
		color: #00c1c0;
		text-decoration: none;
	}	
	.signup-form a:hover {
		text-decoration: underline;
	}
</style>

<div class="signup-form">
    <form action="<c:url value="/registerForms" />" method="post">
		<h2>Inscription</h2>
        <div class="form-group">
        	<input type="text" class="form-control" name="nom" value="<c:out value="${utilisateur.nom}"/>" placeholder="Nom" required="required">
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" placeholder="Prenom">
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="adresseRue" value="<c:out value="${utilisateur.ADrue}"/>" placeholder="Adresse Rue">
        </div> 
        <div class="form-group">
        	<input type="text" class="form-control" name="codepostal" value="<c:out value="${codepostal.numero}"/>" placeholder="code postal">
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="telephone" value="<c:out value="${utilisateur.numMobile}"/>" placeholder="Numéro de téléphone">
        </div> 
        <div class="form-group">
        	<input type="date" class="form-control" name="datenaissance" value="<c:out value="${utilisateur.dateNaissance}"/>" placeholder="Date de naissance">
        </div>                                    
        <div class="form-group">
        	<input type="email" class="form-control" name="email"  value="<c:out value="${utilisateur.email}"/>" placeholder="Email Address" required="required">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="motdepasse" placeholder="Mot de passe" required="required">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" name="confirmation" placeholder="Confirmer votre mot de passe" required="required">
        </div>        

		<div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">Valider</button>
        </div>
    </form>
	<div class="text-center">Already have an account? <a href="<c:url value="/connexion"/>">Se connecter</a></div>
	<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</div>
    