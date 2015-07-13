import java.util.Scanner;

/*
 * EJERCICIO 1.
 * 
 * OBJETIVO: Codificaci�n y decodificaci�n de un texto alternando caracteres por pares.
 * 
 * AUTOR: Javier Latorre -> jlalovi@gmail.com
 *
 * FECHA: 11-dec-2014
 */

public class CodificacionDAW {

	public static void main(String[] args) {
		
		System.out.println("PROGRAMA QUE CODIFICA O DECODIFICA EL TEXTO INTRODUCIDO:");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int longitud;          // N�mero de caracteres que contiene el String introducido por el usuario.
		String texto;		   // Texto introducido por el usuario.
		String texto_decode;   // Variable que contendr� el texto codificado o decodificado.
		String opcion;         // Variable que contendr� la opci�n elegida.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		texto_decode = "";

		Scanner entrada = new Scanner(System.in);
		
		opcion = preguntar("�Qu� desea hacer? �(C)odificar o (D)ecodificar?","C,D");

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
	 * M�TODO preguntar(String,String):
	   � Este m�todo est� compuesto por dos par�metros, ambos Strings:
	       - El primer par�metro es la pregunta que se desea imprimir por pantalla.
	       - El segundo, las opciones v�lidas para la pregunta. Las opciones se separar�n por comas para admitir m�s de un car�cter por opci�n.
	         No se diferenciar� entre may�sculas y min�sculas y se eliminar�n los espacios entre las comas.
	*/
		private static String preguntar(String pregunta, String opciones) {
				
		 // DECLARACI�N DE VARIABLES
		 // ========================
			
			String opcion_elegida;          // Cadena de control de la opci�n elegida para pasarla a car�cter.
			boolean opcion_correcta;        // Variable de control para salir de bucle y para salir del m�todo una vez seleccionada una de las posibles opciones correctas.
			String [] opcion_comparar;      // Vector que almacena cada una de las opciones especificadas en el m�todo separadas por comas.
			
		 // ENTRADA Y PROCESO DE DATOS (INPUT)
		 // ==================================
			
			Scanner entrada = new Scanner(System.in);
			
			System.out.println(pregunta);
			opcion_elegida = entrada.nextLine().trim(); // Quito espacios del principio y final.
			
			opcion_comparar = opciones.split(",");
			
			opcion_correcta = false;  // Presupongo que la opci�n elegida de primeras es incorrecta, para comprobar si es verdad o no en el siguiente bucle.
			do {
				for (int i=0; i<opcion_comparar.length && opcion_correcta==false; i++) {  // Saldr� del bucle cuando se terminen de comprobar las diferentes opciones o cuando se encuentre una opci�n correcta.
					if (opcion_elegida.equalsIgnoreCase(opcion_comparar[i].trim())) {  // Comparo la opci�n elegida con cada opci�n indicada por el usuario en el m�todo (quito espacios de principio y final en caso de que los haya entre la separaci�n de las comas)
						opcion_correcta=true;
					}
				}
				if (opcion_correcta==false) {  // Si el bucle anterior termina sin dar valor verdadero a 'opcion_correcta', pido de nuevo
					System.out.println("Por favor, introduce una de las opciones indicadas en la pregunta.");
					System.out.println(pregunta);
					opcion_elegida = entrada.nextLine().trim();
				}
			} while (opcion_correcta==false);
			
			// entrada.close();  Tengo problemas al volver a llamar al m�todo si cierro el Scanner. (Volver� a ello en el futuro)
			
		// SALIDA DE DATOS (OUTPUT)
		// ========================
			
			return opcion_elegida;
			
		}
	/*
	 * FIN M�TODO preguntar(String,String);
	 */

		
	/*
	 * M�TODO codificar(String) y decodificar(string):
	*/
	private static String codificar(String texto) {
		
	 // DECLARACI�N DE VARIABLES
	 // ========================
		
		String texto_nuevo="";  // Cadena donde almacenar� el texto codificado.
		
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
		return codificar(texto);  // Puesto que codificar y decodificar sigue el mismo proceso, realizo una sobrecarga del m�todo codificar(String).
	}
	
	/*
	 * FIN M�TODO codificar(String) y decodificar(string);
	 */
	
}
