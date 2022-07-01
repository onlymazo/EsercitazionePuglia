<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inclusioni.html"%>
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
<link rel="stylesheet" href="css/home.css">
<body class="accneg">
	<jsp:include page="nav.jsp" />
	<div class="container accesso-negato">


		<div class="row">
			<div class="col"> &nbsp;</div>
			<div class="col">
				<h2>Non puoi accedere a questa pagina</h2>
				<h3>Area riservata</h3>
				<p>
					Se hai dimenticato le credenziali contatta <a
						href="mailto:apulia@imperat.it">il gestore della pagina</a>.
				</p>

			</div>
		</div>
		

		</div>


	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>