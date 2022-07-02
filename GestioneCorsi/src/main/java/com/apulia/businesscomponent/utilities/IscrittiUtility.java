package com.apulia.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.apulia.architecture.dao.DAOConstants;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dbaccess.DBAccess;


public class IscrittiUtility implements DAOConstants{
	private Connection conn;

	public IscrittiUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Vector<String[]> getIscritti() throws DAOException {
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI_ATTUALI);
			
			ResultSetMetaData meta = rs.getMetaData();
			int nColonne = meta.getColumnCount();
			Vector<String[]> dati = new Vector<String[]>();
			rs.beforeFirst();
			while(rs.next()) {
				String[] riga = new String[meta.getColumnCount()];
				for(int i = 0; i<nColonne; i++) 
					riga[i] = rs.getString(i+1);
				dati.add(riga);	
			}
			return dati;
		}catch (SQLException sql) {
				throw new DAOException(sql);
			}
	}


}
