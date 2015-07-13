/*

MANEJO DE STRINGS 1.12
======================

OBJETIVO: 
	 Programa que muestra un men� para permitir las dos opciones anteriores (y el men� 
	 se repite hasta que se elija la opci�n de salir)

OBSERVACI�N: 
	 Espacios sin codificar y el resto de caracteres codificados (atendiendo tabla ASCII).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CODIFICA O DECODIFICA UN TEXTO CON EL M�TODO C�SAR");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String texto;		      // Texto introducido por el usuario y guardado en una cadena.
		byte opcion;              // Men� para elegir codificar o decodificar texto utilizando el m�todo C�sar.
		String texto_codideco;    // Texto codificado o decodificado, seg�n el caso.
		String [] palabras;       // Vector donde contendr� todas las palabras del texto introducido.
		int npalabras;			  // N�mero de palabras en el vector.
		int i, j;				  // Variables de iteraci�n.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);
		
		do {  // Bucle para repetir el programa hasta que el usuario decida salir.
			
			// Men� inicial:
			do {
				System.out.println("\n\nElige una de las 3 opciones siguientes:");
				System.out.println("\t1.- Codificar texto.");
				System.out.println("\t2.- Decodificar texto.");
				System.out.println("\t3.- Salir");
				opcion = entrada.nextByte();
			} while (opcion<1 || opcion>3);
			
			entrada.nextLine();
			
			// Incializaci�n de datos:
			texto_codideco = "";      // Inicializo 'texto_codideco' con un valor vac�o.
			texto = "";               // Idem con 'texto'

			if (opcion==1) {
				System.out.println("Introduce el trozo de texto que deseas codificar:");
				texto = entrada.nextLine().trim();
			}
			else if (opcion==2) {
				System.out.println("Introduce el trozo de texto que deseas decodificar:");
				texto = entrada.nextLine().trim();			
			}
						
	 // PROCESAMIENTO DE DATOS
	 // ======================

			if (opcion==1 || opcion==2) {
				
				palabras = texto.split(" ");
				
				npalabras = palabras.length;  // N�mero de palabras en el vector.
				
				for (i=0; i<npalabras; i++) { // Este bucle iterar� por cada palabra.
					if (opcion==1) {
						for (j=0; j<palabras[i].length(); j++) {  // Y este otro itera por cada letra de cada una de esas palabras (opci�n 1).
							texto_codideco += (char)(Integer.valueOf(palabras[i].charAt(j))+1);  // Paso cada letra a ASCII, le sumo uno, y el resultado lo vuelvo a pasar a cadena. Esa cadena la sumo al acumulador 'texto_codificado'.
						}
					}
					else { // opci�n==2
						for (j=0; j<palabras[i].length(); j++) {  // Y este otro itera por cada letra de cada una de esas palabras (opci�n 2).
							texto_codideco += (char)(Integer.valueOf(palabras[i].charAt(j))-1);  // Paso cada letra a ASCII, le resto uno, y el resultado lo vuelvo a pasar a cadena. Esa cadena la sumo al acumulador 'texto_codificado'.
						}
					}
					if (i!=npalabras-1)
						texto_codideco += " ";  // Por cada palabra, a�ado un espacio (salvo la �ltima palabra).
				}				
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
				
				System.out.printf("\nEl resultado es %s", texto_codideco);
				
			} // Fin de 'if (opcion==1 || opcion==2)'
	
		} while (opcion!=3);  // Fin del 'do' inicial.
		
		System.out.println("\n�Gracias por utilizar el programa!");
		
		entrada.close();
	}
}