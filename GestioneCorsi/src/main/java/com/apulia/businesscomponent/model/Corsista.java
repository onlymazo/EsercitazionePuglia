package com.apulia.businesscomponent.model;

public class Corsista {
	private long codCorsista;
	private String nome;
	private String cognome;
	private boolean precFormativi;
	
	public long getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
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
	public boolean isPrecFormativi() {
		return precFormativi;
	}
	public void setPrecFormativi(boolean precFormativi) {
		this.precFormativi = precFormativi;
	}
	@Override
	public String toString() {
		return "Corsista [codCorsista=" + codCorsista + ", nome=" + nome + ", cognome=" + cognome + ", precFormativi="
				+ precFormativi + "]";
	}
}
