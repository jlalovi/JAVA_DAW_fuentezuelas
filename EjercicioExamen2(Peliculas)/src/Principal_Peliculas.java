/*

Ejercicio 2 - Examen
====================

OBJETIVO:

	Realizar para almacenar en memoria y tratar posteriormente datos relativos a una colección de películas . 
	Para cada película se debe pedir al usuario: título de la película, género (debe ser –hay que controlarlo- 
	un valor entre los siguientes: T- terror, D-drama, C-comedia), duración en minutos (debe ser un valor entre 
	45 y 180) y nombre del director. Antes de empezar a pedir películas se pedirá al usuario la cantidad de 
	películas de que consta la colección (no podrán ser más de 100) Una vez pedidas las películas, se mostrará 
	al usuario un menú con las opciones : 1-buscar películas por género, 2- buscar películas por duración, 
	3-salir. En caso de que se seleccione 1, se pedirá al usuario el género deseado (T/D/C) y se mostrarán en
	pantalla una lista con todos los datos de las películas de ese género, diciendo al final el número de 
	películas encontradas. En caso de que se selecciones 2, se pedirá al usuario la duración máxima deseada y 
	se mostrarán (todos los datos de cada película) todas las que su duración sea menor o igual a la introducidas 
	(y al final el número de películas listadas). Si se elije 3, obviamente, el programa acaba.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 18-nov-2014

*/

import java.util.Scanner;

public class Principal_Peliculas {

