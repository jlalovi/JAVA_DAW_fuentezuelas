import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {

		    Scanner sc = new Scanner(System.in);
		    
		    int N;
		    String nombre;
		    
	        System.out.println("Introduzca su nombre");
		    nombre=sc.nextLine();
		    System.out.println("Introduzca un número");  // Error de compilación:
		    N=sc.nextInt();								 // 'N' no estaba inicializada. Para que tenga sentido el programa, pido al usuario que introduzca su valor.
		    
		    sc.close(); // Cierro scanner
	
		    if(N==0)  // Error lógico: '0' no es par ni impar.
	    		System.out.println(nombre+" el número introducido es el 0");
		    else if (N%2==0)   // Error lógico: 'N%2!=0' es impar.
		    	System.out.println(nombre+" el número introducido es par");    
		    else
		    	System.out.println(nombre+" el número introducido es impar");
				
	}

}
