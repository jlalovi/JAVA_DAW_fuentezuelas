/*

Ejercicio 2.5 Bucles
====================

OBJETIVO: Escribe un programa que dado un número entero lo descomponga dígito a dígito, lo vuelva a
		  componer al revés y lo muestre. Por ejemplo: si le datos el número 187365, el programa 
		  mostrará 563781.

OBSERVACION: Considero que un número capicúa debe de tener 2 o más cifras.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 16-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE INVIERTE LAS CIFRAS DEL VALOR INTRODUCIDO");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int cifras;       // Variable donde almacenaré el dato introducido por el usuario.
		int [] cifra;     // Vector para almacenar cada una de las cifras de la varible 'cifras' de manera inversa.
		int resto;        // Cifra que voy obteniendo una a una en el bucle y almaceno en el vector.
		int i, j;         // Variables de control para las iteraciones.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		cifras = 0;
		resto = 0;
		cifra = new int[10];  // Inicializo un vector suficientemente grande como para almacenar una cifra de 10 dígitos (más de lo que permite un tipo 'int').
		
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Introduce un número natural (mayor que 0):");
			cifras = entrada.nextInt();
		} while (cifras<0);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		i = 0; // Inicio la variable de iteración antes de comenzar el bucle.
		do { // Como no conozco el tope, utilizaré este tipo de bucle.
			resto = cifras % 10;
			cifra[i] = resto; //
			i = i + 1;   // Aquí 'i' lo utilizo como contador de este bucle. + 1 por cada iteración. (También me servirá como tope del siguiente bucle)
			cifras = (cifras - resto) / 10; // No hace falta restar el 'resto', puesto que estamos con número enteros. Pero opto por las buenas prácticas de futuro.
		} while (cifras!=0);
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.print("La cifra a la inversa es: ");
		for (j=0; j<=i-1; j++) {
			System.out.print(cifra[j]);
		}
		
	}
}