	public static void main(String[] args) {

		System.out.println("ESTE PROGRAMA ALMACENA UNA SERIE DE DATOS SOBRE PELÍCULAS Y TRABAJA CON ELLOS");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		String [] titulo;      // Título de la película.
		String [] genero;      // Tipo de género (Terror, Drama y Comedia).
		String [] autor;       // Nombre del autor.
		int [] duracion;       // Duración de la pelígula (entre 45 y 180 minutos).
		int tope;              // Número de películas que el usuario quiere guardar.
		int i;				   // Variable de iteración.
		int contador;          // Acumulador que me servirá para contar iteraciones.
		int opcion;            // Opción a elegir en el menú.
		String opcionG;        // Opción para género en menú.
		int opcionD;           // Opción para duración en menú.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);

		// Pido el número de películas que el usuario quiere registrar para inicializar el tamaño de los vectores.
		System.out.println("¿Cuántas películas deseas introducir?");
		do {
			tope = entrada.nextInt();
			if (tope<=0) {
				System.out.println("Por favor, introduce un número positivo de películas y al menos una: ");
			}
		} while (tope<=0);
		
		titulo = new String[tope];
		genero = new String[tope];
		autor = new String[tope];
		duracion = new int[tope];
		
		// Creo la 'Base de Datos' de películas a partir de los datos introducidos por el usuario.
		for (i=0; i<tope; i++) {  // En cada iteración de este bucle, pediré el título, género, autor y duración.

			entrada.nextLine(); // Limpio el buffer del Scanner para la lectura de las siguientes cadenas
			
			// TÍTULO
			System.out.printf("\nIntroduce el título de la película %d: ", i+1);
			titulo[i] = entrada.nextLine();
			if (titulo[i]=="") {  // Obligo al usuario a introducir un título.
				do {
					System.out.println("Por favor introduce un título:");
					titulo[i] = entrada.nextLine();
				} while (titulo[i]=="");
			}

			// GÉNERO
			System.out.printf("\nIntroduce el genero de la película %d: (T)error, (D)rama o (C)omedia: ", i+1);
			genero[i] = entrada.nextLine();
			genero[i] = genero[i].toUpperCase();
			if (genero[i].compareTo("T")!=0 && genero[i].compareTo("D")!=0 && genero[i].compareTo("C")!=0) {
				do {
					System.out.println("\nPor favor, introduce sólo la primera letra de los géneros enunciados:(T)error, (D)rama o (C)omedia: ");
					genero[i] = entrada.nextLine();
					genero[i] = genero[i].toUpperCase();
				} while (genero[i].compareTo("T")!=0 && genero[i].compareTo("T")!=0 && genero[i].compareTo("T")!=0);  // Sólo permitiré estos valores en Género.
			}

			// AUTOR
			System.out.printf("\nIntroduce el nombre del autor de la película %d: ", i+1);
			autor[i] = entrada.nextLine(); // Obligo al usuario a introducir un autor.
			if (autor[i]=="") {
				do {
					System.out.println("\nPor favor introduce un nombre de autor: ");
					autor[i] = entrada.nextLine();
				} while (autor[i]=="");
			}

			// DURACIÓN
			System.out.printf("\nIntroduce la duración en minutos de la película %d: ", i+1);
			do {
				duracion[i] = entrada.nextInt();
				if (duracion[i]<45 || duracion[i]>180) { // Obligo al usuario a introducir una duración entre 45 y 180 minutos.
					System.out.println("\nPor favor, introduce una duración entre 45 y 180 minutos. Ni más, ni menos: ");
				}
			} while (duracion[i]<45 || duracion[i]>180); // Obligo al usuario a introducir una duración entre 45 y 180.

		} // fin de 'for(i=0; i<tope; i++)'
		
	 // PROCESAMIENTO DE DATOS Y MENSAJES POR PANTALLA
	 // ==============================================

		do { // Quiero repetir el MENÚ tantas veces como el usuario quiera. Esto es cuando pulse la 'opción' 3.

			// MENÚ
			System.out.println("\n===============================================");
			System.out.println("MENÚ DE LA BASE DE DATOS CREADA SOBRE PELÍCULAS");
			System.out.println("===============================================");
			System.out.println("Por favor, selecciona una de las siguientes opciones:");
			System.out.println("\t1.- Buscar películas por género.");
			System.out.println("\t2.- Buscar películas por duración.");
			System.out.println("\t3.- Salir.");
			do {
				opcion = entrada.nextInt();
				if (opcion<1 || opcion>3) {
					System.out.println("\nPor favor, introduce el número de la opción (1, 2 o 3): ");
				}
			} while (opcion<1 || opcion>3);
	
			contador = 0; // Inicializo el contador que utilizaré en la Opción 1 o 2 a cero.
			
			entrada.nextLine(); // Limpio el buffer del Scanner para la lectura de las siguientes cadenas
			
			// OPCIÓN 1
			if (opcion==1) {
				System.out.println("\nIntroduce el genero de la película: (T)error, (D)rama o (C)omedia: ");
				opcionG = entrada.nextLine(); // Sólo quiero recoger una letra.
				opcionG = opcionG.toUpperCase(); // Transformo, en caso de que el usuario pulse la consonante correcta en minúscula, a mayúscula.
				if (opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0) {
					do {
						System.out.println("\nPor favor, introduce sólo la primera letra de los géneros enunciados:(T)error, (D)rama o (C)omedia: ");
						opcionG = entrada.nextLine();
						opcionG = genero[i].toUpperCase();
					} while (opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0);  // Sólo permitiré estos valores en Género.
				}
				System.out.println("\n\tEl género elegido contiene las siguientes películas con su información: ");
				for (i=0; i<tope; i++) {
					if (opcionG.compareTo(genero[i])==0) {
						System.out.printf("\n\tTítulo: %-20s Género: %s Duración: %-3d Autor: %-20s", titulo[i], genero[i], duracion[i], autor[i]);
						contador++;
					}
				}
				System.out.printf("\n\tEl Número de películas dentro del género introducido es %d.", contador);
			}
	
			// OPCIÓN 2
			if (opcion==2) {
				System.out.println("\nIntroduce la duración máxima: ");
				do {
					opcionD = entrada.nextInt();
					if (opcionD<45 || opcionD>180) {
						System.out.println("\nPor favor, introduce una duración entre 45 y 180 minutos. Ni más, ni menos: ");
					}
				} while (opcionD<45 || opcionD>180); // Obligo al usuario a introducir una duración entre 45 y 180.
				System.out.println("\nTodas las películas de menor duración a la seleccionada, contienen la siguiente información:");
				for (i=0; i<tope; i++) {
					if (duracion[i]<opcionD) {
						System.out.printf("\n\tTítulo: %-15s Autor: %-15s Género: %-4s Duración: %-3d", titulo[i], autor[i], genero[i], duracion[i]);
						contador++;
					}
				}
				System.out.printf("\n\n\tEl Número de películas dentro del género introducido es %d.\n", contador);
			}
	
			// OPCIÓN 3
			if (opcion==3) {
				System.out.println("\n¡¡Gracias por usar el programa!!");
				System.out.println("Fdo: Javier Latorre.");
			}

		} while (opcion!=3); // 
		
		entrada.close(); // Cierro el Scanner prácticamente al final del ejercicio, ya que en el bucle solicito datos al usuario hasta aquí.
	}
}








