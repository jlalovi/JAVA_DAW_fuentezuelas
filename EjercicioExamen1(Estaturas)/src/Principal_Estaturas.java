/*

Ejercicio 1 - Examen
====================

OBJETIVO:

	Para realizar un estudio estad�stico, se piden estaturas por teclado (en cm, es decir,
	el usuario introduce datos como 185, 173, etc). Se est� pidiendo hasta que el usuario
	introduce un cero. Se debe comprobar que las estaturas introducidas son �v�lidas�,
	consideraremos como v�lidas las que est�n  entre 150 y 200 cm. En caso de recibirse
	una estatura no v�lida se mostrar� un mensaje de error y no se tendr� cuenta. Una vez
	introducidas todas las estaturas el programa debe calcular y sacar por pantalla los
	siguientes datos: n� de estaturas v�lidas introduc�as, estatura media , estatura m�xima, 
	estatura m�nima, n� de �bajos� (entre 150 y 165cm), n� de �normales� entre 166 y 185 y 
	n� de �altos� (m�s de 185).

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 18-nov-2014

*/

import java.util.Scanner;

public class Principal_Estaturas {

	public static void main(String[] args) {

		System.out.println("ESTE PROGRAMA MUESTRA UNOS DATOS A PARTIR LAS ESTATURAS INTRODUCIDAS");

	 // DELARACI�N DE VARIABLES
	 // =======================
		
		// Declaro e inicializo los valores al mismo tiempo a 0.
		int estatura=0;         // Estatura que introduce el usuario. Se trabajar� con ella y desaparecer� con la siguiente altura introducida.
		int total_estaturas=0;  // N�mero total de alturas introducidas por el usuario.
		int estatura_media=0;   // Media de las alturas introducidas.
		int sumatorio=0;        // Suma de alturas para conocer la 'estatura_media'
		int estatura_minima=0;  // Altura m�s baja introducida.
		int estatura_maxima=0;  // Altura m�s alta introducida.
		int n_bajos=0;	        // N�mero de alturas entre (150 y 165).
		int n_normales=0;		// N�mero de alturas entre (166 y 185).
		int n_altos=0;		    // N�mero de alturas entre (>185).

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);

		do { // Este bucle lo repetir� hasta que el usuario introduzca un 0.
		
			System.out.println("Introduce una estatura: ");
			estatura = entrada.nextInt();
			if (estatura != 0 && estatura<150 || estatura>200) {  // Si la altura es diferente a 0 y menor que 150 o mayor que 200, mando un mensaje de error.
				do {
					System.out.println("Por favor, introduce una estatura v�lida entre 150 y 200 (ambas inclusives): ");
					estatura = entrada.nextInt();
				} while (estatura<150 || estatura >200);
			}
		
	 // PROCESAMIENTO DE DATOS
	 // ======================

			if (estatura != 0) {                               // Si el dato es v�lido y distinto de 0:
				total_estaturas = total_estaturas + 1;         // Una vez pasada la condici�n anterior, empiezo a trabajar con los datos v�lidos.
				sumatorio = estatura + sumatorio;
				estatura_media = sumatorio / total_estaturas;  // Estatura media a partir del sumatorio y el total de estaturas.
				if (total_estaturas == 1) {                    // La primera estatura introducida ser� la m�xima y la m�nima.
					estatura_minima = estatura;
					estatura_maxima = estatura;
				}
				if (estatura>estatura_maxima) {                // Compruebo si la altura introducida es mayor que la almacenada.
					estatura_maxima = estatura;
				}
				if (estatura<estatura_minima) {                // Compruebo si la altura introducida es menor que la almacenada.
					estatura_minima = estatura;
				}
				if (estatura>=150 && estatura<=165) {
					n_bajos = n_bajos + 1;
				}
				if (estatura>165 && estatura<=185) {
					n_normales = n_normales + 1;
				}
				if (estatura>=185) {
					n_altos = n_altos + 1;
				}
			}
			
		} while(estatura!=0); // fin del 'do' inicial, una vez el usuario introduce 0 en estatura.
			
		entrada.close(); // Al salir de este bucle, dejar� de leer datos con el scanner, por lo que lo cierro aqu�.
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.printf("\n- El n�mero total de estaturas introducidas es %d", total_estaturas);
		System.out.printf("\n- La estatura media es %d", estatura_media);
		System.out.printf("\n- La estatura m�xima es %d", estatura_maxima);
		System.out.printf("\n- La estatura minima es %d", estatura_minima);
		System.out.printf("\n- El n�mero de bajos es %d", n_bajos);
		System.out.printf("\n- El n�mero de normales es %d", n_normales);
		System.out.printf("\n- El n�mero de altos es %d", n_altos);
		
	}
}