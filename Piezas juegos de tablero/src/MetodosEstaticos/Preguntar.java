package MetodosEstaticos;
import java.util.Scanner;

/**
 * Clase Preguntar
 * contiene métodos para solicitar datos por la consola. 
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 07/03/2015 (v.2)
 * @since 09/01/2015
 *
 */
public class Preguntar {

	/**
	 * Imprime por consola presionar que se presione intro para poder continuar. En caso de que se escriba algo y se pulse intro,
	 * se volverá a mostrar el mensaje por pantalla hasta que únicamente se presione intro.
	 */
	public static void continuar(){
		String intro="";
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println(" --Presione 'intro' para continuar--");
			intro=entrada.nextLine();			
		} while (!"".equals(intro));
	}
	
	/**
	 * Imprime por consola una 'pregunta' que permita una serie de 'opciones' almacenadas en una cadena separadas por comas.
	 * En consola se imprimirá la pregunta y se solicitará al usuario que escriba una de las opciones para continuar, sino es así, 
	 * se volverá a repetir la pregunta hasta que el usuario introduzca una de las opciones permitidas.
	 * Ejemplo: 'opciones("¿Quieres continuar?", "s,n,S,N")'
	 * @param pregunta
	 * @param opciones
	 * @return una de las opciones posibles que haya intoducido el usuario
	 */
	public static String opciones(String pregunta, String opciones) {
		
		String opcion_elegida;          // Cadena de control de la opción elegida para pasarla a carácter.
		boolean opcion_correcta;        // Variable de control para salir de bucle y para salir del método una vez seleccionada una de las posibles opciones correctas.
		String [] opcion_comparar;      // Vector que almacena cada una de las opciones especificadas en el método separadas por comas.
		
		@SuppressWarnings("resource")
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
				System.out.println("Por favor, introduce una de las opciones indicadas.\n");
				System.out.println(pregunta);
				opcion_elegida = entrada.nextLine().trim();
			}
		} while (opcion_correcta==false);
		
		// entrada.close();  Tengo problemas al volver a llamar al método si cierro el Scanner. (Volveré a ello en el futuro)
		
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
	
	/**
	 * Permite imprimir por consola una 'pregunta' que deberá ser contestada por el usuario por consola con una cadena
	 * que no puede ser vacía, con un 'tamaño_max' de caracteres y con/sin espacios permitidos. Sino se cumple alguna
	 * de estas tres condiciones, se repetirá la pregunta para que el usuario vuelva a introducir un nuevo valor por consola.	 * 
	 * @param pregunta que se imprimirá por pantalla
	 * @param tamaño_max de caracteres permitidos en la respuesta
	 * @param espacios true: permitidos / false: no permitidos	 * 
	 * @return cadena escrita por el usuario por consola que supere todas estas condiciones
	 */
	public static String cadena(String pregunta, int tamaño_max, boolean espacios) {
		String cadena_elegida;
		boolean cadena_correcta=false;
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println(pregunta);
			cadena_elegida = entrada.nextLine().trim(); // Quito espacios del principio y final.
			if ("".equals(cadena_elegida))
				System.out.println("El valor introducido no puede estar vacío. Introduce de nuevo otro valor.");
			else if (cadena_elegida.length()>tamaño_max)
				System.out.println("El valor introducido no puede tener más de " + tamaño_max + " caracteres. Introduce de nuevo otro valor.");
			else if (espacios=false) {
				cadena_correcta=true; //presupongo que no hay espacios en la cadena introducida y compruebo en el siguiente bucle.
				for (int i=0; i<cadena_elegida.length(); i++){
					if (cadena_elegida.charAt(i)==' ')
						cadena_correcta=false;
				}
				if (cadena_correcta==false)
					System.out.println("El valor introducido no puede contener espacios. Introduce de nuevo otro valor.");
			}
			else
				cadena_correcta=true;
			
		} while (cadena_correcta==false);
		
		return cadena_elegida;
	}
	
	/**
	 * Sobrecarga de método cadena(pregunta, tamaño_max, espacios), siendo espacios=true por defecto.
	 * @param pregunta que se imprimirá por pantalla
	 * @param tamaño_max de caracteres permitidos en la respuesta
	 * @return cadena escrita por el usuario por consola que supere todas estas condiciones
	 * @see cadena(String pregunta, int tamaño_max, boolean espacios)
	 */
	public static String cadena(String pregunta, int tamaño_max) {
		return cadena(pregunta, tamaño_max, true);
	}
	
	/**
	 * Sobrecarga de método cadena(pregunta, tamaño_max, espacios), siendo tamaño_max=50 y espacios=true por defecto. 
	 * @param pregunta que se imprimirá por pantalla 
	 * @return cadena escrita por el usuario por consola que supere todas estas condiciones 
	 * @see cadena(String pregunta, int tamaño_max, boolean espacios)
	 */
	public static String cadena(String pregunta) {
		return cadena(pregunta, 50, true);
	}
	
	/**
	 * Permite imprimir por consola una 'pregunta' que deberá ser contestada por el usuario por consola con un número entero
	 * que comprenda los valores entre 'principio' y 'fin'. El método obligará al usuario a introducir un número correcto
	 * a partir de una serie de bucles que imprimirán por pantalla el tipo de error.
	 * NOTA: HAY QUE MEJORAR EL MÉTODO PARA INCLUIR NÚMEROS NEGATIVOS Y CREAR TAMBIÉN UNA SOBRECARGA QUE PERMITA 'DOUBLES'
	 * @param pregunta que se imprimirá por pantalla 
	 * @param principio es el primer valor del intervalo (inclusive)
	 * @param fin es el último valor del intervalo (inclusive)
	 * @return número entero introducido por el usuario por consola que haya superado todas las condiciones anteriores
	 */
	public static int intervalo(String pregunta, int principio, int fin) {
		String numero_elegido;
		int numero=0;
		boolean numero_correcto=false;
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println(pregunta);
			numero_elegido=entrada.nextLine().trim();
			
			if ("".equals(numero_elegido))
				System.out.println("El valor introducido no puede estar vacío. Introduce de nuevo un valor.");
			else {
				for (int i=0; i<numero_elegido.length(); i++) { // Compruebo número a número si de verdad lo son:
					if (Integer.valueOf(numero_elegido.charAt(i))<48  || Integer.valueOf(numero_elegido.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
						System.out.println("El valor introducido no es numérico. Vuelve a introducir un valor.");
						numero_correcto=false;
					}
					else
						numero_correcto=true;
				}
				if (numero_correcto) {
					numero=Integer.parseInt(numero_elegido);
					if (numero>=principio && numero<=fin)
						numero_correcto=true;
					else  {
						System.out.println("El valor introducido no comprende los valores entre " + principio + " y " + fin + ". Vuelve a introducir un valor.");
						numero_correcto=false;
					}
				}
			}
		} while(numero_correcto==false);
		
		return numero;
	}
}
