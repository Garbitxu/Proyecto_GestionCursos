<%@ include file="../includes/admin_Header.jsp" %> 

<a href="/formacion" >
<button class="btn btn-primary" type="submit">Volver a la página principal</button>
</a>


<h1>Hello world!</h1>
          
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
<h2>Has llegado al panel de administración. ¡Enhorabuena!</h2>

<a href="admin/curso/edit">
<button class="btn btn-primary" type="submit">Crear nuevo curso</button>
</a>
<c:choose>
	<c:when test="${fn:length(cursos) != 0}">

<table class="tablePlugin">
 <caption>Tabla con la información de los 1000 últimos cursos. Utilice el buscador del menú de arriba si no encuentra el curso que quiere.</caption> 
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>     
			<th>Código</th>
			<th>Operaciones</th>               
		</tr>
	</thead>
	<tbody>       
		<c:forEach items="${cursos}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nombre}</td>
				<td>${c.codigo}</td>
				<td><a href="admin/curso/edit/${c.id}"><span class="glyphicon glyphicon-pencil text-success"></span></a> 
				<a href="admin/curso/delete/${c.id}"><span class="glyphicon glyphicon-trash text-danger"></span></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:when>
<c:otherwise>
		<p>No tenemos ningún curso registrado..</p>
	</c:otherwise>
</c:choose>
<p>Sube tu archivo .CSV aquí.</p>


<%@ include file="../includes/footer.jsp" %> 