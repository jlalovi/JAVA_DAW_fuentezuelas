package interfaceComparable;

import java.util.ArrayList;
import java.util.Collections;

public class pruebaInterfaceComparar {

	public static void main(String[] args) {
		
		ArrayList<Persona> personas=new ArrayList<Persona>();
		
		personas.add(new Persona("Pepe",23));
		personas.add(new Persona("Juan",5));
		personas.add(new Persona("Luis",85));
		
		//Ordenar Array
		
		Collections.sort(personas);  // El método 'Collections.sort' tiene implementada una interface que obliga que el objeto que
									 // que se quiera ordenar tenga implementada la misma interface. Esta interface es la llamada 'Comparable'.
		
		for (Persona p:personas) {
			System.out.println(p);
		}
		
	}

}
