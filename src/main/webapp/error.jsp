
<%@ include file="WEB-INF/views/includes/logout_header.jsp" %> 


	<div id="conexion">
		
		<form action="conexion" method="post">
			<a href=""><img class="redi-logo" src="resources/img/logo-ipartek.png"></a>
			<br><br><br>
			<p>Lo sentimos, pero el Usuario y/o contraseña introducidos no son correctos.</p>
			 <br>
			<label for="usuario">Usuario</label>
			<input type="text" id="usuario" name="usuario"><br>
			<label for="clave">Contraseña</label>
			<input type="password" id="clave" name="clave">
			<br><br>
			<input type="submit" value="validar">
		</form><br>
	<a href="/formacion" >
<button class="btn btn-primary" type="submit">Volver a la página principal</button>
</a>
	</div>
<%@ include file="WEB-INF/views/includes/footer_login.jsp" %> 
