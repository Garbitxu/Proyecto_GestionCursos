<%@ include file="../includes/admin_Header.jsp"%>

<h1>Gestiona aquí tus cursos</h1>

<a href="/formacion" >
<button class="btn btn-primary return" type="submit">Volver a la página principal</button>
</a>
<br><br>
	<form:form action="admin/curso/crear" modelAttribute="cursos">
			
			<form:hidden path="id"/>
			
			<form:label path="nombre">Nombre del Curso</form:label>
			<form:input path="nombre"/>
			<form:errors path="nombre" class="form-error"/>
			
			<form:label path="codigo">Código del Curso</form:label>
			<form:input path="codigo"/>
			<form:errors path="codigo" class="form-error"/>
			<c:if test="${cursos.id == -1}">		
				<form:button class="btn btn-success" type="submit">Crear</form:button>
			</c:if>	
			<c:if test="${cursos.id != -1}">		
				<form:button class="btn btn-success" type="submit">Modificar</form:button>
			</c:if>		
		</form:form>


<%@ include file="../includes/footer.jsp"%>