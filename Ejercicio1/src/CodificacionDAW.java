import java.util.Scanner;

/*
 * EJERCICIO 1.
 * 
 * OBJETIVO: Codificación y decodificación de un texto alternando caracteres por pares.
 * 
 * AUTOR: Javier Latorre -> jlalovi@gmail.com
 *
 * FECHA: 11-dec-2014
 */

public class CodificacionDAW {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE CODIFICA O DECODIFICA EL TEXTO INTRODUCIDO:");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		int longitud;          // Número de caracteres que contiene el String introducido por el usuario.
		String texto;		   // Texto introducido por el usuario.
		String texto_decode;   // Variable que contendrá el texto codificado o decodificado.
		String opcion;         // Variable que contendrá la opción elegida.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		texto_decode = "";

		Scanner entrada = new Scanner(System.in);
		
		opcion = preguntar("¿Qué desea hacer? ¿(C)odificar o (D)ecodificar?","C,D");

		if (opcion.equalsIgnoreCase("c"))
			System.out.println("Introduce el texto que quieres codificar:");
		else
			System.out.println("Introduce el texto que quieres decodificar:");
		
		texto = entrada.nextLine();
		
		entrada.close();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		if (opcion.equalsIgnoreCase("c"))
			texto_decode = codificar(texto);
		else
			texto_decode = decodificar(texto);
		
		
	
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		System.out.println(texto_decode);
		
	}

	/*
	 * MÉTODO preguntar(String,String):
	   · Este método está compuesto por dos parámetros, ambos Strings:
	       - El primer parámetro es la pregunta que se desea imprimir por pantalla.
	       - El segundo, las opciones válidas para la pregunta. Las opciones se separarán por comas para admitir más de un carácter por opción.
	         No se diferenciará entre mayúsculas y minúsculas y se eliminarán los espacios entre las comas.
	*/
		private static String preguntar(String pregunta, String opciones) {
				
		 // DECLARACIÓN DE VARIABLES
		 // ========================
			
			String opcion_elegida;          // Cadena de control de la opción elegida para pasarla a carácter.
			boolean opcion_correcta;        // Variable de control para salir de bucle y para salir del método una vez seleccionada una de las posibles opciones correctas.
			String [] opcion_comparar;      // Vector que almacena cada una de las opciones especificadas en el método separadas por comas.
			
		 // ENTRADA Y PROCESO DE DATOS (INPUT)
		 // ==================================
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println(pregunta);
			opcion_elegida = entrada.nextLine().trim(); // Quito espacios del principio y final.
			
			opcion_comparar = opciones.split(",");
			
			opcion_correcta = false;  // Presupongo que la opción elegida de primeras es incorrecta, para comprobar si es verdad o no en el siguiente bucle.
			do {
				for (int i=0; i<opcion_comparar.length && opcion_correcta==false; i++) {  // Saldré del bucle cuando se terminen de comprobar las diferentes opciones o cuando se encuentre una opción correcta.
					if (opcion_elegida.equalsIgnoreCase(opcion_comparar[i].trim())) {  // Comparo la opción elegida con cada opción indicada por el usuario en el método (quito espacios de principio y final en caso de que los haya entre la separación de las comas)
						opcion_correcta=true;
					}
				}
				if (opcion_correcta==false) {  // Si el bucle anterior termina sin dar valor verdadero a 'opcion_correcta', pido de nuevo
					System.out.println("Por favor, introduce una de las opciones indicadas en la pregunta.");
					System.out.println(pregunta);
					opcion_elegida = entrada.nextLine().trim();
				}
			} while (opcion_correcta==false);
			
			// entrada.close();  Tengo problemas al volver a llamar al método si cierro el Scanner. (Volveré a ello en el futuro)
			
		// SALIDA DE DATOS (OUTPUT)
		// ========================
			
			return opcion_elegida;
			
		}
	/*
	 * FIN MÉTODO preguntar(String,String);
	 */

		
	/*
	 * MÉTODO codificar(String) y decodificar(string):
	*/
	private static String codificar(String texto) {
		
	 // DECLARACIÓN DE VARIABLES
	 // ========================
		
		String texto_nuevo="";  // Cadena donde almacenaré el texto codificado.
		
	 // ENTRADA Y PROCESO DE DATOS (INPUT)
	 // ==================================
		
		if (texto.length()%2==0) {
			for (int i=0; i<texto.length(); i+=2) {
				texto_nuevo += texto.charAt(i+1) + texto.charAt(i);
			}
		}
		if (texto.length()%2==1) {
			for (int i=0; i<texto.length()-1; i+=2) {
				texto_nuevo += texto.charAt(i+1) + texto.charAt(i);
			}
			texto_nuevo += texto.charAt(texto.length()-1);
		}
		
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
			
		return texto_nuevo;
			
		}
	
	private static String decodificar(String texto) {
		return codificar(texto);  // Puesto que codificar y decodificar sigue el mismo proceso, realizo una sobrecarga del método codificar(String).
	}
	
	/*
	 * FIN MÉTODO codificar(String) y decodificar(string);
	 */
	
}
