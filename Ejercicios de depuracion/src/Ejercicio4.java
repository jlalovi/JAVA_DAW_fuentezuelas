import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		 Scanner sc = new Scanner(System.in);
	      double dividendo, divisor,resultado;
	      
	        System.out.print("Introduzca el dividendo: ");
	        dividendo = sc.nextDouble();
	        System.out.print("Introduzca el divisor: ");
	        divisor = sc.nextDouble();    
	        if (divisor==0) {  // Error en tiempo de ejecución posible NO contemplado:
	        	while (divisor==0) {  // Contemplo que el divisor introducido sea 0, para volver a pedir al usuario otro número.
	        		System.out.println("El divisor NO puede ser 0. Introduce otro valor:");
	        		divisor = sc.nextDouble();
	        	}
	        }
	        sc.close(); // Cierro Scanner.
	        
	        resultado=dividendo/divisor;
            System.out.println(dividendo + " / " + divisor + " = " + resultado);  
            System.out.printf("%.2f / %.2f = %.2f %n" , dividendo, divisor , resultado);
	}

}
