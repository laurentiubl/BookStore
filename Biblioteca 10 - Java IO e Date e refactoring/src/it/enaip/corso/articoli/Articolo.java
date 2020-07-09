package it.enaip.corso.articoli;

import it.enaip.corso.noleggi.Noleggio;
import it.enaip.corso.noleggi.Utente;

public abstract class Articolo {

	private String codiceIdentificativo;

	public void setCodiceIdentificativo(String codiceIdentificativo) {
		this.codiceIdentificativo = codiceIdentificativo;
	}

	public Articolo(String codiceIdentificativo) {
		this.codiceIdentificativo = codiceIdentificativo;
	}
	public String getCodiceIdentificativo() {
		return codiceIdentificativo;
	}
	public Noleggio<Articolo> noleggia(Utente utente) {
		return new Noleggio<Articolo>(utente, this);
	}

	public abstract String getDescrizione();
}
