/*

Ejercicio 2.1 Condicionales
===========================

OBJETIVO: Calcula una ecuaci�n de segundo grado.

OBSERVACIONES: El programa tiene en cuenta el valor 'Delta' o 'discriminante':
			   Delta = 0 -> Ecuaci�n de segundo grado con soluci�n doble.
			   Delta > 0 -> Ecuaci�n de segundo grado con dos soluciones reales.
			   Delta < 0 -> Ecuaci�n de segundo grado con dos soluciones complejas conjugadas.
					
			   El programa tambi�n tiene en cuenta si a = 0, indicando que se trata de
			   una ecuaci�n simple y su resultado.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 09-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA CALCULAR UNA ECUACI�N DE SEGUNDO GRADO");

	 // DELARACI�N DE VARIABLES
	 // =======================
		
		int a, b, c;    // Variables que asignar� el usuario para que el programa pueda resolver la ecuaci�n de segundo grado.
		double delta;   // Variable donde se almacenar� el valor 'discriminante' o 'delta'.
		double x1, x2;  // Variables donde se almacenar�n los resultados de la ecuaci�n de segundo grado.
		String mensaje; // Objeto que almacenar� el mensaje a mostrar al final del algoritmo.

   	 // ENTRADA DE DATOS (INPUT)
	 // ========================
	
		Scanner entrada = new Scanner(System.in);

		System.out.println("Si una ecuaci�n de segundo grado se expresa como 'ax^2 + bx + c = 0':");
		System.out.println("Introduce el valor num�rico de 'a':");
		a = entrada.nextInt();
		System.out.println("Introduce el valor num�rico de 'b':");
		b = entrada.nextInt();
		System.out.println("Introduce el valor num�rico de 'c':");
		c = entrada.nextInt();
		
		entrada.close();
		
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		delta = Math.pow(b, 2) - 4 * a * c;    // Valor 'Delta' o 'discriminante'.
		
		if (a==0) {                 // Comprobaci�n de si la ecaci�n de segundo grado se convierte en una simple.
			x1 = -c/b;
			mensaje = "Al ser el valor 'a' igual a '0', la ecuaci�n ser�a simple. No obstante, el valor de 'x' es: " + x1;
		}
		
		else {						// Comprobaci�n del valor de 'delta'.
			
			if (delta > 0) {        // Si 'delta' es mayor que 0:
				
				x1 = (-b + Math.pow( (Math.pow(b,2) - 4*a*c) , (1/2) ) ) / 2*a;
				x2 = (-b - Math.pow( (Math.pow(b,2) - 4*a*c) , (1/2) ) ) / 2*a;
				mensaje = "La ecuaci�n tiene dos soluciones, que son n�meros reales distintos: " + x1 + " y " + x2;
			}
			
			else if (delta==0){     // Si 'delta' es igual a 0:
				
				x1 = -b/2*a;
				mensaje = "La ecuaci�n tiene una soluci�n doble igual a " + x1;
			}
			
			else {					// Si 'delta' es menor que 0:
				
				mensaje = "La ecuaci�n no tiene soluciones reales.";
			}
		}
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(mensaje); // Impresi�n del mensaje dependiendo de las condiciones anteriores.
		
	}

}
