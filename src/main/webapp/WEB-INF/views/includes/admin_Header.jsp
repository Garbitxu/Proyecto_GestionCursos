<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@ page session="false" %>

<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title><spring:message code="nav.app.name" text="Ipartek"/></title>
	<base href="/formacion/" />
	
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<!-- Custom -->
	<link href="resources/css/custom.css" rel="stylesheet">	
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" crossorigin="anonymous">
	
</head>
<body>
	 <div class="container">
<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="formacion"></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
          <!-- menu izquierda -->
            <ul class="nav navbar-nav">
            <li class="">
              	<a href=""><img class="redi-logo" src="resources/img/logo-ipartek.png"></a>
              </li>    
              <li class="">
              	<a href="admin">Inicio (administrador)</a>
              </li>           
            </ul>
     
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        
      