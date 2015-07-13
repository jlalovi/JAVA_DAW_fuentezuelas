/*

Ejercicio 1.3 Condicionales
===========================

OBJETIVO: Calcular media aritmética de 3 números.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA MOSTRAR LA MEDIA ARITMÉTICA DE 3 NÚMEROS:");
		
	 // DELARACIÓN DE VARIABLES
	 // =======================
		
		int n1, n2, n3;  // Variables que almacenan los tres números introducidos por el usuario.
		int media;       // Variable que almacenará la media de n1, n2 y n3.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("introduce el primer valor: ");
		n1 = entrada.nextInt();
		System.out.println("introduce el segundo valor: ");
		n2 = entrada.nextInt();
		System.out.println("introduce el tercer valor: ");
		n3 = entrada.nextInt();
		
		entrada.close();
			
	 // PROCESAMIENTO DE DATOS
	 // ======================

		media = (n1+n2+n3)/3;
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println("La media aritmética de los 3 valores introducidos es igual a " + media);
		
	}
}