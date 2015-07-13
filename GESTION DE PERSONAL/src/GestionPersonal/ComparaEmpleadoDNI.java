package GestionPersonal;
import java.util.Comparator;
import Empleados.Empleado;

/**
 * Clase con Comparator implementado para comparar objetos de tipo 'Empleado' por su DNI.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class ComparaEmpleadoDNI implements Comparator<Empleado>{
	
	/**
	 * Implementación de la interface 'Comparator' en la clase 'ComparaEmpleadoDNI'.
	 * @return
	 * <ul>
	 *     <li>0: El DNI de empleado1 y empleado2 son iguales</li>
	 *     <li>1: El DNI del primer empleado es mayor que el del segundo.</li>
	 *     <li>-1: El DNI del primer empleado es menor que el del segundo.</li>
	 * </ul>
	 */
	@Override
	public int compare(Empleado empleado1, Empleado empleado2) {
		return empleado1.getDNI().compareTo(empleado2.getDNI());
	}

}