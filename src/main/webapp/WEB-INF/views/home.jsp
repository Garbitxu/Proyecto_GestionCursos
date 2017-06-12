<%@ include file="includes/header.jsp" %> 

 <!-- search -->
		  <!-- Filtro para buscar entre todos los cursos --> 
			<form class="navbar-form navbar-left">
				<div class="input-group">
				<label class="input-group-addon" for="buscador_cursos">
						<span class="glyphicon glyphicon-search"></span>
					
					<input id="buscador_cursos" 
							   name="buscador_cursos"
						       type="text" 
						       class="form-control" 
						       placeholder="busca el curso que quieras">
				</label>	
				</div>				
			</form>
		 <!-- / filtro search -->
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