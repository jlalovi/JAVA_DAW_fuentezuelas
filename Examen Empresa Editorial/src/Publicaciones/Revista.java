package Publicaciones;

public class Revista extends PublicacionPeriodica{
		
	//CONSTRUCTORES:
		
	public Revista(String isbn, int npaginas, String nombre_publicacion) {
		super(isbn, npaginas, nombre_publicacion);
	}
		
	//MÉTODOS
		
	@Override
	public double costePublicacion() {
		return 0.02*this.npaginas + 1;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + this.isbn + " - Páginas: " + this.npaginas + " - Título: " + this.nombre_publicacion + " - Coste de publicación: " + this.costePublicacion() + "€";
	}
		
}
