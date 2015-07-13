/*

MANEJO DE STRINGS 1.9
=====================

OBJETIVO: Programa pregunte un número entero positivo y nos diga si el número es capicúo.

OBSERVACIÓNES: 
	- Se mostrará un mensaje de error si existe algún signo diferente a número.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI EL NÚMERO INTRODUCIDO ES CAPICÚA");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int longitud;           // Número de caracteres que contiene el número introducido por el usuario.
		String numero;		    // Número introducido por el usuario y guardado en una cadena.
		String numero_inverso;  // Variable que contendrá el número invertido en otra cadena.
		boolean capicua;        // Capicua V o F.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incialización de datos:
		capicua = true;  // Presupondré que el número que va a ser introducido será capicúa.		

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce un número");
		numero = entrada.nextLine();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		longitud = numero.length();
		
		for (int i=0; i<=longitud-1; i++) {
			if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
				capicua = false;
				System.out.printf("El carácter %s NO es un número\n", numero.charAt(i));
			}
		}
		
		if (capicua) {
			numero_inverso = "";  // Inicializo esta variable con un valor vacío.
			for (int i=0; i<=longitud-1; i++) {
				numero_inverso += numero.charAt(longitud-1-i);
			}
			if (!numero_inverso.equals(numero))  // Recordar que las malditas cadenas se comparan con métodos!!
				capicua = false;
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (capicua)
			System.out.println("El número es capicúa");
		else 
			System.out.println("El número introducido NO es capicúa.");
		
	}
}