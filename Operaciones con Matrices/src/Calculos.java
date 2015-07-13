
/**
 * Clase Matriz
 * contiene métodos para hacer diferentes tipos de cálculos numéricos. 
 * 
 * @author Javier Latorre
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */
public class Calculos {

	/**
	 * Método 'numAleatorio'
	 * genera un número aleatorio dentro del rango especificado de números enteros
	 * 
	 * @param primero 'int' del primer número del rango
	 * @param ultimo 'int' del último número del rango
	 * @param ultimoIncluido 'boolean' 'true': incluye el último número 'false': No incluye el último número
	 * @return 'int' del número generado aleatoriamente dentro del rango especificado
	 * 
	 * @since 09/01/2015
	 */
	public static int numAleatorio(int primero, int ultimo, boolean ultimoIncluido) {
		
		int num;
		
		if (primero<0)
			primero--; // Si el primer número del rango es negativo, le restamos 1 para incluirlo en el rango.
		
		if (ultimoIncluido)
			num = (int)(Math.random()*(ultimo+1-primero)+primero);
		else
			num = (int)(Math.random()*(ultimo-primero)+primero);
		
		return num;
	}
	/**
	 * Método 'numAleatorio'
	 * genera un número aleatorio dentro del rango especificado de números enteros incluyendo el último número especificado
	 * 
	 * @see Calculos.numAleatorio
	 * @param primero 'int' del primer número del rango
	 * @param ultimo 'int' del último número del rango
	 * @return 'int' del número generado aleatoriamente dentro del rango especificado
	 * 
	 * @since 09/01/2015
	 */
	public static int numAleatorio(int primero, int ultimo) {
		return Calculos.numAleatorio(primero, ultimo, true);
	}
	
}
