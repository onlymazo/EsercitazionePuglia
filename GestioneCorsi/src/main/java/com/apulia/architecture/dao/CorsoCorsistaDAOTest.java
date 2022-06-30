package com.apulia.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.Corsista;
import com.apulia.businesscomponent.model.Corso;
import com.apulia.businesscomponent.model.CorsoCorsista;
import com.apulia.businesscomponent.model.Docente;

class CorsoCorsistaDAOTest {

	private Corso corso;
	private Corsista corsista;
	private Docente docente;
	private CorsoCorsista cc;
	private Connection conn;

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		
		docente = new Docente();
		docente.setCodDocente(1);
		docente.setNome("Pino");
		docente.setCognome("La Mula");
		docente.setCv("non è studiato");
		
		corso = new Corso();
		corso.setCodCorso(1);
		corso.setCodDocente(1);
		corso.setNome("Corso di Panzerotti");
		corso.setDataInizio(new GregorianCalendar(2022, 6, 5).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 7, 1).getTime());
		corso.setCosto(500.00);
		corso.setCommenti("Gustosi panzerotti fatti dalle tue mani! Gnam! c fam");
		corso.setAula(5);
		
		corsista = new Corsista();
		corsista.setCodCorsista(1);
		corsista.setNome("Marco");
		corsista.setCognome("Bianco");
		corsista.setPrecFormativi(false);
		
		cc = new CorsoCorsista();
		cc.setCodCorso(1);
		cc.setCodCorsista(1);
	}
	
	@Test
	void testCreate() throws Exception {
		try {
			DocenteDAO.getFactory().create(conn, docente);
			CorsoDAO.getFactory().create(conn, corso);
			CorsistaDAO.getFactory().create(conn, corsista);
			CorsoCorsistaDAO.getFactory().create(conn, cc);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from corso_corsista where cod_corso = 1 and cod_corsista = 1");
			conn.commit();
			CorsoDAO.getFactory().delete(conn, 1);
			DocenteDAO.getFactory().delete(conn, 1);
			CorsistaDAO.getFactory().delete(conn, 1);					
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " + exc.getMessage());
		}
	}

}
