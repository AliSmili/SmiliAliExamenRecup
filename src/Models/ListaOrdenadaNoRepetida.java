package Models;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaOrdenadaNoRepetida <T> extends ArrayList <T>{
	
	private comparaPokemons<T> miComparador;

	
	public ListaOrdenadaNoRepetida(comparaPokemons<T> comp){
		
		this.miComparador =  comp;
	
	}

}
