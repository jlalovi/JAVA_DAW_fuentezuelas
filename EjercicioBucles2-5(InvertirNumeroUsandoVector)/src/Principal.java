/*

Ejercicio 2.5 Bucles
====================

OBJETIVO: Escribe un programa que dado un n�mero entero lo descomponga d�gito a d�gito, lo vuelva a
		  componer al rev�s y lo muestre. Por ejemplo: si le datos el n�mero 187365, el programa 
		  mostrar� 563781.

OBSERVACION: Considero que un n�mero capic�a debe de tener 2 o m�s cifras.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 16-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE INVIERTE LAS CIFRAS DEL VALOR INTRODUCIDO");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int cifras;       // Variable donde almacenar� el dato introducido por el usuario.
		int [] cifra;     // Vector para almacenar cada una de las cifras de la varible 'cifras' de manera inversa.
		int resto;        // Cifra que voy obteniendo una a una en el bucle y almaceno en el vector.
		int i, j;         // Variables de control para las iteraciones.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		cifras = 0;
		resto = 0;
		cifra = new int[10];  // Inicializo un vector suficientemente grande como para almacenar una cifra de 10 d�gitos (m�s de lo que permite un tipo 'int').
		
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Introduce un n�mero natural (mayor que 0):");
			cifras = entrada.nextInt();
		} while (cifras<0);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		i = 0; // Inicio la variable de iteraci�n antes de comenzar el bucle.
		do { // Como no conozco el tope, utilizar� este tipo de bucle.
			resto = cifras % 10;
			cifra[i] = resto; //
			i = i + 1;   // Aqu� 'i' lo utilizo como contador de este bucle. + 1 por cada iteraci�n. (Tambi�n me servir� como tope del siguiente bucle)
			cifras = (cifras - resto) / 10; // No hace falta restar el 'resto', puesto que estamos con n�mero enteros. Pero opto por las buenas pr�cticas de futuro.
		} while (cifras!=0);
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.print("La cifra a la inversa es: ");
		for (j=0; j<=i-1; j++) {
			System.out.print(cifra[j]);
		}
		
	}
}