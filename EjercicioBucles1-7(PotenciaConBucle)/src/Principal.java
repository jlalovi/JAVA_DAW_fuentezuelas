/*

Ejercicio 1.7 Bucles
====================

OBJETIVO: Programa que te calcula la potencia de un número introduciendo el número base y el exponente (con bucle).

OBSERVACIÓN: Considero que el usuario introduce números enteros en el exponente y la base.
			 No permito introducir un exponente menor que 0.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 13-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE CALCULA LA PPOTENCIA CONOCIENDO BASE Y EXPONENTE:");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int base, exponente;     // Datos introducidos por el usuario.
		int resultado;           // Resultado de la potencia.
		int i;                   // Variable para iterar en el bucle.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		// Inicialización de variables:
		resultado = 1; // Por si el exponente es igual a 0, el bucle NO se iniciará.
		base = 0;
		exponente = 0;
		
		System.out.println("Introduce el valor de la base:");
		base = entrada.nextInt();
		
		System.out.println("Introduce el valor del exponente:");
		do {
			exponente = entrada.nextInt();
			if (exponente<0) {
				System.out.println("Por favor, introduce un exponente igual o mayor a 0.");
			}
		} while (exponente<=0);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		for (i=1; i<=exponente; i++ ) {
			resultado *= base;  // resultado = resultado * base
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println("La potencia del número introducido es " + resultado);

	}
}








