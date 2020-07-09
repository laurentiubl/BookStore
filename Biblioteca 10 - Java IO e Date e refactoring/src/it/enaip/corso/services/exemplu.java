package it.enaip.corso.services;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import it.enaip.corso.articoli.Articolo;

public class exemplu {

	 
	public List<Articolo> getInscrit(List<Articolo> listamea, Predicate<Articolo> parametru){
		
		List<Articolo> list = new ArrayList<Articolo>();
		
		for(Articolo a: listamea) {
			if(parametru.test(a))
				list.add(a);
		}
		System.out.println(list);
		return list;
		
		
	}
	
}
