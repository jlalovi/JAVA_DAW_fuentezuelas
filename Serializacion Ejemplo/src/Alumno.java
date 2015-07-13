import java.io.Serializable;


public class Alumno implements Serializable{

	//PROPIEDADES
	private String nombre;
	private String apellidos;
	private String dni;
	
	//CONSTRUCTOR
	public Alumno(String nombre, String apellidos, String dni) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.dni=dni;
	}
	
	//MÉTODO
	public String toString() {
		return this.apellidos + ", " + this.nombre + " DNI: " + this.dni;
	}
	
}
