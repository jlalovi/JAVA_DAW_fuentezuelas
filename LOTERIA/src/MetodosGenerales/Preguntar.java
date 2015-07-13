package MetodosGenerales;
import java.util.Scanner;

/**
 * Clase Preguntar
 * contiene métodos para solicitar datos por la consola. 
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */
public class Preguntar {

	/**
	 * Permite imprimir por consola una 'pregunta' que permita una serie de 'opciones' almacenadas en una cadena separadas por comas.
	 * En consola se imprimirá la pregunta y se solicitará al usuario que escriba una de las opciones para continuar, sino es así, 
	 * se volverá a repetir la pregunta hasta que el usuario introduzca una de las opciones permitidas.
	 * Ejemplo: 'opciones("¿Quieres continuar?", "s,n,S,N")'
	 * @param pregunta
	 * @param opciones
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String opciones(String pregunta, String opciones) {
		
	 // DECLARACIÓN DE VARIABLES
		
		String opcion_elegida;          // Cadena de control de la opción elegida para pasarla a carácter.
		boolean opcion_correcta;        // Variable de control para salir de bucle y para salir del método una vez seleccionada una de las posibles opciones correctas.
		String [] opcion_comparar;      // Vector que almacena cada una de las opciones especificadas en el método separadas por comas.
		
	 // ENTRADA Y PROCESO DE DATOS (INPUT)
		
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
				System.out.println("Por favor, introduce una de las opciones indicadas.");
				System.out.println(pregunta);
				opcion_elegida = entrada.nextLine().trim();
			}
		} while (opcion_correcta==false);
		
		// entrada.close();  Tengo problemas al volver a llamar al método si cierro el Scanner. (Volveré a ello en el futuro)
		
	// SALIDA DE DATOS (OUTPUT)
		
		return opcion_elegida;
		
	}

	/**
	 * Permite imprimir por consola una 'pregunta' que deberá ser contestada por el usuario por consola con un s, n, S, o N.
	 * En consola se imprimirá la pregunta y se solicitará al usuario que escriba una de las opciones para continuar, sino es así, 
	 * se volverá a repetir la pregunta hasta que el usuario introduzca una de las opciones permitidas.
	 * Ejemplo: 'siNo("¿Quieres continuar?")'
	 * @param pregunta
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String siNo(String pregunta) {
		return opciones(pregunta,"s,n,S,N");
	}
	
	/**
	 * Sobrecarga del método 'siNo(pregunta)' con la pregunta por defecto "¿Desea Continuar?"
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String siNo() {
		return siNo("¿Desea continuar? ¿(S)i o (N)o?");
	}
	
}
