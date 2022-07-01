<%@page import="com.apulia.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inclusioni.html"%>
<meta charset="ISO-8859-1">
<title>Errore! Attenzione!</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body class="errore">
	<jsp:include page="nav.jsp" />
	<div class="container errore-cont">

		<%
		if (exception instanceof ClassNotFoundException) {
		%>

		<div class="row">
			<div class="col">&nbsp;</div>
			<div class="col">
					<h3>Oh mio dio, un errore! AAAAAAAHHHHH!</h3>
				<div class="errore-pan">
					<h5>Eccezione durante la connessione al DB</h5>


					<h5 <%=exception.getClass().getName()%>></h5>
					<p>
						Motivo:&nbsp;<%=exception.getMessage()%></p>

				</div>
				<button onclick="window.history.back()" class="btn btn-dark">Indietro</button>
			</div>
		</div>


		<%
		} else if (exception instanceof DAOException) {
		%>

		<div class="row">
			<div class="col">&nbsp;</div>
			<div class="col">
					<h3>Oh mio dio, un errore! AAAAAAAHHHHH!</h3>
				<div class="errore-pan">
				<h5>Eccezione DAO</h5>
				<h5 <%=exception.getClass().getName()%>></h5>
				<p>
					Motivo:&nbsp;<%=exception.getMessage()%></p>

			</div>
			<button onclick="window.history.back()" class="btn btn-dark">Indietro</button>
			</div>
		</div>


		<%
		} else {
		%>

		<div class="row">
			<div class="col">&nbsp;</div>
			<div class="col">
					<h3>Oh mio dio, un errore! AAAAAAAHHHHH!</h3>
			<div class="errore-pan">

				<h5>Eccezione non prevista</h5>

				<h5 <%=exception.getClass().getName()%>></h5>
				<p>
					Motivo:&nbsp;<%=exception.getMessage()%></p>
				<p>
					Stacktrace:&nbsp;<%
				exception.printStackTrace(new PrintWriter(out));
				%>
				</p>

			</div>
			<button onclick="window.history.back()" class="btn btn-dark">Indietro</button>
			</div>
		</div>




		<%
		}
		%>
	</div>
	<footer class="footer"><%@ include file="footer.html"%></footer>
</body>
</html>