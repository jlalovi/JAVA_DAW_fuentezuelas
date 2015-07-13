/*

Ejercicio 2 - Examen
====================

OBJETIVO:

	Realizar para almacenar en memoria y tratar posteriormente datos relativos a una colecci�n de pel�culas . 
	Para cada pel�cula se debe pedir al usuario: t�tulo de la pel�cula, g�nero (debe ser �hay que controlarlo- 
	un valor entre los siguientes: T- terror, D-drama, C-comedia), duraci�n en minutos (debe ser un valor entre 
	45 y 180) y nombre del director. Antes de empezar a pedir pel�culas se pedir� al usuario la cantidad de 
	pel�culas de que consta la colecci�n (no podr�n ser m�s de 100) Una vez pedidas las pel�culas, se mostrar� 
	al usuario un men� con las opciones : 1-buscar pel�culas por g�nero, 2- buscar pel�culas por duraci�n, 
	3-salir. En caso de que se seleccione 1, se pedir� al usuario el g�nero deseado (T/D/C) y se mostrar�n en
	pantalla una lista con todos los datos de las pel�culas de ese g�nero, diciendo al final el n�mero de 
	pel�culas encontradas. En caso de que se selecciones 2, se pedir� al usuario la duraci�n m�xima deseada y 
	se mostrar�n (todos los datos de cada pel�cula) todas las que su duraci�n sea menor o igual a la introducidas 
	(y al final el n�mero de pel�culas listadas). Si se elije 3, obviamente, el programa acaba.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 18-nov-2014

*/

import java.util.Scanner;

public class Principal_Peliculas {

