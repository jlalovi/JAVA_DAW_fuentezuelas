//�rea de un c�rculo
import java.util.Scanner; // necesario para utilizar el Scanner y pedir datos al usuario.

public class debug09 { // Error de compilaci�n. 'pblic' en vez de 'public'
	public static void main (String args[]){
		
		double a,r;
		
		Scanner entrada = new Scanner(System.in); // Inicializo Scanner.
		
        System.out.print("Introduce el radio de un circulo: ");
        r = entrada.nextDouble(); // Pido el valor de r
        
        entrada.close(); // cierro Scanner
       
        a = Math.PI*(r*r); // Error de compilaci�n. Faltaba multiplicar 'Math.PI'.
       
        // Error de compilaci�n 'out' escrito como 'ot'.
        // 'printf' m�s adecuado que 'println'
        System.out.printf("El �rea de una circunferencia de radio %.2f es %f", r, a);
	}
}