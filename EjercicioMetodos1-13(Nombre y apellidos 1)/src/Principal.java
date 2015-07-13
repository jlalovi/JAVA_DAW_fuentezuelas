/*

MANEJO DE STRINGS 1.13
======================

OBJETIVO: 
	 Programa que recibe  un nombre de persona en el formato �Apellidos, Nombre� y lo devuelve 
	 en el formato �Nombre Apellidos�. Ejemplo: Bail�n Garc�a, Eduardo -> Eduardo Bail�n Garc�a. 
	 En caso de haber m�s de una coma, devuelve un error.
	 
OBSERVACIONES:
	- Considero el n�mero de comas introducidas por el usuario. Ninguna, una o m�s de una.
	- Considero 'mel�n' como neutral, aplicable tanto para el femenino como el masculino.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 1-dec-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CAMBIA FORMATO 'APELLIDOS, NOMBRE'");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String apellidos_nombre;   // Variable que almacena los apellidos y nombre introducidos por el usuario con el formato "Apellido1 Apellido2, Nombre".
		String nombre_apellidos;   // Variable que almacena el nombre y apellidos con el formato "Nombre Apellido1 Apellido2".
		String [] nombre_completo; // Vector que contendr� el nombre en una posici�n y los apellidos en otra.
		int ncomas;                // Contador de comas ',' que se han introducido.
		boolean error;             // Mostrar o no mensaje de error y continuar o no el procesamiento de datos.
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incializaci�n de datos:
		error=false; // Presupondr� que no habr� ning�n error y el usuario incluir� una s�la coma.
		nombre_apellidos = "";
		ncomas = 0;

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce los apellidos y el nombre separados por una coma");
		apellidos_nombre = entrada.nextLine();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		for (int i=1; i<apellidos_nombre.length(); i++) {
			if (apellidos_nombre.charAt(i)==',')
				ncomas++;
		}
		
		if (ncomas!=1)
			error=true;
		
		if (!error) { // Sino hay error procedo:
			nombre_completo = apellidos_nombre.split(","); // Vector con nombre en posici�n 1 y apellidos en la 0.
			nombre_apellidos = nombre_completo[1].trim() + " " + nombre_completo[0]; // Quito el espacio que sobra al Nombre y lo a�ado entre �ste y los apellidos.
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (error)
			System.out.printf("\nHas introducido %d comas, �cuando te dije claramente una! �so mel�n!.", ncomas);
		else
			System.out.printf("\nEl nombre introducido es %s", nombre_apellidos);
		
	}
}