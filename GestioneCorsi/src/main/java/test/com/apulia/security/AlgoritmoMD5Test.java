package test.com.apulia.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apulia.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void test() {
		String pass = AlgoritmoMD5.convertiMD5("Pass01");
		assertNotNull(pass);
		System.out.println(pass);
	}

}
