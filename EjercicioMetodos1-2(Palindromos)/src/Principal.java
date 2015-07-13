/*

MANEJO DE STRINGS 1.2
=====================

OBJETIVO: Programa que devuelve si una palabra es palíndromo.

OBSERVACIÓNES: 
	- Se tienen en cuenta los espacios y los acentos en el palíndromo (Ej. "asá" y "esa sase" NO serían políndromos.)
	- No se tienen en cuenta las mayúsculas (Ej. Asa es palíndromo)

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 25-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI EL TEXTO INTRODUCIDO ES PALÍNDROMO");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int longitud;          // Número de caracteres que contiene el String introducido por el usuario.
		String texto;		   // Texto introducido por el usuario.
		String texto_inverso;  // Variable que contendrá el texto invertido que el usuario introdujo.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		texto_inverso = "";

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce el texto que quieres invertir:");
		texto = entrada.nextLine().toLowerCase();  // Leo el dato y lo transformo todo en minúsculas.
		
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
			System.out.println("El texto introducido es palíndromo.");
		}
		else {
			System.out.println("El texto introducido NO es palíndromo.");
		}
		
	}
}