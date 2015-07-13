import java.util.Scanner;

/**
 * Clase Preguntar
 * contiene m�todos para hacer preguntas con opciones. 
 * 
 * @author Javier Latorre
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */

public class Preguntar {

	/**
	 * 
	 * M�todo 'opciones'
	 * imprime una pregunta y devuelve una opci�n elegida por el usuario entre todas las que se hayan indicado en el m�todo a partir de una cadena con
	 * las opciones separadas por comas.
	 * 
	 * <p>Ejemplo: Preguntar.opciones("�Te gusta la aplicaci�n? �(S)i, (N)o, (Q)uiz�s?", "s,n,q")</p>
	 * 
	 * @param pregunta 'String' de la pregunta que se imprimir�
	 * @param opciones 'String' con las opciones separadas por comas ','
	 * @return 'String' de la opci�n elegida
	 * 
	 * @since 09/01/2015
	 */
	public static String opciones (String pregunta, String opciones) {
		
	 // DECLARACI�N VARIABLES
	 // =====================
		String opcion_elegida;          // Cadena de control de la opci�n elegida para pasarla a car�cter.
		boolean opcion_correcta;        // Variable de control para salir de bucle y para salir del m�todo una vez seleccionada una de las posibles opciones correctas.
		String [] opcion_comparar;      // Vector que almacena cada una de las opciones especificadas en el m�todo separadas por comas.
		
		
	 // ENTRADA Y PROCESAMIENTO DE DATOS
	 // ================================
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
		
	 // SALIDA DE DATOS
	 // ===============
		return opcion_elegida;
		
	}

	/**
	 * 
	 * M�todo 'siNo'
	 * imprime una pregunta y devuelve la opci�n elegida por el usuario "s" o "n".
	 * 
	 * <p>Ejemplo: Preguntar.siNo("�Te gusta la aplicaci�n? �(S)i, (N)o")</p>
	 *  
	 * @param pregunta 'String' de la pregunta que se imprimir�
	 * @return 'String' de la opci�n elegida "s" o "n"
	 * 
	 * @since 09/01/2015
	 */
	public static String siNo(String pregunta) {
		return opciones(pregunta,"s,n");
	}
	
	/**
	 * 
	 * M�todo 'siNo'
	 * imprime la pregunta "�Desea continuar?" y devuelve la opci�n elegida por el usuario "s" o "n".
	 * 
	 * @return 'String' de la opci�n elegida "s" o "n"
	 * 
	 * @since 09/01/2015
	 */
	public static String siNo() {
		return siNo("�Desea continuar? �(S)i o (N)o?");
	}
	
}
