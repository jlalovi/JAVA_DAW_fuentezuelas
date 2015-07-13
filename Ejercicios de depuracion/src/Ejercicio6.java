// package ejercicios; Esto da error de compilación al no estar creado este paquete.
import java.util.Scanner;
/**
* Programa que lea una serie de números por teclado hasta que
* se lea un número negativo, ojo cuando el primer número introducido es negativo.
* El programa indicará cuántos números
* acabados en 2 se han leído.
*/


public class Ejercicio6 { // Ponía Ejercicio 8. Error de compilación, al no ser la clase igual al archivo.
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n, contador=0; // Error lógico: Inicializo el contador a 0, por si no se introduce ningún número terminado en 2.
	        
	        do{
	        	System.out.print("Introduce un número entero: ");
	        	n = sc.nextInt();
	        	// Error lógico: Para conocer el último número de un número entero, realizo el MOD 10 de ese número.
	        	// Error lógico: Además, indico en la condición que el número tiene que ser positivo para no contar el negativo.
	        	if(n%10==2 && n>0)  
	        	{
	        		contador++;
	        	}
	        }while(n>=0); // Error lógico. Repito el bucle MIENTRAS n>=0. Saldré cuando sea n<0 (número negativo).
	       
	        sc.close();  // cierro Scanner
	        
	        // Error lógico. Este mensaje es más coherente mostrarlo una vez se introducen todos los números.
	        System.out.println("Se han introducido " + contador + " números acabados en 2");
	        
	    }
}
