/*

MANEJO DE STRINGS 1.5
=====================

OBJETIVO: 
	Programa que cuente  el n�mero de vocales y el n�mero de consonantes de un texto dado por el 
	usuario (teniendo en cuenta que pueden ser vocales acentuadas).
	
OBSERVACI�N:
	- Contemplo may�sculas y min�sculas.
	- El ejercicio cuenta el resto de caract�res como consonantes. Habr�a que establecer condiciones 
	  basadas en el c�digo ASCII itilizando 'Integer.valueOf' para s�mbolos y n�meros.
	- Contemplo las vocales acentuadas, pero NO otro tipo de acentos ni di�resis, etc.
	
AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 29-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CUENTA VOCALES Y CONSONANTES");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String texto;             // Texto introducido por el usuario.
		int longitud;             // Longitud de la cadena introducida por el usuario.
		int vocales, consonantes; // N�mero de vocales y consonantes en el texto introducido.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		vocales = 0;      //
		consonantes = 0;  // Empiezo presumiendo que no hay vocales ni consonantes en el texto que se introducir�.
		
		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce un trozo de texto:");
		texto = entrada.nextLine().trim();  // Voy a empezar a crear esta buena pr�ctica de eliminar espacios al principio y al final.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		longitud = texto.length();  // Cuento los caracteres del texto introducido.
		
		texto = texto.toLowerCase(); // Paso todas las letras introducidas a min�scula.
		
		for (int i=0; i<=longitud-1; i++) {
			if (texto.charAt(i)=='a' || texto.charAt(i)=='e' || texto.charAt(i)=='i' ||
				texto.charAt(i)=='o' || texto.charAt(i)=='u' || texto.charAt(i)=='�' ||
				texto.charAt(i)=='�' || texto.charAt(i)=='�' || texto.charAt(i)=='�' ||
				texto.charAt(i)=='�') {
				vocales++;
			}
			else
				consonantes++;
		}		
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("El texto introducido tiene %d vocales y %d consonantes.", vocales, consonantes);
		
	}
}