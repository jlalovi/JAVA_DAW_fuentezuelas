/*

MANEJO DE STRINGS 1.1
=====================

OBJETIVO: Programa que pregunta un texto y lo imprime  inverso. (Ejemplo: Antonio->oinotnA)

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 25-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA EL TEXTO INTRODUCIDO DEL REVÉS");

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
		texto = entrada.nextLine();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		longitud = texto.length();
		
		for (int i=0; i<=longitud-1; i++) {
			texto_inverso += texto.charAt(longitud-1-i); // Voy leyendo los caracteres desde el final al principio de 'texto' y los almaceno desde el principio al fin de 'texto_invertido'.
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("El texto introducido invertido es: '%s'.", texto_inverso);
		
	}
}