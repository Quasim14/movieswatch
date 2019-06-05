
<p>fhfh</p>
<form method="post" action="<c:url value="/formAddUser" />">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="nom">Nom</label>
        <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['nom']}</span>
        <br />
        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
        <span class="erreur">${form.erreurs['email']}</span>
        <br />
        <br />
        <input type="submit" value="Inscription" class="btn btn-info" />
        <br />
        </body>
        </html>