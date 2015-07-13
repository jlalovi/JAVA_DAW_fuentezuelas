import java.util.Scanner;

public class Comprobar_fecha {

	public static void main(String[] args) {
		// Testeo:
		
		int fecha[] = fechaCorrecta(1900,2014);
		
		System.out.printf("%d %d %d",fecha[0], fecha[1], fecha[2]);

	}
	

/*
 * MÉTODO fechaCorrecta(int,int):
   · El método está compuesto por dos parámetros, ambos 'int':
       - El primer parámetro es el año mínimo que se quiere establecer.
       - El segundo, el año máximo.
     El valor devuelto será un vector con día, mes y año correctos en este orden.
     Compruebo meses de 28, 29, 30 y 31 días y años mínimos y máximos. Obligo al usuario a
     introducir valores correctos para poder devolverlos con el método.

*/
	private static int [] fechaCorrecta(int ano_min, int ano_max) {
		
	 // DECLARACIÓN DE VARIABLES
	 // ========================	 
		
		int d, m, a; // día, mes y año.
		
	 // ENTRADA DE DATOS (INPUT)
     // ========================
			
		Scanner entrada = new Scanner(System.in);
		
		// FECHA DE HOY.
		// AÑO:
		System.out.println("Introduce el año:");
		a = entrada.nextInt();
		while (a<ano_min || a>ano_max) {
			System.out.printf("Por favor, introduce un año entre %d y %d.\n", ano_min, ano_max);
			a = entrada.nextInt();
		}
		// MES:
		System.out.println("Introduce el mes (1-12):");
		m = entrada.nextInt();
		while (m<1 || m>12) {
			System.out.println("Por favor, introduce un mes entre el 1 y el 12.");
			m = entrada.nextInt();
		}
		// DÍA:
		System.out.println("Introduce el día:");
		d = entrada.nextInt();
		switch (m) {
			case 2:  // Febrero.
				if (d==29) {  // Si el usuario introduce día '29', comprobamos si el año es bisiesto.
					if (!((a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0)))) {
						System.out.println("Es Febrero, pero el año introducido anteriormente NO es bisiesto.");
						do {
							System.out.println("Por favor, introduce un día entre 1 y 28."); // Nos aseguramos de que el usuario introduzca
							d = entrada.nextInt();									 // un día correcto.
						}
						while (d<1 || d>28);
					}
				}
				else if (d<1 || d>28) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 28.
					do {
						System.out.println("Por favor, introduce un día entre 1 y 28.");
						d = entrada.nextInt();
					}
					while (d<1 || d>28);
				}
				break;				
			case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
				while (d<1 || d>30) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 30.
					System.out.println("Por favor, introduce un día entre 1 y 30.");
					d = entrada.nextInt();
				}
				break;				
			case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
				while (d<1 || d>31) {  // Nos aseguramos de que el usuario introduzca un día entre el 1 y el 31.
					System.out.println("Por favor, introduce un día entre 1 y 31.");
					d = entrada.nextInt();
				}
				break;				
			default:
				break;
		} // fin de 'switch'
		
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		int fecha[] = {d,m,a};  // Declaro e inicializao el vector 'fecha[]' con el día, mes y año correctos.
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		return fecha;
		
	}
	
/*
 * FIN MÉTODO fechaCorrecta(int,int);
 */
}
