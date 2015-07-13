/*

MANEJO DE STRINGS 1.10
======================

OBJETIVO: 
	 Programa que codifique una cadena de caracteres (introducida por el usuario) con el algoritmo Cesar 
	 (busca en Internet en qu� consiste).

OBSERVACI�NES: 
	Espacios sin codificar y el resto de caracteres codificados (atendiendo tabla ASCII).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CODIFICA UN TEXTO CON EL M�TODO C�SAR");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String texto;		      // Texto introducido por el usuario y guardado en una cadena.
		String texto_codificado;  // Texto codificado con el c�digo C�sar.
		String [] palabras;       // Vector donde contendr� todas las palabras del texto introducido.
		int npalabras;			  // N�mero de palabras en el vector.
		int i, j;				  // Variables de iteraci�n.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incializaci�n de datos:
		texto_codificado = "";    // Inicializo 'texto_codificado' con un valor vac�o.

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el trozo de texto que deseas codificar:");
		texto = entrada.nextLine().trim(); // Elimino los espacios del principio y final en la misma lectura del texto introducido.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		palabras = texto.split(" ");
		
		npalabras = palabras.length;  // N�mero de palabras en el vector.
		
		for (i=0; i<npalabras; i++) { // Este bucle iterar� por cada palabra.
			for (j=0; j<palabras[i].length(); j++) {  // Y este otro itera por cada letra de cada una de esas palabras.
				texto_codificado += (char)(Integer.valueOf(palabras[i].charAt(j))+1);  // Paso cada letra a ASCII, le sumo uno, y el resultado lo vuelvo a pasar a cadena. Esa cadena la sumo al acumulador 'texto_codificado'.
			}
			if (i!=npalabras-1)
				texto_codificado += " ";  // Por cada palabra, a�ado un espacio (salvo la �ltima palabra).
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("El texto introducido codificado es '%s'", texto_codificado);
		
	}
}