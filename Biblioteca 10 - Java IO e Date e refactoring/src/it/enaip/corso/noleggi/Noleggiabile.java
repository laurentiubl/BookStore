package it.enaip.corso.noleggi;

public interface Noleggiabile {

	public void setGiacenza(int giacenza);
	public int getGiacenza();
	public Noleggio<?> noleggia(Utente utente);
}
