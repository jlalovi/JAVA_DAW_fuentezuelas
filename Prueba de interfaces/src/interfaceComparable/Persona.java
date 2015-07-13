package interfaceComparable;

public class Persona implements Comparable<Persona>{ // En el main utilizo el método 'Collections.sort()' (ver aclaración en método)
												     // Al escribir el 'implements Comparable<objeto_a_comparar>' se puede pinchar sobre
													 // el error para implementar los métodos obligatorios de la interface.

	//PROPIESDADES
	private String nombre;
	private int edad;
	
	//CONSTRUCTORES
	
	public Persona(String nombre, int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}

	//MÉTODOS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(Persona persona) {
		return this.edad>persona.getEdad() ? 1 : ( this.edad<persona.getEdad() ? -1 : 0  ) ;
	}
	
	
	public String toString() {
		return this.nombre + " : " + this.edad;
	}
	
}
