//Muestra los números del 1 al 100 (ambos incluidos). Usa un bucle while.
public class debug13 { // Error de compilación, Nombre de la clase 'debg13' tiene que ser igual al del archivo.
	public static void main (String args[]){
		int num=1; 
       
        while (num<=100){ // Error lógico. Si se quiere incluir el 100, o bien num<=100 o num<101, en el bucle.
            System.out.println(num);          
            num++;
        }
	}
} // Error de compilación. Faltaba una llave por cerrar.