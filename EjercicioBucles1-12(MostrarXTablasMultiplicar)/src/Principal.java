/*

Ejercicio 1.12 Bucles
=====================

OBJETIVO: Programa que imprime la tabla de multiplicar (hasta el 10) de un intervalo introducido por un usuario.

OBSERVACIONES: - Permito introducir tablas de multiplicar del 0 al 50, para evitar mostrar por pantalla una gran cantidad de tablas.
			   - Obligo al usuario a introducir un valor para 'tabla2' superior o igual al de 'tabla1'.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 13-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA EL INTERVALO DE TABLAS DE MULTIPLICAR ELEGIDAS POR EL USUARIO");
		
	 // DELARACIÓN DE VARIABLES
	 // =======================

	    byte tope;            // Variable constante para número de multiplicaciones a mostrar.
	    byte i, j;            // Variables de control para las iteraciones de los bucles.
	    int resultado;        // Operaciones de cada una de las tablas realizadas dentro de los bucles.
	    byte tabla1, tabla2;  // Estos valores introducidos por el usuario comprenderán el intervalo de tablas a mostrar.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:	
	    tope = 10;   // Cada tabla de multiplicar multiplicará hasta el 10.
	    tabla1=0;
	    tabla2=0;
	    resultado=0;

		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println ("Introduce el valor de la primera tabla (entre 0 y 50): ");
			tabla1 = entrada.nextByte();
		} while (tabla1<0 || tabla1>50);

		do {
			System.out.println ("Introduce el valor de la segunda tabla (entre " + tabla1 +" y 50):");
			tabla2 = entrada.nextByte();
		} while (tabla2<tabla1 || tabla2>50);
		
		entrada.close();

	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		for (j=tabla1; j<=tabla2; j++) {
			System.out.println("\nTABLA DEL " + j + ":");
			System.out.println("============");
			for (i=0; i<=tope; i++) {
				resultado = i*j;
				System.out.println(j + " x " + i + " = " + resultado);
			}
		}
		
	}
}








