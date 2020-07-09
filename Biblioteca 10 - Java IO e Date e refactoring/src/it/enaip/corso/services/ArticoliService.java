package it.enaip.corso.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import it.enaip.corso.Biblioteca;
import it.enaip.corso.articoli.Articolo;
import it.enaip.corso.articoli.ArticoloEditoriale;
import it.enaip.corso.articoli.Catalogatore;
import it.enaip.corso.articoli.Gadget;

public class ArticoliService {

	private static final String ARTICOLI_FILENAME1 = "articoli.txt";
	private static final String ARTICOLI_FILENAME2 = "articoli.txt";
	private static final String ARTICOLI_FILENAME3 = "articoli.txt";
	
	
	private static final String GIACENZE_FILENAME_PREFIX = "GiacenzeAl-";
	
	public List<Articolo> caricaArticoli(List<Articolo> articoliDisponibili2) {
		Catalogatore catalogatore1 = new Catalogatore(ARTICOLI_FILENAME1, articoliDisponibili2);
		catalogatore1.start();
        
		Catalogatore catalogatore2 = new Catalogatore(ARTICOLI_FILENAME2, articoliDisponibili2);
		catalogatore2.start();

        Catalogatore catalogatore3 = new Catalogatore(ARTICOLI_FILENAME3, articoliDisponibili2);
        catalogatore3.start();
        
        while(     !catalogatore1.isFinished()
        		&& !catalogatore2.isFinished()
        		&& !catalogatore3.isFinished()) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return articoliDisponibili2;
	}

	
	
	
	public void stampaArticoliDisponibili(List<Articolo> articoliDisponibili) {
		for (Articolo articolo: articoliDisponibili) {
			String stringDaStampare = "";
			if(ArticoloEditoriale.class.isInstance(articolo)) {
				String titolo = ((ArticoloEditoriale)articolo).getTitolo();
				stringDaStampare = titolo;
				if (titolo.length()<5)
					stringDaStampare += "ATTENZIONE: " + titolo;
				else
					stringDaStampare += titolo.substring(0, 5);
				stringDaStampare += titolo + "...";
			}
			else if(Gadget.class.isInstance(articolo)) {
				stringDaStampare =
						((Gadget)articolo).getDescrizione()
						+ " - "
						+ ((Gadget)articolo).getPeso()
						;
			}
			else {
				System.out.println("ERRORE caso non previsto");
			}
			System.out.println(stringDaStampare);
		}//for
		System.out.println("FINE STAMPA DISPONIBILI");
	}

	public void salvaArticoliDisponibili(List<Articolo> articoliDisponibili) {
		
		String giacenzeFileName = GIACENZE_FILENAME_PREFIX
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) 
				+".txt";
	    try(BufferedWriter w = new BufferedWriter(new FileWriter(Biblioteca.FILES_PATH + giacenzeFileName))){
			for (Articolo articolo: articoliDisponibili) {
				String stringDaStampare = "";
				if(ArticoloEditoriale.class.isInstance(articolo))
				{
					String titolo = ((ArticoloEditoriale)articolo).getTitolo();
					//System.out.println(i + ": " + titolo.toUpperCase());
					stringDaStampare = titolo;
					if (titolo.length()<5)
						//System.out.println("ATTENZIONE: " + titolo);
						stringDaStampare += "ATTENZIONE: " + titolo;
					else
						//System.out.println(titolo.substring(0, 5));
						stringDaStampare += titolo.substring(0, 5);
					//System.out.println(i + ": " + titolo + "...");
					stringDaStampare += titolo + "...";
				}
				else if(Gadget.class.isInstance(articolo)) {
					stringDaStampare =
							((Gadget)articolo).getDescrizione()
							+ " - "
							+ ((Gadget)articolo).getPeso()
							;
				}
				else {
					//TODO: caso non previsto
					System.out.println("ERRORE caso non previsto");
				}
	    		w.append(stringDaStampare);
	    		w.newLine();
			}//for
	    }catch (Exception e) {
		    e.printStackTrace();
		}
		System.out.println("FINE scrittura file giacenze");
	}

}
