<%@page import="com.apulia.businesscomponent.model.Admin"%>
<%@page import="com.apulia.businesscomponent.facade.AdminFacade"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">

    <%
    	String login = (String) session.getAttribute("cod_admin");

    	if(login != null) {    
    		
    		Long cod = Long.valueOf(login);
    		Admin admin =  AdminFacade.getInstance().getAdminByCod(cod);
    %>
        <div class="navbar-header">
      <a class="navbar-brand brand" href="gestione.jsp">Fattapposta</a>
    </div>
      <ul >
        <li class="form-inline my-2 my-lg-0">
        	Benvenuto, <%= admin.getNome() %>
        	
        </li>
        <li class="form-inline my-2 my-lg-0"><a href="logout.jsp">
        	Logout
        	</a>
        </li>
      </ul>
    <%
    	} else {
    %>
    
        <div class="navbar-header">
      <a class="navbar-brand brand" href="home.jsp">Fattapposta</a>
    </div>
    
    <%
    }%>

    </div>
</nav>


