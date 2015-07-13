/*

MANEJO DE STRINGS 1.2
=====================

OBJETIVO: Programa que devuelve si una palabra es pal�ndromo.

OBSERVACI�NES: 
	- Se tienen en cuenta los espacios y los acentos en el pal�ndromo (Ej. "as�" y "esa sase" NO ser�an pol�ndromos.)
	- No se tienen en cuenta las may�sculas (Ej. Asa es pal�ndromo)

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 25-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI EL TEXTO INTRODUCIDO ES PAL�NDROMO");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int longitud;          // N�mero de caracteres que contiene el String introducido por el usuario.
		String texto;		   // Texto introducido por el usuario.
		String texto_inverso;  // Variable que contendr� el texto invertido que el usuario introdujo.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		texto_inverso = "";

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce el texto que quieres invertir:");
		texto = entrada.nextLine().toLowerCase();  // Leo el dato y lo transformo todo en min�sculas.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		longitud = texto.length();
		
		for (int i=0; i<=longitud-1; i++) {
			texto_inverso += texto.charAt(longitud-1-i); // Voy leyendo los caracteres desde el final al principio de 'texto' y los almaceno desde el principio al fin de 'texto_invertido'.
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (texto.equals(texto_inverso)) {
			System.out.println("El texto introducido es pal�ndromo.");
		}
		else {
			System.out.println("El texto introducido NO es pal�ndromo.");
		}
		
	}
}