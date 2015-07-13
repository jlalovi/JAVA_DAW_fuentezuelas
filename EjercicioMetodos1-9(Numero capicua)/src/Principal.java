/*

MANEJO DE STRINGS 1.9
=====================

OBJETIVO: Programa pregunte un n�mero entero positivo y nos diga si el n�mero es capic�o.

OBSERVACI�NES: 
	- Se mostrar� un mensaje de error si existe alg�n signo diferente a n�mero.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI EL N�MERO INTRODUCIDO ES CAPIC�A");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int longitud;           // N�mero de caracteres que contiene el n�mero introducido por el usuario.
		String numero;		    // N�mero introducido por el usuario y guardado en una cadena.
		String numero_inverso;  // Variable que contendr� el n�mero invertido en otra cadena.
		boolean capicua;        // Capicua V o F.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incializaci�n de datos:
		capicua = true;  // Presupondr� que el n�mero que va a ser introducido ser� capic�a.		

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce un n�mero");
		numero = entrada.nextLine();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		longitud = numero.length();
		
		for (int i=0; i<=longitud-1; i++) {
			if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
				capicua = false;
				System.out.printf("El car�cter %s NO es un n�mero\n", numero.charAt(i));
			}
		}
		
		if (capicua) {
			numero_inverso = "";  // Inicializo esta variable con un valor vac�o.
			for (int i=0; i<=longitud-1; i++) {
				numero_inverso += numero.charAt(longitud-1-i);
			}
			if (!numero_inverso.equals(numero))  // Recordar que las malditas cadenas se comparan con m�todos!!
				capicua = false;
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (capicua)
			System.out.println("El n�mero es capic�a");
		else 
			System.out.println("El n�mero introducido NO es capic�a.");
		
	}
}