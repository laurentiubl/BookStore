package it.enaip.corso.articoli;

public abstract class ArticoloEditoriale extends Articolo implements Cloneable {

	public enum Genere {
		CLASSICA("Genere classico","Disco"), 
		JAZZ("Genere jazz","Disco"),
		POP("Genere pop","Disco"), 
		ROCK("Genere rock","Disco"), 

		FANTASY("Genere fantasy","Libro"), 
		GIALLO("Genere giallo","Libro"),
		GIURIDICO("Genere giuridico","Libro"),
		ROSA("Genere rosa","Libro"),
		STORICO("Genere storico","Libro")
		;

		private String descrizione;
		private String tipologia;
		
		Genere(String descrizione, String tipologia) {
			this.descrizione = descrizione;
			this.tipologia = tipologia;
		}
		
		public String getDescrizione() {
			return descrizione;
		}
		public String getTipologia() {
			return tipologia;
		}
	}

	private String titolo;
	private String autore;
	private int annoPubblicazione;
	private Genere genere;
	
	public ArticoloEditoriale(String codiceIdentificativo, String titolo, String autore, int annoPubblicazione, Genere genere) {
		super(codiceIdentificativo);
		this.titolo = titolo;
		this.autore = autore;
		this.annoPubblicazione = annoPubblicazione;
		this.genere = genere;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	
	@Override
	public ArticoloEditoriale clone() throws CloneNotSupportedException {
		//TODO: implementare deep copy
		return (ArticoloEditoriale) super.clone();
	}
	
	public String getDescrizione() {
		return titolo;
	}
}
