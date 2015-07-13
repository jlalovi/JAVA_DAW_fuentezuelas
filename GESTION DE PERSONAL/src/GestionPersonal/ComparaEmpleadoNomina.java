package GestionPersonal;
import java.util.Comparator;
import Empleados.Empleado;

/**
 * Clase con Comparator implementado para comparar objetos de tipo 'Empleado' por su nómina.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class ComparaEmpleadoNomina implements Comparator<Empleado>{

	//PROPIEDADES
	private int mes;
	private int año;
	
	//CONSTRUCTORES
	private ComparaEmpleadoNomina(){ //Constructor sin parámetros privado para no poder instanciarlo en el main.
	} 
	
	/**
	 * Constructor único de 'ComparaEmpleadoNomina', clase con Comparator implementado para comparar
	 * objetos de tipo 'Empleado' por su nómina. Son necesarias las propiedades mes y año para conocer
	 * el número de días, necesario para calcular la nómina correspondiente.
	 * @param mes
	 * @param año
	 */
	public ComparaEmpleadoNomina(int mes, int año){
		this();
		this.mes=mes;
		this.año=año;
	}
	
	/**
	 * Implementación de la interface 'Comparator' en la clase 'ComparaEmpleadoNomina'.
	 * @return
	 * <ul>
	 *     <li>0: La nómina y el nombre completo de empleado1 y empleado2 son iguales</li>
	 *     <li>1: La nómina (o el nombre completo si la nómina es igual) del primer empleado es menor que el del segundo.</li>
	 *     <li>-1: La nómina (o el nombre completo si la nómina es igual) del primer empleado es mayor que el del segundo.</li>
	 * </ul>
	 */
	@Override
	public int compare(Empleado empleado1, Empleado empleado2) {
		double nomina_e1 = empleado1.calculaNomina(this.mes, this.año);
		double nomina_e2 = empleado2.calculaNomina(this.mes, this.año);
		return nomina_e1==nomina_e2 ? empleado1.compareTo(empleado2) : (nomina_e1>nomina_e2 ? -1 : 1); // Nómina en orden decreciente (y a igualdad, por nombre completo)
	}
}
