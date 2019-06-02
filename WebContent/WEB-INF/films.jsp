<table>
	<thead>
		<tr>
			<th>
				Title original :
			</th>
			
		</tr>		
	</thead>
	
	<tbody>
	<c:forEach items="${listeFilm}" var="pFilm">
	<p>HELLO<p>
	<td>
		${pFilm.titreOriginal }
	</td>
	</c:forEach>
	</tbody>
	
</table>