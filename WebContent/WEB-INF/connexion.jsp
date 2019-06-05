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
<p>${sessionScope.currentUser.role}</p>
<p>ID UTILISATEUR</p>
<p>${sessionScope.currentUser.idUtilisateur}</p>



