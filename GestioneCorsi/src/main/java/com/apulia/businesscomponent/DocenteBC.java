package com.apulia.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dao.DocenteDAO;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.model.Docente;

public class DocenteBC implements GenericBC<Docente> {
	private Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	//TODO creare classe DocenteCodGenerator e completare create con getNextCod.
	@Override
	public void create(Docente entity) throws DAOException {
		try {
			DocenteDAO.getFactory().create(conn, entity);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Docente entity) throws DAOException {
		try {
			DocenteDAO.getFactory().update(conn, entity);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(long cod) throws DAOException {
		try {
			DocenteDAO.getFactory().delete(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Docente getByCod(long cod) throws DAOException {
		try {
			return DocenteDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Docente[] getAll() throws DAOException {
		try {
			return DocenteDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	
	
}
