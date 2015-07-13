//Pedir tres números y mostrarlos ordenados de mayor a menor.

import java.util.Scanner; // Importo el Scanner que voy a utilizar.

public class debug15 {  // Error de compilación. Otra vez lo mismo.

    public static void main(String[] args) {
        int a,b,c;
        Scanner Entrada = new Scanner(System.in); // Inicializo el Scanner para pedir los datos a continuación:
        
        // Errores de compilación: No estaba inicializado el Scanner ni estaba bien expresado el almacenamiento.
        System.out.print("Introduzca primer número: ");
        a=Entrada.nextInt();
        System.out.print("Introduzca segundo número: ");
        b=Entrada.nextInt();
        System.out.print("Introduzca tercer número: ");
        c=Entrada.nextInt();
        
        Entrada.close(); // Cierro Scanner.
        
        // Error lógico. Faltan procesos (con esta metodología poco eficiente) para cubrir todas las soluciones posibles.
        if(a>b && b>c)
            System.out.println(a+", "+b+", "+c);
        else if(a>c && c>b)
            System.out.println(a+", "+c+", "+b);
        else if (b>a && a>c)
        	System.out.println(b+", "+a+", "+c);
        else if (b>a && a<c)
        	System.out.println(b+", "+c+", "+a);
        else if (c>a && a>b)
        	System.out.println(c+", "+a+", "+b);
        else if (c>a && b>a)
        	System.out.println(c+", "+b+", "+a);

    } // Error de compilación. Faltaba esta llave.
}