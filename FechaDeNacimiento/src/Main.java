/*

Ejercicio 12 - Relación Bucles 2
================================

OBJETIVO: Programa que pide el año de nacimiento al usuario y calcula la edad del mismo. Si el año de nacimiento introducido 
		  es posterior a 201x por error el programa volverá a pedir el año de nacimiento correcto.

OBSERVACIONES: - Considero el tipo de mes y si el año es bisiesto.
			   - También considero que la persona más anciana en el momento de hacer el programa, nació el año 1898, por lo que
			     no permitiré introducir un año de nacimiento menor a ese.
			   - Mostraré como mensajes especiales si el usuario ha nacido hoy o si es su cumpleaños. En caso contrario, mostraré
			     su edad exacta en años, meses y días.

AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 31-oct-2014

*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int dia_hoy, mes_hoy, ano_hoy; // Variables donde el usuario almacenará la fecha de hoy.
		int dia_nac, mes_nac, ano_nac; // Variables donde el usuario almacenará la fecha de su nacimiento.
		int dias=0, meses, anos;       // Variables donde el programa almacenará la edad del usuario en días, meses y años.
		
   	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);
		
		// FECHA DE HOY.
		// AÑO:
		System.out.println("¿En qué año estamos actualmente? (2014<)");
		ano_hoy = entrada.nextInt();
		while (ano_hoy<0) {
			System.out.println("Por favor, Introduce un año igual o mayor que 2014.");
			ano_hoy = entrada.nextInt();
		}
		// MES:
		System.out.println("¿En qué mes estamos actualmente? (1-12)");
		mes_hoy = entrada.nextInt();
		while (mes_hoy<1 || mes_hoy>12) {
			System.out.println("Por favor, introduce un mes entre el 1 y el 12.");
			mes_hoy = entrada.nextInt();
		}
		// DÍA:
		System.out.println("¿En qué dia estamos actualmente?");
		dia_hoy = entrada.nextInt();
		switch (mes_hoy) {
			case 2:  // Febrero.
				if (dia_hoy==29) {  // Si el usuario introduce día '29', comprobamos si el año es bisiesto.
					if (!((ano_hoy % 4 == 0) && ((ano_hoy % 100 != 0) || (ano_hoy % 400 == 0)))) {
						System.out.println("Es Febrero, pero el año introducido anteriormente NO es bisiesto.");
						do {
							System.out.println("Por favor, introduce un día entre 1 y 28."); // Nos aseguramos de que el usuario introduzca
							dia_hoy = entrada.nextInt();									 // un día correcto.
						}
						while (dia_hoy<1 || dia_hoy>28);
					}
				}
				else if (dia_hoy<1 || dia_hoy>28) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 28.
					do {
						System.out.println("Por favor, introduce un día entre 1 y 28.");
						dia_hoy = entrada.nextInt();
					}
					while (dia_hoy<1 || dia_hoy>28);
				}
				break;				
			case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
				while (dia_hoy<1 || dia_hoy>30) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 30.
					System.out.println("Por favor, introduce un día entre 1 y 30.");
					dia_hoy = entrada.nextInt();
				}
				break;				
			case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
				while (dia_hoy<1 || dia_hoy>31) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 31.
					System.out.println("Por favor, introduce un día entre 1 y 31.");
					dia_hoy = entrada.nextInt();
				}
				break;				
			default:
				break;
		} // fin de 'switch'
		
		// FECHA DE NACIMIENTO.
		// AÑO:
		System.out.println("¿En qué año naciste? (1898<)"); // Ver observaciones.
		ano_nac = entrada.nextInt();
		while (ano_nac<1898) {
			System.out.println("Por favor, Introduce un año igual o mayor que 1898.");
			ano_nac = entrada.nextInt();
		}
		// MES:
		System.out.println("¿En qué mes naciste? (1-12)");
		mes_nac = entrada.nextInt();
		while (mes_nac<1 || mes_nac>12) {
			System.out.println("Por favor, introduce un mes entre el 1 y el 12.");
			mes_nac = entrada.nextInt();
		}
		// DÍA:
		System.out.println("¿En qué dia naciste?");
		dia_nac = entrada.nextInt();
		if (ano_nac == ano_hoy && mes_nac == mes_hoy && dia_nac > dia_hoy) { // Si el año y el mes de nacimiento son iguales a los de hoy:
			do {                                                             // Nos aseguramos de que el usuario introduzca un día inferior.
			System.out.println("A ver, ¿acaso vienes del futuro? Introduce un día inferior al de hoy.");  
			dia_nac = entrada.nextInt();
			}
			while(ano_nac == ano_hoy && mes_nac == mes_hoy && dia_nac > dia_hoy);
		}
		else {
			switch (mes_nac) {
				case 2:  // Febrero.
					if (dia_nac==29) {  // Si el usuario introduce día '29', comprobamos si el año es bisiesto.
						if (!(ano_nac%4 == 0 || (ano_nac%4 == 0 && ano_nac%100 == 0 && ano_nac%400 == 0))) {
							System.out.println("Es Febrero, pero el año introducido anteriormente NO es bisiesto.");
							do {
								System.out.println("Por favor, introduce un día entre 1 y 28."); // Nos aseguramos de que el usuario introduzca
								dia_nac = entrada.nextInt();									 // un día correcto.
							}
							while (dia_nac<1 || dia_nac>28);
						}
					}
					else if (dia_nac<1 || dia_nac>28) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 28.
						do {
							System.out.println("Por favor, introduce un día entre 1 y 28.");
							dia_nac = entrada.nextInt();
						}
						while (dia_nac<1 || dia_nac>28);
					}
					break;				
				case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
					while (dia_nac<1 || dia_nac>30) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 30.
						System.out.println("Por favor, introduce un día entre 1 y 30.");
						dia_nac = entrada.nextInt();
					}
					break;				
				case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
					while (dia_nac<1 || dia_nac>31) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 31.
						System.out.println("Por favor, introduce un día entre 1 y 31.");
						dia_nac = entrada.nextInt();
					}
					break;				
				default:
					break;
			} // fin de 'switch'
		} // fin de 'else'
		
		entrada.close(); // Fin Scanner.		
				
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		if (dia_nac>dia_hoy) {    // Si el día de nacimiento es mayor que el día de hoy:
			meses = 1;            // La variable 'meses' actúa aquí como acumulador que utilizaré más adelante.
			switch (mes_hoy-1) {
			case 2: // Febrero
				dias = 28 + (dia_hoy - dia_nac); // El resultado del paréntesis será negativo, por eso es la suma del paréntesis.
				break;
			case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
				dias = 30 + (dia_hoy - dia_nac); // El resultado del paréntesis será negativo, por eso es la suma del paréntesis.
				break;				
			case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
				dias = 31 + (dia_hoy - dia_nac); // El resultado del paréntesis será negativo, por eso es la suma del paréntesis.
				break;
			default:
				break;
			}
		}
		else {
			meses = 0; // La variable 'meses' actúa aquí como acumulador que utilizaré más adelante.
			dias = dia_hoy - dia_nac;
		}
		
		if (mes_nac+meses>mes_hoy) { // A la variable 'mes_nac' se le suma el acumulador 'meses', que es 0 o 1.
			anos = 1; // La variable 'anos' actúa aquí como acumulador que utilizaré más adelante.
			meses = 12 + ( mes_hoy - (mes_nac + meses) ); // Aquí también utilizo el acumulador 'meses'.
		}
		else {
			anos = 0; // La variable 'anos' actúa aquí como acumulador que utilizaré más adelante.
			meses = mes_hoy - (mes_nac + meses); // Aquí también utilizo el acumulador 'meses'.
		}
		
		anos = ano_hoy - (ano_nac + anos);  // A la variable 'ano_nac' se le suma el acumulador 'anos', que es 0 o 1.
		
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		if (ano_nac == ano_hoy && mes_nac==mes_hoy && dia_nac==dia_hoy) {
			System.out.println("¡Enhorabuena! ¡Hoy es tu primer día de vida!");
		}
		else if (mes_nac==mes_hoy && dia_nac==dia_hoy) {
			System.out.println("¡Felicidades! ¡Hoy cumples "+anos+" año/s!");
		}
		else {
			System.out.println("Tu edad exacta es: "+anos+" año/s, "+meses+" mese/s y "+dias+" día/s.");
		}
		
	}
}
