package com.apulia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apulia.businesscomponent.utilities.LoginUtility;
import com.apulia.security.AlgoritmoMD5;

@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 8300633159495698955L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cod_admin = request.getParameter("cod_admin");
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));

		HttpSession session = request.getSession();
		String adminpass = null;
		if (cod_admin != null && password != null) {
			try {
				LoginUtility lU = new LoginUtility();
				adminpass = lU.getAdminPass(Long.parseLong(request.getParameter("cod_admin")));
				if (adminpass.equals(password)) {
					session.setAttribute("cod_admin", cod_admin);
					response.sendRedirect("gestione.jsp");
				} else {
					response.sendRedirect("accessonegato.jsp");
				}
			} catch (Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}
}