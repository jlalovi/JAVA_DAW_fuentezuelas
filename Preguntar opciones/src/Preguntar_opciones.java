import java.util.Scanner;

public class Preguntar_opciones {

	public static void main(String[] args) {
		// Testeo:
		
		String prueba1 = preguntar("�Qu� g�nero de mola? (T)error, (D)rama, (C)omedia","t,  D, c  ");
		
		String prueba2 = preguntarSiNo("Te mola �(S)i o (N)o?");
		
		String prueba3 = preguntarSiNo();
		
		System.out.println("La opciones elegidas son: " + prueba1 + " " + prueba2 + " " + prueba3);
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

	private static String preguntarSiNo(String pregunta) {
		return preguntar(pregunta,"s,n");
	}
	
	private static String preguntarSiNo() {
		return preguntarSiNo("�Desea continuar? �(S)i o (N)o?");
	}
/*
 * FIN M�TODOS preguntar(String,String), preguntarSiNo(String) y preguntarSiNo();
 */
	
}
