package it.enaip.corso.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

import it.enaip.corso.Biblioteca;
import it.enaip.corso.articoli.Articolo;
import it.enaip.corso.noleggi.Noleggio;
import it.enaip.corso.noleggi.Utente;

public class NoleggiService {

	private static final String NOLEGGI_FILENAME_PREFIX = "NoleggiAl-";

	public void noleggiaArticolo(List<Utente> utenti, List<Articolo> articoliDisponibili,
			List<Noleggio<?>> noleggi, int indiceArticolo, int indiceUtente) {
		Noleggio<?> noleggio;
		if(indiceUtente >= 0 && indiceUtente < utenti.size())
		{
			noleggio = articoliDisponibili.get(indiceArticolo)
					.noleggia(utenti.get(indiceUtente));
			articoliDisponibili.remove(indiceArticolo);
			noleggi.add(noleggio);
		}
		else
			System.out.println("ERRORE: indice utente non valido - " + indiceUtente);
	}

	public void stampaNoleggi(List<Noleggio<?>> noleggi) {
		for (Noleggio<?> noleggio: noleggi) {
			String stringDaStampare = "";
			String titolo = ((Articolo)noleggio.getT()).getDescrizione();
			
			Articolo articolo = (Articolo)noleggio.getT();
	
			String tipo = "";
			tipo= articolo.getClass().getSimpleName();
			
			String strUtente = "";
			strUtente = noleggio.getUtente().getNome()
					+ " " + noleggio.getUtente().getCognome();
			
			stringDaStampare = tipo + " - " + titolo + " - " + strUtente;
			
			System.out.println(stringDaStampare);
		}
		System.out.println("FINE STAMPE");
	}

	public void salvaNoleggi(List<Noleggio<?>> noleggi) {
		String noleggiFileName = NOLEGGI_FILENAME_PREFIX
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) 
				+".txt";
	    try(BufferedWriter w = new BufferedWriter(new FileWriter(Biblioteca.FILES_PATH + noleggiFileName))){
			for (Noleggio<?> noleggio: noleggi) {
				
				
				String stringDaStampare = "";
				String titolo = ((Articolo)noleggio.getT()).getDescrizione();
				Articolo articolo = (Articolo)noleggio.getT();
				String tipo = "";
				tipo= articolo.getClass().getSimpleName();    				
				String strUtente = "";
				strUtente = noleggio.getUtente().getNome()
						+ " " + noleggio.getUtente().getCognome();
				stringDaStampare = tipo + " - " + titolo + " - " + strUtente;
					
	    		w.write(stringDaStampare);
	    		w.newLine();
			}
				
			//for
	    }catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("FINE STAMPA Noleggi");
	}
	
	
	
	
	public void salvaNoleggiConPredicate(List<Noleggio<?>> noleggi, Predicate<Noleggio> parametru) {
		String noleggiFileName = NOLEGGI_FILENAME_PREFIX
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) 
				+".txt";
	    try(BufferedWriter w = new BufferedWriter(new FileWriter(Biblioteca.FILES_PATH + noleggiFileName))){
			for (Noleggio<?> noleggio: noleggi) {
				
				if(parametru.test(noleggio)) {
				String stringDaStampare = "";
				String titolo = ((Articolo)noleggio.getT()).getDescrizione();
				Articolo articolo = (Articolo)noleggio.getT();
				String tipo = "";
				tipo= articolo.getClass().getSimpleName();    				
				String strUtente = "";
				strUtente = noleggio.getUtente().getNome()
						+ " " + noleggio.getUtente().getCognome();
				stringDaStampare = tipo + " - " + titolo + " - " + strUtente;
					
	    		w.write(stringDaStampare);
	    		w.newLine();
			}
				}
			//for
	    }catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("FINE STAMPA Noleggi");
	}

}
