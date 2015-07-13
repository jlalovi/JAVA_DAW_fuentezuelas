
public class maxmin {

	// MÉTODO PARA COMPARAR DOS NÚMEROS Y OBTENER EL MAYOR	
	public static int mayor (int ... n) {
		
		int max = n[0]; // Inicializamos 
		
		for (int i=1; i<n.length; i++) {
			if (n[i]>max) {
				max = n[i];
			}
		}
		
		return max;	
	}
	
	// Sobrecarga con x valores de tipo double.
	public static double mayor (double ... n) {
		
		double max = n[0]; // Inicializamos 
		
		for (int i=1; i<n.length; i++) {
			if (n[i]>max) {
				max = n[i];
			}
		}
		
		return max;	
	}

	// MÉTODO PARA COMPARAR DOS NÚMEROS Y OBTENER EL MENOR	
	public static int menor (int ... n) {
		
		int min = n[0]; // Inicializamos 
		
		for (int i=1; i<n.length; i++) {
			if (n[i]<min) {
				min = n[i];
			}
		}
		
		return min;	
	}
	
	// Sobrecarga con x valores de tipo double.
	public static double menor (double ... n) {
		
		double min = n[0]; // Inicializamos 
		
		for (int i=1; i<n.length; i++) {
			if (n[i]<min) {
				min = n[i];
			}
		}
		
		return min;	
	}
	
}
