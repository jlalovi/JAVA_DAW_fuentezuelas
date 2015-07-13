/*

Ejercicio 2.14 Bucles
=====================

OBJETIVO: Desarrollar un algoritmo al que se le den dos enteros y determine si dichos n�meros son amigos. 
	      Dos n�meros a y b son amigos si la suma de los divisores de a coincide con b y viceversa.

OBSERVACION:
       - Seg�n Wikipedia: "Dos n�meros amigos son dos n�meros enteros positivos a y b tales que
		 la suma de los divisores propios de uno es igual al otro numero y viceversa, es decir, 
	     s(a)=b y s(b)=a, donde s(n) es igual a la suma de los divisores de n, sin incluir a n. 
		 (La unidad se considera divisor propio, pero no lo es el mismo n�mero.)". Por tanto,
		 no considerar� el mismo n�mero como divisor propio en el algoritmo.
	   - Ya puestos, aunque no forme parte del ejercicio, ya que lo he le�do en Wikipedia, a�adir�
		 si el n�mero es perfecto: "Si un n�mero es amigo de s� mismo (es igual a la suma de sus 
		 divisores propios), recibe entonces el nombre de n�mero perfecto."

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 16-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE MUESTRA SI DOS N�MEROS SON AMIGOS");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int n1, n2;                // Variables con valores introducidos por el usuario. Estos dos n�meros ser�n de los que se realizar� la operaci�n m�ximo com�n divisor.
		int i;                     // Variable de iteraci�n para los bucles.
		int contador1, contador2;  // Variables que me servir�n para contar el n�mero de divisibles de cada n�mero, para saber el tope de cada vector.
		int [] divisibles1;        // Vectores donde almacenar� los n�meros divisibles de cada n�mero introducido por el usuario.
		int [] divisibles2;        // " "
		int suma1, suma2;          // Suma de los n�meros divisibles almacenados en cada uno de los vectores ('divisibles1' y 'divisibles2').

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		n1=0; n2=0; 
		contador1=0; contador2=0;
		suma1=0; suma2=0;
		divisibles1 = new int[20]; // Considero que un n�mero con un m�ximo de 20 divisibles es suficiente.
		divisibles2 = new int[20]; //

		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Introduce el primer n�mero (de 0-1000):");
			n1 = entrada.nextInt();
		} while (n1<0 || n1>1000);

		do {
			System.out.println("Introduce el primer n�mero (de 0-1000):");
			n2 = entrada.nextInt();
		} while (n2<0 || n2>1000);
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		// DIVISIBLES N�MERO 1.
		if (n1%2==0) {  // Pares
			for (i=1; i<=n1/2; i++) {  // Empiezo a contar desde 'i=1' para la operaci�n 'n1%i'
				if (n1%i==0) {
					contador1 = contador1+1;  // Este contador calcular� el n�mero de divisibles en 'divisibles1[]'    
					divisibles1[contador1] = i;
				}
			} 
		} else {        // Impares
			for (i=1; i<=(n1+1)/2; i++) {  // Empiezo a contar desde 'i=1' para la operaci�n 'n1%i'
				if (n1%i==0) {
					contador1 = contador1+1;  // Este contador calcular� el n�mero de divisibles en 'divisibles1[]' 
					divisibles1[contador1] = i;
				}
			}
		}

		// SUMATORIO DIVISIBLES N�MERO 1.
		for (i=0; i<=contador1; i++) {  // Aqu� "i=0" porque empieza desde la primera posici�n del vector.
			suma1 = suma1 + divisibles1[i];  // Sumo todos los n�meros divisibles del n�mero 1.
		}

		// DIVISIBLES N�MERO 2.
		if (n2%2==0) {  // Pares
			for (i=1; i<=n2/2; i++) {  // Empiezo a contar desde 'i=1' para la operaci�n 'n2%i'
				if (n2%i==0) {
					contador2 = contador2+1;  // Este contador calcular� el n�mero de divisibles en 'divisibles2[]'    
					divisibles2[contador2] = i;
				}
			} 
		} else {        // Impares
			for (i=1; i<=(n2+1)/2; i++) {  // Empiezo a contar desde 'i=1' para la operaci�n 'n2%i'
				if (n2%i==0) {
					contador2 = contador2+1;  // Este contador calcular� el n�mero de divisibles en 'divisibles2[]' 
					divisibles2[contador2] = i;
				}		
			}
		}

		// SUMATORIO DIVISIBLES N�MERO 2.
		for (i=0; i<=contador1; i++) {  // Aqu� "i=0" porque empieza desde la primera posici�n del vector.
			suma2 = suma2 + divisibles2[i];  // Sumo todos los n�meros divisibles del n�mero 2.
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (suma1 == n2 && suma2 == n1) {    // Ej: n1=220 y n2=284
			System.out.printf("Los n�meros introducidos %d y %d son amigos.\n", n1, n2);
			System.out.println("La suma de los divisores propios son:");
			System.out.printf("%d para el primero y %d para el segundo.", suma1, suma2);
		}
		else { // ('else1')  // Ej: n1=50 y n2=70
			System.out.printf("Los n�meros introducidos %d y %d NO son amigos.\n", n1, n2);
			System.out.println("La suma de los divisores propios son:");
			System.out.printf("%d para el primero y %d para el segundo.", suma1, suma2);

			// PARTE EXTRA PARA INDICAR SI SON N�MEROS PERFECTOS
			// Como un n�mero amigo de s� mismo no va a poder ser amigo de otro n�mero diferente, los mensajes siguientes siguen la coherencia del anterior.
			if (suma1==n1 && suma2==n2) {  // Ej: n1=28 y n2=496
				System.out.printf("\nSin embargo, %d y %d son n�meros perfectos, ya que cada uno de ellos es la suma de sus n�meros divisibles propios.", n1, n2);
			} else {
				if (suma1 == n1) {   // Ej: n1=496 y n2=700
					System.out.printf("\nSin embargo, %d  es un n�mero perfecto, ya que es la suma de sus n�meros divisibles propios.", n1);
				}
				if (suma2 == n2) {   // Ej: n1=500 y n2==496
					System.out.printf("\nSin embargo, %d  es un n�mero perfecto, ya que es la suma de sus n�meros divisibles propios.", n2);
				}
			}
		} // fin de 'else1'
		
	} // fin de main
} // fin de public class