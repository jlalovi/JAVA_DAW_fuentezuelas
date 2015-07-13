/*

MANEJO DE STRINGS 1.14
======================

OBJETIVO: 
	 El mismo ejercicio que el n� anterior pero a la inversa.
	 
OBSERVACIONES:
	- No controlo si el nombre es compuesto. S�lo admito nombres sin espacios (puedes poner Juanca, Marijose, etc.,
	  si te place).
	- Sin embargo, s� que considero un apellido compuesto (puedes tener todos los apellidos nobiliarios que te d�
	  la gana).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 1-dec-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE CAMBIA FORMATO 'NOMBRE APELLIDOS'");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String apellidos_nombre;   // Variable que almacena los apellidos y nombre con el formato "Apellido1 Apellido2, Nombre".
		String nombre_apellidos;   // Variable que almacena el nombre y apellidos con el formato "Nombre Apellido1 Apellido2".
		String [] nombre_completo; // Vector que contendr� el nombre en una posici�n y los apellidos en otra.
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incializaci�n de datos:
		apellidos_nombre = "";

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el nombre y los apellidos (si tu nombre es compuesto, escr�belo sin espacios)");
		nombre_apellidos = entrada.nextLine().trim();  // Quito posibles espacios al principio y al final de lo que introduzca el usuario.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		nombre_completo = nombre_apellidos.split(" ");
		
		for (int i=1; i<nombre_completo.length; i++) {  // �Ojo! Empiezo por posici�n 1, ya que la 0 es el nombre.
			if (i<nombre_completo.length-1)
				apellidos_nombre += nombre_completo[i] + " ";
			else
				apellidos_nombre += nombre_completo[i]; // No le a�ado espacio al �ltimo apellido.
		}
		
		apellidos_nombre += ", " + nombre_completo[0]; // A�ado el nombre al final, separado por una coma y espacio.
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("\nTu nombre ordenado de manera guay es '%s'.", apellidos_nombre);
		
	}
}