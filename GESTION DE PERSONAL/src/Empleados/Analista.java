package Empleados;

import MetodosEstaticos.Fecha;

/**
 * Subclase de 'Tecnico' que crea objetos de tipo 'Analista'.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class Analista extends Tecnico{
	
	//CONSTRUCTORES
	
	/**
	 * Construye un objeto 'Analista' con las propiedades siguientes:
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param centro_trabajo
	 */
	public Analista(String nombre, String ape1, String ape2, String dni, String centro_trabajo) {
		super(nombre, ape1, ape2, dni, centro_trabajo);
		this.puesto_trabajo="Analista";
	}
		
	//M�TODOS
	
	/**
	 * Calcula la n�mina del 'Analista' en el mes y a�o correspondientes.
	 * @param dni
	 * @param centro_trabajo
	 * @return n�mina calculada en el mes y a�o correspondientes
	 */
	@Override
	public double calculaNomina(int mes, int a�o) {
		double nomina_sin_suplemento = (Fecha.diasEn(mes, a�o)*30.0 + this.sueldo_base);
		double suplemento = nomina_sin_suplemento*10/100;
		return nomina_sin_suplemento + suplemento;
	}

}
