
import java.util.Scanner;

public class Ejercicio5 { // Pon�a 'Ejercicio5a'. Error de compilaci�n, al no ser la clase igual al archivo.

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		Scanner sc = new Scanner(System.in);		 
        int n;       
        System.out.print("Introduce un n�mero entero: ");
        n = sc.nextInt();       
        sc.close(); // cierro Scanner
	        
        System.out.println("Tabla del " + n);
        for(int i = 1; i<=10; i++){
        	// En vez de utilizar la conversi�n impl�cita que conlleva la utilizaci�n del println,
        	// utilizo printf, que es m�s adecuada. Adem�s, puedo mostrar por pantalla un formato m�s ordenado.
            System.out.printf("%2d x %d = %d \n", i, n, i*n);
        }
	        
	}

}
