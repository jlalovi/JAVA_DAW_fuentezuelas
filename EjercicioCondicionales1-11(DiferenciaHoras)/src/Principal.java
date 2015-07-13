/*

Ejercicio 1.11 Condicionales
============================

OBJETIVO: Introduce por teclado dos horas en formato: h:m:s y mostrar la diferencia de tiempo 
		  transcurrido entre las dos en formato h:m:s.
		  
OBSERVACIÓNES: - En 'total'Paso la primera y segunda horas a segundos, realizo su diferencia y al 
			     resultado le hago el valor absoluto, por si dicha diferencia es negativa.
               - 's3 = total%60'. El resto del modular del total de segundos a 60, va a ser el residuo 
                 de segundos que marcara el reloj.
               - 'm3 = ((total-s3)/60)%60'. El resto del total en segundos menos los segundos obtenidos
                 anteriormente, da como resultado los minutos.
               - 'h3 = (((total-s3)/60)-m3)/60'. Si a la diferencia entre el total de segundos y los 
               	 segundos obtenidos lo divides entre 60, y a ese resultado le restas los minutos obtenidos 
               	 y lo divides entre 60, resulta el total de horas.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("ESTE PROGRAMA TE INDICA LA DIFERENCIA ENTRE DOS HORAS EXPRESADAS EN (H:M:S)");

	 // DELARACIÓN DE VARIABLES
	 // =======================
		
		byte h1, m1, s1;  // Primera hora (h:m:s) introducida por el usuario.
		byte h2, m2, s2;  // Segunda hora (h:m:s) introducida por el usuario.
		int total;        // Total en segundos de la diferencia de las dos horas introducidas.
		int h3, m3, s3;   // Tercera hora (h:m:s) resultado de la diferencia de las dos horas introducidas a partir de 'total'.


	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("PRIMERA HORA:");
		System.out.println("Introduce el número de horas:");
		h1 = entrada.nextByte();
		System.out.println("Introduce el número de minutos:");
		m1 = entrada.nextByte();
		System.out.println("Introduce el número de segundos:");
		s1 = entrada.nextByte();
		
		System.out.println("SEGUNDA HORA:");
		System.out.println("Introduce el número de horas:");
		h2 = entrada.nextByte();
		System.out.println("Introduce el número de minutos:");
		m2 = entrada.nextByte();
		System.out.println("Introduce el número de segundos:");
		s2 = entrada.nextByte();
		
		entrada.close();
			
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		total = Math.abs ((s1 + m1*60 + h1*60*60) - (s2 + m2*60 + h2*60*60)); // Ver observaciones.
		
		s3 = total%60;                   //
		m3 = ((total-s3)/60)%60;         // Ver observaciones.
		h3 = (((total-s3)/60)-m3)/60;    //
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(total);
		System.out.println("La diferencia expresada en h:m:s entre " + h1 + (":") + m1 + (":") + s1 + " y " 
						   + h2 + (":") + m2 + (":") + s2 + (" es ") + 	h3 + (":") + m3 + (":") + s3);
		
	}

}