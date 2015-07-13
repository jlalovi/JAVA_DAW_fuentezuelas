/*

Ejercicio 2.6 Bucles
====================

OBJETIVO: Programa que le pide al usuario un número(de una o más cifras), y muestra por pantalla si el
		  numero introducido es CAPICUA (se lee igual de inicio a fin que de fin a inicio).

OBSERVACION: Considero que un número capicúa debe de tener 2 o más cifras.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 16-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI EL NÚMERO INTRODUCIDO ES CAPICÚA");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int cifras;       // Variable donde almacenaré el dato introducido por el usuario.
		int [] cifra;     // Vector para almacenar cada una de las cifras de la varible 'cifras' de manera inversa.
		int resto;        // Cifra que voy obteniendo una a una en el bucle y almaceno en el vector.
		int i, j;         // Variables de control para las iteraciones.
		boolean capicua;  // Variable lógica que me indicará si el número es capicúa o no.
		String mensaje;   // Mensaje a imprimir por pantalla al final del algoritmo.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		cifras = 0;
		resto = 0;
		cifra = new int[10];  // Inicializo un vector suficientemente grande como para almacenar una cifra de 10 dígitos (El máximo que permite un int es 2,147,483,647).
		capicua = true;   // Presumire que el número introducido es capicúa antes de pasar por las condiciones.
		
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Introduce un número natural (mayor que 0):");
			cifras = entrada.nextInt();
		} while (cifras<0);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		i = -1; // Inicializo el contador 'i' en este caso particular, en el que i actúa como contador y marcador.
				// Lo inicializo con '-1' porque en java, los vectores empiezan en la posición 0.
		do {
			i = i + 1;   // Aquí 'i' lo utilizo como contador que utilizaré en el siguiente bucle y como marcador de éste.
			resto = cifras % 10;
			cifra[i] = resto; // Aquí es donde 'i' me sirve como marcador de posición en este vector y bucle (empezando por i=0).			
			cifras = (cifras - resto) / 10; // No hace falta restar el 'resto', puesto que estamos con número enteros. Pero opto por las buenas prácticas de futuro.
		} while (cifras!=0);
		
		if (i>1) {  // Considero que un número puede ser capicúa si tiene más de una cifra.
			
			for (j=0; j<=i; j++) { 
				if (cifra[j]!=cifra[i-j]) {  // Compruebo la primera posición del vector con la última, comprobando si son diferentes, e iré aumentando y reduciendo ambas posiciones en el bucle.
					capicua = false;  // Al entrar en esta condición, aunque sea sólo una vez, el número NO es capicúa.
				}
			}
			
			if(capicua) {
				mensaje = "El número es capicúa.";
			} else {
				mensaje = "El número NO es capicúa.";
			}
			
		} else {
			mensaje = "¡El número introducido tiene una sóla cifra! Por tanto, no lo considero capicúa.";
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(mensaje);
		
	}
}