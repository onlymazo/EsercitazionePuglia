package test.com.apulia.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.apulia.architecture.dao.CorsistaDAO;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodCorsista(1);
		corsista.setNome("Marco");
		corsista.setCognome("Bianco");
		corsista.setPrecFormativi(false);
	}
	
	
	@Test
	@Order(1)
	void testCreate() throws Exception {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: "+exc.getMessage());
			
		}
	}
	
	
	@Test
	@Order(2)
	void testUpdateGetByID(){ 
		try {
			corsista = new Corsista();
			corsista.setCodCorsista(1);
			corsista.setNome("Michele");
			corsista.setCognome("Rossi");
			corsista.setPrecFormativi(true);
			
			CorsistaDAO.getFactory().update(conn, corsista);
			System.out.println("Aggiornato corsista");
			Corsista c = CorsistaDAO.getFactory().getByCod(conn, 1);
			System.out.println(c.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("GetByCod/update fallito: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetAll(){ 
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Get all fallito: "+exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		try {
			CorsistaDAO.getFactory().delete(conn, 1);
			System.out.println("Corsista eliminato");
			DBAccess.closeConnection();
	}catch(DAOException exc) {
		exc.printStackTrace();
		fail("Metodo di pulizia fallito: "+exc.getMessage());
		}
	}


}
