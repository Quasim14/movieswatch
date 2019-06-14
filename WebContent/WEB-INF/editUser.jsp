<div class="container mt-5 pt-5">
    <h3 class="display-3 font-weight-bold">Edition Profile</h3>
  	<hr>
	<div class="row">
      <!-- left column -->
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <h3>infos Personelle </h3>
        
        <form class="form-horizontal" role="form" method="post" action="edituser">
          <div class="form-group">
            <label class="col-lg-3 control-label">ID</label>
            <div class="col-lg-8">
              <input class="form-control" type="number" id="idUtilisateur" name="idUtilisateur" value="<c:out value="${sessionScope.currentUser.idUtilisateur}"/>" >
            </div>
          </div>        
          <div class="form-group">
            <label class="col-lg-3 control-label">Nom:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" id="nom" name="nom" value="<c:out value="${sessionScope.currentUser.nom}"/>" >
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Prenom</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" id="prenom" name="prenom" value="<c:out value="${sessionScope.currentUser.prenom}"/>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Adresse</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" id="adresseRue" name="adresseRue" value="<c:out value="${sessionScope.currentUser.ADrue}"/>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Numero de telephone</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" id="telephone" name="telephone" value="<c:out value="${sessionScope.currentUser.numMobile}"/>">
            </div>
          </div>          
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <input class="form-control" type="email" id="email" name="email" value="<c:out value="${sessionScope.currentUser.email}"/>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Mot de passe:</label>
            <div class="col-md-8">
              <input class="form-control" type="password" id="motdepasse" name="motdepasse" value="<c:out value="${sessionScope.currentUser.passwd}"/>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label">Confirmer mot de passe:</label>
            <div class="col-md-8">
              <input class="form-control" type="password" id="confirmation" name="confirmation" value="<c:out value="${sessionScope.currentUser.passwd}"/>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input type="submit" class="btn btn-primary" value="Sauvegarder">
              <span></span>
              <input type="reset" class="btn btn-default" value="Annuler">
            </div>
          </div>
        </form>
      </div>
  </div>
</div>