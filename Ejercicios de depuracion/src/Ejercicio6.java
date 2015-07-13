// package ejercicios; Esto da error de compilaci�n al no estar creado este paquete.
import java.util.Scanner;
/**
* Programa que lea una serie de n�meros por teclado hasta que
* se lea un n�mero negativo, ojo cuando el primer n�mero introducido es negativo.
* El programa indicar� cu�ntos n�meros
* acabados en 2 se han le�do.
*/


public class Ejercicio6 { // Pon�a Ejercicio 8. Error de compilaci�n, al no ser la clase igual al archivo.
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n, contador=0; // Error l�gico: Inicializo el contador a 0, por si no se introduce ning�n n�mero terminado en 2.
	        
	        do{
	        	System.out.print("Introduce un n�mero entero: ");
	        	n = sc.nextInt();
	        	// Error l�gico: Para conocer el �ltimo n�mero de un n�mero entero, realizo el MOD 10 de ese n�mero.
	        	// Error l�gico: Adem�s, indico en la condici�n que el n�mero tiene que ser positivo para no contar el negativo.
	        	if(n%10==2 && n>0)  
	        	{
	        		contador++;
	        	}
	        }while(n>=0); // Error l�gico. Repito el bucle MIENTRAS n>=0. Saldr� cuando sea n<0 (n�mero negativo).
	       
	        sc.close();  // cierro Scanner
	        
	        // Error l�gico. Este mensaje es m�s coherente mostrarlo una vez se introducen todos los n�meros.
	        System.out.println("Se han introducido " + contador + " n�meros acabados en 2");
	        
	    }
}
