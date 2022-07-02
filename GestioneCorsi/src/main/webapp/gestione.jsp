<%@page import="java.util.Vector"%>
<%@page import="com.apulia.businesscomponent.utilities.IscrittiUtility"%>
<%@page import="com.apulia.businesscomponent.facade.AdminFacade"%>
<%@page import="com.apulia.businesscomponent.model.Corsista"%>

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

	<header class="titolo-pagina">
			<h3>Elenco corsisti</h3>
		</header>
		
		<div class="table-responsive">
			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>Corso</th>
						<th>Nome</th>
						<th>Cognome</th>
					</tr>
				</thead>
				<tbody>
					<%
					IscrittiUtility  iU = new IscrittiUtility();

					Vector<String[]> vect = iU.getIscritti();
		            String[] dati = new String[vect.size()];
		            for (int i = 0; i < vect.size(); i++) {
		                dati = vect.get(i); { %>
		                	<tr>
		        			<td><%= dati[2] %></td>
		        			<td><%= dati[0] %></td>
		        			<td><%= dati[1] %></td>
		        		</tr>
		                <% }
		            }
					%>
				</tbody>
			</table>
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