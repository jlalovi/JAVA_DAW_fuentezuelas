package MetodosEstaticos;

/**
 * Clase que contiene m�todos relacionados con la fecha.
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class Fecha {

	/**
	 * @param mes
	 * @param a�o
	 * @return n�mero de d�as que contiene el mes del a�o indicados en los par�metros
	 */
	public static int diasEn(int mes, int a�o) {
		int dias;
		switch (mes) {
			case 2:  // Febrero.
				if ((a�o % 4 == 0 && a�o % 100 != 0) || a�o % 400 == 0) // A�os bisiestos.
					dias=29;
				else
					dias=28;	
				break;				
			case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
				dias=30;
				break;				
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: // Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre.
				dias=31;
				break;				
			default:
				dias=0; // Si el mes no existe devuelvo un valor igual a 0 d�as.
				break;
		} // fin de 'switch'
		return dias;
	}
	
}
