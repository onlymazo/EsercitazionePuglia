
package test.com.apulia.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.apulia.architecture.dao.CorsoDAO;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dao.DocenteDAO;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.Corso;
import com.apulia.businesscomponent.model.Docente;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Corso corso;
	private static Docente docente;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		docente = new Docente();
		docente.setCodDocente(1);
		docente.setNome("Pino");
		docente.setCognome("La Mula");
		docente.setCv("non è studiato");
		DocenteDAO.getFactory().create(conn, docente);
		
		
		
		corso = new Corso();
		corso.setCodCorso(1);
		corso.setCodDocente(1);
		corso.setNome("Corso di Panzerotti");
		corso.setDataInizio(new GregorianCalendar(2022, 6, 5).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 7, 1).getTime());
		corso.setCosto(500.00);
		corso.setCommenti("Gustosi panzerotti fatti dalle tue mani! Gnam! c fam");
		corso.setAula(5);
	}
	
	@Test
	@Order(1)
	void testCreate() throws Exception {
		try {
			CorsoDAO.getFactory().create(conn, corso);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdate() {
		try {
			corso = new Corso();
			corso.setCodCorso(1);
			corso.setCodDocente(1);
			corso.setNome("Corso di Contrabbando");
			corso.setDataInizio(new GregorianCalendar(2022, 1, 5).getTime());
			corso.setDataFine(new GregorianCalendar(2022, 2, 1).getTime());
			corso.setCosto(5001.00);
			corso.setCommenti("Gustose sigarette sbarcate con le tue mani!");
			corso.setAula(1);
			CorsoDAO.getFactory().update(conn, corso);
			System.out.println("Corso aggiornato, ora è tipicamente brindisino");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Update fallito come te: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetByCod() {
		try {
			Corso cor = CorsoDAO.getFactory().getByCod(conn, 1);
			System.out.println(cor.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("GetByID fallito miseramente: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetAll() {
		try {
			Corso[] corso = CorsoDAO.getFactory().getAll(conn);
			assertNotNull(corso);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Get all fallito amaramente: " + exc.getMessage());
		}	
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().delete(conn, 1);
			System.out.println("Corso eliminato, niente più sigarette");
			DocenteDAO.getFactory().delete(conn, 1);
			System.out.println("Docente eliminato, rip");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito come Callisto Tanzi: " + exc.getMessage());
		}
	}

}