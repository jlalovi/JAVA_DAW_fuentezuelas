package interfaceComparable;

public class Persona implements Comparable<Persona>{ // En el main utilizo el m�todo 'Collections.sort()' (ver aclaraci�n en m�todo)
												     // Al escribir el 'implements Comparable<objeto_a_comparar>' se puede pinchar sobre
													 // el error para implementar los m�todos obligatorios de la interface.

	//PROPIESDADES
	private String nombre;
	private int edad;
	
	//CONSTRUCTORES
	
	public Persona(String nombre, int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}

	//M�TODOS
	
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
