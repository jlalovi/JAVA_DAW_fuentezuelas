import java.util.Scanner;

/**
 * OPERACIONES CON MATRICES
 * 
 * - Elegir entre sumar y multiplicar dos matrices.
 * - Pedir tama�o de matrices (fila y columnas de las dos matrices) (f x c)(f x c).
 * - Saber si las dos matrices son del mismo rango (columnas de la primera = filas de la segunda), si no lo son,
 *   volver a preguntar por el tama�o de las matrices (en el caso de que la operaci�n sea multiplicar matrices).
 * - Preguntar si rellenar las matrices aleatoriamente o manualmente. (M�todo aleatorio)
 * - Mostrar por pantalla operaci�n con las matrices gr�ficamente. (M�todo void)
 * - Si se ha generado la matriz aleatoriamente, preguntar por resultado para comprobarlo
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 *
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("PROGRAMA QUE PERMITE HACER OPERACIONES CON MATRICES ");

	 // DELARACI�N DE VARIABLES
	 // =======================

		int matrizA[][];  // Matriz para operar A
		int matrizB[][];  // Matriz para operar B
		int matrizC[][];  // Matriz resultante entre la operaci�n de A y B
		int matrizD[][];  // Matriz para comparar con la resultante rellenada por el usuario en modo examen.
		String opcion="";            // Opciones deshechables
		String opcionMenu="";        // Opci�n elegida en el men� de inicio de programa
		String opcionOperacion="";   // Opci�n elegida de operaci�n (Sumar 's' o Multiplicar 'm')
		int contador;      // Contador de preguntas correctas en modo examen.
		int npreguntas;    // N�mero de matrices que el usuario desea realizar en el examen.
		int nfilas;        // N�mero filas para generar matrices de filas aleatorias en ejercicios de examen.
		int ncol;          // N�mero columnas para generar matrices de columnas aleatorias en ejercicios de examen.
		boolean pcorrecta; // Boleeano para saber si pregunta es correcta o incorrecta. 
		
	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		Scanner entrada = new Scanner(System.in);
		
		do { // Repetir el programa hasta que el usuario decida salir de este.
			
			System.out.println("\nElige una opci�n a realizar:"
					         + "\n\t1. Realizar un examen de operaciones con matrices."
					         + "\n\t2. Realizar operaciones con matrices"
					         + "\n\t3. Salir del programa.\n");
			opcionMenu = Preguntar.opciones("Pulsa '1' para examen, '2' para operaciones y '3' para salir.","1,2,3");
			
			
		 // ENTRADA DE DATOS OPCI�N 1 (INPUT)
		 // ================================
		
			if (opcionMenu.equals("1")) {
				
				System.out.println("�Bienvenido al modo examen!\n");
				opcionOperacion = Preguntar.opciones("�De qu� tipo de operaci�n deseas ser evaluado/a? �(S)umar o (M)ultiplicar matrices? s/m", "s,m");
				System.out.println("�De cu�ntas matrices deseas ser evaluado/a?");
				npreguntas = entrada.nextInt();
				
					
	     // ENTRADA/PROCESAMIENTO/SALIDA DE DATOS OPCI�N 1 (OUTPUT)
	     // =======================================================

				contador = 0; // Inicializo contador de preguntas correctas a 0
				
				for (int i=0; i<npreguntas; i++) {
					
					// GENERAR MATRICES ALEATORIAMENTE PARA SUMA (Matriz A y B tendr�n el mismo n�mero de filas y columnas)
					if (opcionOperacion.equalsIgnoreCase("s")) {
						
						nfilas = Calculos.numAleatorio(2,9);
						ncol = Calculos.numAleatorio(2,9);
						
						matrizA = new int[nfilas][ncol];
						matrizA = Matriz.valoresAleatorios(matrizA);
						
						matrizB = new int[nfilas][ncol];
						matrizB = Matriz.valoresAleatorios(matrizB);
						
						// Resultado almacenado en Matriz C
						matrizC = new int[matrizA.length][matrizA[0].length];
						matrizC = Matriz.suma(matrizA, matrizB);
					}
					// GENERAR MATRICES ALEATORIAMENTE PARA PRODUCTO (Columnas de Matriz A ser�n igual a filas de matriz B)
					else {
						
						nfilas = Calculos.numAleatorio(2,9);
						ncol = Calculos.numAleatorio(2,9);
						
						matrizA = new int[nfilas][ncol];
						matrizA = Matriz.valoresAleatorios(matrizA);
						
						nfilas = ncol;
						ncol = Calculos.numAleatorio(2,9);
						
						matrizB = new int[nfilas][ncol];
						matrizB = Matriz.valoresAleatorios(matrizB);
						
						// Resultado almacenado en Matriz C
						matrizC = new int[matrizA.length][matrizB[0].length];
						matrizC = Matriz.producto(matrizA, matrizB);
						
					}
					
					System.out.printf("\nPregunta n�mero %d\n", i+1);
					
					System.out.printf("\nMatriz A:");
					System.out.printf("\n========");
					Matriz.mostrar(matrizA);
					System.out.printf("\nMatriz B:");
					System.out.printf("\n========");
					Matriz.mostrar(matrizB);
					
					System.out.println("\nIntroduce el n�mero de filas de la matriz resultante:");
					nfilas = entrada.nextInt();
					System.out.println("Introduce el n�mero de columnas de la matriz resultante:");
					ncol = entrada.nextInt();
					matrizD = new int[nfilas][ncol];
					
					// Compruebo si el tama�o de la matriz que quiere introducir el usuario es del tama�o de la matriz resultante.
					if (matrizC.length == nfilas && matrizC[0].length == ncol)
						pcorrecta = true;
					else
						pcorrecta = false;
					
					// Si el tama�o es correcto, el usuario deber� introducir los valores.
					if (pcorrecta) {
						System.out.println("Introduce los valores de la matriz resultante:");
						matrizD = Matriz.valores(matrizD);
					}
					
					// Compruebo si la matriz resultante es igual a la introducida por el usuario.
					if (Matriz.sonIguales(matrizC, matrizD)) {
						pcorrecta=true;
						contador++;
					}
					else
						pcorrecta=false;
					
					// Por cada matriz contestado muestro un mensaje de feedback inmediato, diciendo si la respuesta es correcta o no
					if (pcorrecta)
						System.out.printf("\n�Bien hecho!�Has acertado la pregunta n�mero %d!\n", i+1);
					else
						System.out.printf("\nLo siento, �Has fallado la pregunta n�mero %d!\n", i+1);
					
				}

				// Muestro resultado final del examen.
				System.out.printf("\nHas contestado %d de %d preguntas, �por lo que tienes un %.2f de nota!\n", contador, npreguntas, (double)contador/(double)npreguntas*10.0);


			} // Fin opci�n 1
			
		 // ENTRADA DE DATOS OPCI�N2 (INPUT)
		 // ================================
		
			if (opcionMenu.equals("2")) {
				
				do { // Repetir hasta que el usuario est� contento con los valores de las matrices introducidas.
				
					opcionOperacion = Preguntar.opciones("�Qu� operaci�n desea realizar? �(S)umar o (M)ultiplicar matrices? s/m", "s,m");
					
					System.out.println("\nMatriz A:");
					matrizA = Matriz.nueva();
					System.out.println("\nMatriz B:");
					matrizB = Matriz.nueva();
					
					if (opcionOperacion.equalsIgnoreCase("s")) {
						if (!Matriz.mismaDimension(matrizA, matrizB)) { // Comprobar datos para operaci�n suma
							do {
								System.out.println("Para sumar dos matrices, �stas deben tener las mismas dimensiones, es decir, igual n�mero de filas y columnas.");
								System.out.println("Introduce de nuevo los valores de la Matriz A:");
								matrizA = Matriz.nueva();
								System.out.println("Introduce de nuevo los valores de la Matriz B:");
								matrizB = Matriz.nueva();
							} while (!Matriz.mismaDimension(matrizA, matrizB));
						}
					}
					else { // Comprobar datos para operaci�n multiplicaci�n
						if (!Matriz.multiplicables(matrizA, matrizB)) {
							do {
								System.out.println("Para multiplicar dos matrices, el n�mero de columnas de la primera tiene que ser igual al n�mero de filas de la segunda");
								System.out.println("Introduce de nuevo los valores de la Matriz A:");
								matrizA = Matriz.nueva();
								System.out.println("Introduce de nuevo los valores de la Matriz B:");
								matrizB = Matriz.nueva();
							} while (!Matriz.multiplicables(matrizA, matrizB)); // Repetir mientras matriz A y B no tengan igual n�mero de filas y columnas
						}
					}
			
					opcion = Preguntar.siNo("\n�Desea que el contenido de las matrices se genere autom�ticamente? s/n");
			
					if (opcion.equalsIgnoreCase("s")) {
						matrizA = Matriz.valoresAleatorios(matrizA);
						matrizB = Matriz.valoresAleatorios(matrizB);
					}
					else {
						System.out.println("Introduce los valores de la matriz A:");
						matrizA = Matriz.valores(matrizA);
						System.out.println("Introduce los valores de la matriz B:");
						matrizB = Matriz.valores(matrizB);
					}
					
					System.out.println("\nLas matrices introducidas son las siguientes:");
					System.out.printf("\nMatriz A:");
					System.out.printf("\n========");
					Matriz.mostrar(matrizA);
					System.out.printf("\nMatriz B:");
					System.out.printf("\n========");
					Matriz.mostrar(matrizB);
					
					if (opcionOperacion.equalsIgnoreCase("s"))
						System.out.println("\n�Desea sumar las matrices mostradas?");
					else
						System.out.println("\n�Desea multiplicar las matrices mostradas?");
					opcion = Preguntar.siNo("Pulsa 's' para mostrar soluci�n o 'n' para volver a introducir los datos:");
				
				} while(opcion.equalsIgnoreCase("n")); // Fin repetir hasta que el usuario est� contento con los valores de las matrices introducidas.
			
		
	     // PROCESAMIENTO DE DATOS OPCI�N 2
	     // ===============================

			
				// Suma:
				if (opcionOperacion.equalsIgnoreCase("s")) {
					matrizC = new int[matrizA.length][matrizA[0].length]; // La dimensi�n de la matriz C ser� igual que cualquiera de las matrices A o B (En este caso estoy tomando la dimensi�n de la matriz A)
					matrizC = Matriz.suma(matrizA, matrizB);
				}
				// Producto:
				else {
					matrizC = new int[matrizA.length][matrizB[0].length]; // La dimensi�n de la matriz C ser� igual a las columnas de la matriz B y las filas de la matriz A.
					matrizC = Matriz.producto(matrizA, matrizB);
				}
			
	
		 // SALIDA DE DATOS OPCI�N 2 (OUTPUT)
		 // =================================

				if (opcionOperacion.equalsIgnoreCase("s"))
					System.out.printf("\nMatriz C (Matriz A + Matriz B):");
				else
					System.out.printf("\nMatriz C (Matriz A x Matriz B):");
				System.out.printf("\n==============================");
				Matriz.mostrar(matrizC);
				
			} // Fin opci�n 2
		
		} while(!opcionMenu.equalsIgnoreCase("3")); // Fin repetir hasta que el usuario decida salir del programa.
		
		entrada.close();  // Cierro el Scanner una vez se termina el programa.
		
		System.out.println("\n�Gracias por utilizar el programa!");
		System.out.println("Javier L.");
		
	}
}








