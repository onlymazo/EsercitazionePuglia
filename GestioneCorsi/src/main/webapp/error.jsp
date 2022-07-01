<%@page import="com.apulia.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inclusioni.html" %>
<meta charset="ISO-8859-1">
<title>Errore! Attenzione!</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
	<header class="page-header">
		<h3>Oh mio dio, un errore! AAAAAAAHHHHH!</h3>
	</header>
<%
	if(exception instanceof ClassNotFoundException) {
%>
<div class="card w-100 h-100">
	<div class="card-title">
		<h5>Eccezione durante la connessione al DB</h5>
	</div>
	<div class="card-body">
	<h5 <%=exception.getClass().getName()%>></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<button onclick="window.history.back()" class="btn btn-dark">Indietro</button>
	</div>
</div>
<%
	} else if(exception instanceof DAOException) {
%>
<div class="card w-100 h-100">
	<div class="card-title">
		<h5>Eccezione DAO</h5>
	</div>
	<div class="card-body">
	<h5 <%=exception.getClass().getName()%>></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<button onclick="window.history.back()" class="btn btn-dark">Indietro</button>
	</div>
</div>
<%
	} else {
%>
<div class="card w-100 h-100">
	<div class="card-title">
		<h5>Eccezione non prevista</h5>
	</div>
	<div class="card-body">
	<h5 <%=exception.getClass().getName()%>></h5>
	<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
	<p>Stacktrace:&nbsp;<% exception.printStackTrace(new PrintWriter(out)); %></p>
	<button onclick="window.history.back()" class="btn btn-dark">Indietro</button>
	</div>
</div>
<%
	}
%>
</div>
</body>
</html>