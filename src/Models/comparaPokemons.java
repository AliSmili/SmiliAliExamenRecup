package Models;

import java.util.Comparator;


public class comparaPokemons<T> implements Comparator<T>{
	private Pokemon p1, p2;

	public comparaPokemons(){
		
	}
	/**
	 * ORDENACION DE MENOR A MAYOR SEGUN NUMERO
	 */
	  public int compare(Object p1, Object p2){
	      int num1 = ((Pokemon) p1).getNumero();
	      int num2 = ((Pokemon) p2).getNumero() ;
	      if(num1>num2){
	          return 1;
	       }else if(num1<num2){
	          return -1;
	       }else{
	          return 0;
	       }
	    }
	  
	

}
