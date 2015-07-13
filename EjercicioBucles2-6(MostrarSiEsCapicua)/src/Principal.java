/*

Ejercicio 2.6 Bucles
====================

OBJETIVO: Programa que le pide al usuario un n�mero(de una o m�s cifras), y muestra por pantalla si el
		  numero introducido es CAPICUA (se lee igual de inicio a fin que de fin a inicio).

OBSERVACION: Considero que un n�mero capic�a debe de tener 2 o m�s cifras.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 16-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI EL N�MERO INTRODUCIDO ES CAPIC�A");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int cifras;       // Variable donde almacenar� el dato introducido por el usuario.
		int [] cifra;     // Vector para almacenar cada una de las cifras de la varible 'cifras' de manera inversa.
		int resto;        // Cifra que voy obteniendo una a una en el bucle y almaceno en el vector.
		int i, j;         // Variables de control para las iteraciones.
		boolean capicua;  // Variable l�gica que me indicar� si el n�mero es capic�a o no.
		String mensaje;   // Mensaje a imprimir por pantalla al final del algoritmo.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		cifras = 0;
		resto = 0;
		cifra = new int[10];  // Inicializo un vector suficientemente grande como para almacenar una cifra de 10 d�gitos (El m�ximo que permite un int es 2,147,483,647).
		capicua = true;   // Presumire que el n�mero introducido es capic�a antes de pasar por las condiciones.
		
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Introduce un n�mero natural (mayor que 0):");
			cifras = entrada.nextInt();
		} while (cifras<0);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		i = -1; // Inicializo el contador 'i' en este caso particular, en el que i act�a como contador y marcador.
				// Lo inicializo con '-1' porque en java, los vectores empiezan en la posici�n 0.
		do {
			i = i + 1;   // Aqu� 'i' lo utilizo como contador que utilizar� en el siguiente bucle y como marcador de �ste.
			resto = cifras % 10;
			cifra[i] = resto; // Aqu� es donde 'i' me sirve como marcador de posici�n en este vector y bucle (empezando por i=0).			
			cifras = (cifras - resto) / 10; // No hace falta restar el 'resto', puesto que estamos con n�mero enteros. Pero opto por las buenas pr�cticas de futuro.
		} while (cifras!=0);
		
		if (i>1) {  // Considero que un n�mero puede ser capic�a si tiene m�s de una cifra.
			
			for (j=0; j<=i; j++) { 
				if (cifra[j]!=cifra[i-j]) {  // Compruebo la primera posici�n del vector con la �ltima, comprobando si son diferentes, e ir� aumentando y reduciendo ambas posiciones en el bucle.
					capicua = false;  // Al entrar en esta condici�n, aunque sea s�lo una vez, el n�mero NO es capic�a.
				}
			}
			
			if(capicua) {
				mensaje = "El n�mero es capic�a.";
			} else {
				mensaje = "El n�mero NO es capic�a.";
			}
			
		} else {
			mensaje = "�El n�mero introducido tiene una s�la cifra! Por tanto, no lo considero capic�a.";
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(mensaje);
		
	}
}