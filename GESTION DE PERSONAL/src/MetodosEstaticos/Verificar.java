package MetodosEstaticos;

import java.util.Scanner;

/**
 * Clase Preguntar
 * contiene m�todos para comprobar valores ofrecidos por el usuario y controlar errores. 
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 18/05/2015 (v.1)
 * @since 18/05/2015
 *
 */
public class Verificar {

	/**
	 * Comprueba car�cter a car�cter si la cadena introducida es un n�mero
	 * @param cadena
	 * @return false: si alguno de los caracteres introducidos no es n�mero.
	 * 		   true: si todos los caracteres introducidos son n�meros.
	 */
	public static boolean esNumero(String cadena){
		boolean esNumero=false;
		for (int i=0; i<cadena.length(); i++) { // Compruebo n�mero a n�mero si de verdad lo son:
			if (Integer.valueOf(cadena.charAt(i))<48  || Integer.valueOf(cadena.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
				System.out.println("El valor introducido no es num�rico. Vuelve a introducir un valor.");
				esNumero=false;
			}
			else
				esNumero=true;
		}
		return esNumero;
	}
	
	/**
	 * Comprueba que la cadena es vac�a, es decir, que su valor es "".
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
	 * Comprueba que un n�mero entero comprende entre los valores de un intervalo
	 * 
	 * @param numero_a_comprobar
	 * @param min
	 * @param max
	 * @return true: Si el n�mero se encuentra entre min y max inclusives.
	 * 		   false: Si el n�mero NO se encuentra entre min y max inclusives.
	 */
	public static boolean esIntervalo (int numero_a_comprobar, int min, int max) {
		if (numero_a_comprobar>=min && numero_a_comprobar<=max)
			return true;
		else  {
			return false;
		}
	}
	
	/**
	 * Comprueba si el n�mero de veces que se repite un car�cter es el especificado por el par�metro 'nveces'.
	 * 
	 * @param cadena
	 * @param caracter
	 * @param caracter
	 * @return true: el caracter se repite tantas veces como se especifica en el par�metro. false: no ocurre lo anterior.
	 */
	public static boolean nChars (String cadena, char caracter, int nveces) {
		if (nveces==Verificar.nChars(cadena, caracter))
			return true;
		else
			return false;
	}
	
	/**
	 * Comprueba el n�mero de caracteres de un tipo que tiene una cadena.
	 * 
	 * @param cadena
	 * @param caracter
	 * @return n�mero de veces que se repite el caracter
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
