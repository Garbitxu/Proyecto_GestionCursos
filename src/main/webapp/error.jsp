
<%@ include file="WEB-INF/views/includes/header.jsp" %> 


	<div id="conexion">
		
		<form action="conexion" method="post">
			
			<h1 class="box-header">Conectarse</h1>
			
			<p>Lo sentimos, pero el Usuario y/o contraseña introducidos no son correctos.</p>
			 
			<label for="usuario">Usuario</label>
			<input type="text" id="usuario" name="usuario">
			<label for="clave">Contraseña</label>
			<input type="password" id="clave" name="clave">
			<br>
			<input type="submit" value="validar">

		</form>
	</div>
<%@ include file="WEB-INF/views/includes/footer.jsp" %> 
