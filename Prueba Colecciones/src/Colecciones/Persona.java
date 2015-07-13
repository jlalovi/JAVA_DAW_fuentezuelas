package Colecciones;

public class Persona implements Comparable<Persona>{

	private String nombre;
	private String apellidos;
	
	public Persona (String nombre, String apellidos) {
		this.nombre=nombre;
		this.apellidos=apellidos;
	}

	@Override
	public int compareTo(Persona p1) {
		return this.toString().compareTo(p1.toString()); //Nota!! No haca falta utilizar un get cuando haces referencia a objetos externos del mismo tipo
	}
	
	@Override
	public String toString() {
		return "(" + this.apellidos + ", " + this.nombre + ")";
	}
	
}
