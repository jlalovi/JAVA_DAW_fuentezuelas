package SDI;

public class Alumno {
	
	//propiedades
	private String nombre;
	private String apellidos;
	private int edad;
	
	//constructor
	public Alumno(){}
	
	public Alumno(String nombre, String apellidos, int edad) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
	}

	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return this.nombre + ", " + this.apellidos + ". " + this.edad;
	}
}
