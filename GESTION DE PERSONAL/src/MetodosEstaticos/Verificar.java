package MetodosEstaticos;

import java.util.Scanner;

/**
 * Clase Preguntar
 * contiene métodos para comprobar valores ofrecidos por el usuario y controlar errores. 
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 18/05/2015 (v.1)
 * @since 18/05/2015
 *
 */
public class Verificar {

	/**
	 * Comprueba carácter a carácter si la cadena introducida es un número
	 * @param cadena
	 * @return false: si alguno de los caracteres introducidos no es número.
	 * 		   true: si todos los caracteres introducidos son números.
	 */
	public static boolean esNumero(String cadena){
		boolean esNumero=false;
		for (int i=0; i<cadena.length(); i++) { // Compruebo número a número si de verdad lo son:
			if (Integer.valueOf(cadena.charAt(i))<48  || Integer.valueOf(cadena.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
				System.out.println("El valor introducido no es numérico. Vuelve a introducir un valor.");
				esNumero=false;
			}
			else
				esNumero=true;
		}
		return esNumero;
	}
	
	/**
	 * Comprueba que la cadena es vacía, es decir, que su valor es "".
	 * @param cadena
	 * @return true: El valor de la cadena es "".
	 * 		   false: El valor de la cadena es diferente a "".
	 */
	public static boolean esVacio(String cadena){
		if ("".equals(cadena))
			return true;
		else
			return false;
	}
	
	/**
	 * Comprueba que un número entero comprende entre los valores de un intervalo
	 * 
	 * @param numero_a_comprobar
	 * @param min
	 * @param max
	 * @return true: Si el número se encuentra entre min y max inclusives.
	 * 		   false: Si el número NO se encuentra entre min y max inclusives.
	 */
	public static boolean esIntervalo (int numero_a_comprobar, int min, int max) {
		if (numero_a_comprobar>=min && numero_a_comprobar<=max)
			return true;
		else  {
			return false;
		}
	}
	
	/**
	 * Comprueba si el número de veces que se repite un carácter es el especificado por el parámetro 'nveces'.
	 * 
	 * @param cadena
	 * @param caracter
	 * @param caracter
	 * @return true: el caracter se repite tantas veces como se especifica en el parámetro. false: no ocurre lo anterior.
	 */
	public static boolean nChars (String cadena, char caracter, int nveces) {
		if (nveces==Verificar.nChars(cadena, caracter))
			return true;
		else
			return false;
	}
	
	/**
	 * Comprueba el número de caracteres de un tipo que tiene una cadena.
	 * 
	 * @param cadena
	 * @param caracter
	 * @return número de veces que se repite el caracter
	 */
	public static int nChars (String cadena, char caracter) {
		int contador = 0;
		for( int i=0; i<cadena.length(); i++ ) {
		    if( cadena.charAt(i) == caracter ) {
		    	contador++;
		    } 
		}
		return contador;
	}
	
}
