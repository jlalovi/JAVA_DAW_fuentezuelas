/*

Ejercicio 1.2 - Condicionales
=============================

OBJETIVO: Leer un valor num�rico, doblarlo, multiplicarlo por 25 y visualizar el resultado.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA PARA DOBLAR Y MULTIPLICAR POR 25 EL N�MERO INTRODUCIDO:");
		
	 // DELARACI�N DE VARIABLES
	 // =======================
		
		int n;             // Variable que almacena el n�mero que introduce el usuario para operar.
		int doblar;        // Variable donde almacenar� el n�mero 'n' x 2.
		int multiplicar25; // Variable donde almacenar� el n�mero 'n' x 25.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introdue el n�mero con el que quieres operar:");
		n = entrada.nextInt();
		
		entrada.close();
			
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		doblar = n * 2;
		multiplicar25 = n *25;		
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(n+" multiplicado por 2 es "+doblar);
		System.out.println(n+" multiplicado por 25 es "+multiplicar25);
			
	}

}

