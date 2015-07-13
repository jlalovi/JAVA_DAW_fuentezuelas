/*

Ejercicio 1.3 - Bucles
======================

OBJETIVO: Programa que calcula la suma de los 100 primeros números naturales, imprimiendo en 
		  pantalla cada una de ellas (es decir, va imprimiendo las sumas parciales.)

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE CALCULA LAS SUMAS PARCIALES DE LOS 100 PRIMEROS NÚMEROS");
		
	 // DECLARACIÓN DE VARIABLES
	 // ========================
		
		int tope=100;         // Variable en la que almaceno el tope de números (100).
		int sumatorio;		  // Variables en la que voy almacenando el sumatorio de las sumas parciales.
		int i;				  // Contador para realizar iteraciones.

	 // PROCESO E IMPRESIÓN POR PANTALLA
	 // ================================
		
		sumatorio = 0;        // Inicializo la variable sumatorio para que en la primera iteración sea 0.
		for (i=1; i<=tope; i++) {
			System.out.print(i+" + "+sumatorio+" = ");
			sumatorio = sumatorio + i;
			System.out.println(sumatorio);
		}
		
	}

}
