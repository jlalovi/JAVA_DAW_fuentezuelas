/**
 * @author Javier Latorre
 * 
 */

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

    	  Scanner sc = new Scanner(System.in);
	      double gradosC, gradosF;
	      System.out.println("Introduce grados Cent�grados:");
	      gradosC = sc.nextDouble();
	      sc.close();  // Cierro el scanner.
	      gradosF = 32 + (9 * gradosC / 5);  // Aqu� hab�a un error l�gico F� = 32 + (9 / C� / 5)
	      System.out.println(gradosC +" �C = " + gradosF + " �F");
	      
	}

}
