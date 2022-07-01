<% 
	if(session.getAttribute("cod_admin") != null ) {
		session.invalidate();
	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inclusioni.html" %>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/home.css"> 
</head>
<body class="errore404">
	<jsp:include page="nav.jsp" />
	<div class="container errore-cont">


		<div class="row">
			<div class="col">&nbsp;</div>
			<div class="col">
				<h3>Hai effettuato il logout</h3>
			<p>Per rientrare, effettuare l'accesso:</p>
			<a href="home.jsp">Login</a>
			</div>
		</div>


	</div>

	<footer class="footer"><%@ include file="footer.html"%></footer>
</body>
</html>

<% 
	} else {
		response.sendRedirect("accessonegato.jsp");
		
}
%>