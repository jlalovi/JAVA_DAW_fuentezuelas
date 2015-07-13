//número positivo
public class debug11 { // Error de compilación, Nombre de la clase 'dbug11' tiene que ser igual al del archivo.
public static void main (String args[]){
		int num=3; // Error de compilación: Se tiene que inicializar 'num', para ejecutar los procesos que hay a continuación.
               
        if( num < 0) // Error lógico. Un número es negativo cuando es menor a '0'
            System.out.println("Negativo");
        else
            // suponemos que el 0 es positivo.
            System.out.println("Positivo");
    }
}