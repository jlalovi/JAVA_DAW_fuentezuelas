//dos números iguales
public class debug10 { // Error de compilaci�n 'classs' es 'class'
public static void main (String args[]){
		int n1=5; // Error de compilaci�n: faltaba el ';'
		float n2=5;
       
        if(n1==n2) // Error de compilaci�n: Una comparaci�n de igualdad es '==', '=' es una asignaci�n.
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");
     }
}
// Error de compilaci�n. Sobra esto '}'