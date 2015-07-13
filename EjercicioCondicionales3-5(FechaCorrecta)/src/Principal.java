/*

Ejercicio 3.5 Condicionales
===========================

OBJETIVO: Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Con meses 
		  de 28, 30 y 31 días. CONSIDERANDO años bisiestos.

OBSERVACIÓN: Se enviará un mensaje de error en función del tipo de error en día, mes o año.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA SABER SI LA FECHA INTRODUCIDA ES CORRECTA:");

	 // DELARACIÓN DE VARIABLES
	 // =======================
		
		int ano, mes, dia;         // Variables que almacenarán el año, mes y día introducidos por el usuario.
		
		boolean error=false;       // Variable que se activará como 'true' en caso de haber algún error en el proceso de datos.
		
		String error_ano="",       //
			   error_bisiesto="",  // Variables que almacenarán el tipo o tipos de errores a mostrar.
			   error_mes="",       //
			   error_dia="";       //

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		// Año:
		System.out.println("Introduce un año d.C (Año 1 o mayor):");
		ano = entrada.nextInt();

		// Mes:
		System.out.println("Introduce el mes (1-12):");
		mes = entrada.nextInt();

		// Mes:
		System.out.println("Introduce el día del mes:");
		dia = entrada.nextInt();
		
		entrada.close();
			
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		// Año:
		if (ano<1) {
			error=true;
			error_ano = "- El año que has introducido NO es el año 1 o mayor.";
		}
		
		// Mes:
		if (mes<1 || mes>12) {
			error=true;
			error_mes = "- El mes introducido NO comprende entre el 1 y el 12.";
		}
		
		// Día:
		switch (mes) {
		case 2:  // Febrero.
			if (dia==29) {  // Si el usuario introduce día '29', comprobamos si el año es bisiesto.
				if (!(ano%4 == 0 || (ano%4 == 0 && ano%100 == 0 && ano%400 == 0))) {
					error=true;
					error_bisiesto = "- Has marcado Febrero, día 29. Pero el año introducido NO es bisiesto.";
				}
			}
			else if (dia<1 || dia>28) {
				error=true;
				error_dia = "- Es Febrero y el día introducido NO comprende entre 1 y 28 (o 29 si es bisiesto).";
			}
			break;				
		case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
			if (dia<1 || dia>30) {
				error=true;
				error_dia = "- El día que has introducide NO corresponde con el mes correspondiente de 1 a 30 días.";
			}
			break;				
		case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
			if (dia<1 || dia>31) {
				error=true;
				error_dia = "- El día que has introducide NO corresponde con el mes correspondiente de 1 a 31 días.";
			}
			break;				
		default:
			if (dia<1 || dia>31) {
				error=true;
				error_dia = "- Además de ser el mes incorrecto, el día NO comprende siquiera entre el 1 y el 31.";
			}
			break;
		}
		
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		if (error) {
			System.out.println("La fecha introducida NO es correcta porque:"); // Mostraré los errores que contengan mensaje.
			if (error_ano!="") {
				System.out.println(error_ano);
			}
			if (error_mes!="") {
				System.out.println(error_mes);
			}
			if (error_dia!="") {
				System.out.println(error_dia);
			}
			if (error_bisiesto!="") {
				System.out.println(error_bisiesto);
			}
			
		}	
	}

}