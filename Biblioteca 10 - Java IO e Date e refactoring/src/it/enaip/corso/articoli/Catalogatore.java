package it.enaip.corso.articoli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.enaip.corso.Biblioteca;

public class Catalogatore implements Runnable {

	
	private boolean finished = false;

	public static final int INDEX_TIPO = 0;
	public static final int INDEX_ISBN = 1;
	// Articolo Editoriale
	public static final int INDEX_DATA = 2;
	public static final int INDEX_TITOLO = 3;
	public static final int INDEX_AUTORE = 4;
	public static final int INDEX_GENERE = 5;
	public static final int INDEX_GIACENZA= 6;
	// Gadget
	public static final int INDEX_GADGET_DESCRIZIONE = 2;
	private static final int INDEX_GADGET_PESO = 3;
	public static final int INDEX_GADGET_GIACENZA= 4;

	
	private String fileName;
	private List<Integer> giacenze;
	
	private List<Articolo> articoliDisponibili;
	
	private List<Articolo> articoli;
	






public Catalogatore(String articoliFilename1, List<Articolo> articoliDisponibili2) {
	// TODO Auto-generated constructor stub
	this.fileName = articoliFilename1;
	this.articoliDisponibili = articoliDisponibili2;
}




public List<Articolo> getArticoliDisponibili() {
		return articoliDisponibili;
	}


	public void setArticoliDisponibili(List<Articolo> articoliDisponibili) {
		this.articoliDisponibili = articoliDisponibili;
	}


public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


private void cataloga() {
	
	articoliDisponibili = new ArrayList<Articolo>();
	
	for(int i = 0; i < articoli.size(); i++) {
		for(int j =0; j < giacenze.get(i); j++) {
			try {
				if(articoli.get(i) instanceof Gadget)
					articoliDisponibili.add(
						((Gadget)articoli.get(i)).clone()
						);
				else
					articoliDisponibili.add(
						((ArticoloEditoriale)articoli.get(i)).clone()
						);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

private void leggiFile() {
		
		giacenze = new ArrayList<Integer>();
		articoli = new ArrayList<Articolo>();
	
		try(BufferedReader r = new BufferedReader(
			new FileReader(Biblioteca.FILES_PATH + fileName))){
	
			String line;
			while ( (line = r.readLine()) != null ) {
				if(line.trim().isEmpty() || line.startsWith("#")) {
						//commento o riga vuota
				}
				else { // esecuzione regolare
					String[] splittedRigaDistintaArticoli = line.split(";");
					String strTipoArticolo = splittedRigaDistintaArticoli[INDEX_TIPO];
					if (   "LIBRO".equals(strTipoArticolo)
						|| "DISCO".equals(strTipoArticolo))
					{
						String dataPubblicazione = splittedRigaDistintaArticoli[INDEX_DATA];
						String[] splittedDataPubblicazione = dataPubblicazione.split("-");
						int anno = 0;
						if (splittedDataPubblicazione.length>=3) {
							String terzo = splittedDataPubblicazione[2]; //terzo elemento, di indice 2
							anno = Integer.parseInt(terzo);
							
							String strGenere = splittedRigaDistintaArticoli[INDEX_GENERE];
							ArticoloEditoriale.Genere g = null;
							if (strGenere != null && !strGenere.isEmpty())
								// controllo se strGenere è valida (exception)
								g = ArticoloEditoriale.Genere.valueOf(strGenere); // <-- da stringa a enum
							
							if ("LIBRO".equals(strTipoArticolo))
							{
								// controllo che il genere sia ammissibile per il tipo di articolo (disco, libro)
								if("Libro".equals(g.getTipologia())) {
									articoli.add(
										new Libro(
												  splittedRigaDistintaArticoli[INDEX_ISBN]
												, splittedRigaDistintaArticoli[INDEX_TITOLO]
												, splittedRigaDistintaArticoli[INDEX_AUTORE]
												, anno
												, g // genere di tipo Genere (enum) 
												)
										);
									giacenze.add(Integer.parseInt(splittedRigaDistintaArticoli[INDEX_GIACENZA]));
								}
								else
									System.out.println("ERRORE: genere non ammissibile per il tipo Libro: " + strGenere);
							} else
							if ("DISCO".equals(strTipoArticolo))
							{	// controllo che il genere sia ammissibile per il tipo di articolo (disco, libro)
								if("Disco".equals(g.getTipologia())) {
									articoli.add(
										new Disco(
												  splittedRigaDistintaArticoli[INDEX_ISBN]
												, splittedRigaDistintaArticoli[INDEX_TITOLO]
												, splittedRigaDistintaArticoli[INDEX_AUTORE]
												, anno
												, g // genere di tipo Genere (enum) 
												)
										);
									giacenze.add(Integer.parseInt(splittedRigaDistintaArticoli[INDEX_GIACENZA]));
								}
								else
									System.out.println("ERRORE: genere non ammissibile per il tipo Disco: " + strGenere);
							} else {
								// qualcosa non va: caso non previsto
								System.out.println("ERRORE: tipo di articolo non previsto: " + strTipoArticolo);
							}
						}		
					}//if ( "LIBRO".equals(strTipoArticolo)|| "DISCO".equals(strTipoArticolo))
					else if ("GADGET".equals(strTipoArticolo))
					{
						articoli.add(
								new Gadget(
									  splittedRigaDistintaArticoli[INDEX_ISBN]
									, splittedRigaDistintaArticoli[INDEX_GADGET_DESCRIZIONE]
									, Double.parseDouble(splittedRigaDistintaArticoli[INDEX_GADGET_PESO].replace(',', '.'))
									)
								);
						giacenze.add(Integer.parseInt(splittedRigaDistintaArticoli[INDEX_GADGET_GIACENZA]));
					}//if ("GADGET".equals(strTipoArticolo))
				}//esecuzione regolare
			}//while ( (line = r.readLine()) != null ) {
		} catch (FileNotFoundException fileNotFoundException) {
		    System.out.println(
		    		"ERRORE: file DISTINTA non presente"
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


		
	}




	@Override
	public void run() {
	finished = false;
	System.out.println("Inizio caricamento file:" + fileName);
	int giacenzeBeforeCataloga = 0;
	
	this.leggiFile();
	giacenzeBeforeCataloga = giacenze.size();
	this.cataloga();
	
	System.out.println("Fine caricamento file" + fileName + "Giacenze caricate:" + (giacenze.size() - giacenzeBeforeCataloga));
	finished = true;
	
	
}
	
	public void start() {
		Thread th = new Thread(this);
		th.start();
	}


	public boolean isFinished() {
		
		return this.finished;
	}
	
	
}
