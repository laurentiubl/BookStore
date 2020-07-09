package it.enaip.corso;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import it.enaip.corso.articoli.Articolo;
import it.enaip.corso.articoli.ArticoloEditoriale;
import it.enaip.corso.articoli.Catalogatore;
import it.enaip.corso.noleggi.Noleggio;
import it.enaip.corso.noleggi.Utente;

import it.enaip.corso.services.*;


public class Biblioteca {
	public static final String FILES_PATH = "C:\\Users\\Blg-John\\Desktop\\TestFiles\\";
	
	

	public static void main(String[] args) {
		//Esercizio Biblioteca 9 - Java IO e Date
		//Togliere dal codice l'array di stringhe che rappresenta la distinta e l'elenco di utenti
		// e scriverli in un due file di testo. Nel codice leggere le informazioni dai file.
		//Alla fine dell'esecuzione del programma scrivere un file che contiene l'elenco dei noleggi
		// e un file che contiene l'elenco delle giacenze rimanenti
		//inserendo nel nome del file la data e l'ora correnti in questo formato:
		// NoleggiAl-2018-10-23_15-13-22.txt
		// GiacenzeAl-2018-10-23_15-13-22.txt
		//Provare a modificare la distinta e l'elenco degli utenti.

		UtentiService utentiService = new UtentiService();
		List<Utente> utenti = utentiService.caricaUtenti();

		ArticoliService articoliService = new ArticoliService();
		
		List<Articolo> articoliDisponibili = new ArrayList<Articolo>();

		articoliService.caricaArticoli(articoliDisponibili);
		
		List<Noleggio<?>> noleggi = new ArrayList<Noleggio<?>>();

		
		
		//primo noleggio libro 3 utente 2
		NoleggiService noleggiService = new NoleggiService();
//		noleggiService.noleggiaArticolo(utenti, articoliDisponibili, noleggi, 3, 2);//KO libro con genere non valido ROCK
//		//secondo noleggio libro 12 utente 1
//		noleggiService.noleggiaArticolo(utenti, articoliDisponibili, noleggi, 12, 1);//OK
//		//terzo noleggio disco 41 utente 1
//		noleggiService.noleggiaArticolo(utenti, articoliDisponibili, noleggi, 41, 1);//OK
//		noleggiService.noleggiaArticolo(utenti, articoliDisponibili, noleggi, 65, 3);//utente 3 non valido
//		noleggiService.noleggiaArticolo(utenti, articoliDisponibili, noleggi, 65, 2);//OK
//		//Gadget:
//		noleggiService.noleggiaArticolo(utenti, articoliDisponibili, noleggi, 86, 0);
		
		articoliService.stampaArticoliDisponibili(articoliDisponibili);

		noleggiService.stampaNoleggi(noleggi);

		articoliService.salvaArticoliDisponibili(articoliDisponibili);

		
		
	

		System.out.println("FINE");
		
//		exemplu e = new exemplu();
//		
//		Predicate <Articolo> pp = p-> {
//			
//			if( p instanceof  ArticoloEditoriale)
//				
//			return ((ArticoloEditoriale) p).getAnnoPubblicazione() < 1990;
//			
//			return false;
//			};
//			
//			Predicate <Noleggio> nn = p -> p.getUtente().getEta() > 40;
//				
//		
//			noleggiService.salvaNoleggi(noleggi);
//			
//		e.getInscrit(articoliDisponibili, pp);
		
	}

}
