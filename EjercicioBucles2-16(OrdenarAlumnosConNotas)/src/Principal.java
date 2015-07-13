/*

Ejercicio 2.16 Bucles
=====================

OBJETIVO: Igual al anterior, pero para un número de asignaturas también seleccionable por el usuario (máximo 10), 
	      es decir, se pedirán los nombres y x notas (las que haya dicho el usuario) para cada alumno y después 
		  se muestra una lista ordenada alfabéticamente.

OSERVACIÓN: Consideraré que el número de notas introducido por el usuario será el mismo para todos los alumnos.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 17-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE ORDENA ALFABÉTICAMENTE UN NÚMERO 'X' DE ALUMNOS CON SUS 'Y' NOTAS");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int nAlumn;        // 'N' alumnos que el usuario quiere introducir.
		int nNotas;        // 'N' notas que el usuario quiere introducir.
		String [] alumno;  // Vector para almacenar cada uno de los alumnos, hasta un máximo de 100.
		int [][] nota;     // Matriz para almacenar cada una de las notas de los alumnos. El número de notas será de 10.
		int i, j;          // Variables de control para las iteraciones de los bucles. 'i' será para iterar entre filas y 'j' entre columnas de la matriz.
		String auxC;       // Variable auxiliar para hacer intercambios de valores de cadena.
		int auxN;          // Variable auxiliar para hacer intercambios de valores numéricos.
		boolean ordenados; // Sale del bucle 'do', cuando los alumnos estén ordenados alfabéticamente.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		// Número de Alumnos.
		do {
			System.out.println("Introduce el número de alumnos que deseas introducir (al menos 1): ");
			nAlumn = entrada.nextInt();
		} while (nAlumn<1);
		
		alumno = new String [nAlumn];  // Inicializo el vector 'alumno[]' con el número de alumnos que el usuario a elegido.
		
		// Número de Notas.
		do {
			System.out.println("¿Cuántas notas quieres registrar por alumno? (al menos 1): ");
			nNotas = entrada.nextInt();
		} while (nNotas<1);
		
		nota = new int [nAlumn][nNotas];  // Inicializo la matriz 'nota[][]' con el número de notas que el usuario a elegido, teniendo en cuenta el número de alumnos.
		
		// Nombre de alumnos y sus correspondientes notas.
		for (i=0; i<nAlumn; i++) {
			System.out.printf("\nIntroduce el nombre y apellido del alumno %d: ", i+1);
			alumno[i] = entrada.next();
			for (j=0; j<nNotas; j++) {        // Cambios relacionados con la matriz.
				System.out.printf("\nIntroduce la nota %d correspondiente al alumno '%s': ", j+1, alumno[i]);
				nota[i][j] = entrada.nextInt();
				if(nota[i][j]<0 || nota[i][j]>10) {
					do {
						System.out.printf("\nPor favor, la nota debe comprender entre 0 y 10. Introdúcela de nuevo: ");
						nota[i][j] = entrada.nextInt();
					} while (nota[i][j]<0 || nota[i][j]>10);
				}
			}
		}
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		do {
			ordenados = true; // Al principio de este bucle presumiré que todo está ordenado. Esto lo comprobaré en las condiciones anidadas.
			for (i=0; i<nAlumn-1; i++) {  // Ya que voy a comprar parejas, el último paso será 'i' e 'i+1', por tanto, el tope en el bucle será hasta 'nAlumn-1', para no salirme del rango.
				if (alumno[i].compareToIgnoreCase(alumno[i+1])>0) {  // Ordenaré por parejas. Si el primer número es mayor que el segundo, realizo un intercambio.
					// Intercambios en vector alumno[]
					auxC = alumno[i];
					alumno[i] = alumno[i+1];
					alumno[i+1] = auxC;
					// Intercambios equivalentes a los anteriores en la matriz nota[][].
					for (j=0; j<nNotas; j++) {
						auxN = nota[i][j];
						nota[i][j] = nota [i+1][j];
						nota[i+1][j] = auxN;
					}
					ordenados = false; // Si se entra en este condicional, no permitiré salir del bucle repetir.
				}
			}
		} while (!ordenados); // ¡No saldré del bucle hasta que los alumnos esté ordenados alfabéticamente!
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println("\nLos alumnos ordenados alfabéticamente con sus correspondientes notas son:");
		for (i=0; i<nAlumn; i++) {
			System.out.printf("\n %s:", alumno[i]);
			for (j=0; j<nNotas; j++) {
				System.out.printf(" %d", nota[i][j]);
			}
		}
	}
}