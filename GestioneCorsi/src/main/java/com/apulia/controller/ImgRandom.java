package com.apulia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apulia.architecture.dao.DAOConstants;


/**
 * Servlet implementation class ImgRandom
 */
@WebServlet("/ImgRandom")
public class ImgRandom extends HttpServlet implements DAOConstants {
	private static final long serialVersionUID = 389314166488852514L;

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName(config.getInitParameter("jdbcDriver"));
			conn = DriverManager.getConnection(config.getInitParameter("jdbcURL"),
					config.getInitParameter("jdbcUsername"), 
					config.getInitParameter("jdbcPassword"));
			stmt = conn.createStatement();
		} catch (ClassNotFoundException exc) {
			System.out.println("Driver non trovato");
			System.out.println(exc.getMessage());
		} catch (SQLException exc) {
			System.out.println("Eccezione SQL");
			System.out.println(exc.getMessage());
			System.out.println(exc.getErrorCode());
			System.out.println(exc.getSQLState());
			exc.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		try {
			stmt.close();
			ps.close();
			conn.close();
		} catch (SQLException exc) {
			System.out.println("Eccezione SQL");
			System.out.println(exc.getMessage());
			System.out.println(exc.getErrorCode());
			System.out.println(exc.getSQLState());
			exc.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" \"href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\">");

		try {
			ResultSet rs = stmt.executeQuery(SELECT_SFONDO);
			rs.next();

			out.println("<title>Immagini Random</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">");
			out.println("<header>");
			out.println("Ad ogni refresh cambia immagine");
			out.println("</header>");

			out.println(rs.getString("descrizione"));
			out.println("<img src=" + "\"" + rs.getString("link_img") +" \"" +">");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (SQLException sql) {
			out.println("<title>Errore nella elaborazione dati</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">");
			out.println("<div class=\"alert alert-danger\">");
			out.println("<h3>Eccezione SQL</h3>");
			out.println("<p>" + sql.getMessage() + "</p>");
			out.println("<p>" + sql.getErrorCode() + "</p>");
			out.println("<p style=\"margin-top: 20px;\">" + "<a href=\"index.html\">" + "Torna alla pagina di index"
					+ "</a></p>");
			out.println("</div>");
			out.println("</div> ");
			out.println("</body>");
			out.println("</html>");
			out.close();


	}
}

}
