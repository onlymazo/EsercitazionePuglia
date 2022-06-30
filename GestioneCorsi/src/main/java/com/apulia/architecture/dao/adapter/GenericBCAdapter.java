package com.apulia.architecture.dao.adapter;

import com.apulia.architecture.dao.DAOException;
import com.apulia.businesscomponent.GenericBC;

public class GenericBCAdapter<T> implements GenericBC<T> {

	@Override
	public void create(T entity) throws DAOException {
		
	}

	@Override
	public void update(T entity) throws DAOException {
		
	}

	@Override
	public void delete(long cod) throws DAOException {
		
	}

	@Override
	public T getByCod(long cod) throws DAOException {
		return null;
	}

	@Override
	public T[] getAll() throws DAOException {
		return null;
	}

}
