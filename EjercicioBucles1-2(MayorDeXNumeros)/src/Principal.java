/*

Ejercicio 1.2 - Bucles
======================

OBJETIVO: Programa que pide x n�meros al usuario y calcula el valor m�ximo de entre ellos.

OBSERVACI�N: Obligo al usuario a introducir un valor entre 2 y 50 para el tope de n�meros
 			 a comparar.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 08-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE MUESTRA EL MAYOR DE X N�MEROS INTRODUCIDOS POR EL USUARIO");

	 // DECLARACI�N DE VARIABLES
	 // ========================
		
		byte tope;       // Variable en la que almaceno el tope de n�meros que el usuario puede introducir en el bucle.
		int numero;	     // N�mero introducido por el usuario en cada iteraci�n del bucle.
		int mayor;       // Variable que comparar� los n�meros introducidos por el usuario para almacenar el mayor.
		int menor;		 // "", pero el menor.
		int i;			 // Contador para realizar iteraciones.
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Introduce el n�mero de valores (entre 2 y 50) que quieres comparar: ");
			tope = entrada.nextByte();
		} while (tope<2 || tope>50);  // Obligo al usuario a introducir un valor entre 2 y 50.
		
		entrada.close();
		
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		mayor = 0;   // Al parecer tengo que inicializar esta variable para poder compilar.
		menor = 0;   // ""
		for (i=1; i<=tope; i++) {
			System.out.println("Introduce el n�mero " +i );
			numero = entrada.nextInt();
			if (i==1) {
				mayor = numero;
				menor = numero;
			}
			else if (numero>mayor) {
				mayor = numero;
			}
			else if (numero<menor) {
				menor = numero;
			}
		}
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println("El mayor de los "+tope+" n�meros introducidos es el "+mayor+"y el menor es el"+menor);

	}

}
