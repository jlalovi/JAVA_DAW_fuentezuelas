
public class Empleado {
	
	//ATRIBUTOS
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String DNI;
	private int centro;
	private String categoria;
	private String tecnologias;
	
	//CONSTRUCTOR
	
	public Empleado(String nombre, String apellido1, String apellido2, String DNI, int centro, String categoria, String tecnologias) {
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.DNI=DNI;
		this.centro=centro;
		this.categoria=categoria;
		this.tecnologias=tecnologias;
	}
	
	//GETTERS & SETTERS
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getCentro() {
		return centro;
	}
	public void setCentro(int centro) {
		this.centro = centro;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}
	
	//MÉTODOS	
	public String toString() {
		return this.nombre + " " + this.apellido1 + " " + this.apellido2 + " " + this.apellido2 + " " + this.DNI + " " + this.centro + " " + this.categoria + " " + this.tecnologias;
	}

}
