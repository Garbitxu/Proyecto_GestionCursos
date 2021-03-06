<%@ include file="../includes/admin_Header.jsp" %> 

<a href="/formacion" >
<button class="btn btn-primary" type="submit">Volver a la p�gina principal</button>
</a>


<h1>�Bienvenido administrador!</h1>
          
          <h2>Aqu� puedes ver y gestionar todos tus cursos.</h2>
          <br><br>
          <!-- search -->
		  <!-- Filtro para buscar entre todos los cursos --> 
			<form class="form-horizontal">
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
					<br><br>
			<a href="admin/migracion"><button class="btn btn-primary return" type="submit">Sube tu archivo CSV aqui</button></a>

			
		 <!-- / filtro search -->
<a href="admin/curso/edit">
<button class="btn btn-primary" type="submit">Crear nuevo curso</button>
</a>
<br><br>
<c:choose>
	<c:when test="${fn:length(cursos) != 0}">

<table class="tablePlugin">
 <caption>Tabla con la informaci�n de los 1000 �ltimos cursos. Utilice el buscador del men� de arriba si no encuentra el curso que quiere.</caption> 
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>     
			<th>C�digo</th>
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
		<p>No tenemos ning�n curso registrado..</p>
	</c:otherwise>
</c:choose>





<%@ include file="../includes/footer.jsp" %> 