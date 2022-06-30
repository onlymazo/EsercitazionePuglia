package test.com.apulia.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.Corso;

class CorsoDAOTest {
	private static Corso corso;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setCodCorso(1);
		corso.setCodDocente(2);
		corso.setNome("Corso di Panzerotti");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
