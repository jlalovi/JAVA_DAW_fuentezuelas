package GestionPersonal;
import java.util.Comparator;
import Empleados.Empleado;

/**
 * Clase con Comparator implementado para comparar objetos de tipo 'Empleado' por su n�mina.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class ComparaEmpleadoNomina implements Comparator<Empleado>{

	//PROPIEDADES
	private int mes;
	private int a�o;
	
	//CONSTRUCTORES
	private ComparaEmpleadoNomina(){ //Constructor sin par�metros privado para no poder instanciarlo en el main.
	} 
	
	/**
	 * Constructor �nico de 'ComparaEmpleadoNomina', clase con Comparator implementado para comparar
	 * objetos de tipo 'Empleado' por su n�mina. Son necesarias las propiedades mes y a�o para conocer
	 * el n�mero de d�as, necesario para calcular la n�mina correspondiente.
	 * @param mes
	 * @param a�o
	 */
	public ComparaEmpleadoNomina(int mes, int a�o){
		this();
		this.mes=mes;
		this.a�o=a�o;
	}
	
	/**
	 * Implementaci�n de la interface 'Comparator' en la clase 'ComparaEmpleadoNomina'.
	 * @return
	 * <ul>
	 *     <li>0: La n�mina y el nombre completo de empleado1 y empleado2 son iguales</li>
	 *     <li>1: La n�mina (o el nombre completo si la n�mina es igual) del primer empleado es menor que el del segundo.</li>
	 *     <li>-1: La n�mina (o el nombre completo si la n�mina es igual) del primer empleado es mayor que el del segundo.</li>
	 * </ul>
	 */
	@Override
	public int compare(Empleado empleado1, Empleado empleado2) {
		double nomina_e1 = empleado1.calculaNomina(this.mes, this.a�o);
		double nomina_e2 = empleado2.calculaNomina(this.mes, this.a�o);
		return nomina_e1==nomina_e2 ? empleado1.compareTo(empleado2) : (nomina_e1>nomina_e2 ? -1 : 1); // N�mina en orden decreciente (y a igualdad, por nombre completo)
	}
}
