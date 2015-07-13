package Publicaciones;

public abstract class Publicacion {
	//PROPIEDADES:
	
	protected String isbn;
	protected int npaginas;
	
	//CONSTRUCTORES:
	private Publicacion(){} // No quiero que el constructor por defecto sea accesible en las subclases.
	
	protected Publicacion(String isbn, int npaginas) {
		this.isbn=isbn;
		this.npaginas=npaginas;
	}
	
	//MÉTODOS
	
	public String getIsbn() {
		return isbn;
	}

	public abstract double costePublicacion();
}
