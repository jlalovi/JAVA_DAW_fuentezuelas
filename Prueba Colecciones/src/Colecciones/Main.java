package Colecciones;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		//Personas (se utilizar�n m�s adelante):
		Persona p1=new Persona("Juan","L�pez");
		Persona p2=new Persona("Antonio","L�pez");
		Persona p3=new Persona("Manolo","Garc�a");
		
		
		System.out.println("Prueba LinkedList");
		System.out.println("=================");
		LinkedList<String> lista = new LinkedList<String>();
		
		lista.add("Juan");
		lista.add("Antonio");
		lista.add("Manuel");
		lista.add("Antonio");
		
//		//RECORRER UN BUCLE (3 formas: a manor, for each e iterator. Ver apuntes)
//		//Iterator:
//		//Iterator tiene una interface que se llama iterable
//		Iterator it = lista.iterator(); 
//		
//		while(it.hasNext()){			
//			System.out.println(it.next()); // Esto, en la pr�ctica, tendr� los mismos resultados que un ArrayList
//		}
		
		//Aunque es mucho m�s r�pido en este caso utilizar un toString();
		System.out.println(lista);
		
		System.out.println("\nPrueba HashSet");
		System.out.println("==============");
		HashSet<String> conjunto = new HashSet<String>();
		
		conjunto.add("Juan");
		conjunto.add("Antonio");
		conjunto.add("Manuel");
		conjunto.add("Antonio"); // Este add, devolver� un false y no se agragar� al conjunto
		
		System.out.println(conjunto); // Lo va a listar eliminando los repetidos y ordenados por su HASH (buscar concepto para profundizar)
		
		System.out.println(conjunto.contains("Antonio")); // Esto se utiliza para buscar si existe un elemento (devuelve true o false)
		
		System.out.println("\nPrueba TreeSet");
		System.out.println("==============");
		TreeSet<String> conjunto_ord = new TreeSet<String>();
		
		conjunto_ord.add("Juan");
		conjunto_ord.add("Antonio");
		conjunto_ord.add("Manuel");
		conjunto_ord.add("Antonio"); // Este add, devolver� un false y no se agragar� al conjunto
		
		System.out.println(conjunto_ord); //No saldr�n elementos repetidos y aparecer� ordenado seg�n el compareTo establecido (por defecto alfab�ticamente)
		
		
		System.out.println("\nPrueba TreeSet con objetos persona");
		System.out.println("==============");
		TreeSet<Persona> conjunto_ord_personas = new TreeSet<Persona>();
		
		
		conjunto_ord_personas.add(p1);
		conjunto_ord_personas.add(p2);
		conjunto_ord_personas.add(p3);
		conjunto_ord_personas.add(p2); // Este add, devolver� un false y no se agragar� al conjunto
		
		System.out.println(conjunto_ord_personas); // Para ordenar los objetos, el objeto debe tener implementado un comparable, sino se tendr� un error en ejecuci�n.
												   // Adem�s, habr� que declarar un toString para que no aparezca por pantalla la referencia.
		
		System.out.println("\nPrueba HashMap de Strings");
		System.out.println("==============");
		HashMap<Integer, String> m = new HashMap<Integer, String>(); //Es necesario tipar dos tipos. El primero ser� la clave.
		
		m.put(3, "Javier"); // Atenci�n. Es un put, en vez de un add en las colecciones de maps.
		m.put(2, "Pepe");
		m.put(4, "Luis");
		m.put(7, "Rafael");
		m.put(4, "Antonio"); // No permite duplicados con la clave. En este caso sobreescribir� el valor 4=Luis por 4=Manolo
		
		System.out.println(m.get(3)); // Imprimir� el elemento cuya clave sea 3
		
		System.out.println(m);
		
		System.out.println(m.containsKey(3)); //true
		System.out.println(m.containsKey(9)); //false
	}

}
