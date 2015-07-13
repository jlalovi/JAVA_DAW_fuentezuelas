import java.util.Scanner;

public class Preguntar_opciones {

	public static void main(String[] args) {
		// Testeo:
		
		String prueba1 = preguntar("¿Qué género de mola? (T)error, (D)rama, (C)omedia","t,  D, c  ");
		
		String prueba2 = preguntarSiNo("Te mola ¿(S)i o (N)o?");
		
		String prueba3 = preguntarSiNo();
		
		System.out.println("La opciones elegidas son: " + prueba1 + " " + prueba2 + " " + prueba3);
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

	private static String preguntarSiNo(String pregunta) {
		return preguntar(pregunta,"s,n");
	}
	
	private static String preguntarSiNo() {
		return preguntarSiNo("¿Desea continuar? ¿(S)i o (N)o?");
	}
/*
 * FIN MÉTODOS preguntar(String,String), preguntarSiNo(String) y preguntarSiNo();
 */
	
}
