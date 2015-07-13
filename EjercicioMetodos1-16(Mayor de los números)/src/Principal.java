/*

MANEJO DE STRINGS 1.16
======================

OBJETIVO: 
	 Programa que admita una cadena con el siguiente formato (�12,23,45,65,78,23,12,23�) (damos por bueno que 
	 tendr� este formato, es decir, que el usuario lo ha introducido correctamente) y devuelva el  mayor de los
	 n�meros que va en la lista.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 1-dec-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE INDICA EL MAYOR DE LOS N�MEROS");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String numeros;   // N�meros introducidos por el usuario en este formato: "12,23,45,65,78,23,12,23"
		String [] numero; // Vector con cada uno de los n�meros introducidos.
		int mayor;        // El mayor de los n�meros introducidos
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce la cadena de n�meros con este formato 'n1,n2,n3,..'");
		numeros = entrada.nextLine();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		numero = numeros.split(",");
		mayor = Integer.parseInt(numero[0]); // Inicializo 'mayor' con el primer valor introducido.
		
		for (int i=0; i<numero.length; i++) { // Por si acaso el usuario ha introducido un s�lo n�mero, empiezo el bucle en 0.
			if (Integer.parseInt(numero[i])>mayor)
				mayor = Integer.parseInt(numero[i]);
		}
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("\nEl mayor de los n�meros introducidos es el %d", mayor);
		
	}
}