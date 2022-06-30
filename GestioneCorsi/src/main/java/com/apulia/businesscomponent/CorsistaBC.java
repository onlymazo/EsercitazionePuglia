package com.apulia.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.apulia.architecture.dao.CorsistaDAO;
import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dbaccess.DBAccess;
import com.apulia.businesscomponent.codgenerator.CorsistaCodGenerator;
import com.apulia.businesscomponent.model.Corsista;

public class CorsistaBC implements GenericBC<Corsista> {
	private Connection conn;
	
	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	@Override
	public void create(Corsista entity) throws DAOException {
		try {
			if(entity.getCodCorsista() == 0) {
				entity.setCodCorsista(CorsistaCodGenerator.getInstance().getNextCod());
				CorsistaDAO.getFactory().create(conn, entity);
			} else {
				CorsistaDAO.getFactory().create(conn, entity);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		} catch (ClassNotFoundException | IOException exc) {
			System.err.println(exc.getMessage());
			exc.printStackTrace();
		}
	}

	@Override
	public void update(Corsista entity) throws DAOException {
		try {
			CorsistaDAO.getFactory().update(conn, entity);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(long cod) throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corsista getByCod(long cod) throws DAOException {
		try {
			return CorsistaDAO.getFactory().getByCod(conn, cod);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corsista[] getAll() throws DAOException {
		try {
			return CorsistaDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
