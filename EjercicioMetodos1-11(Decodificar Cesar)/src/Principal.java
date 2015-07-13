/*

MANEJO DE STRINGS 1.11
======================

OBJETIVO: 
	Programa que DEcodifique una cadena de caracteres codificada con el algoritmo Cesar.

OBSERVACI�NES: 
	Espacios sin codificar y el resto de caracteres codificados (atendiendo tabla ASCII).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE DECODIFICA UN TEXTO CON EL M�TODO C�SAR");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String texto;		        // Texto introducido por el usuario y guardado en una cadena (codificado en c�digo C�sar).
		String texto_decodificado;  // Texto codificado con el c�digo C�sar.
		String [] palabras;         // Vector donde contendr� todas las palabras del texto introducido.
		int npalabras;			    // N�mero de palabras en el vector.
		int i, j;				    // Variables de iteraci�n.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incializaci�n de datos:
		texto_decodificado = "";    // Inicializo 'texto_decodificado' con un valor vac�o.

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el trozo de texto que deseas decodificar:");
		texto = entrada.nextLine().trim(); // Elimino los espacios del principio y final en la misma lectura del texto introducido.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		palabras = texto.split(" ");
		
		npalabras = palabras.length;  // N�mero de palabras en el vector.
		
		for (i=0; i<npalabras; i++) { // Este bucle iterar� por cada palabra.
			for (j=0; j<palabras[i].length(); j++) {  // Y este otro itera por cada letra de cada una de esas palabras.
				texto_decodificado += (char)(Integer.valueOf(palabras[i].charAt(j))-1);  // Paso cada letra a ASCII, le sumo uno, y el resultado lo vuelvo a pasar a cadena. Esa cadena la sumo al acumulador 'texto_codificado'.
			}
			if (i!=npalabras-1)
				texto_decodificado += " ";  // Por cada palabra, a�ado un espacio (salvo la �ltima palabra).
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("El texto introducido decodificado es '%s'", texto_decodificado);
		
	}
}