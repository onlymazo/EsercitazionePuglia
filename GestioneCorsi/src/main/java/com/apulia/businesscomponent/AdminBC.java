package com.apulia.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.apulia.architecture.dao.AdminDAO;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dao.adapter.GenericBCAdapter;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.Admin;

public class AdminBC extends GenericBCAdapter<Admin> {
	private Connection conn;
	
	public AdminBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	@Override
	public Admin getByCod(long cod) throws DAOException {
		try {
			return AdminDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
}
