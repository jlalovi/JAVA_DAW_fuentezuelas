/*

MANEJO DE STRINGS 1.10
======================

OBJETIVO: 
	 Programa que codifique una cadena de caracteres (introducida por el usuario) con el algoritmo Cesar 
	 (busca en Internet en qué consiste).

OBSERVACIÓNES: 
	Espacios sin codificar y el resto de caracteres codificados (atendiendo tabla ASCII).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CODIFICA UN TEXTO CON EL MÉTODO CÉSAR");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		String texto;		      // Texto introducido por el usuario y guardado en una cadena.
		String texto_codificado;  // Texto codificado con el código César.
		String [] palabras;       // Vector donde contendré todas las palabras del texto introducido.
		int npalabras;			  // Número de palabras en el vector.
		int i, j;				  // Variables de iteración.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incialización de datos:
		texto_codificado = "";    // Inicializo 'texto_codificado' con un valor vacío.

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el trozo de texto que deseas codificar:");
		texto = entrada.nextLine().trim(); // Elimino los espacios del principio y final en la misma lectura del texto introducido.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		palabras = texto.split(" ");
		
		npalabras = palabras.length;  // Número de palabras en el vector.
		
		for (i=0; i<npalabras; i++) { // Este bucle iterará por cada palabra.
			for (j=0; j<palabras[i].length(); j++) {  // Y este otro itera por cada letra de cada una de esas palabras.
				texto_codificado += (char)(Integer.valueOf(palabras[i].charAt(j))+1);  // Paso cada letra a ASCII, le sumo uno, y el resultado lo vuelvo a pasar a cadena. Esa cadena la sumo al acumulador 'texto_codificado'.
			}
			if (i!=npalabras-1)
				texto_codificado += " ";  // Por cada palabra, añado un espacio (salvo la última palabra).
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("El texto introducido codificado es '%s'", texto_codificado);
		
	}
}