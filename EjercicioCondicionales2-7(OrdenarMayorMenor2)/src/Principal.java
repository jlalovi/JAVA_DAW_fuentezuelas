/*

Ejercicio 2.7 Condicionales
===========================

OBJETIVO:  Pedir dos números y mostrarlos ordenados de mayor a menor.

OBSERVACIÓN: El programa considera si los dos números son iguales.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA ORDENAR DOS NÚMEROS DE MAYOR A MENOR:");

	 // DELARACIÓN DE VARIABLES
	 // =======================
		
		int n1, n2;      // El programa considerará si dos números son iguales.
		int aux;         // Variable auxiliar para intercambiar números.
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
			mensaje = "Los números introducidos son iguales.";
		}
		else {
			if (n1<n2) {
				aux = n1;
				n1 = n2;
				n2 = aux;
			}
			mensaje = "Los números ordenados de mayor a menor son: " + n1 + " y " + n2 + ".";
		}

	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(mensaje);
		
	}

}