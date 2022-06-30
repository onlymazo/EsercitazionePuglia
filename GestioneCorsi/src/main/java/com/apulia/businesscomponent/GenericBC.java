package com.apulia.businesscomponent;

import com.apulia.architecture.dao.DAOException;

public interface GenericBC<T> {
	public void create(T entity) throws DAOException;
	public void update(T entity) throws DAOException;
	public void delete(long cod) throws DAOException;
	public T getByCod(long cod) throws DAOException;
	public T[] getAll() throws DAOException;
}
