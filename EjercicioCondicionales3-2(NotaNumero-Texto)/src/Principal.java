/*

Ejercicio 3.2 Condicionales
===========================

OBJETIVO: Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien...

OBSERVACIONES: - En el ejercicio de SLE, lo hice con un 'eval', pero puesto que en JAVA, no se me permite
				 añadir una condición en un case, sino que tengo que introducir todos los 'case's uno a
				 uno, utilizaré condicionales directamente.
			   - Puesto que todavía no estamos en la relación de bucles, añadiré un mensaje de error
			     cuando el número introducido no comprenda entre 0 y 10.
			   - Admitiré no obstante decimales, declarando la variable 'nota_numero' como 'float'.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA MOSTRAR LA NOTA INTRODUCIDA EN FORMA DE TEXTO:");

	 // DELARACIÓN DE VARIABLES
	 // =======================
		
		float nota_numero;    // Variable donde almacenaré la nota entre 0 y 10 introducida por el usuario.
		String nota_cadena;   // Variable donde almacenaré la nota en su forma escrita (Insuficiente, Suficiente...)

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce la nota numérica que quieres transformar en texto:");
		nota_numero = entrada.nextByte();
		
		entrada.close();
			
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		if (nota_numero>=0 && nota_numero<5) {
			nota_cadena = "Insuficiente";
		}
		else if (nota_numero>=5 && nota_numero<6) {
			nota_cadena = "Suficiente";
		}
		else if (nota_numero>=6 && nota_numero<7) {
			nota_cadena = "Bien";
		}
		else if (nota_numero>=7 && nota_numero<8) {
			nota_cadena = "Notable";
		}
		else if (nota_numero>=8 && nota_numero<10) {
			nota_cadena = "Sobresaliente";
		}
		else if (nota_numero==10) {
			nota_cadena = "Matrícula de Honor";
		}
		else {
			nota_cadena = "La nota introducida es incorrecta. Debe comprender entre 0 y 10.";
		}
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		System.out.println(nota_numero + " equivale a " + nota_cadena);
		
	}

}