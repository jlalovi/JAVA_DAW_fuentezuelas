import java.util.Scanner;

/*

Ejercicio 4 - Relaci�n de Bucles 1
==================================

OBJETIVO: Programa que calcula la suma de los x primeros n�meros naturales, imprimiendo en 
		  pantalla cada una de ellas (es decir, va imprimiendo las sumas parciales.)

OBSERVACIONES: - He establecido un l�mite entre 0 y 1000 para el n�mero que se le pide al usuario, para
			     omitir los n�meros negativos y establecer un tope no exageradamente alto.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 08-nov-2014

*/

public class Main {

	public static void main(String[] args) {
		
		// DECLARACI�N DE VARIABLES
		// ========================
		
		int tope;             // Constante en la que almaceno el tope de n�meros que el usuario puede introducir en el bucle.
		int sumatorio;		  // Variables en la que voy almacenando el sumatorio de las sumas parciales.
		int i;				  // Contador para realizar iteraciones.

		// ASIGNACI�N DE DATOS E IMPRESIONES DE PANTALLA
		// =============================================
		
		System.out.println("PROGRAMA QUE MUESTRA EL MAYOR DE 10 N�MEROS INTRODUCIDOS POR EL USUARIO");
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Introduce el n�mero de n�meros naturales para la sucesi�n (entre 0 y 1000):");
			tope = entrada.nextInt();
		} 
		while (tope<0 || tope>1000);
		
		entrada.close();
		
		sumatorio = 0;        // Inicializo la variable sumatorio para que en la primera iteraci�n sea 0.
		for (i=1; i<=tope; i++) {
			System.out.print(i+" + "+sumatorio+" = ");
			sumatorio = sumatorio + i;
			System.out.println(sumatorio);
		}
		
	}

}
