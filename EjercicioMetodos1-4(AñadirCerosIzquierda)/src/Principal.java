/*

MANEJO DE STRINGS 1.4
=====================

OBJETIVO: 
	Programa que recibe un n�mero y lo imprime formateado con ceros a la izquierda y una 
	longitud de 6 d�gitos. (Ejemplo: 35 -> 000035,   1269->001269).
	
OBSERVACIONES:
	- Considero los errores l�gicos al introducir un n�mero negativo.
	
AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 28-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE A�ADE CEROS A LA IZQUIERDA SI ES NECESARIO PARA OBTENER UNA LONGITUD DE 6 CIFRAS");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int valor_numero;      // Valor introducido por el usuario.
		String texto_numero;   // Conversi�n del n�mero introducido a cadena.
		int longitud;          // Longitud de la cadena
		int i;                 // Variable para iterar en los bucles utilizados.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introuduce un n�mero entero");
		valor_numero = entrada.nextInt();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		texto_numero = String.valueOf(valor_numero);   // Convierto n�mero a cadena.
		
		longitud = texto_numero.length();              // Longitud de la cadena.
		
		if (texto_numero.charAt(0)==('-'))
			longitud--;                                // Si el n�mero es negativo, no cuento el '-' en la longitud.
		
		if (longitud<6 && texto_numero.charAt(0)==('-')) { // Si el n�mero tiene menos de 6 d�gitos y es negativo.
			texto_numero = texto_numero.substring(1);      // Le quito el '-'
			for (i=0; i<=5-longitud; i++) {
				texto_numero = "0" + texto_numero;         // Le a�ado tantos ceros como para completar 6 digitos.
			}
			texto_numero = "-" + texto_numero;             // A�ado de nuevo el '-'
		} else if (longitud<6) {                           // Si el n�mero no es negativo y menor de 6 digitos.
			for (i=0; i<=5-longitud; i++) {
				texto_numero = "0" + texto_numero;         // Le a�ado tantos ceros como para completar 6 digitos.
			}
		}
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(texto_numero);
		
	}
}