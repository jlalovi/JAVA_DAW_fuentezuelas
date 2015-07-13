import java.util.Scanner;

/*

MANEJO DE STRINGS 1.7
=====================

OBJETIVO: 
	Programa que averigua si un DNI introducido es correcto. (Consultar en internet como se obtiene la 
	letra del DNI).

OBSERVACIONES:
	- Considero una letra aquellas que est�n en la tabla ASCII entre los valores: 97-122 (Para ello 
	  pasar� el texto introducido a min�sculas).
	- Considero aquellos DNIs que tienen menos de 8 cifras.
	- Considero si el usuario introduce la letra del DNI en may�sculas o min�sculas.
	- Considero un DNI incorrecto si su longitud es de m�s de 9 caract�res o menos de 2.
	- Tambi�n compruebo si la posici�n que equivale a la letra NO es un n�mero.
	- De todos estos tipo de error, env�o un mensaje de error correspondiente.
	
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

	 // DELARACI�N DE VARIABLES
	 // =======================

		String DNI;           // DNI introducido por el usuario.
		int longitud;         // Longitud del DNI.
		String numero;        // N�mero del DNI almacenado en una cadena.
		char letra;           // Letra del DNI.
		boolean DNIcorrecto;  // Verdadero o falso.
		int modulo23DNI;      // El m�dulo 23 del n�mero del DNI, que me servir� para saber si la letra introducida es correcta.
		String letrasDNI;     // Cadena donde almacenar� en orden las letras equivalentes de DNI una vez realizado el m�dulo 23.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		DNIcorrecto = true;  // Presupondr� que el DNI que se introducir� es verdadero desde el principio.
		
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
			
		if (DNIcorrecto) {  // Si la longitud del DNI no es superior a 9 caracteres, procedo con la siguiente comprobaci�n:
			
			numero = DNI.substring(0, longitud-1);  // La cadena 'numero' ser� el DNI menos el �ltimo car�cter que presupondr� que es una letra correcta.
			
			for (int i=0; i<=longitud-2; i++) { // Compruebo n�mero a n�mero si de verdad lo son:
				
				if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
					DNIcorrecto = false;  // Si alguno de estos n�meros comprobados queda fuera de rango especificado, NO es un n�mero, por lo que el DNI es incorrecto.
					System.out.printf("El car�cter %s NO es un n�mero\n", numero.charAt(i));
				}
				
			}
			
			if (DNIcorrecto) { // Si he pasado los pasos anteriores, sigo presuponiendo que el DNI es correcto. Sino, me salto esta comprobaci�n.
				letra = DNI.toUpperCase().charAt(longitud-1);  // El caracter 'letra' presupondr� que ser� el �ltimo car�cter introducido en la cadena (adem�s lo convierto en may�scula).
				
				if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un n�mero.
					DNIcorrecto = false;
					System.out.println("�Se te ha olvidado introducir la letra de tu DNI!");
				}
				
				if (DNIcorrecto) {  // Si la letra del DNI es diferente a un n�mero, procedo con la siguiente comprobaci�n.
					
					modulo23DNI = Integer.valueOf(numero)%23; // M�dulo 23 del n�mero del DNI, que ser� un n�mero entre el 0 y el 22:
					letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";    // 23 letras posibles en el DNI, en orden del resultado del m�dulo23DNI.
					
					if (letra!=letrasDNI.charAt(modulo23DNI)) {
						DNIcorrecto = false;
						System.out.printf("La letra introducida en tu DNI es incorrecta. Deber�a ser la letra '%s'\n", letrasDNI.charAt(modulo23DNI));
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