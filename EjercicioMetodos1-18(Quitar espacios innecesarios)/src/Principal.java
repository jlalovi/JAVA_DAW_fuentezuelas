/*

MANEJO DE STRINGS 1.17
======================

OBJETIVO: 
	 Programa que recibe un texto e imprime el mismo texto pero eliminando los espacios innecesarios, si los hay.
	 Ejemplo( � hola     D.    Pepito         hola         D.       Jos� = �hola D. Pepito hola D. Jos�).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 1-dec-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE ELIMINA ESPACIOS INNECESARIOS");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String texto;       // Texto introducido por el usuario.
		String [] vtexto;   // Vector que contiene cada una de las palabras del texto.
		String nuevo_texto; // Texto resultante del proceso de eliminaci�n de espacios.
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Inicializaci�n de variables.
		nuevo_texto = " ";
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el texto con todos los espacios que te d� la gana:");
		texto = entrada.nextLine().trim();

		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		vtexto = texto.split(" "); // Separo las palabras por espacios (aunque seguir�n quedando los espacios redundantes)

		for (int i=0; i<vtexto.length; i++) {
			if (!(vtexto[i].trim().equals("")))  // Si la posici�n que estoy iterando le quito todos los espacios y resulta vac�a, la ignoro.
				nuevo_texto += vtexto[i].trim() + " "; // Quito los espacios que rodean a cada palabra.
		}		
		
		nuevo_texto = nuevo_texto.trim(); // Quito el �ltimo espacio que me sobra.
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(nuevo_texto);
		
	}
}