package com.apulia.businesscomponent.codgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.apulia.architecture.dao.DAOConstants;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dbaccess.DBAccess;

public class CorsoCodGenerator implements CodGeneratorInterface, DAOConstants {
	private static CorsoCodGenerator codGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsoCodGenerator()
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsoCodGenerator getInstance()
			throws ClassNotFoundException, DAOException, IOException {
		if(codGen == null) {
			codGen = new CorsoCodGenerator();
		}
		return codGen;
	}
	
	@Override
	public long getNextCod() throws ClassNotFoundException, DAOException, IOException {
		long cod = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSOSEQ);
			rs.next();
			cod = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
			
		}
		return cod;
	}

}
