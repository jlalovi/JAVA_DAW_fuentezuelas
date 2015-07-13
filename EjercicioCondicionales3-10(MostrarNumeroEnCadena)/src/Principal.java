/*

Ejercicio 3.9 Condicionales
===========================

OBJETIVO:  Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar: cincuenta y seis.

OBSERVACIONES: 
	- Para evitar crear un gran número de casos, tengo en cuenta las decenas y las unidades para sumar las cadenas 
	  cuando es apropiado.
	- Los valores conflictivos para sumar cadenas son las unidades sin decenas y aquellos cuyas decenas son 1 o 2.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 12-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA MOSTRAR CIFRA DEL 0 AL 99 EN TEXTO:");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int cifra=0;                                     // Número introducido por el usuario.
		int decenas, unidades;                           // Número descompuesto en decenas y unidades.
		String decena_texto, unidad_texto, cifra_texto;  // Cadenas de texto correspondientes a decenas, unidades y cifra completa.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		while (cifra!=-1) { // Quiero que el programa me pida una y otra vez datos hasta que introduzca '-1'
		
			System.out.println("");
			System.out.println("Introduce una cifra entre 0 y 99 (-1 para salir):");
			cifra = entrada.nextByte();
			
			decena_texto="";  //
			unidad_texto="";  // Inicializo estos datos para poder compilar
			cifra_texto="";   //

	 // PROCESAMIENTO DE DATOS
	 // ======================

			while ( cifra < -1 || cifra > 99 )  {
				System.out.println ("Por favor, introduce un valor entre 0 y 99: ");
				cifra = entrada.nextByte();
			}
	
			unidades = cifra % 10;
			decenas = ((cifra - unidades)/10)%10;
	
			// UNIDADES
			if (cifra == 0) {
				cifra_texto = "cero";
			}
			else if (unidades != 0) {
				switch (unidades) {
					case 1:
						unidad_texto = "uno";
						break;
					case 2:
						unidad_texto = "dos";
						break;
					case 3:
						unidad_texto = "tres";
						break;
					case 4:
						unidad_texto = "cuatro";
						break;
					case 5:
						unidad_texto = "cinco";
						break;
					case 6:
						unidad_texto = "seis";
						break;
					case 7:
						unidad_texto = "siete";
						break;
					case 8:
						unidad_texto = "ocho";
						break;
					case 9:
						unidad_texto = "nueve";
						break;
				}
			}
	
			// DECENAS
			if (decenas == 0) {  // Los valores sin decenas toman directamente el valor de las unidades.
				cifra_texto = unidad_texto;
			}
	
			if (decenas == 1) {  // 17, 18 y 19 empiezan por "dieci" y siguen con una unidad, por lo que sumo las cadenas. 
				switch (unidades) {
					case 0:
						cifra_texto = "diez";
						break;
					case 1:
						cifra_texto = "once";
						break;
					case 2:
						cifra_texto = "doce";
						break;
					case 3:
						cifra_texto = "trece";
						break;
					case 4:
						cifra_texto = "catorce";
						break;
					case 5:
						cifra_texto = "quince";
						break;
					case 6:
						cifra_texto = "deiciséis";
						break;
					default:
						decena_texto = "dieci";
						cifra_texto = decena_texto + unidad_texto;
						break;
				}
			}
	
			if (decenas == 2) {     // 20, 22, 23 y 26 no siguen una lógica por tener acentos o escribirse distinto. Con el resto sumo cadenas.
				switch (unidades) {
					case 0:
						cifra_texto = "veinte";
						break;
					case 2:
						cifra_texto = "veintidós";
						break;
					case 3:
						cifra_texto = "veintitrés";
						break;
					case 6:
						cifra_texto = "veintiséis";
						break;
					default:
						decena_texto = "veinti";
						cifra_texto = decena_texto + unidad_texto;
						break;
				}
			}
	
			switch (decenas) {    // Sigo con las lógicas anteriores, ahora con las decenas.
			case 3:
				decena_texto = "treinta";
				break;
			case 4:
				decena_texto = "cuarenta";
				break;
			case 5:
				decena_texto = "cincuenta";
				break;
			case 6:
				decena_texto = "sesenta";
				break;
			case 7:
				decena_texto = "setenta";
				break;
			case 8:
				decena_texto = "ochenta";
				break;
			case 9:
				decena_texto = "noventa";
				break;
			}
			
			if (decenas > 2) {
				if (unidades == 0) {
					cifra_texto = decena_texto;
				}
				else {
					cifra_texto = decena_texto + " y " + unidad_texto;
				}
			}
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
			if (cifra!=-1) {
				System.out.println("El valor introducido es el " + cifra_texto);
			}
			else {
				System.out.println("¡Gracias por utilizar el programa!");
			}
		
		} // fin del while inicial
		
		entrada.close(); // fin de Scanner	
	}
}