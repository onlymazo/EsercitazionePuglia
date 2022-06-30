package com.apulia.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.apulia.architecture.dao.CorsoDAO;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.codgenerator.CorsoCodGenerator;
import com.apulia.businesscomponent.model.Corso;

public class CorsoBC implements GenericBC<Corso> {
	private Connection conn;
	
	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	@Override
	public void create(Corso entity) throws DAOException {
		try {
			if(entity.getCodCorso() == 0) {
				entity.setCodCorso(CorsoCodGenerator.getInstance().getNextCod());
				CorsoDAO.getFactory().create(conn, entity);
			} else {
				CorsoDAO.getFactory().create(conn, entity);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} catch (ClassNotFoundException | IOException exc) {
			System.err.println(exc.getMessage());
			exc.printStackTrace();
		}
	}

	@Override
	public void update(Corso entity) throws DAOException {
		try {
			CorsoDAO.getFactory().update(conn, entity);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(long cod) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso getByCod(long cod) throws DAOException {
		try {
			return CorsoDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso[] getAll() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
