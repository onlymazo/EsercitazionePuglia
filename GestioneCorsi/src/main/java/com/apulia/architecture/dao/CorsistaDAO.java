package com.apulia.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.apulia.businesscomponent.model.Corsista;

public class CorsistaDAO implements DAOConstants, GenericDAO<Corsista> {

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

	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		int bool;
		
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorsista());
			rowSet.updateString(2, entity.getNome());
			rowSet.updateString(3, entity.getCognome());
			bool = entity.isPrecFormativi() ? 1 : 0; 
			rowSet.updateInt(4, bool);
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		PreparedStatement ps;
		int bool;
		
		try {
			ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCognome());
			bool = entity.isPrecFormativi() ? 1 : 0;
			ps.setInt(3, bool);
			ps.setLong(4, entity.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
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

	@Override
	public Corsista getByCod(Connection conn, long codCorsista) throws DAOException {
		Corsista corsista = null;
		boolean bool;
		
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
				bool = (rs.getInt(4)==1); 
				corsista.setPrecFormativi(bool);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsisti = null;
		boolean bool;
		
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
				bool = (rs.getInt(4)==1); 
				c.setPrecFormativi(bool);
				corsisti[i] = c;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}

}
