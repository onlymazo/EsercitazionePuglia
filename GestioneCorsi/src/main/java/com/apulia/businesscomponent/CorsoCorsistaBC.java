package com.apulia.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.apulia.architecture.dao.CorsoCorsistaDAO;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dao.adapter.GenericBCAdapter;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC extends GenericBCAdapter<CorsoCorsista> {
	private Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	@Override
	public void create(CorsoCorsista entity) throws DAOException {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, entity);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
}
