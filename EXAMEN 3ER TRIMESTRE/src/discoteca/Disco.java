package discoteca;

import java.util.ArrayList;

public class Disco {

	//PROPIEDADES
	private String codigo;
	private String titulo;
	private String autor;
	private String precio;
	private ArrayList<Cancion> canciones;
	
	//GETTERS
	public String getCodigo() {
		return codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getPrecio() {
		return precio;
	}
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}
	
	//SETTER
	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	//CONSTRUCTORES
	@SuppressWarnings("unused")
	private Disco(){} //No quiero un Constructor por defecto.
	
	public Disco(String codigo, String titulo, String autor, String precio) {
		this.canciones = new ArrayList<Cancion>();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	
	//MÉTODOS 
	/**
	 * Añade un objeto 'Canción' nuevo al ArrayList de canciones de 'Disco'
	 * @param cancion_nueva es un objeto Cancion
	 */
	public void añadirCancion(Cancion cancion_nueva){
		canciones.add(cancion_nueva);
	}
	
	public String calcularTiempoTotal() {
		int sumaTiempo=0;
		for (Cancion c: this.canciones) {
			sumaTiempo+=c.getDuracion();
		}		
		int segundos=sumaTiempo%60;
		int minutos= (sumaTiempo-segundos)/60;
		return minutos+":"+segundos;
	}
	
	//(para testeo)
	@Override
	public String toString() {
		return this.titulo + "";
	}
	
	
}
