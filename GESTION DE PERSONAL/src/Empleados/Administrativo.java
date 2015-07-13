package Empleados;

import MetodosEstaticos.Fecha;

/**
 * Subclase de 'Empleado' que crea objetos de tipo 'Administrativo'.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class Administrativo extends Empleado{
	
	//CONSTRUCTORES
	
	/**
	 * Construye un objeto 'Administrativo' con las propiedades siguientes:
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param centro_trabajo
	 */
	public Administrativo(String nombre, String ape1, String ape2, String dni, String centro_trabajo) {
		super(nombre, ape1, ape2, dni, centro_trabajo);
		this.sueldo_base=200;
		this.puesto_trabajo="Administrativo";
	}
		
	//MÉTODOS
	
	/**
	 * Calcula la nómina del 'Administrativo' en el mes y año correspondientes.
	 * @param dni
	 * @param centro_trabajo
	 * @return nómina calculada en el mes y año correspondientes
	 */
	@Override
	public double calculaNomina(int mes, int año) {
		return Fecha.diasEn(mes, año)*10.70 + this.sueldo_base;
	}

}
