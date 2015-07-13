package ControlExcepciones;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ControlExcepciones {

	public static void main(String[] args) throws DatoNoValidoException {
		boolean datomalo;
				
		do {	
			System.out.println("Introduzca un n�mero 1");
			try {
				Scanner entrada = new Scanner(System.in);
				int num = entrada.nextInt();
				datomalo=false;
			}
			catch (InputMismatchException e) { // Manejador de la excepci�n
				System.out.println("Se ha introducido algo que no es un entero");
				datomalo=true;
			}
		}while(datomalo);
		
		System.out.println("Se ha introducido un n�mero entero 1\n");
		
		do {	
			System.out.println("Introduzca un n�mero 2");
			try {
				Scanner entrada = new Scanner(System.in);
				int num = entrada.nextInt();
				datomalo=false;
			}
			catch (InputMismatchException e) { // Manejador de la excepci�n
				System.out.println("Se ha introducido algo que no es un entero");
				datomalo=true;
			}
		}while(datomalo);
		
		System.out.println("Se ha introducido un n�mero entero 2\n");
		
		Empleado e = new Empleado("Pepe", 7);
		System.out.println("El empleado est� en el centro " + e.getCentro());
		
	}

}
