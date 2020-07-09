package it.enaip.corso.noleggi;

public class Utente {
	
	private String id;
	private String nome;
	private String cognome;
	private char sesso;
	private int eta;
	private String indirizzo;
	private String telefono;
	
	public Utente(String id, String nome, String cognome, String sesso, String eta, String indirizzo, String telefono) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		if (sesso.length()==1) 
			this.sesso = sesso.charAt(0);
		else
			this.sesso = 'M';
		this.eta = Integer.parseInt(eta);
		this.indirizzo = indirizzo;
		this.telefono = telefono;
	}
	public Utente(String id, String nome, String cognome, char sesso, int eta, String indirizzo, String telefono) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public char getSesso() {
		return sesso;
	}

	public int getEta() {
		return eta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
