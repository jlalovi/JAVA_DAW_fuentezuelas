import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {

		    Scanner sc = new Scanner(System.in);
		    
		    int N;
		    String nombre;
		    
	        System.out.println("Introduzca su nombre");
		    nombre=sc.nextLine();
		    System.out.println("Introduzca un n�mero");  // Error de compilaci�n:
		    N=sc.nextInt();								 // 'N' no estaba inicializada. Para que tenga sentido el programa, pido al usuario que introduzca su valor.
		    
		    sc.close(); // Cierro scanner
	
		    if(N==0)  // Error l�gico: '0' no es par ni impar.
	    		System.out.println(nombre+" el n�mero introducido es el 0");
		    else if (N%2==0)   // Error l�gico: 'N%2!=0' es impar.
		    	System.out.println(nombre+" el n�mero introducido es par");    
		    else
		    	System.out.println(nombre+" el n�mero introducido es impar");
				
	}

}
