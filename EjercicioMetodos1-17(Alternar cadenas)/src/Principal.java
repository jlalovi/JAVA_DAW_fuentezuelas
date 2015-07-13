/*

MANEJO DE STRINGS 1.17
======================

OBJETIVO: 
	 Programa que pregunte dos cadenas de caracteres  e imprime una cadena que haya mezclado las palabras de las 
	 dos cadenas, tomado de forma alternante palabras de una y de otra.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 1-dec-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE ALTERNA LAS PALABRAS DEL TEXTO 1 CON EL 2 FORMANDO UN NUEVO TEXTO");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		String texto1;      // Texto 1 introducido por el usuario.
		String [] vtexto1;  // Vector que contiene cada una de las palabras del texto 1.
		String texto2;      // Texto 2 introducido por el usuario.
		String [] vtexto2;  // Vector que contiene cada una de las palabras del texto 2.
		String nuevo_texto; // Texto resultante de la combinación de los dos anteriores.
		int longitudv1;     // Longitud del vector 1.
		int longitudv2;     // Longitud del vector 2.
		int i, j;           // Variable de iteración.
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Inicialización de variables.
		nuevo_texto = " ";
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el texto 1:");
		texto1 = entrada.nextLine().trim();
		System.out.println("Introduce el texto 2:");
		texto2 = entrada.nextLine().trim();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		vtexto1 = texto1.split(" ");
		vtexto2 = texto2.split(" ");
		
		longitudv1 = vtexto1.length;
		longitudv2 = vtexto2.length;
		
		if (longitudv1<=longitudv2) {
			for (i=0; i<longitudv1; i++) {
				nuevo_texto += vtexto1[i] + " ";
				nuevo_texto += vtexto2[i] + " ";
			}
			for (j=i+1; j<longitudv2; j++) {
				nuevo_texto += vtexto2[i] + " ";
			}
		}
		else {
			for (i=0; i<longitudv2; i++) {
				nuevo_texto += vtexto1[i] + " ";
				nuevo_texto += vtexto2[i] + " ";
			}
			for (j=i+1; j<longitudv1; j++) {
				nuevo_texto += vtexto1[i] + " ";
			}
		}
		
		nuevo_texto = nuevo_texto.trim(); // Quito el espacio que me sobra.
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(nuevo_texto);
		
	}
}