import java.util.Scanner;

/*
 * EJERCICIO 2.
 * 
 * OBJETIVO: 'Base de Datos' de alumnos y sus notas.
 * 
 * AUTOR: Javier Latorre -> jlalovi@gmail.com
 *
 * FECHA: 11-dec-2014
 */

public class AlumnosNotas {

	public static void main(String[] args) {

		System.out.println("ESTE PROGRAMA ALMACENA UNA SERIE DE DATOS SOBRE ALUMNOS Y TRABAJA CON ELLOS");

	 // DELARACIÓN DE VARIABLES
	 // =======================

		String [] nombres;      // Nombres alumnos.
		String [] apellidos;    // Apellidos alumnos.
		String [] DNI;          // DNI alumnos.
		String [] sexo;         // Apellidos alumnos.
		double [][] notas;      // Notas en Programación, Entornos y Sistemas.
		int nalumnos;           // Variable para marcar número total de alunos.
		int i;                  // Variable para iterar en los bucles.
		String opcion;          // Elegir opción de menú.
		String opcion_sexo;     // Elegir sexo para listado.
		double sumatorio;       // Variable que contedrá la suma de determinados números para a continuación hacer la media.
		double media;           // Variable que contendrá medias aritméticas.
		double sumatorioP=0;
		double mediaP;
		double sumatorioE=0;
		double mediaE;
		double sumatorioS=0;
		double mediaS;


	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);

		// Pido el número de alumnos que el usuario quiere registrar para inicializar el tamaño de los vectores.
		System.out.println("¿Cuántos alumnos deseas almacenar?");
		do {
			nalumnos = entrada.nextInt();
			if (nalumnos<=0) {
				System.out.println("Por favor, introduce un número positivo de alumnos y al menos uno: ");
			}
		} while (nalumnos<=0);
		
		nombres = new String[nalumnos];
		apellidos = new String[nalumnos];
		DNI = new String[nalumnos];
		sexo = new String[nalumnos];
		notas = new double[nalumnos][3];
		
		// Creo la 'Base de Datos' de alumnos a partir de los datos introducidos por el usuario.
		for (i=0; i<nalumnos; i++) {  // En cada iteración de este bucle, pediré los datos de cada alumno.

			entrada.nextLine(); // Limpio el buffer del Scanner para la lectura de las siguientes cadenas
			
			// NOMBRES
			System.out.printf("\nIntroduce el nombre del alumno %d: ", i+1);
			nombres[i] = entrada.nextLine();
			if (nombres[i]=="") {  // Obligo al usuario a introducir un nombre.
				do {
					System.out.println("Por favor introduce un nombre:");
					nombres[i] = entrada.nextLine();
				} while (nombres[i]=="");
			}
			
			// APELLIDOS
			System.out.printf("\nIntroduce el apellido del alumno %d: ", i+1);
			apellidos[i] = entrada.nextLine();
			if (apellidos[i]=="") {  // Obligo al usuario a introducir un apellido.
				do {
					System.out.println("Por favor introduce un Apellido:");
					apellidos[i] = entrada.nextLine();
				} while (apellidos[i]=="");
			}

			// DNI
			System.out.printf("\nIntroduce el dni del alumno %d: ", i+1);
			DNI[i] = dniCorrecto();
			
			// SEXO
			System.out.printf("\nIntroduce el dni del alumno %d: ", i+1);
			sexo[i] = preguntar("¿Es (H)ombre o (M)ujer?","h,m");
			
			// NOTAS
			System.out.printf("\nIntroduce la nota en Programación del alumno %d: ", i+1);
			notas[i][0] = entrada.nextDouble();
			if (notas[i][0]<0 || notas[i][0]>10) {  // Obligo al usuario a introducir una nota entre 0 y 10..
				do {
					System.out.println("Por favor introduce una nota que comprenda un valor entre 0 y 10:");
					notas[i][0] = entrada.nextDouble();
				} while (notas[i][0]<0 || notas[i][0]>10);
			}
			System.out.printf("\nIntroduce la nota en Entornos del alumno %d: ", i+1);
			notas[i][1] = entrada.nextDouble();
			if (notas[i][1]<0 || notas[i][1]>10) {  // Obligo al usuario a introducir una nota entre 0 y 10..
				do {
					System.out.println("Por favor introduce una nota que comprenda un valor entre 0 y 10:");
					notas[i][1] = entrada.nextDouble();
				} while (notas[i][1]<0 || notas[i][1]>10);
			}
			System.out.printf("\nIntroduce la nota en Sistemas del alumno %d: ", i+1);
			notas[i][2] = entrada.nextDouble();
			if (notas[i][2]<0 || notas[i][2]>10) {  // Obligo al usuario a introducir una nota entre 0 y 10..
				do {
					System.out.println("Por favor introduce una nota que comprenda un valor entre 0 y 10:");
					notas[i][2] = entrada.nextDouble();
				} while (notas[i][2]<0 || notas[i][2]>10);
			}

		} // fin de 'for(i=0; i<nalumnos; i++)'
		
