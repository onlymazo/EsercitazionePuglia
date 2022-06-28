package com.apulia.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.apulia.businesscomponent.model.Corso;

public class CorsoDAO implements DAOConstants, GenericDAO<Corso> {
		
		private CachedRowSet rowSet;

		private CorsoDAO() throws DAOException {
			try {
				rowSet = RowSetProvider.newFactory().createCachedRowSet();
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
		}

		public static CorsoDAO getFactory() throws DAOException {
			return new CorsoDAO();
		}

		public void create(Connection conn, Corso entity) throws DAOException {
			try {
				rowSet.setCommand(SELECT_CORSO);
				rowSet.execute(conn);
				rowSet.moveToInsertRow();
				rowSet.updateLong(1, entity.getCodCorso());
				rowSet.updateLong(2, entity.getCodDocente());
				rowSet.updateString(3, entity.getNome());
				rowSet.updateDate(4, new java.sql.Date(entity.getDataInizio().getTime()));
				rowSet.updateDate(5, new java.sql.Date(entity.getDataFine().getTime()));
				rowSet.updateDouble(6, entity.getCosto());
				rowSet.updateString(7, entity.getCommenti());
				rowSet.updateInt(8, entity.getAula());
				rowSet.insertRow();
				rowSet.moveToCurrentRow();
				rowSet.acceptChanges();
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
		}

		
		public void update(Connection conn, Corso entity) throws DAOException {
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(UPDATE_CORSO);
				ps.setLong(1, entity.getCodCorso());
				ps.setLong(2, entity.getCodDocente());
				ps.setString(3, entity.getNome());
				ps.setDate(4, new java.sql.Date(entity.getDataInizio().getTime()));
				ps.setDate(5, new java.sql.Date(entity.getDataFine().getTime()));
				ps.setDouble(6, entity.getCosto());
				ps.setString(7, entity.getCommenti());
				ps.setInt(8, entity.getAula());
				ps.execute();
				conn.commit();
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
		}

		public void delete(Connection conn, long codCorso) throws DAOException {
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(DELETE_CORSO);
				ps.setLong(1, codCorso);
				ps.execute();
				conn.commit();
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
		}
		
		public Corso getByCod(Connection conn, long codCorso) throws DAOException {
			Corso corso = null;
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(SELECT_CORSO_BYCOD);
				ps.setLong(1, codCorso);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					corso = new Corso();
					corso.setCodCorso(rs.getLong(1));
					corso.setCodDocente(rs.getLong(2));
					corso.setNome(rs.getString(3));
					corso.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
					corso.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
					corso.setCosto(rs.getDouble(6));
					corso.setCommenti(rs.getString(7));
					corso.setAula(rs.getInt(8));
				}
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
			return corso;
		}

		@Override
		public Corso[] getAll(Connection conn) throws DAOException {
			Corso[] corsi = null;
			try {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(SELECT_CORSO);
				rs.last();
				corsi = new Corso[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					Corso c = new Corso();
					c.setCodCorso(rs.getLong(1));
					c.setCodDocente(rs.getLong(2));
					c.setNome(rs.getString(3));
					c.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
					c.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
					c.setCosto(rs.getDouble(6));
					c.setCommenti(rs.getString(7));
					c.setAula(rs.getInt(8));
					corsi[i] = c;
				}
				rs.close();
			} catch (SQLException sql) {
				throw new DAOException(sql);
			}
			return corsi;
		}
	}

