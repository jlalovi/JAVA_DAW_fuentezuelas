/*

Ejercicio 1.11 Bucles
=====================

OBJETIVO: Programa que le pide al usuario un n�mero (0-1000) y calcula todos los divisores menores de este 
		  mismo n�mero, mostr�ndolos en pantalla.

OBSERVACI�N: Sabiendo que un n�mero primo s�lo es divisible por s� mismo y por 1, esto me dar� una pista 
			 para crear el condicional del final del programa.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 13-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE MUESTRA LA CANTIDAD DE DIVISORES Y NO DIVISORES DE UN N�MERO");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int tope;           // N�mero introducido por el usuario.
		int i;              // Variable de control para las iteraciones del bucle.
		int divisibles;     // Contador para conocer el n�mero de divisibles en el n�mero.
		int noDivisibles;   // Contador para conocer el n�mero de no divisibles en el n�mero.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Inicializaci�n de datos
		divisibles = 0;
		noDivisibles = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un n�mero del 0 al 1.000.000 para conocer sus divisibles:");
			tope = entrada.nextInt();
		} while (tope<0 || tope>1_000_000);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		for (i=1; i<=tope; i++) {
			if (tope%i==0) {
				divisibles = divisibles + 1;
			} 
			{
				noDivisibles = noDivisibles + 1;
			}
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println("En total, " + tope + " tiene " + divisibles + " n�meros divisibles y " 
						   + noDivisibles + " n�meros no divisibles.");

		if (divisibles == 2) {
			System.out.println(tope + " es un n�mero primo.");
		}
		else {
			System.out.println(tope + " NO es un n�mero primo.");
		}
		
	}
}