	 // PROCESAMIENTO DE DATOS Y MENSAJES POR PANTALLA
	 // ==============================================

		do { // Quiero repetir el MENÚ tantas veces como el usuario quiera. Esto es cuando pulse la 'opción' 3.

			// MENÚ
			System.out.println("\n=============================================");
			System.out.println("MENÚ DE LA BASE DE DATOS CREADA SOBRE ALUMNOS");
			System.out.println("=============================================");
			System.out.println("Por favor, selecciona una de las siguientes opciones:");
			System.out.println("\t1.- Listar alumnos por sexo.");
			System.out.println("\t2.- Listar alumnos por con su nota media.");
			System.out.println("\t3.- Listar nota media de cada asignatura.");
			System.out.println("\t4.- Salir.");
			
			opcion = preguntar("Por favor, introduce el número de la opción (1, 2, 3 o 4): ", "1,2,3,4");
			
			entrada.nextLine(); // Limpio el buffer del Scanner para la lectura de las siguientes cadenas
			
			// OPCIÓN 1
			if (opcion.equals("1")) {
				
				opcion_sexo = preguntar("¿Qué alumnos desea listar? ¿(H)ombres o (M)ujeres?","h,m");
				
				System.out.println("\n\tLos siguientes alumnos componen el género seleccionado: ");
				for (i=0; i<nalumnos; i++) {
					if ( opcion_sexo.equalsIgnoreCase(sexo[i]) ) {
						System.out.printf("\n\tNombre: %s -- Apellidos: %s -- DNI: %s -- Notas: Programación(%f), Entornos(%f) y Sistemas(%f)", 
								          nombres[i], apellidos[i], DNI[i], notas[i][0], notas[i][1], notas[i][2]);
					}
				}

			}
			
			// OPCIÓN 2
			if (opcion.equals("2")) {
				
				System.out.println("\n\tLos siguientes alumnos poseen las siguientes medias: ");
				for (i=0; i<nalumnos; i++) {
					sumatorio = notas[i][0] + notas[i][1] + notas[i][2];
					media = mediaAritmetica(sumatorio,3);
					System.out.printf("\n\tNombre: %s -- Apellidos: %s -- DNI: %s -- Sexo: %s -- Nota media: %f", 
								     nombres[i], apellidos[i], DNI[i], sexo[i], media);

				}

			}
			
			// OPCIÓN 3
			if (opcion.equals("3")) {
				
				System.out.println("\n\tLa media de cada una de las asignaturas es: ");
				for (i=0; i<nalumnos; i++) {
					sumatorioP += notas[i][0];
					sumatorioE += notas[i][1];
					sumatorioS += notas[i][2];				
				}
				mediaP = mediaAritmetica(sumatorioP,nalumnos);
				mediaE = mediaAritmetica(sumatorioE,nalumnos);
				mediaS = mediaAritmetica(sumatorioS,nalumnos);
				System.out.printf("\n\tProgramación: %f -- Entornos: %f -- Sistemas: %f", mediaP, mediaE, mediaS);
			}
	
		} while (!opcion.equals("4")); // Salgo del menú cuando eligo salir.
		
		System.out.println("Gracias por utilizar el programa! Adios!");
		
