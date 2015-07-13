package Empleados;

/**
 * Subclase de 'Tecnico' que crea objetos de tipo 'Becario'.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class Becario extends Tecnico{

	//CONSTRUCTORES
	
	/**
	 * Construye un objeto 'Becario' con las propiedades siguientes:
	 * @param nombre
	 * @param ape1
	 * @param ape2
	 * @param dni
	 * @param centro_trabajo
	 */
	public Becario(String nombre, String ape1, String ape2, String dni, String centro_trabajo) {
		super(nombre, ape1, ape2, dni, centro_trabajo);
		this.puesto_trabajo="Becario";
	}
	
	//MÉTODOS
	
	/**
	 * Calcula la nómina del 'Becario' en el mes y año correspondientes.
	 * @param dni
	 * @param centro_trabajo
	 * @return nómina calculada en el mes y año correspondientes
	 */
	@Override
	public double calculaNomina(int mes, int año) {
		return this.sueldo_base;
	}

}
