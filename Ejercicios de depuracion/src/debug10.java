//dos nÃºmeros iguales
public class debug10 { // Error de compilación 'classs' es 'class'
public static void main (String args[]){
		int n1=5; // Error de compilación: faltaba el ';'
		float n2=5;
       
        if(n1==n2) // Error de compilación: Una comparación de igualdad es '==', '=' es una asignación.
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");
     }
}
// Error de compilación. Sobra esto '}'