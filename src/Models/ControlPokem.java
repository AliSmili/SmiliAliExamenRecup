package Models;


import java.util.Collections;

public class ControlPokem {
	
	private static comparaPokemons<Pokemon> comp;
	public static ListaOrdenadaNoRepetida<Pokemon> listaPokemons = new ListaOrdenadaNoRepetida<Pokemon>(comp );
		
	
	public static Pokemon Obtener(int numero){
		Pokemon pok = null;
		
		for(Pokemon i: listaPokemons){
			if(i.getNumero()== numero){
				pok = i;
			}
		}
		
		return pok;
	}
		public static boolean Buscar(int numero){
			Pokemon pok = Obtener(numero);
			
			if(pok == null){
				return false;
			}else{
				return true;
			}
		}
		
	
		/**
		 Aniadimos el pokemon si el número no coincide en nuestra lista
		 */
		public static void Aniadir(String nombre,int numero, int nivelEvolucion,String region, String tipo, String comentarios){
			if(Buscar(numero)) throw new RuntimeException("No se puede añadir el pokemon porque ya hay uno con el mismo número");
			
			listaPokemons.add(new Pokemon(nombre,numero,nivelEvolucion,region, tipo, comentarios));
			Collections.sort(listaPokemons, comp);
		}

}
