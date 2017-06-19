package Models;

public class Pokemon {
	
	private String nombre ;
	private int numero;
	private int nivelEvolucion;
	private String region;
	private String tipo;
	private String comentarios;
	public Pokemon(String nombre, int numero, int nivelEvolucion, String region, String tipo, String comentarios) {
		
		this.nombre = nombre;
		this.numero = numero;
		this.nivelEvolucion = nivelEvolucion;
		this.region = region;
		this.tipo = tipo;
		this.comentarios = comentarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNivelEvolucion() {
		return nivelEvolucion;
	}
	public void setNivelEvolucion(int nivelEvolucion) {
		this.nivelEvolucion = nivelEvolucion;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", numero=" + numero + ", nivelEvolucion=" + nivelEvolucion + ", region="
				+ region + ", tipo=" + tipo + ", comentarios=" + comentarios + "]";
	}

}
