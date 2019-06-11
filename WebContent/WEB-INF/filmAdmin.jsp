<h3 class="display-3 font-weight-bold white-text mt-5 pt-5 text-dark">Ajout de films</h3>
  <hr class="hr-light my-4 w-75">
<form method="POST"  action="<c:url value="/admin/filmAdmin" />">

<div class="row">

	<div class="col">
		<div class="form-group">
		 <label class="col-lg-3 control-label">Titre original:</label>
		 <div class="col-lg-8">
		   <input name="titre"  class="form-control" type="text"></input>
		 </div>
		</div>

		<div class="form-group">
		 <label class="col-lg-3 control-label">Budget:</label>
		 <div class="col-lg-8">
		   <input name="budget"  class="form-control" type="text"></input>
		 </div>
		</div>

		<div class="form-group">
		 <label class="col-lg-3 control-label">Année production:</label>
		 <div class="col-lg-8">
		   <input name="anneeProduction"  class="form-control" type="date"></input>
		 </div>
		</div>

		<div class="form-group">
		 <label class="col-lg-3 control-label">Synopsis:</label>
		 <div class="col-lg-8">
		   <textarea name="synopsis"  class="form-control"></textarea>
		 </div>
		</div>

	</div>

	<div class="col">
			<div class="form-group">
			 <label class="col-lg-3 control-label">Metrage:</label>
			 <div class="col-lg-8">
			   <select class="custom-select" name="metrage">
			<option  value="court">court</option>
			<option  value="moyen">moyen</option>
			<option  value="long">long</option>
			</select>
			 </div>
			</div>

			<div class="form-group">
			 <label class="col-lg-3 control-label">Url affiche:</label>
			 <div class="col-lg-8">
			   <input name="urlAffiche"  class="form-control" type="text"></input>
			 </div>
			</div>
			<div class="form-group">
			 <label class="col-lg-3 control-label">Numéro isan:</label>
			 <div class="col-lg-8">
			   <input name="isan"  class="form-control" type="text"></input>
			 </div>
			</div>
			<div class="form-group">
			 <label class="col-lg-3 control-label">Age (CSA):</label>
			 <div class="col-lg-8">
			   <select name="age"  class="custom-select">
			<option  value="10">10</option>
			<option  value="12">12</option>
			<option  value="16">16</option>
			<option  value="18">18</option>
			</select>
			 </div>
			</div>
	</div>

</div>

<div class="row">
	<div class="form-group">
		 <div class="col">
		   <input value="Soumettre"  class="form-control" type="submit"></input>
		 </div>
	</div>
</div>

</form>
