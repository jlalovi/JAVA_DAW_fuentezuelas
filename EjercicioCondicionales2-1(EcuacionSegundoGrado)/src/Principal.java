/*

Ejercicio 2.1 Condicionales
===========================

OBJETIVO: Calcula una ecuación de segundo grado.

OBSERVACIONES: El programa tiene en cuenta el valor 'Delta' o 'discriminante':
			   Delta = 0 -> Ecuación de segundo grado con solución doble.
			   Delta > 0 -> Ecuación de segundo grado con dos soluciones reales.
			   Delta < 0 -> Ecuación de segundo grado con dos soluciones complejas conjugadas.
					
			   El programa también tiene en cuenta si a = 0, indicando que se trata de
			   una ecuación simple y su resultado.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 09-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA CALCULAR UNA ECUACIÓN DE SEGUNDO GRADO");

	 // DELARACIÓN DE VARIABLES
	 // =======================
		
		int a, b, c;    // Variables que asignará el usuario para que el programa pueda resolver la ecuación de segundo grado.
		double delta;   // Variable donde se almacenará el valor 'discriminante' o 'delta'.
		double x1, x2;  // Variables donde se almacenarán los resultados de la ecuación de segundo grado.
		String mensaje; // Objeto que almacenará el mensaje a mostrar al final del algoritmo.

   	 // ENTRADA DE DATOS (INPUT)
	 // ========================
	
		Scanner entrada = new Scanner(System.in);

		System.out.println("Si una ecuación de segundo grado se expresa como 'ax^2 + bx + c = 0':");
		System.out.println("Introduce el valor numérico de 'a':");
		a = entrada.nextInt();
		System.out.println("Introduce el valor numérico de 'b':");
		b = entrada.nextInt();
		System.out.println("Introduce el valor numérico de 'c':");
		c = entrada.nextInt();
		
		entrada.close();
		
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		delta = Math.pow(b, 2) - 4 * a * c;    // Valor 'Delta' o 'discriminante'.
		
		if (a==0) {                 // Comprobación de si la ecación de segundo grado se convierte en una simple.
			x1 = -c/b;
			mensaje = "Al ser el valor 'a' igual a '0', la ecuación sería simple. No obstante, el valor de 'x' es: " + x1;
		}
		
		else {						// Comprobación del valor de 'delta'.
			
			if (delta > 0) {        // Si 'delta' es mayor que 0:
				
				x1 = (-b + Math.pow( (Math.pow(b,2) - 4*a*c) , (1/2) ) ) / 2*a;
				x2 = (-b - Math.pow( (Math.pow(b,2) - 4*a*c) , (1/2) ) ) / 2*a;
				mensaje = "La ecuación tiene dos soluciones, que son números reales distintos: " + x1 + " y " + x2;
			}
			
			else if (delta==0){     // Si 'delta' es igual a 0:
				
				x1 = -b/2*a;
				mensaje = "La ecuación tiene una solución doble igual a " + x1;
			}
			
			else {					// Si 'delta' es menor que 0:
				
				mensaje = "La ecuación no tiene soluciones reales.";
			}
		}
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(mensaje); // Impresión del mensaje dependiendo de las condiciones anteriores.
		
	}

}
