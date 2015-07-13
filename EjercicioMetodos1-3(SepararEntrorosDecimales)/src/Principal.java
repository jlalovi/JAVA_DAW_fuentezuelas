/*

MANEJO DE STRINGS 1.3
=====================

OBJETIVO: 
	Programa que reciba un número  y nos diga la cantidad de digitos enteros y la cantidad de decimales que tiene. 
	(ejemplo: 1234.37 -> 4 enteros y 2 decimales). Usando métodos de conversión y de strings).
	
OBSERVACIONES:
	- Considero los errores lógicos al introducir un número negativo.
	- También considerop los errores lógicos al introducir un número entero sin decimales.
	

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 25-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA EL NÚMERO DE ENTEROS Y DECIMALES DEL NÚMERO INTRODUCIDO");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		double decimal_num;        // Número introducido por el usuario.
		String decimal_text;       // Número transformado a cadena de texto.
		String [] decimal_parts;   // Separación de parte decimal y entera en un vector.
		int decimales;             // Número de decimales.
		int enteros;			   // Número de enteros.	

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un número");
		decimal_num = entrada.nextDouble();           // Si el número introducido es sólo entero, Java lo registra con un decimal igual a 0.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		decimal_text = String.valueOf(decimal_num);   // Convierto el número introducido en cadena.
		decimal_parts = decimal_text.split("\\.");
		
		if (decimal_parts[0].charAt(0)==('-'))        // Si la parte entera es negativa, no cuento el '-' como número entero.
			enteros = decimal_parts[0].length() - 1;
		else
			enteros = decimal_parts[0].length();
		
		if ( Integer.valueOf(decimal_parts[1])==0) {  // Si la parte decimal es = a 0, igualo 'decimales' a 0, sino, 'decimales', será el tamaño de la cadena correspondiente.
			decimales = 0;
		}
		else {
			decimales = decimal_parts[1].length();
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println();
		System.out.printf("El número de enteros es %d y el de decimales es %d", enteros, decimales);
		
	}
}