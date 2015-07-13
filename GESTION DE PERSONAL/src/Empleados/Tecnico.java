package Empleados;

import java.util.ArrayList;

/**
 * Superclase que crea objetos de tipo 'Técnico', que a su vez es subclase de 'Empleado'.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public abstract class Tecnico extends Empleado{
	
	//PROPIEDADES
	
	private ArrayList<String> capacidades;
	
	//CONSTRUCTORES

	/**
	 * Construye un objeto 'Técnico' con las propiedades siguientes:
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param centro_trabajo
	 */
	public Tecnico(String nombre, String ape1, String ape2, String dni, String centro_trabajo) {
		super(nombre, ape1, ape2, dni, centro_trabajo);
		this.capacidades=new ArrayList<String>();
		this.sueldo_base=300;
	}
	
	//MÉTODOS
	
	/**
	 * @return ArrayList de capacidades que posee el objeto 'Tecnico'
	 */
	public ArrayList<String> getCapacidades() {
		return capacidades;
	}
	/**
	 * Sobreescribe las capacidades del objeto 'Técnico' por las incluídas en el parámetro ArrayList. 
	 * @param capacidades
	 */
	public void setCapacidades(ArrayList<String> capacidades) {
		this.capacidades.clear(); // Elimino todo el contenido que pudiese tener 'capacidades'
		this.capacidades.addAll(capacidades);
	}
	/**
	 * Sobreescribe las capacidades del objeto 'Técnico' por las incluídas en el parámetro Array. 
	 * @param capacidades
	 */
	public void setCapacidades(String ... capacidades) {
		this.capacidades.clear(); // Elimino todo el contenido que pudiese tener 'capacidades'
		for (int i=0; i<capacidades.length; i++){
			this.capacidades.add(capacidades[i]);
		}
	}
	/**
	 * Añade una nueva capacidad al ArrayList de 'capacidades' de 'Tecnico'
	 * @param nueva_capacidad
	 */
	public void añadirCapacidad(String nueva_capacidad) {
		this.capacidades.add(nueva_capacidad);
	}
	
	/**
	 * Devuelve una cadena con el nombre completo, DNI, puesto de trabajo, centro de trabajo y capacidades del empleado en este formato:
	 * @return "Apellido1 Apellido2, Nombre - XXXXXXXXx - puesto de trabajo - Centro de trabajo: X - Capacidades:[capacidad1, capacidad2, ...]"
	 */
	@Override
	public String mostrarDatosCompletos(){ // Método general del que se hará un override en 'Tecnicos' para el método buscarEmpleadoDNI
		return super.mostrarDatosCompletos() + " - Capacidades:" + this.capacidades.toString();
	}


}
