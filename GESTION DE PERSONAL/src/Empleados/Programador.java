package Empleados;

import MetodosEstaticos.Fecha;

/**
 * Subclase de 'Tecnico' que crea objetos de tipo 'Programador'.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class Programador extends Tecnico{
	
	//CONSTRUCTORES
	
	/**
	 * Construye un objeto 'Programador' con las propiedades siguientes:
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param centro_trabajo
	 */
	public Programador(String nombre, String ape1, String ape2, String dni, String centro_trabajo) {
		super(nombre, ape1, ape2, dni, centro_trabajo);
		this.puesto_trabajo="Programador";
	}
	
	//MÉTODOS
	
	/**
	 * Calcula la nómina del 'Programador' en el mes y año correspondientes.
	 * @param dni
	 * @param centro_trabajo
	 * @return nómina calculada en el mes y año correspondientes
	 */
	@Override
	public double calculaNomina(int mes, int año) {
		return Fecha.diasEn(mes, año)*20.50 + this.sueldo_base;
	}

}
