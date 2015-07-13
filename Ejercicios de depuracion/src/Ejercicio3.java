// 'import java.io.*;' Mo se utilizan estos paquetes 
import java.util.Scanner;  // Utilizo el paquete específico para Scanner.

public class Ejercicio3 {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
         char car;  // 'car1' es una variable que no utilizo
         
         System.out.print("Introduzca un carácter: ");
         car=sc.nextLine().charAt(0); // Error en tiempo de ejecución: Las posiciones en Java empiezan desde 0. En este caso, 1 quedaba fuera de rango.
         
         sc.close();
                
         if(Character.isUpperCase(car)) 
            System.out.println("Es una letra mayúscula");   
         else
             System.out.println("No es una letra mayúscula");   
         if(Character.isDigit(car)) 
	           System.out.println("Es un número");
	     else
	           System.out.println("No es un número");
         
         
	}

}
