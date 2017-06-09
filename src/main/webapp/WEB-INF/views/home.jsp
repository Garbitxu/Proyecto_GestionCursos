<%@ include file="includes/header.jsp" %> 


<c:choose>
	<c:when test="${fn:length(cursos) != 0}">
<table class="tablePlugin">
 <caption>Tabla con la información de los 10 últimos cursos.</caption> 
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>     
			<th>Código</th>
		</tr>
	</thead>
	<tbody>       
		<c:forEach items="${cursos}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nombre}</td>
				<td>${c.codigo}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:when>
<c:otherwise>
		<p>No tenemos ningún curso registrado..</p>
	</c:otherwise>
</c:choose>


<%@ include file="includes/footer.jsp" %> 