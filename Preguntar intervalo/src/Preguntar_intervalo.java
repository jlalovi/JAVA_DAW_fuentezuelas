import java.util.Scanner;

public class Preguntar_intervalo {

	public static void main(String[] args) {
		// Testeo:
		
		int a = preguntarIntervalo(0,10);
		
		
		System.out.println(a);
		
	}

/*
 * MÉTODOS preguntar(String,String), preguntarSiNo(String) y preguntarSiNo():
   · El primer método está compuesto por dos parámetros, ambos Strings:
       - El primer parámetro es la pregunta que se desea imprimir por pantalla.
       - El segundo, las opciones válidas para la pregunta. Las opciones se separarán por comas para admitir más de un carácter por opción.
         No se diferenciará entre mayúsculas y minúsculas y se eliminarán los espacios entre las comas.
   · El segundo método es una sobrecarga del primero en el que sólo hay que indicar la pregunta, siendo las opciones predeterminadas 's' o 'n'.
   · El tercer método es una sobrecarga del segundo. No hay que indicar parámetro, imprimiéndose de manera predeterminada la pregunta '¿Desea continuar? ¿(S)i o (N)o?'
     con las opciones 's' y 'n'.
*/
	private static int preguntarIntervalo(int minimo, int maximo) {
			
	 // DECLARACIÓN DE VARIABLES
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
			numero_correcto=true;  // Presupongo que el número introducido es un número.
			for (int i=0; i<numero_string.length() && numero_correcto==true; i++) {			
				if (Integer.valueOf(numero_string.charAt(i))<48  || Integer.valueOf(numero_string.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
					numero_correcto = false;
					System.out.println("No has introducido un valor numérico.");
				}
				if (numero_correcto) { // Si el número introducido es un número, compruebo que esté dentro el intervalo.
					numero = Integer.parseInt(numero_string);
					if (numero<minimo || numero>maximo) {
						numero_correcto=false;
						System.out.printf("El valor numérico introducido no está dentro del intervalo %d - %d\n", minimo, maximo);
					}
				}
				if (numero_correcto==false) { // Si el valor introducido no cumple las condiciones anteriores, repetiré el bucle a continuación.
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
		
		 // DECLARACIÓN DE VARIABLES
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
				numero_correcto=true;  // Presupongo que el número introducido es un número.
				for (int i=0; i<numero_string.length() && numero_correcto==true; i++) {		
					if (Integer.valueOf(numero_string.charAt(i))<48  || Integer.valueOf(numero_string.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
						numero_correcto = false;
						System.out.println("No has introducido un valor numérico.");
					}
					if (numero_correcto) { // Si el número introducido es un número, compruebo que esté dentro el intervalo.
						numero = Double.parseDouble(numero_string);
						if (numero<minimo || numero>maximo) {
							numero_correcto=false;
							System.out.printf("El valor numérico introducido no está dentro del intervalo %d - %d\n", minimo, maximo);
						}
					}
					if (numero_correcto==false) { // Si el valor introducido no cumple las condiciones anteriores, repetiré el bucle a continuación.
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
 * FIN MÉTODOS preguntar(String,String), preguntarSiNo(String) y preguntarSiNo();
 */
	
}
