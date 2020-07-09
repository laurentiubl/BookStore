package it.enaip.corso.articoli;

public class Libro extends ArticoloEditoriale{
	
	public Libro(String isbn, String titolo, String autore, int annoPubblicazione, Genere genere) {
		super(isbn, titolo, autore, annoPubblicazione, genere);
	}

}
