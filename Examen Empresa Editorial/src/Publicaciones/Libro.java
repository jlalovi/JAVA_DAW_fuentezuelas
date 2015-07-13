package Publicaciones;

import java.util.TreeMap;

public class Libro extends Publicacion{
	//PROPIEDADES:
	
	private String titulo;
	private TapaLibro tipo_tapa; // Enum en el que s�lo acepto valores "DURA" y "BLANDA"
	private TreeMap<String,String> autores; // TreeMap donde almacenar� una cadena con el DNI y otra con el nombre y apellidos del autor. Lo m�s adecuado habr�a sido crear un objeto Autor, pero quer�a poner a pruaba la colecci�n TreeMap de manera b�sica.
		
	//CONSTRUCTORES:
	
	public Libro(String isbn, int npaginas, String titulo, TapaLibro tipo_tapa) {
		super(isbn, npaginas);
		this.titulo=titulo;
		this.tipo_tapa=tipo_tapa;
		this.autores=new TreeMap<String,String>();
	}
		
	//M�TODOS
	
	public boolean a�adirAutor(String dni, String nombre_completo){
		boolean a�adido;		
		if (this.autores.containsKey(dni.toLowerCase())) //Compruebo si el autor existe para devolver un false.
			a�adido=false;
		else {
			autores.put(dni, nombre_completo); // Si el autor se introduce sin probelmas, devuelvo un true.
			a�adido=true;
		}		
		return a�adido;
	}
		
	@Override
	public double costePublicacion() {
		double tapa;
		if (this.tipo_tapa==TapaLibro.BLANDA)
			tapa=0.50;
		else
			tapa=1;
		return 0.01 * this.npaginas + 2.5 * autores.size() + tapa;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + this.isbn + " - P�ginas: " + this.npaginas + " - T�tulo: " + this.titulo + " - Tipo de tapa: " + this.tipo_tapa + " - Autor/es: " + this.autores.toString() + " - Coste de publicaci�n: " + this.costePublicacion() + "�";
	}
	
}
