package com.apulia.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long codCorso;
	private long codDocente;
	private String nome;
	private Date dataInizio;
	private Date dataFine;
	private double costo;
	private String commenti;
	private int aula;
	
	public long getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
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
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getCommenti() {
		return commenti;
	}
	public void setCommenti(String commenti) {
		this.commenti = commenti;
	}
	public int getAula() {
		return aula;
	}
	public void setAula(int aula) {
		this.aula = aula;
	}
	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", codDocente=" + codDocente + ", nome=" + nome + ", dataInizio="
				+ dataInizio + ", dataFine=" + dataFine + ", costo=" + costo + ", commenti=" + commenti + ", aula="
				+ aula + "]";
	}
}
