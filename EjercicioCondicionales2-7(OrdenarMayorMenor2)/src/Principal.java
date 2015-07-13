/*

Ejercicio 2.7 Condicionales
===========================

OBJETIVO:  Pedir dos n�meros y mostrarlos ordenados de mayor a menor.

OBSERVACI�N: El programa considera si los dos n�meros son iguales.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA ORDENAR DOS N�MEROS DE MAYOR A MENOR:");

	 // DELARACI�N DE VARIABLES
	 // =======================
		
		int n1, n2;      // El programa considerar� si dos n�meros son iguales.
		int aux;         // Variable auxiliar para intercambiar n�meros.
		String mensaje;  // Mensaje para imprimir por pantalla.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el primer valor:");
		n1 = entrada.nextInt();
		System.out.println("Introduce el segundo valor:");
		n2 = entrada.nextInt();
		
		entrada.close();
		
	 // PROCESAMIENTO DE DATOS
	 // ======================

		if (n2==n1) {
			mensaje = "Los n�meros introducidos son iguales.";
		}
		else {
			if (n1<n2) {
				aux = n1;
				n1 = n2;
				n2 = aux;
			}
			mensaje = "Los n�meros ordenados de mayor a menor son: " + n1 + " y " + n2 + ".";
		}

	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(mensaje);
		
	}

}