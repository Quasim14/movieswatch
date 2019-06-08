

<h1 class="h1-responsive font-weight-bold text-center my-5">Vos commandes</h1>
<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Numéro de commande</th>
                            <th scope="col">Date</th>                      
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    
	<c:forEach items="${commandes}" var="commande">
		                <tr>
                            <td>${commande.idCommande} </td>
                            <td><fmt:formatDate pattern = "dd-MM-yyyy"  value="${commande.facture.dateCommande}" /> </td>
                            <td class="text-right">
                            <a href="<c:url value="/accesrestreint/detailscommande">
								<c:param name="idcommande" value="${commande.idCommande }"/>
								</c:url>">
									<button class="btn btn-sm btn-info"><i class="fa fa-info-circle"></i> </button></a>
                            </td>
                        </tr>		
		
		<br>

	</c:forEach>

                       
                    </tbody>
                </table>