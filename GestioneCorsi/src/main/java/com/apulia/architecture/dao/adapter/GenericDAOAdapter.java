package com.apulia.architecture.dao.adapter;

import java.sql.Connection;

import com.apulia.architecture.dao.DAOException;
import com.apulia.architecture.dao.GenericDAO;

public abstract class GenericDAOAdapter<T> implements GenericDAO<T> {

	@Override
	public void create(Connection conn, T entity) throws DAOException {
		
	}

	@Override
	public void update(Connection conn, T entity) throws DAOException {
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		
	}

	@Override
	public T getByCod(Connection conn, long id) throws DAOException {
		return null;
	}

	@Override
	public T[] getAll(Connection conn) throws DAOException {
		return null;
	}

}
