<h1 class="h1-responsive font-weight-bold text-center mt-5 pt-5 text-dark">Liste des commandes</h1>
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                 			<th scope="col">Numéro de commande</th>
                            <th scope="col">Date</th>                      
                            <th>Facture</th>
                        </tr>
                    </thead>
                    <tbody>
						<c:forEach items="${commandes}" var="commande">
		                	<tr>
	                            <td>${commande.idCommande} </td>
	                            <td><fmt:formatDate pattern = "dd-MM-yyyy"  value="${commande.facture.dateCommande}" /> </td>
	                            <td class="text-right">
	                            <a href="<c:url value="/facture/${commande.idCommande}.pdf"></c:url>" target="_blank"><button class="btn btn-sm btn-info"><i class="fa fa-download"></i> </button></a>
	                            </td>
                        	</tr>
                        	<br>
                        </c:forEach>                    
                    </tbody>
                </table>
        	</div>
		</div>
	</div>
</div>
             