import java.util.Scanner;

/*

MANEJO DE STRINGS 1.7
=====================

OBJETIVO: 
	Programa que averigua si un DNI introducido es correcto. (Consultar en internet como se obtiene la 
	letra del DNI).

OBSERVACIONES:
	- Considero una letra aquellas que están en la tabla ASCII entre los valores: 97-122 (Para ello 
	  pasaré el texto introducido a minúsculas).
	- Considero aquellos DNIs que tienen menos de 8 cifras.
	- Considero si el usuario introduce la letra del DNI en mayúsculas o minúsculas.
	- Considero un DNI incorrecto si su longitud es de más de 9 caractéres o menos de 2.
	- También compruebo si la posición que equivale a la letra NO es un número.
	- De todos estos tipo de error, envío un mensaje de error correspondiente.
	
AUTOR: Javier Latorre -> jlalovi@gmail.com

FECHA: 30-nov-2014

*/

/**
 * 
 * @author Javier
 *
 */

public class Principal {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE COMPRUEBA SI UN DNI ES CORRECTO");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		String DNI;           // DNI introducido por el usuario.
		int longitud;         // Longitud del DNI.
		String numero;        // Número del DNI almacenado en una cadena.
		char letra;           // Letra del DNI.
		boolean DNIcorrecto;  // Verdadero o falso.
		int modulo23DNI;      // El módulo 23 del número del DNI, que me servirá para saber si la letra introducida es correcta.
		String letrasDNI;     // Cadena donde almacenaré en orden las letras equivalentes de DNI una vez realizado el módulo 23.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		DNIcorrecto = true;  // Presupondré que el DNI que se introducirá es verdadero desde el principio.
		
		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce tu DNI:");
		DNI = entrada.nextLine().trim();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		longitud = DNI.length();
		
		if (longitud<2 || longitud>9) {  // Compruebo que la longitud del DNI completo no es menor de 2 ni supera los 9 caracteres.
			DNIcorrecto = false;
			System.out.println("El DNI debe estar formado al menos por 2 caracteres y menos de 9.");
		}
			
		if (DNIcorrecto) {  // Si la longitud del DNI no es superior a 9 caracteres, procedo con la siguiente comprobación:
			
			numero = DNI.substring(0, longitud-1);  // La cadena 'numero' será el DNI menos el último carácter que presupondré que es una letra correcta.
			
			for (int i=0; i<=longitud-2; i++) { // Compruebo número a número si de verdad lo son:
				
				if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
					DNIcorrecto = false;  // Si alguno de estos números comprobados queda fuera de rango especificado, NO es un número, por lo que el DNI es incorrecto.
					System.out.printf("El carácter %s NO es un número\n", numero.charAt(i));
				}
				
			}
			
			if (DNIcorrecto) { // Si he pasado los pasos anteriores, sigo presuponiendo que el DNI es correcto. Sino, me salto esta comprobación.
				letra = DNI.toUpperCase().charAt(longitud-1);  // El caracter 'letra' presupondré que será el último carácter introducido en la cadena (además lo convierto en mayúscula).
				
				if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un número.
					DNIcorrecto = false;
					System.out.println("¡Se te ha olvidado introducir la letra de tu DNI!");
				}
				
				if (DNIcorrecto) {  // Si la letra del DNI es diferente a un número, procedo con la siguiente comprobación.
					
					modulo23DNI = Integer.valueOf(numero)%23; // Módulo 23 del número del DNI, que será un número entre el 0 y el 22:
					letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";    // 23 letras posibles en el DNI, en orden del resultado del módulo23DNI.
					
					if (letra!=letrasDNI.charAt(modulo23DNI)) {
						DNIcorrecto = false;
						System.out.printf("La letra introducida en tu DNI es incorrecta. Debería ser la letra '%s'\n", letrasDNI.charAt(modulo23DNI));
					}
					
				}
			}		
		}	

	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		if (DNIcorrecto)
			System.out.println("El DNI introducido es correcto.");
		else
			System.out.println("El DNI introducido NO es correcto.");
		
	}
}