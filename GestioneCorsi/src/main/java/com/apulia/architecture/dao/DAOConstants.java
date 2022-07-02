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
	
	String SELECT_ADMIN_BYCOD = "Select * from admin where cod_admin = ?";
	String SELECT_CORSO_BYCOD = "Select * from corso where cod_corso = ?";
	String SELECT_CORSISTA_BYCOD = "Select * from corsista where cod_corsista = ?";
	String SELECT_DOCENTE_BYCOD = "Select * from docente where cod_docente = ?";
	
	String SELECT_ADMINPASS = "Select password from admin where cod_admin=?";

	
	//-----SEQUENZE
	String SELECT_DOCENTESEQ = "Select docente_seq from dual";
	String SELECT_CORSOSEQ = "Select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "Select corsista_seq.nextval from dual";
	
	//----REPORT
	String SELECT_CORSISTI_TOTALI = "Select count(cod_corsista) from corsista";
	String SELECT_CORSO_TOP = "Select corso.nome_corso from corso, corso_top where corso.cod_corso = corso_top.cod_corso";
	String SELECT_INIZIO_ULTIMO_CORSO = "Select nome_corso, data_inizio from corso where data_inizio in (select max(data_inizio) from corso)";
	String SELECT_DURATA_MEDIA ="Select avg(((data_fine - data_inizio)/7)*5) from corso";
	String SELECT_NUMERO_COMMENTI = "Select count(commenti) from corso";
	String SELECT_ELENCO_CORSISTI = "Select cod_corsista, nome_corsista, cognome_corsista from corsista";
	String SELECT_DOCENTE_CORSI = "Select d.* from docenti_1, docente d where docenti_1.cod_docente = d.cod_docente";
	String SELECT_CORSI_DISPONIBILI = "Select c.* from corso c, corsi_posti cp where c.cod_corso = cp.cod_corso";
	String SELECT_CORSISTI_ATTUALI = "Select * from corsisti_iscritti";
	
}
