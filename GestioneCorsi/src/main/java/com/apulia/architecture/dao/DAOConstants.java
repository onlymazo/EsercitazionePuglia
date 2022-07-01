package com.apulia.architecture.dao;

public interface DAOConstants {

	String SELECT_CORSO = "Select * from corso";
	String SELECT_CORSISTA = "Select * from corsista";
	String SELECT_DOCENTE = "Select * from docente";
	String SELECT_CORSO_CORSISTA = "Select * from corso_corsista";
	
	String UPDATE_CORSO = "Update corso set cod_docente = ?, nome_corso = ?, data_inizio = ?, data_fine = ?, costo_corso = ?, commenti = ?, aula_corso = ? where cod_corso = ?";
	String UPDATE_CORSISTA = "Update corsista set nome_corsista = ?, cognome_corsista = ?, precedenti_formativi = ? where cod_corsista = ?";
	String UPDATE_DOCENTE = " Update docente set nome_docente = ?, cognome_docente = ?, cv = ? where cod_docente = ?";
	
	String DELETE_CORSO = "Delete from corso where cod_corso = ?";
	String DELETE_CORSISTA = "Delete from corsista where cod_corsista = ?";
	String DELETE_DOCENTE = "Delete from docente where cod_docente = ?";
	
	String SELECT_CORSO_BYCOD = "Select * from corso where cod_corso = ?";
	String SELECT_CORSISTA_BYCOD = "Select * from corsista where cod_corsista = ?";
	String SELECT_DOCENTE_BYCOD = "Select * from docente where cod_docente = ?";
	
	String SELECT_ADMINPASS = "Select password from admin where cod_admin=?";

	
	//-----SEQUENZE
	String SELECT_DOCENTESEQ = "Select docente_seq from dual";
	String SELECT_CORSOSEQ = "Select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "Select corsista_seq.nextval from dual";

	
}
