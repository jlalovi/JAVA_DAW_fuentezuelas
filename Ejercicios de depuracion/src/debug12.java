//Módulo 10 de un número
public class debug12 { // Error de compilación, Nombre de la clase 'dbug12' tiene que ser igual al del archivo.
public static void main (String args[]){
		float a=12.34F,b; // Error de compilación. El decimal de un tipo 'float' se inicializa con una 'F' al final.
               
       b=a%10;
	   
	    System.out.println("resultado " + b); // Error de compilación: 'out' estaba escrito como 'ot'.
    }
}