	public static void main(String[] args) {

		System.out.println("ESTE PROGRAMA ALMACENA UNA SERIE DE DATOS SOBRE PEL�CULAS Y TRABAJA CON ELLOS");

	 // DELARACI�N DE VARIABLES
	 // =======================

		String [] titulo;      // T�tulo de la pel�cula.
		String [] genero;      // Tipo de g�nero (Terror, Drama y Comedia).
		String [] autor;       // Nombre del autor.
		int [] duracion;       // Duraci�n de la pel�gula (entre 45 y 180 minutos).
		int tope;              // N�mero de pel�culas que el usuario quiere guardar.
		int i;				   // Variable de iteraci�n.
		int contador;          // Acumulador que me servir� para contar iteraciones.
		int opcion;            // Opci�n a elegir en el men�.
		String opcionG;        // Opci�n para g�nero en men�.
		int opcionD;           // Opci�n para duraci�n en men�.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);

		// Pido el n�mero de pel�culas que el usuario quiere registrar para inicializar el tama�o de los vectores.
		System.out.println("�Cu�ntas pel�culas deseas introducir?");
		do {
			tope = entrada.nextInt();
			if (tope<=0) {
				System.out.println("Por favor, introduce un n�mero positivo de pel�culas y al menos una: ");
			}
		} while (tope<=0);
		
		titulo = new String[tope];
		genero = new String[tope];
		autor = new String[tope];
		duracion = new int[tope];
		
		// Creo la 'Base de Datos' de pel�culas a partir de los datos introducidos por el usuario.
		for (i=0; i<tope; i++) {  // En cada iteraci�n de este bucle, pedir� el t�tulo, g�nero, autor y duraci�n.

			entrada.nextLine(); // Limpio el buffer del Scanner para la lectura de las siguientes cadenas
			
			// T�TULO
			System.out.printf("\nIntroduce el t�tulo de la pel�cula %d: ", i+1);
			titulo[i] = entrada.nextLine();
			if (titulo[i]=="") {  // Obligo al usuario a introducir un t�tulo.
				do {
					System.out.println("Por favor introduce un t�tulo:");
					titulo[i] = entrada.nextLine();
				} while (titulo[i]=="");
			}

			// G�NERO
			System.out.printf("\nIntroduce el genero de la pel�cula %d: (T)error, (D)rama o (C)omedia: ", i+1);
			genero[i] = entrada.nextLine();
			genero[i] = genero[i].toUpperCase();
			if (genero[i].compareTo("T")!=0 && genero[i].compareTo("D")!=0 && genero[i].compareTo("C")!=0) {
				do {
					System.out.println("\nPor favor, introduce s�lo la primera letra de los g�neros enunciados:(T)error, (D)rama o (C)omedia: ");
					genero[i] = entrada.nextLine();
					genero[i] = genero[i].toUpperCase();
				} while (genero[i].compareTo("T")!=0 && genero[i].compareTo("T")!=0 && genero[i].compareTo("T")!=0);  // S�lo permitir� estos valores en G�nero.
			}

			// AUTOR
			System.out.printf("\nIntroduce el nombre del autor de la pel�cula %d: ", i+1);
			autor[i] = entrada.nextLine(); // Obligo al usuario a introducir un autor.
			if (autor[i]=="") {
				do {
					System.out.println("\nPor favor introduce un nombre de autor: ");
					autor[i] = entrada.nextLine();
				} while (autor[i]=="");
			}

			// DURACI�N
			System.out.printf("\nIntroduce la duraci�n en minutos de la pel�cula %d: ", i+1);
			do {
				duracion[i] = entrada.nextInt();
				if (duracion[i]<45 || duracion[i]>180) { // Obligo al usuario a introducir una duraci�n entre 45 y 180 minutos.
					System.out.println("\nPor favor, introduce una duraci�n entre 45 y 180 minutos. Ni m�s, ni menos: ");
				}
			} while (duracion[i]<45 || duracion[i]>180); // Obligo al usuario a introducir una duraci�n entre 45 y 180.

		} // fin de 'for(i=0; i<tope; i++)'
		
	 // PROCESAMIENTO DE DATOS Y MENSAJES POR PANTALLA
	 // ==============================================

		do { // Quiero repetir el MEN� tantas veces como el usuario quiera. Esto es cuando pulse la 'opci�n' 3.

			// MEN�
			System.out.println("\n===============================================");
			System.out.println("MEN� DE LA BASE DE DATOS CREADA SOBRE PEL�CULAS");
			System.out.println("===============================================");
			System.out.println("Por favor, selecciona una de las siguientes opciones:");
			System.out.println("\t1.- Buscar pel�culas por g�nero.");
			System.out.println("\t2.- Buscar pel�culas por duraci�n.");
			System.out.println("\t3.- Salir.");
			do {
				opcion = entrada.nextInt();
				if (opcion<1 || opcion>3) {
					System.out.println("\nPor favor, introduce el n�mero de la opci�n (1, 2 o 3): ");
				}
			} while (opcion<1 || opcion>3);
	
			contador = 0; // Inicializo el contador que utilizar� en la Opci�n 1 o 2 a cero.
			
			entrada.nextLine(); // Limpio el buffer del Scanner para la lectura de las siguientes cadenas
			
			// OPCI�N 1
			if (opcion==1) {
				System.out.println("\nIntroduce el genero de la pel�cula: (T)error, (D)rama o (C)omedia: ");
				opcionG = entrada.nextLine(); // S�lo quiero recoger una letra.
				opcionG = opcionG.toUpperCase(); // Transformo, en caso de que el usuario pulse la consonante correcta en min�scula, a may�scula.
				if (opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0) {
					do {
						System.out.println("\nPor favor, introduce s�lo la primera letra de los g�neros enunciados:(T)error, (D)rama o (C)omedia: ");
						opcionG = entrada.nextLine();
						opcionG = genero[i].toUpperCase();
					} while (opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0 && opcionG.compareTo("T")!=0);  // S�lo permitir� estos valores en G�nero.
				}
				System.out.println("\n\tEl g�nero elegido contiene las siguientes pel�culas con su informaci�n: ");
				for (i=0; i<tope; i++) {
					if (opcionG.compareTo(genero[i])==0) {
						System.out.printf("\n\tT�tulo: %-20s G�nero: %s Duraci�n: %-3d Autor: %-20s", titulo[i], genero[i], duracion[i], autor[i]);
						contador++;
					}
				}
				System.out.printf("\n\tEl N�mero de pel�culas dentro del g�nero introducido es %d.", contador);
			}
	
			// OPCI�N 2
			if (opcion==2) {
				System.out.println("\nIntroduce la duraci�n m�xima: ");
				do {
					opcionD = entrada.nextInt();
					if (opcionD<45 || opcionD>180) {
						System.out.println("\nPor favor, introduce una duraci�n entre 45 y 180 minutos. Ni m�s, ni menos: ");
					}
				} while (opcionD<45 || opcionD>180); // Obligo al usuario a introducir una duraci�n entre 45 y 180.
				System.out.println("\nTodas las pel�culas de menor duraci�n a la seleccionada, contienen la siguiente informaci�n:");
				for (i=0; i<tope; i++) {
					if (duracion[i]<opcionD) {
						System.out.printf("\n\tT�tulo: %-15s Autor: %-15s G�nero: %-4s Duraci�n: %-3d", titulo[i], autor[i], genero[i], duracion[i]);
						contador++;
					}
				}
				System.out.printf("\n\n\tEl N�mero de pel�culas dentro del g�nero introducido es %d.\n", contador);
			}
	
			// OPCI�N 3
			if (opcion==3) {
				System.out.println("\n��Gracias por usar el programa!!");
				System.out.println("Fdo: Javier Latorre.");
			}

		} while (opcion!=3); // 
		
		entrada.close(); // Cierro el Scanner pr�cticamente al final del ejercicio, ya que en el bucle solicito datos al usuario hasta aqu�.
	}
}








