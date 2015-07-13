/*

MANEJO DE STRINGS 1.3
=====================

OBJETIVO: 
	Programa que reciba un n�mero  y nos diga la cantidad de digitos enteros y la cantidad de decimales que tiene. 
	(ejemplo: 1234.37 -> 4 enteros y 2 decimales). Usando m�todos de conversi�n y de strings).
	
OBSERVACIONES:
	- Considero los errores l�gicos al introducir un n�mero negativo.
	- Tambi�n considerop los errores l�gicos al introducir un n�mero entero sin decimales.
	

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 25-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA EL N�MERO DE ENTEROS Y DECIMALES DEL N�MERO INTRODUCIDO");

	 // DELARACI�N DE VARIABLES
	 // =======================

		double decimal_num;        // N�mero introducido por el usuario.
		String decimal_text;       // N�mero transformado a cadena de texto.
		String [] decimal_parts;   // Separaci�n de parte decimal y entera en un vector.
		int decimales;             // N�mero de decimales.
		int enteros;			   // N�mero de enteros.	

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un n�mero");
		decimal_num = entrada.nextDouble();           // Si el n�mero introducido es s�lo entero, Java lo registra con un decimal igual a 0.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		decimal_text = String.valueOf(decimal_num);   // Convierto el n�mero introducido en cadena.
		decimal_parts = decimal_text.split("\\.");
		
		if (decimal_parts[0].charAt(0)==('-'))        // Si la parte entera es negativa, no cuento el '-' como n�mero entero.
			enteros = decimal_parts[0].length() - 1;
		else
			enteros = decimal_parts[0].length();
		
		if ( Integer.valueOf(decimal_parts[1])==0) {  // Si la parte decimal es = a 0, igualo 'decimales' a 0, sino, 'decimales', ser� el tama�o de la cadena correspondiente.
			decimales = 0;
		}
		else {
			decimales = decimal_parts[1].length();
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println();
		System.out.printf("El n�mero de enteros es %d y el de decimales es %d", enteros, decimales);
		
	}
}