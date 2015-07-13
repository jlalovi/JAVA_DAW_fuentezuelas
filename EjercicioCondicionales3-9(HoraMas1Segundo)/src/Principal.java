/*

Ejercicio 3.9 Condicionales
===========================

OBJETIVO: Pedir una hora de la forma hora, minutos y segundos, y mostrar la hora en el segundo siguiente.

OBSERVACIÓN: Si la hora introducida no es correcta, no sumaré el segundo y mostraré un mensaje de error.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("ESTE PROGRAMA TE MUESTRA UN SEGUNDO MÁS DE LA HORA INTRODUCIDA EN (H:M:S)");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int h, m, s;     // Hora (h:m:s) introducida por el usuario.
		int nH, nM, nS;  // Nuvos valores al sumar 1 segundo.
		String mensaje;  // Mensaje a mostrar.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el número de horas:");
		h = entrada.nextByte();
		System.out.println("Introduce el número de minutos:");
		m = entrada.nextByte();
		System.out.println("Introduce el número de segundos:");
		s = entrada.nextByte();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================

		if (s >= 0 && s <= 59 && m >= 0 && m <= 59 && h >= 0 && h <= 23) {
			if (s == 59) {
				nS = 0;
				if (m == 59) {
					nM = 0;
					if (h == 23) {
						nH = 0;
					}
					else {
						nH = h + 1;
					}
				}
				else {
					nM = m + 1;
					nH = h;
				}
			}
			else {
				nS = s + 1;
				nM = m;
				nH = h;
			}
			mensaje = "Ahora son las " + nH + " horas, " + nM + " minutos y " + nS + " segundos.";

		}
		else {
			mensaje = "La hora introducida no es correcta.";
		}
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(mensaje);

	}

}