<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%
	if(session.getAttribute("cod_admin") != null) {
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inclusioni.html"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/home.css"> 
<title>Gestione Corsi</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">

<div class="menu-bottoni">
<button type="button" class="btn btn-outline-secondary">Inserisci nuovo corsista</button>
<button type="button" class="btn btn-outline-secondary">Visualizza statistiche</button>
<button type="button" class="btn btn-outline-secondary">Elimina corsi</button>
</div>



</div>


<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>

<%
		} else {
	response.sendRedirect("accessonegato.jsp");
	
}
%>