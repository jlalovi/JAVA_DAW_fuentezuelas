//Ingresar d�a de una fecha, reportar el d�a de la semana que le corresponde, suponiendo que el d�a 1 de dicho mes fue lunes

import java.util.Scanner;
 
public class debug14 { // Error de compilaci�n. Otra vez el nombre de la clase y antes que el 'import'.
	
    public static void main(String[] args) {
         
        Scanner in = new Scanner(System.in);
        int dia;
        System.out.print("Ingrese el dia :");
        dia=in.nextInt();
        in.close(); // Cierro el Scanner.
        
        switch(dia%7) // Error l�gico. Hay 7 d�as de la semana, no 6...
        {
            case 0: System.out.println("Domingo");break;
            case 1: System.out.println("Lunes");break;
            case 2: System.out.println("Martes");break;
            case 3: System.out.println("Miercoles");break;
            case 4: System.out.println("Jueves");break;
            case 5: System.out.println("Viernes");break;
            case 6: System.out.println("Sabado");break;
            default: System.out.println("Numero fuera de rango");break;
        }
    }
}