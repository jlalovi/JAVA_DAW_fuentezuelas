
import java.util.Scanner;

public class Ejercicio5 { // Ponía 'Ejercicio5a'. Error de compilación, al no ser la clase igual al archivo.

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Scanner sc = new Scanner(System.in);		 
        int n;       
        System.out.print("Introduce un número entero: ");
        n = sc.nextInt();       
        sc.close(); // cierro Scanner
	        
        System.out.println("Tabla del " + n);
        for(int i = 1; i<=10; i++){
        	// En vez de utilizar la conversión implícita que conlleva la utilización del println,
        	// utilizo printf, que es más adecuada. Además, puedo mostrar por pantalla un formato más ordenado.
            System.out.printf("%2d x %d = %d \n", i, n, i*n);
        }
	        
	}

}
