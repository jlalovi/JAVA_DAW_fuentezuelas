import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// Declaración de un ArrayList de "String". Puede ser de cualquier otro Elemento u Objeto (float, Boolean, Object, ...)
		ArrayList<String> nombreArrayList = new ArrayList<String>();
		nombreArrayList.add("Elemento");   // Añade el elemento al ArrayList
		nombreArrayList.add(0, "Elemento 2");   // Añade el elemento al ArrayList en la posición '0'
		nombreArrayList.size();   // Devuelve el numero de elementos del ArrayList
		nombreArrayList.get(2);   // Devuelve el elemento que esta en la posición '2' del ArrayList
		nombreArrayList.contains("Elemento");   // Comprueba se existe del elemento ('Elemento') que se le pasa como parametro
		nombreArrayList.indexOf("Elemento");   // Devuelve la posición de la primera ocurrencia ('Elemento') en el ArrayList 
		nombreArrayList.lastIndexOf("Elemento");   // Devuelve la posición de la última ocurrencia ('Elemento') en el ArrayList
		nombreArrayList.remove(5);   // Borra el elemento de la posición '5' del ArrayList
		nombreArrayList.remove("Elemento");   // Borra la primera ocurrencia del 'Elemento' que se le pasa como parametro.
		nombreArrayList.clear();   //Borra todos los elementos de ArrayList
		nombreArrayList.isEmpty();   // Devuelve True si el ArrayList esta vacio. Sino Devuelve False
		ArrayList arrayListCopia = (ArrayList) nombreArrayList.clone();   // Copiar un ArrayList
		Object[] array = nombreArrayList.toArray();   // Pasa el ArrayList a un Array

	}

}
