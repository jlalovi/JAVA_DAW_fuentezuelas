//Muestra los n�meros del 1 al 100 (ambos incluidos). Usa un bucle while.
public class debug13 { // Error de compilaci�n, Nombre de la clase 'debg13' tiene que ser igual al del archivo.
	public static void main (String args[]){
		int num=1; 
       
        while (num<=100){ // Error l�gico. Si se quiere incluir el 100, o bien num<=100 o num<101, en el bucle.
            System.out.println(num);          
            num++;
        }
	}
} // Error de compilaci�n. Faltaba una llave por cerrar.