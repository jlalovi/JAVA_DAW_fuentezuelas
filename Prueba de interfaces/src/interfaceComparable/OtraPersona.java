package interfaceComparable;

public class OtraPersona {

	//PROPIESDADES
	private static String nombre;
	private int edad;
	
	//CONSTRUCTORES
	
	public OtraPersona(String nombre, int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}

	//MÉTODOS
	
	public static String getNombre() {
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
	
}
