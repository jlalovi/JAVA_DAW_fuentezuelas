/*

MANEJO DE STRINGS 1.4
=====================

OBJETIVO: 
	Programa que recibe un número y lo imprime formateado con ceros a la izquierda y una 
	longitud de 6 dígitos. (Ejemplo: 35 -> 000035,   1269->001269).
	
OBSERVACIONES:
	- Considero los errores lógicos al introducir un número negativo.
	
AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 28-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE AÑADE CEROS A LA IZQUIERDA SI ES NECESARIO PARA OBTENER UNA LONGITUD DE 6 CIFRAS");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int valor_numero;      // Valor introducido por el usuario.
		String texto_numero;   // Conversión del número introducido a cadena.
		int longitud;          // Longitud de la cadena
		int i;                 // Variable para iterar en los bucles utilizados.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introuduce un número entero");
		valor_numero = entrada.nextInt();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		texto_numero = String.valueOf(valor_numero);   // Convierto número a cadena.
		
		longitud = texto_numero.length();              // Longitud de la cadena.
		
		if (texto_numero.charAt(0)==('-'))
			longitud--;                                // Si el número es negativo, no cuento el '-' en la longitud.
		
		if (longitud<6 && texto_numero.charAt(0)==('-')) { // Si el número tiene menos de 6 dígitos y es negativo.
			texto_numero = texto_numero.substring(1);      // Le quito el '-'
			for (i=0; i<=5-longitud; i++) {
				texto_numero = "0" + texto_numero;         // Le añado tantos ceros como para completar 6 digitos.
			}
			texto_numero = "-" + texto_numero;             // Añado de nuevo el '-'
		} else if (longitud<6) {                           // Si el número no es negativo y menor de 6 digitos.
			for (i=0; i<=5-longitud; i++) {
				texto_numero = "0" + texto_numero;         // Le añado tantos ceros como para completar 6 digitos.
			}
		}
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(texto_numero);
		
	}
}