package it.enaip.corso.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.enaip.corso.Biblioteca;
import it.enaip.corso.noleggi.Utente;

public class UtentiService {

	private static final String UTENTI_FILENAME = "User.txt";

	public List<Utente> caricaUtenti() {
		List<Utente> utenti = new ArrayList<Utente>();
		try(BufferedReader r = new BufferedReader(
				new FileReader(Biblioteca.FILES_PATH + UTENTI_FILENAME))){
			String line;
			while ( (line = r.readLine()) != null ) {
				if(line.trim().isEmpty() || line.startsWith("#")) {
					//commento di riga
				}
				else { // esecuzione regolare
					String[] userStrings = line.split(";");
					//TODO: gestione errori (devono esserci 7 campi)
					//0:id 1:nome 2:cognome 3:sesso 4:eta 5:indirizzo 6:telefono
					utenti.add(
						new Utente(
							  userStrings[0] //id
							, userStrings[1] //nome
							, userStrings[2] //cognome
							, userStrings[3] //sesso
							, userStrings[4] //eta
							, userStrings[5] //indirizzo
							, userStrings[6] //telefono
							)
						);
				}
			}
		}catch (FileNotFoundException fileNotFoundException) {
		    System.out.println(
		    		"ERRORE: file non presente"
		    		+ fileNotFoundException.getMessage()
		    		);
		    fileNotFoundException.printStackTrace();
		}catch (IOException ioe) {
		    System.out.println(
		    		"ERRORE: errore generico"
		    		+ ioe.getMessage()
		    		);
		    ioe.printStackTrace();
		};
		return utenti;
	}
}
