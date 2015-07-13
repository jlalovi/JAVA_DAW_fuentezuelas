package ControlExcepciones;

public class Empleado {
	private String nombre;
	private int centro;     // Queremos que sólo valga 1,2 ó 3

	public Empleado() throws DatoNoValidoException {  // Ojo en cómo utilizo los setters, para no tener que especificar de nuevo la misma regla de excepciones especificada en el método setter.
		this.setNombre("");
		this.setCentro(1);
	}
	
	public Empleado( String nombre, int centro) throws DatoNoValidoException { // Ojo en cómo utilizo los setters, para no tener que especificar de nuevo la misma regla de excepciones especificada en el método setter. 
		this.setNombre(nombre);
		this.setCentro(centro);
	}

	
	//Setters y getters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCentro() {
		return centro;
	}
	public void setCentro(int centro) throws DatoNoValidoException { // Separando por comas se pueden añadir más excepciones Ej. 'throws DatoNoValidoException, OtraExcepcion {'
		if (centro<1 || centro >3) { // Prueba de lanzar excepciones.
			throw new DatoNoValidoException("El número de centro " + centro + " no mola");
		}
		else {
			this.centro = centro;
		}			
		
	}
	
}
