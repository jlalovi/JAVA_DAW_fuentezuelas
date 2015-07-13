/**
 * @author Javier Latorre
 * 
 */

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

    	  Scanner sc = new Scanner(System.in);
	      double gradosC, gradosF;
	      System.out.println("Introduce grados Centígrados:");
	      gradosC = sc.nextDouble();
	      sc.close();  // Cierro el scanner.
	      gradosF = 32 + (9 * gradosC / 5);  // Aquí había un error lógico Fº = 32 + (9 / Cº / 5)
	      System.out.println(gradosC +" ºC = " + gradosF + " ºF");
	      
	}

}
