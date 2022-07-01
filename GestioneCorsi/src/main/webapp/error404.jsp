<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inclusioni.html" %>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
<title>Error 404</title></head>
<body>
<div class="container">
 <div class="page-header">
  <h3>Pagina non trovata</h3> 
 </div>
 <div class="card w-100 h-100">
  <div class="card-title">
   <h3>Impossibile caricare la risorsa richiesta</h3>
  </div>
   <div class="card-body">
    <p>Siamo spiacenti del disagio risolveremo al più presto</p>
    <p>Per segnalare il problema:&nbsp;
    <a href="mailto:lello@migro.it">Manda una mail a Lello che risolve tutto</a>
    <p>Oppure torna alla pagina precedente:</p>
    <input type="button" class="btn btn-dark" 
    value="Indietro" onclick="window.history.back()" />     
   </div>
 </div>
</div>
</body>
</html>