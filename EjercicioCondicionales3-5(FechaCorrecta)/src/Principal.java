/*

Ejercicio 3.5 Condicionales
===========================

OBJETIVO: Pedir el d�a, mes y a�o de una fecha e indicar si la fecha es correcta. Con meses 
		  de 28, 30 y 31 d�as. CONSIDERANDO a�os bisiestos.

OBSERVACI�N: Se enviar� un mensaje de error en funci�n del tipo de error en d�a, mes o a�o.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 10-nov-2014

*/

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA PARA SABER SI LA FECHA INTRODUCIDA ES CORRECTA:");

	 // DELARACI�N DE VARIABLES
	 // =======================
		
		int ano, mes, dia;         // Variables que almacenar�n el a�o, mes y d�a introducidos por el usuario.
		
		boolean error=false;       // Variable que se activar� como 'true' en caso de haber alg�n error en el proceso de datos.
		
		String error_ano="",       //
			   error_bisiesto="",  // Variables que almacenar�n el tipo o tipos de errores a mostrar.
			   error_mes="",       //
			   error_dia="";       //

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		// A�o:
		System.out.println("Introduce un a�o d.C (A�o 1 o mayor):");
		ano = entrada.nextInt();

		// Mes:
		System.out.println("Introduce el mes (1-12):");
		mes = entrada.nextInt();

		// Mes:
		System.out.println("Introduce el d�a del mes:");
		dia = entrada.nextInt();
		
		entrada.close();
			
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		// A�o:
		if (ano<1) {
			error=true;
			error_ano = "- El a�o que has introducido NO es el a�o 1 o mayor.";
		}
		
		// Mes:
		if (mes<1 || mes>12) {
			error=true;
			error_mes = "- El mes introducido NO comprende entre el 1 y el 12.";
		}
		
		// D�a:
		switch (mes) {
		case 2:  // Febrero.
			if (dia==29) {  // Si el usuario introduce d�a '29', comprobamos si el a�o es bisiesto.
				if (!(ano%4 == 0 || (ano%4 == 0 && ano%100 == 0 && ano%400 == 0))) {
					error=true;
					error_bisiesto = "- Has marcado Febrero, d�a 29. Pero el a�o introducido NO es bisiesto.";
				}
			}
			else if (dia<1 || dia>28) {
				error=true;
				error_dia = "- Es Febrero y el d�a introducido NO comprende entre 1 y 28 (o 29 si es bisiesto).";
			}
			break;				
		case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
			if (dia<1 || dia>30) {
				error=true;
				error_dia = "- El d�a que has introducide NO corresponde con el mes correspondiente de 1 a 30 d�as.";
			}
			break;				
		case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
			if (dia<1 || dia>31) {
				error=true;
				error_dia = "- El d�a que has introducide NO corresponde con el mes correspondiente de 1 a 31 d�as.";
			}
			break;				
		default:
			if (dia<1 || dia>31) {
				error=true;
				error_dia = "- Adem�s de ser el mes incorrecto, el d�a NO comprende siquiera entre el 1 y el 31.";
			}
			break;
		}
		
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		if (error) {
			System.out.println("La fecha introducida NO es correcta porque:"); // Mostrar� los errores que contengan mensaje.
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