/*

MANEJO DE STRINGS 1.15
======================

OBJETIVO: 
	 El mismo ejercicio que el anterior pero que detecte automáticamente el formato en el que recibe y 
	 lo devuelva en el otro.
	 
OBSERVACIONES:
	- Considero el número de comas introducidas por el usuario, y si son más de una, mandaré un mensaje de error.
	- No controlo si el nombre es compuesto. Sólo admito nombres sin espacios (puedes poner Juanca, Marijose, etc.,
	  si te place).
	- Sin embargo, sí que considero un apellido compuesto (puedes tener todos los apellidos nobiliarios que te dé
	  la gana).
	- Sigo considerando 'melón' como neutral, aplicable tanto para el femenino como el masculino.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 1-dec-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE DETECTA FORMATO A CAMBIAR DE NOMBRE Y APELLIDOS Y VICEVERSA");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		String texto_introducido;  // Variable que almacena el texto introducido por el usuario.
		String apellidos_nombre;   // Variable que almacena los apellidos y nombrecon el formato "Apellido1 Apellido2, Nombre".
		String nombre_apellidos;   // Variable que almacena el nombre y apellidos con el formato "Nombre Apellido1 Apellido2".
		String [] nombre_completo; // Vector que contendrá el nombre en una posición y los apellidos en otra.
		int ncomas;                // Contador de comas ',' que se han introducido.
		boolean error;             // Mostrar o no mensaje de error y continuar o no el procesamiento de datos.
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		// Incialización de datos:
		error=false; // Presupondré que no habrá ningún error y al usuario no se le colará más de una coma.
		nombre_apellidos = "";
		apellidos_nombre = "";
		ncomas = 0;

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce los apellidos y el nombre separados por una coma o bien tu nombre y apellidos sin comas:");
		texto_introducido = entrada.nextLine().trim(); // Quito espacios innecesarios de principio y final.
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		for (int i=1; i<texto_introducido.length(); i++) { // Cuento el número de comas que ha introducido el usuario.
			if (texto_introducido.charAt(i)==',')
				ncomas++;
		}
		
		if (ncomas>1)   // Si hay más de una coma, lanzaré un mensaje de error y me ahorro el chorro de procesamiento que hay a continuación.
			error=true;
		
		if (!error) { // Sino hay error procedo:
			
			if (ncomas==1) {
				apellidos_nombre = texto_introducido;
				nombre_completo = apellidos_nombre.split(","); // Vector con nombre en posición 1 y apellidos en la 0.
				nombre_apellidos = nombre_completo[1].trim() + " " + nombre_completo[0]; // Quito el espacio que sobra al Nombre y lo añado entre éste y los apellidos.
			}
			else { // No hay comas:
				nombre_apellidos = texto_introducido;
				nombre_completo = nombre_apellidos.split(" ");	
				for (int i=1; i<nombre_completo.length; i++) {  // ¡Ojo! Empiezo por posición 1, ya que la 0 es el nombre.
					if (i<nombre_completo.length-1)
						apellidos_nombre += nombre_completo[i] + " ";
					else
						apellidos_nombre += nombre_completo[i]; // No le añado espacio al último apellido.
				}				
				apellidos_nombre += ", " + nombre_completo[0]; // Añado el nombre al final, separado por una coma y espacio.
			}
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (error)
			System.out.printf("\nHas introducido %d comas, ¡cuando te dije claramente una o ninguna! ¡so melón!.", ncomas);
		else
			if (ncomas==1)
				System.out.printf("\nEl nombre introducido es %s", nombre_apellidos);
			else
				System.out.printf("\nTu nombre ordenado de manera guay es '%s'.", apellidos_nombre);
		
	}
}