<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="inclusioni.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error 404</title>
</head>
<link rel="stylesheet" href="css/home.css">
<body class="errore404">
	<jsp:include page="nav.jsp" />
	<div class="container errore-cont">


		<div class="row">
			<div class="col">&nbsp;</div>
			<div class="col">
				<h3>Pagina non trovata</h3>
				<h3>Impossibile caricare la risorsa richiesta</h3>
				<p>Siamo spiacenti del disagio risolveremo al più presto</p>
				<p>
					Per segnalare il problema:&nbsp; <a href="mailto:lello@migro.it">Manda
						una mail a Lello che risolve tutto</a>
				<p>Oppure torna alla pagina precedente:</p>
				<input type="button" class="btn btn-dark" value="Indietro"
					onclick="window.history.back()" />
			</div>
		</div>


	</div>

	<footer class="footer"><%@ include file="footer.html"%></footer>
</body>
</html>