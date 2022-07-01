<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand brand" href="gestione.jsp">Fattapposta</a>
    </div>
    <%
    	String login = (String) session.getAttribute("cod_admin");
    	String username = (String) session.getAttribute("nome_admin");
    
    	if(login != null) {    
    %>
      <ul >
        <li class="form-inline my-2 my-lg-0">
        	Benvenuto, <%= username %>
        	
        </li>
        <li class="form-inline my-2 my-lg-0"><a href="logout.jsp">
        	Logout
        	</a>
        </li>
      </ul>
    <%
    	}
    %>

    </div>
</nav>