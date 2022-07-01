package com.apulia.businesscomponent.model;

public class Admin {
	private long codAdmin;
	private String nome;
	private String cognome;
	private String password;

	public long getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(long codAdmin) {
		this.codAdmin = codAdmin;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [codAdmin=" + codAdmin + ", nome=" + nome + ", cognome=" + cognome + ", password=" + password
				+ "]";
	}
	

}
