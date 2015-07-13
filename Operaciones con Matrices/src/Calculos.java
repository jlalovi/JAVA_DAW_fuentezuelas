
/**
 * Clase Matriz
 * contiene m�todos para hacer diferentes tipos de c�lculos num�ricos. 
 * 
 * @author Javier Latorre
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */
public class Calculos {

	/**
	 * M�todo 'numAleatorio'
	 * genera un n�mero aleatorio dentro del rango especificado de n�meros enteros
	 * 
	 * @param primero 'int' del primer n�mero del rango
	 * @param ultimo 'int' del �ltimo n�mero del rango
	 * @param ultimoIncluido 'boolean' 'true': incluye el �ltimo n�mero 'false': No incluye el �ltimo n�mero
	 * @return 'int' del n�mero generado aleatoriamente dentro del rango especificado
	 * 
	 * @since 09/01/2015
	 */
	public static int numAleatorio(int primero, int ultimo, boolean ultimoIncluido) {
		
		int num;
		
		if (primero<0)
			primero--; // Si el primer n�mero del rango es negativo, le restamos 1 para incluirlo en el rango.
		
		if (ultimoIncluido)
			num = (int)(Math.random()*(ultimo+1-primero)+primero);
		else
			num = (int)(Math.random()*(ultimo-primero)+primero);
		
		return num;
	}
	/**
	 * M�todo 'numAleatorio'
	 * genera un n�mero aleatorio dentro del rango especificado de n�meros enteros incluyendo el �ltimo n�mero especificado
	 * 
	 * @see Calculos.numAleatorio
	 * @param primero 'int' del primer n�mero del rango
	 * @param ultimo 'int' del �ltimo n�mero del rango
	 * @return 'int' del n�mero generado aleatoriamente dentro del rango especificado
	 * 
	 * @since 09/01/2015
	 */
	public static int numAleatorio(int primero, int ultimo) {
		return Calculos.numAleatorio(primero, ultimo, true);
	}
	
}
