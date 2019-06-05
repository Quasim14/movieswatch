<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container" style="padding-top: 60px;">
    <h1 class="page-header">Edit Profile</h1>
    <div class="row">

        <!-- edit form column -->


        <form class="form-horizontal" role="form" method="post" action="edituser">
            <div class="form-group">
                <label class="col-lg-3 control-label">id:</label>
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
                <label class="col-lg-3 control-label">Pr�nom:</label>
                <div class="col-lg-8">
                    <input class="form-control" type="text" id="prenom" name="prenom" value="<c:out value="${sessionScope.currentUser.prenom}"/>">
                </div>
            </div>

            <br />
            <div class="form-group">
                <label class="col-lg-3 control-label">Adresse</label>
                <div class="col-lg-8">
                    <input class="form-control" type="text" id="adresseRue" name="adresseRue" value="<c:out value="${sessionScope.currentUser.ADrue}"/>">
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label">Num�ro de t�l�phone:</label>
                <div class="col-lg-8">
                    <input class="form-control" type="text" id="telephone" name="telephone" value="<c:out value="${sessionScope.currentUser.numMobile}"/>">
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-3 control-label">Adresse email:</label>
                <div class="col-lg-8">
                    <input class="form-control" type="email" id="email" name="email" value="<c:out value="${sessionScope.currentUser.email}"/>">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Password:</label>
                <div class="col-lg-8">
                    <input class="form-control" type="password" id="motdepasse" name="motdepasse" value="<c:out value="${sessionScope.currentUser.passwd}"/>">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Confirm password:</label>
                <div class="col-lg-8">
                    <input class="form-control" type="password" id="confirmation" name="confirmation" value="<c:out value="${sessionScope.currentUser.passwd}"/>">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label"></label>
                <div class="col-md-8">
                    <input class="btn btn-primary" value="Sauvegarder"type="submit">
                    <span></span>
                    <input class="btn btn-default" value="Annuler" type="reset">
                </div>
            </div>
        </form>
    </div>
</div>