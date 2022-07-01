<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="inclusioni.html"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/login.css"> 

<title>Fattapposta - Area Admin</title>
</head>
<body>

	<div class="container">
	<div class="d-flex justify-content-center h-100">
				<div class="card">
					<h1 class="titolo">Fattapposta</h1>
					<div>Un corso per ogni tua necessità</div>

					<h5 class="reserved">AREA RISERVATA</h5>

					<div class="card-body">
						<form action="/<%=application.getServletContextName()%>/controllo" method="post">
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text bg-dark"><i
										class="fas fa-user"></i></span>
								</div>
								<input type="text" name="cod_admin" class="form-control"
									placeholder="codice admin" autofocus>

							</div>
							<div class="input-group form-group">
								<div class="input-group-prepend ">
									<span class="input-group-text bg-dark"><i
										class="fas fa-key"></i></span>
								</div>
								<input type="password" name="password" placeholder="password"
									class="form-control">

							</div>
							<div class="form-group">
								<a class="btn float-left btn-dark" href="#">Torna
									all'area utente</a>
							</div>

							<div class="form-group">
								<input type="submit" value="Login"
									class="btn float-right btn-dark">
							</div>
						</form>
					</div>
					<div class="social-icon">
						<!-- Facebook -->
						<a href="#"><i class="fab fa-facebook-f"></i></a>

						<!-- Twitter -->
						<a href="#"><i class="fab fa-twitter"></i></a>

						<!-- Instagram -->
						<a href="#"><i class="fab fa-instagram"></i></a>

						<!-- Linkedin -->
						<a href="#"><i class="fab fa-linkedin-in"></i></a>

						<!-- Pinterest -->
						<a href="#"><i class="fab fa-pinterest"></i></a>

						<!-- Stack overflow -->
						<a href="#"><i class="fab fa-stack-overflow"></i></a>

						<!-- Youtube -->
						<a href="#"><i class="fab fa-youtube"></i></a>

						<!-- Github -->
						<a href="#"><i class="fab fa-github"></i></a>

						<!-- Whatsapp -->
						<a href="#"><i class="fab fa-whatsapp"></i></a>

					</div>
				</div>

			</div>


	</div>
</body>
</html>