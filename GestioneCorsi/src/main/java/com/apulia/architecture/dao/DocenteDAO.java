package com.apulia.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.apulia.businesscomponent.model.Docente;

public class DocenteDAO implements DAOConstants, GenericDAO<Docente> {
	private CachedRowSet rowSet;

	private DocenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}
	
	@Override
	public void create(Connection conn, Docente entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_DOCENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodDocente());
			rowSet.updateString(2, entity.getNome());
			rowSet.updateString(3, entity.getCognome());
			rowSet.updateString(4, entity.getCv());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Docente entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_DOCENTE);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCognome());
			ps.setString(3, entity.getCv());
			ps.setLong(4, entity.getCodDocente());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public void delete(Connection conn, long cod) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_DOCENTE);
			ps.setLong(1, cod);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public Docente getByCod(Connection conn, long cod) throws DAOException {
		Docente docente = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BYCOD);
			ps.setLong(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				docente = new Docente();
				docente.setCodDocente(rs.getLong(1));
				docente.setNome(rs.getString(2));
				docente.setCognome(rs.getString(3));
				docente.setCv(rs.getString(4));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docente;
	}
	
	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente d = new Docente();
				d.setCodDocente(rs.getLong(1));
				d.setNome(rs.getString(2));
				d.setCognome(rs.getString(3));
				d.setCv(rs.getString(4));
				docenti[i] = d;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}
}