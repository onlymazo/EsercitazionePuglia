package com.apulia.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.apulia.architecture.dao.adapter.GenericDAOAdapter;
import com.apulia.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO extends GenericDAOAdapter<CorsoCorsista> implements DAOConstants {
	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	
	@Override
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			int count = 0;
			while(rowSet.next()) {
				if(rowSet.getLong(1) == entity.getCodCorso()) {
					count++;
				}
			}
			if(count <= 12) {
				rowSet.moveToInsertRow();
				rowSet.updateLong(1, entity.getCodCorso());
				rowSet.updateLong(2, entity.getCodCorsista());
				rowSet.insertRow();
				rowSet.moveToCurrentRow();
				rowSet.acceptChanges();
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}		
	}

}
