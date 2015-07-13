import java.util.Scanner;

/**
 * Clase Matriz
 * contiene métodos para hacer diferentes operaciones con matrices. 
 * 
 * @author Javier Latorre
 * @version 09/01/2015
 * @since 09/01/2015
 *
 */

public class Matriz {

	/**
	 * 
	 * Método 'nueva'
	 * crea una matriz de tamaño filas x columnas proporcionada por el usuario.
	 * 
	 * @return 'int[][]' Una matriz con el tamaño filas x columnas especificado por el usuario
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] nueva() {
		
		int columnas;
		int filas;
		int[][] matriz;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Número de filas:");
		filas = entrada.nextInt();
		System.out.println("número de columnas:");
		columnas = entrada.nextInt();
		
		matriz = new int[filas][columnas];
		
		return matriz;
		
	}
	
	/**
	 * Método 'mismaDimension'
	 * compara si la dimensión de dos matrices es igual
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
	 * Método 'multiplicables'
	 * compara si dos matrices son multipicables, es decir, si el número de columnas de la primera es igual
	 * al número de filas de la segunda matriz.
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
	 * Método 'suma'
	 * devuelve la suma de las dos matrices especificadas como parámetros, siempre y cuando tengan la misma dimensión.
	 * Para ello, se recomienda utilizar el método Matriz.mismadimension previamente a este para asegurarse de que se
	 * puede hacer la operación correctamente.
	 * 
	 * @param matrizA 'int[][]' 
	 * @param matrizB 'int[][]'
	 * @return 'int[][]' resultado de la suma entre matrizA y matrizB
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] suma(int[][] matrizA, int[][] matrizB) {
		
		int[][] matrizC = new int[matrizA.length][matrizA[0].length]; // La dimensión de la matriz C será igual que cualquiera de las matrices A o B (En este caso estoy tomando la dimensión de la matriz A)
		
		for (int f=0; f<matrizC.length; f++) {
			for (int c=0; c<matrizC[f].length; c++) {
				matrizC[f][c] = matrizA[f][c] + matrizB[f][c];
			}
		}
		
		return matrizC;
	}
	
	/**
	 * Método 'producto'
	 * devuelve el producto de las dos matrices especificadas como parámetros, siempre y cuando cumpla el requisito de que el número de columnas de la
	 * Matriz A sea igual al número de filas de la Matriz B.
	 * Para ello, se recomienda utilizar el método Matriz.multiplicables previamente a este para asegurarse de que se
	 * puede hacer la operación correctamente.
	 * 
	 * @param matrizA 'int[][]' 
	 * @param matrizB 'int[][]'
	 * @return 'int[][]' resultado del producto entre matrizA y matrizB
	 * 
	 * @since 09/01/2015
	 */
	public static int[][] producto(int[][] matrizA, int[][] matrizB) {
		
		int[][] matrizC = new int[matrizA.length][matrizB[0].length]; // La dimensión de la matriz C será igual a las columnas de la matriz B y las filas de la matriz A.
		
		for (int f=0; f<matrizC.length; f++) {
			for (int c=0; c<matrizC[f].length; c++) {
				matrizC[f][c] = 0; // Inicializo el valor de la celda a 0 para el sumatorio del siguiente bucle
				for (int i=0; i<matrizB.length; i++) { // El sumatorio iterará tantas veces como columnas tenga la matriz A o filas la matriz B (en este caso estoy tomando el número de filas de la matriz B)
					matrizC[f][c] += matrizA[f][i] * matrizB[i][c];  // La conclusión a esta fórmula es más fácil si se conoce la teoría: http://es.wikipedia.org/wiki/Multiplicaci%C3%B3n_de_matrices
				}
			}
		}
		
		return matrizC;
	}
	
	/**
	 * Método 'valores'
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
	 * Método 'valoresAleatorios'
	 * rellena la matriz especificada con valores aleatorios entre -99 y 99 (Ambos incluídos), para no romper el método Matriz.mostrar.
	 * 
	 * <p>Para ejecutar este método es necesario el método Calculos.numAleatorio</p>
	 * @see Calculos.numAleatorio
	 * 
	 * @param matriz 'int[][]' a la que se quiere introducir valores en sus celdas
	 * @return 'int[][]' La matriz especificada con los valores introducidos aleatoriamente en el método
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
	 * Método 'mostrar'
	 * muestra por consola la representación gráfica de la matriz. El diseño se rompe si alguno de los valores
	 * de la matriz es superior a ¿x? dígitos.
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
	 * Método 'sonIguales'
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