		entrada.close(); // Cierro el Scanner.
		
	}
	
	/*
	 * MÉTODO dniCorrecto():
	   · Este método no necesita parámetros. Desencadenará una serie de procesos que imprimirá por pantalla los errores del DNI introducido,
	     hasta introducir uno correcto, que será el que devolverá el método.
	*/
	private static String dniCorrecto() {
		
	 // DELARACIÓN DE VARIABLES
	 // =======================

		String DNI;           // DNI introducido por el usuario.
		int longitud;         // Longitud del DNI.
		String numero;        // Número del DNI almacenado en una cadena.
		char letra;           // Letra del DNI.
		boolean DNIcorrecto;  // Verdadero o falso.
		int modulo23DNI;      // El módulo 23 del número del DNI, que me servirá para saber si la letra introducida es correcta.
		String letrasDNI;     // Cadena donde almacenaré en orden las letras equivalentes de DNI una vez realizado el módulo 23.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================
		
		Scanner entrada = new Scanner(System.in);

		System.out.println("DNI con letra:");
		DNI = entrada.nextLine().trim();

	 // PROCESAMIENTO DE DATOS
	 // ======================
		do {
		
		DNIcorrecto = true;  // Presupondré que el DNI que se introducirá es verdadero desde el principio del bucle.
		longitud = DNI.length();
		
		if (longitud<2 || longitud>9) {  // Paso 1: Compruebo que la longitud del DNI completo no es menor de 2 ni supera los 9 caracteres.
			DNIcorrecto = false;
			System.out.println("El DNI debe estar formado al menos por 2 caracteres y menos de 9.");
		}
			
			if (DNIcorrecto) {  // Paso 2: Si la longitud del DNI no es superior a 9 caracteres, procedo con la siguiente comprobación:
				
				numero = DNI.substring(0, longitud-1);  // La cadena 'numero' será el DNI menos el último carácter que presupondré que es una letra correcta.
				
				for (int i=0; i<=longitud-2; i++) { // Compruebo número a número si de verdad lo son:
					
					if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
						DNIcorrecto = false;  // Si alguno de estos números comprobados queda fuera de rango especificado, NO es un número, por lo que el DNI es incorrecto.
						System.out.printf("El carácter %s NO es un número\n", numero.charAt(i));
					}
					
				}
				
				if (DNIcorrecto) { // Paso 3: Si he pasado los pasos anteriores, sigo presuponiendo que el DNI es correcto. Sino, me salto esta comprobación.
					letra = DNI.toUpperCase().charAt(longitud-1);  // El caracter 'letra' presupondré que será el último carácter introducido en la cadena (además lo convierto en mayúscula).
					
					if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un número.
						DNIcorrecto = false;
						System.out.println("¡Se te ha olvidado introducir la letra de tu DNI!");
					}
					
					if (DNIcorrecto) {  // Paso 4: Si la letra del DNI es diferente a un número, procedo con la siguiente comprobación.
						
						modulo23DNI = Integer.valueOf(numero)%23; // Módulo 23 del número del DNI, que será un número entre el 0 y el 22:
						letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";    // 23 letras posibles en el DNI, en orden del resultado del módulo23DNI.
						
						if (letra!=letrasDNI.charAt(modulo23DNI)) { // Paso 5: Por último, compruebo que la letra del DNI es correcta.
							DNIcorrecto = false;
							System.out.printf("La letra introducida del DNI es incorrecta. Debería ser la letra '%s'\n", letrasDNI.charAt(modulo23DNI));
						}
						
					} // fin Paso 3.
				}		
			} // fin Paso 2.
			
			if (DNIcorrecto==false) {
				System.out.println("Introduce de nuevo el DNI con letra de manera correcta:");
				DNI = entrada.nextLine().trim(); // Si el DNI no supera alguno de los procesos, lo vuelvo a pedir ¡y a reempezar el bucle de procesos!
			}
			
		} while (DNIcorrecto==false);

		entrada.close();
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		return DNI;
		
	}
		
	/*
	 * FIN MÉTODO dniCorrecto();
	 */
	
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

	/*
	 * MÉTODO mediaAritmetica():
	   · Este método me servirá para devolver medias aritméticas conociendo el sumatorio y el total.
	*/
	private static double mediaAritmetica(double sumatorio, double total) {

		double media;
		
		media = sumatorio/total;

		return media;
		
	}	
	/*
	 * FIN MÉTODO mediaAritmetica();
	 */
		
	
}