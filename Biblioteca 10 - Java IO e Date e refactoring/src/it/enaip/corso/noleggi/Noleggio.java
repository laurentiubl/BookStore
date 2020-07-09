package it.enaip.corso.noleggi;
//Generics
//
//Partendo dall'esercizio precedente aggiungere un nuovo oggetto "Gadget" che ha i seguenti dati:
//
//codiceIdentificativo (String)
//Descrizione
//Peso
//
//Aggiungere nella distinta degli oggetti che arrivano alla biblioteca almeno 2 Gadget con numero di elementi >3.
//Modificare la classe Noleggio affinché utilizzi i Generics. 
//Procedere alla catalogazione e memorizzazione delle giacenze come negli esercizi precedenti e far noleggiare almeno quattro cose tra libri, dischi e Gadget ai nostri utenti.
//Stampare i dati come negli esercizi precedenti.

public class Noleggio<T> {
	private Utente utente;
	private T t;
	
	public Noleggio(Utente utente, T t) {
		this.utente = utente;
		this.t = t;
	}

	public Utente getUtente() {
		return utente;
	}

	public T getT() {
		return t;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setT(T t) {
		this.t = t;
	}

}
