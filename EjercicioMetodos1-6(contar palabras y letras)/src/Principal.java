/*

MANEJO DE STRINGS 1.6
=====================

OBJETIVO: 
	Programa que cuenta las letras y las palabras tiene un texto. (No se cuentan los puntos ni 
	signos de interrogaci�n, exclamaci�n, par�ntesis, etc..)

OBSERVACI�N:
	- Considero una letra aquellas que est�n en la tabla ASCII entre los valores: 97-122, 129-154 y 160-165.
	- Considero tambi�n como una palabra aquellas que contengan letras y s�mbolos �jo%*#!
	
AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 29-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CUENTA LETRAS Y PALABRAS");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String texto;          // Texto introducido por el usuario.
		int letras_en_palabra; // N�mero de letras en una palabra (para comprobar si �sta es palabra o no).
		int letras, palabras;  // N�mero de letras y palabras en el texto introducido.
		String [] npalabras;   // Vector que contiene las palabras del texto introducido por el usuario.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		letras = 0;      //
		palabras = 0;    // Empiezo presumiendo que no hay letras ni palabras en el texto que se introducir�.
		
		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce un trozo de texto:");
		texto = entrada.nextLine().trim(); // Elimino espacios al principio y al final (realmente necesario en este ejercicio)
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		texto = texto.toLowerCase();  // Paso todas las letras introducidas a min�scula.
		
		npalabras = texto.split(" "); // Creo un vector creando un string para cada grupo de caracteres separados por un espacio.
		
		for (int i=0; i<=npalabras.length-1; i++) {
			letras_en_palabra = 0; // Por cada iteraci�n del bucle 'i', reinicio 'letras_en_palabra' a cero.
			for (int j=0; j<=npalabras[i].length()-1; j++) {				
				if (Integer.valueOf(npalabras[i].charAt(j))>=97  && Integer.valueOf(npalabras[i].charAt(j))<=122 ||    // De la a-z
					Integer.valueOf(npalabras[i].charAt(j))>=129 && Integer.valueOf(npalabras[i].charAt(j))<=154 ||    // vocales raras
					Integer.valueOf(npalabras[i].charAt(j))>=160 && Integer.valueOf(npalabras[i].charAt(j))<=165) {    // vocales con acentos y �
					letras_en_palabra++;
					letras++;  // Este contador NO se reinicia, me servir� para conocer el n�mero total de letras en todas las palabras.
				}
			}
			if (letras_en_palabra>0) { // Si al salir del bucle 'j' 'letras_en_palabra' es superior a cero, �tenemos una palabra nueva! :)
				palabras++;
			}
		}
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("El texto introducido tiene %d letras y %d palabras.", letras, palabras);
		
	}
}