<%@ include file="WEB-INF/views/includes/login_header.jsp" %> 

<div class="fondo">

	<form action="login" method="post">
<p>
<label for="usuario">Usuario</label>
<input type="text" name="usuario">
</p>
<p>
<label for="clave">Clave</label>
<input type="password" name="clave">
</p>
<p><label for="clave"></label>
<input type="submit" value="validar">
</p>
</form>

</div>
<%@ include file="WEB-INF/views/includes/footer_login.jsp" %> 