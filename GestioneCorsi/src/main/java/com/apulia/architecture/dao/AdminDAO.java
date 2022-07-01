package com.apulia.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.apulia.architecture.dao.adapter.GenericDAOAdapter;
import com.apulia.businesscomponent.model.Admin;

public class AdminDAO extends GenericDAOAdapter<Admin> implements DAOConstants {
	private CachedRowSet rowSet;
	
	private AdminDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static AdminDAO getFactory() throws DAOException {
		return new AdminDAO();
	}
	
	public Admin getByCod(Connection conn, long cod) throws DAOException {
		Admin admin = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ADMIN_BYCOD);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setCodAdmin(rs.getLong(1));
				admin.setNome(rs.getString(2));
				admin.setCognome(rs.getString(3));
				admin.setPassword(rs.getString(4));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return admin;
	}
	
}
