/*

Ejercicio 1.11 Bucles
=====================

OBJETIVO: Programa que le pide al usuario un número (0-1000) y calcula todos los divisores menores de este 
		  mismo número, mostrándolos en pantalla.

OBSERVACIÓN: Sabiendo que un número primo sólo es divisible por sí mismo y por 1, esto me dará una pista 
			 para crear el condicional del final del programa.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 13-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE MUESTRA LA CANTIDAD DE DIVISORES Y NO DIVISORES DE UN NÚMERO");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int tope;           // Número introducido por el usuario.
		int i;              // Variable de control para las iteraciones del bucle.
		int divisibles;     // Contador para conocer el número de divisibles en el número.
		int noDivisibles;   // Contador para conocer el número de no divisibles en el número.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Inicialización de datos
		divisibles = 0;
		noDivisibles = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un número del 0 al 1.000.000 para conocer sus divisibles:");
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

		System.out.println("En total, " + tope + " tiene " + divisibles + " números divisibles y " 
						   + noDivisibles + " números no divisibles.");

		if (divisibles == 2) {
			System.out.println(tope + " es un número primo.");
		}
		else {
			System.out.println(tope + " NO es un número primo.");
		}
		
	}
}








