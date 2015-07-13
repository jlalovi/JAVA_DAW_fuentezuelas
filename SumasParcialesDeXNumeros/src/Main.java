import java.util.Scanner;

/*

Ejercicio 4 - Relación de Bucles 1
==================================

OBJETIVO: Programa que calcula la suma de los x primeros números naturales, imprimiendo en 
		  pantalla cada una de ellas (es decir, va imprimiendo las sumas parciales.)

OBSERVACIONES: - He establecido un límite entre 0 y 1000 para el número que se le pide al usuario, para
			     omitir los números negativos y establecer un tope no exageradamente alto.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 08-nov-2014

*/

public class Main {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		// ========================
		
		int tope;             // Constante en la que almaceno el tope de números que el usuario puede introducir en el bucle.
		int sumatorio;		  // Variables en la que voy almacenando el sumatorio de las sumas parciales.
		int i;				  // Contador para realizar iteraciones.

		// ASIGNACIÓN DE DATOS E IMPRESIONES DE PANTALLA
		// =============================================
		
		System.out.println("PROGRAMA QUE MUESTRA EL MAYOR DE 10 NÚMEROS INTRODUCIDOS POR EL USUARIO");
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Introduce el número de números naturales para la sucesión (entre 0 y 1000):");
			tope = entrada.nextInt();
		} 
		while (tope<0 || tope>1000);
		
		entrada.close();
		
		sumatorio = 0;        // Inicializo la variable sumatorio para que en la primera iteración sea 0.
		for (i=1; i<=tope; i++) {
			System.out.print(i+" + "+sumatorio+" = ");
			sumatorio = sumatorio + i;
			System.out.println(sumatorio);
		}
		
	}

}
