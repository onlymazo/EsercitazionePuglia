package com.apulia.businesscomponent.model;

import java.io.File;

public class Docente {
	private long codDocente;
	private String nome;
	private String cognome;
	private String cv;
	
	public long getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	@Override
	public String toString() {
		return "Docente [codDocente=" + codDocente + ", nome=" + nome + ", cognome=" + cognome + ", cv=" + cv + "]";
	}
}
