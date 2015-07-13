package MetodosGenerales;
import java.util.Scanner;

/**
 * Clase Preguntar
 * contiene m�todos para solicitar datos por la consola. 
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */
public class Preguntar {

	/**
	 * Permite imprimir por consola una 'pregunta' que permita una serie de 'opciones' almacenadas en una cadena separadas por comas.
	 * En consola se imprimir� la pregunta y se solicitar� al usuario que escriba una de las opciones para continuar, sino es as�, 
	 * se volver� a repetir la pregunta hasta que el usuario introduzca una de las opciones permitidas.
	 * Ejemplo: 'opciones("�Quieres continuar?", "s,n,S,N")'
	 * @param pregunta
	 * @param opciones
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String opciones(String pregunta, String opciones) {
		
	 // DECLARACI�N DE VARIABLES
		
		String opcion_elegida;          // Cadena de control de la opci�n elegida para pasarla a car�cter.
		boolean opcion_correcta;        // Variable de control para salir de bucle y para salir del m�todo una vez seleccionada una de las posibles opciones correctas.
		String [] opcion_comparar;      // Vector que almacena cada una de las opciones especificadas en el m�todo separadas por comas.
		
	 // ENTRADA Y PROCESO DE DATOS (INPUT)
		
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
				System.out.println("Por favor, introduce una de las opciones indicadas.");
				System.out.println(pregunta);
				opcion_elegida = entrada.nextLine().trim();
			}
		} while (opcion_correcta==false);
		
		// entrada.close();  Tengo problemas al volver a llamar al m�todo si cierro el Scanner. (Volver� a ello en el futuro)
		
	// SALIDA DE DATOS (OUTPUT)
		
		return opcion_elegida;
		
	}

	/**
	 * Permite imprimir por consola una 'pregunta' que deber� ser contestada por el usuario por consola con un s, n, S, o N.
	 * En consola se imprimir� la pregunta y se solicitar� al usuario que escriba una de las opciones para continuar, sino es as�, 
	 * se volver� a repetir la pregunta hasta que el usuario introduzca una de las opciones permitidas.
	 * Ejemplo: 'siNo("�Quieres continuar?")'
	 * @param pregunta
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String siNo(String pregunta) {
		return opciones(pregunta,"s,n,S,N");
	}
	
	/**
	 * Sobrecarga del m�todo 'siNo(pregunta)' con la pregunta por defecto "�Desea Continuar?"
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String siNo() {
		return siNo("�Desea continuar? �(S)i o (N)o?");
	}
	
}
