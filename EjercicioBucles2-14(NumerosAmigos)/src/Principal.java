/*

Ejercicio 2.14 Bucles
=====================

OBJETIVO: Desarrollar un algoritmo al que se le den dos enteros y determine si dichos números son amigos. 
	      Dos números a y b son amigos si la suma de los divisores de a coincide con b y viceversa.

OBSERVACION:
       - Según Wikipedia: "Dos números amigos son dos números enteros positivos a y b tales que
		 la suma de los divisores propios de uno es igual al otro numero y viceversa, es decir, 
	     s(a)=b y s(b)=a, donde s(n) es igual a la suma de los divisores de n, sin incluir a n. 
		 (La unidad se considera divisor propio, pero no lo es el mismo número.)". Por tanto,
		 no consideraré el mismo número como divisor propio en el algoritmo.
	   - Ya puestos, aunque no forme parte del ejercicio, ya que lo he leído en Wikipedia, añadiré
		 si el número es perfecto: "Si un número es amigo de sí mismo (es igual a la suma de sus 
		 divisores propios), recibe entonces el nombre de número perfecto."

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 16-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI DOS NÚMEROS SON AMIGOS");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int n1, n2;                // Variables con valores introducidos por el usuario. Estos dos números serán de los que se realizará la operación máximo común divisor.
		int i;                     // Variable de iteración para los bucles.
		int contador1, contador2;  // Variables que me servirán para contar el número de divisibles de cada número, para saber el tope de cada vector.
		int [] divisibles1;        // Vectores donde almacenaré los números divisibles de cada número introducido por el usuario.
		int [] divisibles2;        // " "
		int suma1, suma2;          // Suma de los números divisibles almacenados en cada uno de los vectores ('divisibles1' y 'divisibles2').

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		n1=0; n2=0; 
		contador1=0; contador2=0;
		suma1=0; suma2=0;
		divisibles1 = new int[20]; // Considero que un número con un máximo de 20 divisibles es suficiente.
		divisibles2 = new int[20]; //

		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Introduce el primer número (de 0-1000):");
			n1 = entrada.nextInt();
		} while (n1<0 || n1>1000);

		do {
			System.out.println("Introduce el primer número (de 0-1000):");
			n2 = entrada.nextInt();
		} while (n2<0 || n2>1000);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		// DIVISIBLES NÚMERO 1.
		if (n1%2==0) {  // Pares
			for (i=1; i<=n1/2; i++) {  // Empiezo a contar desde 'i=1' para la operación 'n1%i'
				if (n1%i==0) {
					contador1 = contador1+1;  // Este contador calculará el número de divisibles en 'divisibles1[]'    
					divisibles1[contador1] = i;
				}
			} 
		} else {        // Impares
			for (i=1; i<=(n1+1)/2; i++) {  // Empiezo a contar desde 'i=1' para la operación 'n1%i'
				if (n1%i==0) {
					contador1 = contador1+1;  // Este contador calculará el número de divisibles en 'divisibles1[]' 
					divisibles1[contador1] = i;
				}
			}
		}

		// SUMATORIO DIVISIBLES NÚMERO 1.
		for (i=0; i<=contador1; i++) {  // Aquí "i=0" porque empieza desde la primera posición del vector.
			suma1 = suma1 + divisibles1[i];  // Sumo todos los números divisibles del número 1.
		}

		// DIVISIBLES NÚMERO 2.
		if (n2%2==0) {  // Pares
			for (i=1; i<=n2/2; i++) {  // Empiezo a contar desde 'i=1' para la operación 'n2%i'
				if (n2%i==0) {
					contador2 = contador2+1;  // Este contador calculará el número de divisibles en 'divisibles2[]'    
					divisibles2[contador2] = i;
				}
			} 
		} else {        // Impares
			for (i=1; i<=(n2+1)/2; i++) {  // Empiezo a contar desde 'i=1' para la operación 'n2%i'
				if (n2%i==0) {
					contador2 = contador2+1;  // Este contador calculará el número de divisibles en 'divisibles2[]' 
					divisibles2[contador2] = i;
				}		
			}
		}

		// SUMATORIO DIVISIBLES NÚMERO 2.
		for (i=0; i<=contador1; i++) {  // Aquí "i=0" porque empieza desde la primera posición del vector.
			suma2 = suma2 + divisibles2[i];  // Sumo todos los números divisibles del número 2.
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (suma1 == n2 && suma2 == n1) {    // Ej: n1=220 y n2=284
			System.out.printf("Los números introducidos %d y %d son amigos.\n", n1, n2);
			System.out.println("La suma de los divisores propios son:");
			System.out.printf("%d para el primero y %d para el segundo.", suma1, suma2);
		}
		else { // ('else1')  // Ej: n1=50 y n2=70
			System.out.printf("Los números introducidos %d y %d NO son amigos.\n", n1, n2);
			System.out.println("La suma de los divisores propios son:");
			System.out.printf("%d para el primero y %d para el segundo.", suma1, suma2);

			// PARTE EXTRA PARA INDICAR SI SON NÚMEROS PERFECTOS
			// Como un número amigo de sí mismo no va a poder ser amigo de otro número diferente, los mensajes siguientes siguen la coherencia del anterior.
			if (suma1==n1 && suma2==n2) {  // Ej: n1=28 y n2=496
				System.out.printf("\nSin embargo, %d y %d son números perfectos, ya que cada uno de ellos es la suma de sus números divisibles propios.", n1, n2);
			} else {
				if (suma1 == n1) {   // Ej: n1=496 y n2=700
					System.out.printf("\nSin embargo, %d  es un número perfecto, ya que es la suma de sus números divisibles propios.", n1);
				}
				if (suma2 == n2) {   // Ej: n1=500 y n2==496
					System.out.printf("\nSin embargo, %d  es un número perfecto, ya que es la suma de sus números divisibles propios.", n2);
				}
			}
		} // fin de 'else1'
		
	} // fin de main
} // fin de public class