package com.apulia.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.apulia.businesscomponent.model.Corsista;

public class CorsistaDAO implements DAOConstants {
	
	private CachedRowSet rowSet;

	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}

	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorsista());
			rowSet.updateString(2, entity.getNome());
			rowSet.updateString(3, entity.getCognome());
			rowSet.updateBoolean(4, entity.isPrecFormativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	
	public void update(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setLong(1, entity.getCodCorsista());
			ps.setString(2, entity.getNome());
			ps.setString(3, entity.getCognome());
			ps.setBoolean(4, entity.isPrecFormativi());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Connection conn, long codCorsista) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, codCorsista);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista getByCod(Connection conn, long codCorsista) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BYCOD);
			ps.setLong(1, codCorsista);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsista = new Corsista();
				corsista.setCodCorsista(rs.getLong(1));
				corsista.setNome(rs.getString(2));
				corsista.setCognome(rs.getString(3));
				corsista.setPrecFormativi(rs.getBoolean(4));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();
			corsisti = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setCodCorsista(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setCognome(rs.getString(3));
				c.setPrecFormativi(rs.getBoolean(4));
				corsisti[i] = c;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
}
