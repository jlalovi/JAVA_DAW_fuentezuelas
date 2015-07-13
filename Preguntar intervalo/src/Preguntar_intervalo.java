import java.util.Scanner;

public class Preguntar_intervalo {

	public static void main(String[] args) {
		// Testeo:
		
		int a = preguntarIntervalo(0,10);
		
		
		System.out.println(a);
		
	}

/*
 * M�TODOS preguntar(String,String), preguntarSiNo(String) y preguntarSiNo():
   � El primer m�todo est� compuesto por dos par�metros, ambos Strings:
       - El primer par�metro es la pregunta que se desea imprimir por pantalla.
       - El segundo, las opciones v�lidas para la pregunta. Las opciones se separar�n por comas para admitir m�s de un car�cter por opci�n.
         No se diferenciar� entre may�sculas y min�sculas y se eliminar�n los espacios entre las comas.
   � El segundo m�todo es una sobrecarga del primero en el que s�lo hay que indicar la pregunta, siendo las opciones predeterminadas 's' o 'n'.
   � El tercer m�todo es una sobrecarga del segundo. No hay que indicar par�metro, imprimi�ndose de manera predeterminada la pregunta '�Desea continuar? �(S)i o (N)o?'
     con las opciones 's' y 'n'.
*/
	private static int preguntarIntervalo(int minimo, int maximo) {
			
	 // DECLARACI�N DE VARIABLES
	 // ========================
		
		String numero_string;
		boolean numero_correcto;
		int numero=0;
		
	 // ENTRADA Y PROCESO DE DATOS (INPUT)
	 // ==================================
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("Introduce un valor entre %d y %d", minimo, maximo);
		numero_string = entrada.nextLine().trim();
		
		do {
			numero_correcto=true;  // Presupongo que el n�mero introducido es un n�mero.
			for (int i=0; i<numero_string.length() && numero_correcto==true; i++) {			
				if (Integer.valueOf(numero_string.charAt(i))<48  || Integer.valueOf(numero_string.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
					numero_correcto = false;
					System.out.println("No has introducido un valor num�rico.");
				}
				if (numero_correcto) { // Si el n�mero introducido es un n�mero, compruebo que est� dentro el intervalo.
					numero = Integer.parseInt(numero_string);
					if (numero<minimo || numero>maximo) {
						numero_correcto=false;
						System.out.printf("El valor num�rico introducido no est� dentro del intervalo %d - %d\n", minimo, maximo);
					}
				}
				if (numero_correcto==false) { // Si el valor introducido no cumple las condiciones anteriores, repetir� el bucle a continuaci�n.
					System.out.printf("Introduce otra vez el valor entre %d y %d", minimo, maximo);
					numero_string = entrada.nextLine().trim();
				}
			}
		} while (numero_correcto == false);
		
		
	// SALIDA DE DATOS (OUTPUT)
	// ========================
		
		return numero;
		
	}

	private static double preguntarIntervalo(double minimo, double maximo) {
		
		 // DECLARACI�N DE VARIABLES
		 // ========================
			
			String numero_string;
			boolean numero_correcto;
			double numero=0;
			
		 // ENTRADA Y PROCESO DE DATOS (INPUT)
		 // ==================================
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.printf("Introduce un valor entre %d y %d", minimo, maximo);
			numero_string = entrada.nextLine().trim();
			
			do {
				numero_correcto=true;  // Presupongo que el n�mero introducido es un n�mero.
				for (int i=0; i<numero_string.length() && numero_correcto==true; i++) {		
					if (Integer.valueOf(numero_string.charAt(i))<48  || Integer.valueOf(numero_string.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
						numero_correcto = false;
						System.out.println("No has introducido un valor num�rico.");
					}
					if (numero_correcto) { // Si el n�mero introducido es un n�mero, compruebo que est� dentro el intervalo.
						numero = Double.parseDouble(numero_string);
						if (numero<minimo || numero>maximo) {
							numero_correcto=false;
							System.out.printf("El valor num�rico introducido no est� dentro del intervalo %d - %d\n", minimo, maximo);
						}
					}
					if (numero_correcto==false) { // Si el valor introducido no cumple las condiciones anteriores, repetir� el bucle a continuaci�n.
						System.out.printf("Introduce otra vez el valor entre %d y %d", minimo, maximo);
						numero_string = entrada.nextLine().trim();
					}
				}
			} while (numero_correcto == false);
			
			
		// SALIDA DE DATOS (OUTPUT)
		// ========================
			
			return numero;
			
		}
	

/*
 * FIN M�TODOS preguntar(String,String), preguntarSiNo(String) y preguntarSiNo();
 */
	
}
