//Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien

import java.util.Scanner; // Importo el Scanner que voy a utilizar.

public class debug16{ // Error de compilación. Repetido en los anteriores.

    public static void main(String[] args) {
    	
        double nota; // Error lógico. Siendo coherente con lo que se pide, una nota puede llevar decimales.
        
        Scanner Entrada = new Scanner(System.in); // Inicializo el Scanner para pedir los datos a continuación:
        
        System.out.print("Introduzca una nota: ");
        nota=Entrada.nextDouble(); // Errores de compilación: No había Scanner inicializado ni bien solicitado.
        if (nota<0 || nota>10) { // Error lógico. En el caso de que el usuario introduzca una nota incorrecta.
        	do {
        		System.out.println("Introduce una nota correcta entre 0 y 10");
        	} while (nota<0 || nota>10);
        }
        	
        // tanto los if's como los else's encierran a una sola instrucción
        // y no es necesario utilizar llaves { }
        
        Entrada.close(); // Cierro Scanner.
        
        //Errores lógicos: cambios en los intervalos de las condicionales para adaptarlos a los decimales.
        if(nota>=0 && nota<5)
            System.out.println("INSUFICIENTE");
        else
            if(nota>=5 && nota<6)
                System.out.println("SUFICIENTE");
            else
                if(nota>=6 && nota<7)
                    System.out.println("BIEN");
                else
                    if(nota>=7 && nota<9)
                        System.out.println("NOTABLE");
                    else
					  if(nota>=9 && nota<=10)
                            System.out.println("SOBRESALIENTE");
        
    }

}