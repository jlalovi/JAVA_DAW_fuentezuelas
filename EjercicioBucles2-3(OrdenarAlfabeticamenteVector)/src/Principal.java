/*

Ejercicio 2.5 Bucles
====================

OBJETIVO: Programa capaz de ordenar un n�mero de cadenas previamente introducidos por teclado. Pide al usuario cuantas 
		  cadenas se desean ordenar, despu�s solicita la introducci�n de dichass cadenas y finalmente los muestra ordenados 
		  alfab�ticamente.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 13-nov-2014

*/

import java.util.Scanner;

@SuppressWarnings("unused")
public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE ORDENA ALFAB�TICAMENTE CADENAS INDICADAS POR USUARIO Y LOS ORDENA");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int tope;        // 'N' n�meros a ordenar introducidos por el usuario.
		int i, j;        // Primera variable de control para las iteraciones del bucle.
		String aux;      // Variable auxiliar para hacer intercambios de valores.
		boolean salida;  // Variable para segundo m�todo. Sale del bucle 'repetir', sino hay cambios.
		String[] cadena; // Variable para almacenar el n�mero mayor de todos los introducidos.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		tope=0;
		aux="";
		
		Scanner entrada = new Scanner(System.in);

		// Pedir al usuario el n�mero de n�meros que quiere ordenar.
		do {
			System.out.println ("\nIntroduce cu�ntas cadenas deseas ordenar (entre 1 y 100): ");
			tope = entrada.nextInt();
		} while (tope<1 || tope>100);

		cadena = new String [tope]; // Inicializo el vector 'cadena[]' a partir del tope introducido por el usuario.
		
		// Pedir uno a uno las cadenas que ir�n almacenados en el vector.
		for (i=0; i<tope; i++) {
			System.out.printf("\nIntroduce la cadena n�mero " +  (i+1) + ": ");
			cadena[i] = entrada.next();
		}
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		do {
			salida = true;                   // Empiezo 'salida' con un valor true, para salir del bucle 'repetir' si el bucle 'desde' no sufre ning�n cambio en el condicional.
			for (i=0; i<tope-1; i++) {       // Por que en el bucle estoy comparando parejas ('i' e 'i+1')
				if (cadena[i].compareToIgnoreCase(cadena[i+1])>0) { // compareToIgnoreCase da 3 valores -1 si es menor (cadena[i]<cadena[i+1]), 0 si son iguales (cadena[i]==cadena[i+1]) y 1 si es mayor (cadena[i]>cadena[i+1]).
					aux = cadena[i];
					cadena[i] = cadena[i+1];
					cadena[i+1] = aux;
					salida = false;          // En la primera pasada, se comprueban todos los pares. Si existe un cambio dentro del condicional, 
				}					         // el valor de 'salida' ser� NO, por lo que al salir del bucle 'desde' se iniciar� de nuevo el bucle 'repetir'.
			}
		} while (!salida);
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println ("Los n�meros ordenados de menor a mayor son:");
		for (i=0; i<tope; i++) {
			System.out.print(" " + cadena[i]);
		}
		
	}
}