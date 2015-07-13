import java.util.Scanner;

/**
 * Clase Matriz
 * contiene m�todos para hacer diferentes operaciones con matrices. 
 * 
 * @author Javier Latorre
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */

public class Matriz {

	/**
	 * 
	 * M�todo 'nueva'
	 * crea una matriz de tama�o filas x columnas proporcionada por el usuario.
	 * 
	 * @return 'int[][]' Una matriz con el tama�o filas x columnas especificado por el usuario
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] nueva() {
		
		int columnas;
		int filas;
		int[][] matriz;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("N�mero de filas:");
		filas = entrada.nextInt();
		System.out.println("n�mero de columnas:");
		columnas = entrada.nextInt();
		
		matriz = new int[filas][columnas];
		
		return matriz;
		
	}
	
	/**
	 * M�todo 'mismaDimension'
	 * compara si la dimensi�n de dos matrices es igual
	 * 
	 * @param matrizA 'int[][]' de la primera matriz
	 * @param matrizB 'int[][]' de la segunda matriz
	 * @return 'boolean' 'true': son iguales 'false': no son iguales
	 * 
	 * @since 09/01/2015
	 */
	public static boolean mismaDimension (int[][] matrizA, int[][] matrizB ) {
		if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length)
			return true;
		else
			return false;
	}
	
	/**
	 * M�todo 'multiplicables'
	 * compara si dos matrices son multipicables, es decir, si el n�mero de columnas de la primera es igual
	 * al n�mero de filas de la segunda matriz.
	 * 
	 * @param matrizA 'int[][]' de la primera matriz
	 * @param matrizB 'int[][]' de la segunda matriz
	 * @return 'boolean' 'true': son multiplicables 'false': no son multiplicables
	 * 
	 * @since 09/01/2015
	 */
	public static boolean multiplicables(int[][] matrizA, int[][] matrizB ) {
		if (matrizA[0].length != matrizB.length)
			return false;
		else
			return true;
	}
	
	/**
	 * M�todo 'suma'
	 * devuelve la suma de las dos matrices especificadas como par�metros, siempre y cuando tengan la misma dimensi�n.
	 * Para ello, se recomienda utilizar el m�todo Matriz.mismadimension previamente a este para asegurarse de que se
	 * puede hacer la operaci�n correctamente.
	 * 
	 * @param matrizA 'int[][]' 
	 * @param matrizB 'int[][]'
	 * @return 'int[][]' resultado de la suma entre matrizA y matrizB
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] suma(int[][] matrizA, int[][] matrizB) {
		
		int[][] matrizC = new int[matrizA.length][matrizA[0].length]; // La dimensi�n de la matriz C ser� igual que cualquiera de las matrices A o B (En este caso estoy tomando la dimensi�n de la matriz A)
		
		for (int f=0; f<matrizC.length; f++) {
			for (int c=0; c<matrizC[f].length; c++) {
				matrizC[f][c] = matrizA[f][c] + matrizB[f][c];
			}
		}
		
		return matrizC;
	}
	
	/**
	 * M�todo 'producto'
	 * devuelve el producto de las dos matrices especificadas como par�metros, siempre y cuando cumpla el requisito de que el n�mero de columnas de la
	 * Matriz A sea igual al n�mero de filas de la Matriz B.
	 * Para ello, se recomienda utilizar el m�todo Matriz.multiplicables previamente a este para asegurarse de que se
	 * puede hacer la operaci�n correctamente.
	 * 
	 * @param matrizA 'int[][]' 
	 * @param matrizB 'int[][]'
	 * @return 'int[][]' resultado del producto entre matrizA y matrizB
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] producto(int[][] matrizA, int[][] matrizB) {
		
		int[][] matrizC = new int[matrizA.length][matrizB[0].length]; // La dimensi�n de la matriz C ser� igual a las columnas de la matriz B y las filas de la matriz A.
		
		for (int f=0; f<matrizC.length; f++) {
			for (int c=0; c<matrizC[f].length; c++) {
				matrizC[f][c] = 0; // Inicializo el valor de la celda a 0 para el sumatorio del siguiente bucle
				for (int i=0; i<matrizB.length; i++) { // El sumatorio iterar� tantas veces como columnas tenga la matriz A o filas la matriz B (en este caso estoy tomando el n�mero de filas de la matriz B)
					matrizC[f][c] += matrizA[f][i] * matrizB[i][c];  // La conclusi�n a esta f�rmula es m�s f�cil si se conoce la teor�a: http://es.wikipedia.org/wiki/Multiplicaci%C3%B3n_de_matrices
				}
			}
		}
		
		return matrizC;
	}
	
	/**
	 * M�todo 'valores'
	 * pide al usuario que introduzca los valores de la matriz especificada (entre -99 y +99).
	 * 
	 * @param matriz 'int[][]' a la que se quiere introducir valores en sus celdas
	 * @return 'int[][]' La matriz especificada con los valores introducidos por el usuario
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] valores(int[][] matriz) {
		
		Scanner entrada = new Scanner(System.in);
		
		for (int f=0; f<matriz.length; f++) {
			for (int c=0; c<matriz[f].length; c++) {
				System.out.printf("\nValor de celda en fila %d columna %d: ", f+1,c+1);
				matriz[f][c] = entrada.nextInt();
			}
		}
		
		return matriz;
		
	}
	
	/**
	 * M�todo 'valoresAleatorios'
	 * rellena la matriz especificada con valores aleatorios entre -99 y 99 (Ambos inclu�dos), para no romper el m�todo Matriz.mostrar.
	 * 
	 * <p>Para ejecutar este m�todo es necesario el m�todo Calculos.numAleatorio</p>
	 * @see Calculos.numAleatorio
	 * 
	 * @param matriz 'int[][]' a la que se quiere introducir valores en sus celdas
	 * @return 'int[][]' La matriz especificada con los valores introducidos aleatoriamente en el m�todo
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] valoresAleatorios(int[][] matriz) {
		
		Scanner entrada = new Scanner(System.in);
		
		for (int f=0; f<matriz.length; f++) {
			for (int c=0; c<matriz[f].length; c++) {
				matriz[f][c] = Calculos.numAleatorio(-99, 99);
			}
		}
		
		return matriz;
		
	}
	
	/**
	 * M�todo 'mostrar'
	 * muestra por consola la representaci�n gr�fica de la matriz. El dise�o se rompe si alguno de los valores
	 * de la matriz es superior a �x? d�gitos.
	 * 
	 * @param matriz 'int[][]' que se quiere mostrar por consola en forma de matriz.
	 * 
	 * @since 09/01/2015
	 */
	public static void mostrar(int[][] matriz) {
		
		for (int f=0; f<matriz.length; f++) {
			System.out.printf("\n| ");
			for (int c=0; c<matriz[f].length; c++) {
				System.out.printf("%8d", matriz[f][c]);
			}
			System.out.printf("\t|");
		}
		System.out.println("");		
	}
	
	/**
	 * M�todo 'sonIguales'
	 * compara dos matrices para saber si son iguales o no.
	 * 
	 * @param matrizA 'int[][]' de la primera matriz que se quiere comparar.
	 * @param matrizB 'int[][]' de la primera matriz que se quiere comparar.
	 * 
	 * @return 'boolean' 'true': Las matrices son iguales 'false': Las matrices no son iguales
	 * 
	 * @since 09/01/2015
	 */
	public static boolean sonIguales(int[][] matrizA, int[][] matrizB) {
		
		boolean iguales=true;
		
		for (int f=0; f<matrizA.length; f++) {
			for (int c=0; c<matrizA[f].length && iguales==true; c++) {
				if (matrizA[f][c]!=matrizB[f][c])
					iguales=false;
			}
		}
		if (iguales)
			return true;
		else
			return false;
	}
	
}
