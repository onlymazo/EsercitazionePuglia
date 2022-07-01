package com.apulia.businesscomponent.facade;

import java.io.IOException;

import com.apulia.architecture.dao.DAOException;
import com.apulia.businesscomponent.AdminBC;
import com.apulia.businesscomponent.CorsistaBC;
import com.apulia.businesscomponent.CorsoBC;
import com.apulia.businesscomponent.CorsoCorsistaBC;
import com.apulia.businesscomponent.DocenteBC;
import com.apulia.businesscomponent.model.Admin;
import com.apulia.businesscomponent.model.Corsista;
import com.apulia.businesscomponent.model.Corso;
import com.apulia.businesscomponent.model.CorsoCorsista;
import com.apulia.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade aF;
	private AdminBC aBC;
	private DocenteBC dBC;
	private CorsistaBC crBC;
	private CorsoBC cBC;
	private CorsoCorsistaBC ccBC;
	
	private AdminFacade() {
		
	}
	
	public static AdminFacade getInstance() {
		if (aF == null) {
			aF = new AdminFacade();
		}
		return aF;
	}
	
	public void createDocente(Docente docente)
			throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		dBC.create(docente);
	}
	
	public void updateDocente(Docente docente)
			throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		dBC.update(docente);
	}
	
	public void deleteDocente(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		dBC.delete(cod);
	}
	
	public Docente getDocenteByCod(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.getByCod(cod);
	}
	
	public Docente[] getAllDocenti()
			throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.getAll();
	}
	
	public void createCorsista(Corsista corsista)
			throws ClassNotFoundException, DAOException, IOException {
		crBC = new CorsistaBC();
		crBC.create(corsista);
	}
	
	public void updateCorsista(Corsista corsista)
			throws ClassNotFoundException, DAOException, IOException {
		crBC = new CorsistaBC();
		crBC.update(corsista);
	}
	
	public void deleteCorsista(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		crBC = new CorsistaBC();
		crBC.delete(cod);
	}
	
	public Corsista getCorsistaByCod(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		crBC = new CorsistaBC();
		return crBC.getByCod(cod);
	}
	
	public Corsista[] getAllCorsisti()
			throws ClassNotFoundException, DAOException, IOException {
		crBC = new CorsistaBC();
		return crBC.getAll();
	}
	
	public void createCorso(Corso corso)
			throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsoBC();
		cBC.create(corso);
	}
	
	public void updateCorso(Corso corso)
			throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsoBC();
		cBC.update(corso);
	}
	
	public void deleteCorso(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsoBC();
		cBC.delete(cod);
	}
	
	public Corso getCorsoByCod(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsoBC();
		return cBC.getByCod(cod);
	}
	
	public Corso[] getAllCorsi(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsoBC();
		return cBC.getAll();
	}
	
	public void createCorsoCorsista(CorsoCorsista cc)
			throws ClassNotFoundException, DAOException, IOException {
		ccBC = new CorsoCorsistaBC();
		ccBC.create(cc);
	}
	
	public Admin getAdminByCod(long cod)
			throws ClassNotFoundException, DAOException, IOException {
		aBC = new AdminBC();
		return aBC.getByCod(cod);
	}
}
