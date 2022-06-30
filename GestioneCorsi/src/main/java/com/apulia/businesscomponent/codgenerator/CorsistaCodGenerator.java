package com.apulia.businesscomponent.codgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.apulia.architecture.dao.DAOConstants;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dbaccess.DBAccess;

public class CorsistaCodGenerator implements CodGeneratorInterface, DAOConstants {
	private static CorsistaCodGenerator codGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaCodGenerator()
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsistaCodGenerator getInstance()
			throws ClassNotFoundException, DAOException, IOException {
		if(codGen == null) {
			codGen = new CorsistaCodGenerator();
		}
		return codGen;
	}
	
	@Override
	public long getNextCod() throws ClassNotFoundException, DAOException, IOException {
		long cod = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTASEQ);
			rs.next();
			cod = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
			
		}
		return cod;
	}

}
