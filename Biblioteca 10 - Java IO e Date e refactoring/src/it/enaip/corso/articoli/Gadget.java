package it.enaip.corso.articoli;

public class Gadget extends Articolo implements Cloneable {

	private String descrizione;
	private double peso;
	
	public Gadget(String codiceIdentificativo, String descrizione, double peso) {
		super(codiceIdentificativo);
		this.descrizione = descrizione;
		this.peso = peso;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public Gadget clone() throws CloneNotSupportedException {
		//TODO: implementare deep copy
		return (Gadget) super.clone();
	}
	
}
