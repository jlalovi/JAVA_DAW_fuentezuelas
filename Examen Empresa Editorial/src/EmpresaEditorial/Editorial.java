package EmpresaEditorial;
import java.util.ArrayList;
import java.util.TreeMap;

import Publicaciones.Publicacion;

public class Editorial {
	
	//PROPIEDADES
	
	private TreeMap<String,String> autores; // Todos los autores que vaya introduciendo en el los objetos Libro, los almacenar� tambi�n en este TreeMap
	private TreeMap<String,Publicacion> publicaciones; // Todas las publicaciones que se creen en la editorial.
	
	// CONSTRUCTOR
	
	public Editorial() {
		this.autores= new TreeMap<String,String>();
		this.publicaciones= new TreeMap<String, Publicacion>();
	}
	
	//M�TODOS
	
	public void a�adirPublicacion(Publicacion publicacion_nueva) {
		publicaciones.put(publicacion_nueva.getIsbn(),publicacion_nueva);
	}
	
	public void a�adirPublicaciones(Publicacion ... publicacion_nueva){
		for (int i=0; i<publicacion_nueva.length; i++) {
			publicaciones.put(publicacion_nueva[i].getIsbn(),publicacion_nueva[i]);
		}
	}
	
	public String buscarPublicacion(String isbn){
		String respuesta="No se ha encontrado la publicaci�n con el ISBN '" + isbn + "'.";
		if (this.publicaciones.containsKey(isbn.toLowerCase())) {
			respuesta=publicaciones.get(isbn).toString();
		}
		return respuesta;
	}
	
	public boolean existeISBN(String isbn){
		return publicaciones.containsKey(isbn.toLowerCase());
	}
	
	public String borrarPublicacion(String isbn){
		String respuesta="No se ha encontrado la publicaci�n con el ISBN '" + isbn + "'.";
		if (this.publicaciones.containsKey(isbn.toLowerCase())) {
			publicaciones.remove(isbn);
			respuesta="La publicacion ha sido borrada correctamente.";
		}
		return respuesta;
	}
	
	public String listarPublicaciones(){
		return publicaciones.toString(); // Van a salir todas las listas en una l�nea, ordenadas por ISBN. S� que visualmente ser� horrible, pero no tengo m�s tiempo para hacer una interfaz gr�fica m�s bonita.
	}
	
	
}
