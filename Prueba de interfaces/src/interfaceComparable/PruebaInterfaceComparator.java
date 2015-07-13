package interfaceComparable;

import java.util.ArrayList;
import java.util.Collections;

public class PruebaInterfaceComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<OtraPersona> personas=new ArrayList<OtraPersona>();
		
		personas.add(new OtraPersona("Pepe",23));
		personas.add(new OtraPersona("Juan",5));
		personas.add(new OtraPersona("Luis",85));
		
		//Ordenar por nombre
		Collections.sort(personas, new ComparaPersonaNombre());
		
		//Imprimir
		for (OtraPersona otraPersona : personas) {
			System.out.println(OtraPersona.getNombre());
		}
		
	}

}
