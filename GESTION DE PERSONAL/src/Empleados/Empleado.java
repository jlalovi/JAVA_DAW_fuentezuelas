package Empleados;

/**
 * Superclase que crea objetos de tipo 'Empleado'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 13/04/2015
 * @since 19/02/2015
 *
 */
public abstract class Empleado implements Comparable<Empleado> {

	//PROPIEDADES
	
	protected String nombre;
	protected String ape1;
	protected String ape2;
	protected String dni;
	protected String centro_trabajo;
	protected String puesto_trabajo;
	protected double sueldo_base;
	
	//CONSTRUCTOR
	
	protected Empleado(){} // No quiero que el constructor vac�o por defecto de la clase Empleado sea accesible.
	
	/**
	 * Construye un objeto 'Empleado' con las propiedades siguientes:
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param centro_trabajo
	 */
	protected Empleado(String nombre, String ape1, String ape2, String dni, String centro_trabajo) {
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;
		this.dni=dni;
		this.centro_trabajo=centro_trabajo;
	}
	
	//M�TODOS
	
	// GETTERS
	
	/**
	 * @return nombre del objeto 'Empleado'
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return primer apellido del objeto 'Empleado'
	 */
	public String getApe1() {
		return ape1;
	}
	/**
	 * @return segundo apellido del objeto 'Empleado'
	 */
	public String getApe2() {
		return ape2;
	}
	/**
	 * @return DNI del objeto 'Empleado'
	 */
	public String getDNI() {
		return dni;
	}	
	/**
	 * @return Centro de trabajo del objeto 'Empleado'
	 */
	public String getCentro_trabajo() {
		return centro_trabajo;
	}
	/**
	 * @return Puesto de trabajo del objeto 'Empleado'
	 */
	public String getPuesto_trabajo() {
		return puesto_trabajo;
	}

	//M�TODO ABSTRACTO
	public abstract double calculaNomina(int mes, int a�o);
	
	//M�TODOS P�BLICOS

	/**
	 * Implementaci�n de la interface 'Comparable'.
	 * @return
	 * <ul>
	 *     <li>0: El nombre y los apellidos son iguales</li>
	 *     <li>1: El nombre y los apellidos del primer empleado es alfab�ticametne mayor que el del segundo.</li>
	 *     <li>-1: El nombre y los apellidos del primer empleado es alfab�ticametne menor que el del segundo.</li>
	 * </ul>
	 */
	@Override
	public int compareTo(Empleado empleado) {
		if (this.ape1.equalsIgnoreCase(empleado.getApe1())&&this.ape2.equalsIgnoreCase(empleado.getApe2()))
			return (this.nombre.compareTo(empleado.getNombre()));
		else if (this.ape1.equalsIgnoreCase(empleado.getApe1()))
			return (this.ape2.compareTo(empleado.getApe2()));
		else
			return (this.ape1.compareTo(empleado.getApe1()));
	}
	
	/**
	 * Devuelve una cadena con el nombre completo, DNI y puesto de trabajo del empleado en este formato:
	 * @return "Apellido1 Apellido2, Nombre - XXXXXXXXx - puesto de trabajo"
	 */
	@Override
	public String toString(){
		return this.dni + " - " + this.ape1 + " " + this.ape2 + ", " + this.nombre + " - " + this.puesto_trabajo;
	}
	
	/**
	 * Devuelve una cadena con el nombre completo, DNI, puesto de trabajo y centro de trabajo del empleado en este formato:
	 * @return "Apellido1 Apellido2, Nombre - XXXXXXXXx - puesto de trabajo - Centro de trabajo: X"
	 */
	public String mostrarDatosCompletos(){ // M�todo general del que se har� un override en 'Tecnicos' para el m�todo buscarEmpleadoDNI
		return this.ape1 + " " + this.ape2 + ", " + this.nombre + " - " + this.dni + " - " + this.puesto_trabajo + " - Centro de trabajo: " + this.centro_trabajo;
	}
	
	/**
	 * Devuelve una cadena con el nombre completo, DNI y puesto de trabajo del empleado en este formato:
	 * @return "XXXXXXXXx - Apellido1 Apellido2, Nombre - puesto de trabajo"
	 */
	public String toStringDNI() {
		return this.dni + " - " + this.ape1 + " " + this.ape2 + ", " + this.nombre + " - " + this.puesto_trabajo;
	}
	
	/**
	 * Devuelve una cadena con el nombre completo, DNI y puesto de trabajo del empleado en este formato:
	 * @return "Apellido1 Apellido2, Nombre - puesto de trabajo - XXXX.X0�"
	 */
	public String toStringNomina(int mes, int a�o) {
		double nomina = calculaNomina(mes, a�o);
		nomina = Math.rint(nomina*10)/10; // Redondeo a un s�lo decimal. Posteriormente a�ado un 0 por temas de presentaci�n.
		return this.ape1 + " " + this.ape2 + ", " + this.nombre + " - " + this.puesto_trabajo + " - " + nomina + "0�"; // Ver comentario anterior
	}
	
}
