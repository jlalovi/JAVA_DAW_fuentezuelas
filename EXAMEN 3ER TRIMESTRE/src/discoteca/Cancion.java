package discoteca;

public class Cancion {

	//PROPIEDADES
	private String codigo_disco;
	private int n_pista;
	private String titulo;
	private int duracion;
	
	//GETTERS 
	public String getCodigo_disco() {
		return codigo_disco;
	}
	public int getN_pista() {
		return n_pista;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	
	//CONSTRUCTORES
	@SuppressWarnings("unused")
	private Cancion(){} //No quiero un Constructor por defecto.
	
	public Cancion(String codigo_disco, int n_pista, String titulo, int duracion) {
		this.codigo_disco = codigo_disco;
		this.n_pista = n_pista;
		this.titulo = titulo;
		this.duracion = duracion;
	}
	
	//MÉTODO (para testeo)
	@Override
	public String toString() {
		return this.titulo + "";
	}
	
	
	
}
