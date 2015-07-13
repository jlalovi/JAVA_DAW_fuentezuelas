package Publicaciones;

public class Revista extends PublicacionPeriodica{
		
	//CONSTRUCTORES:
		
	public Revista(String isbn, int npaginas, String nombre_publicacion) {
		super(isbn, npaginas, nombre_publicacion);
	}
		
	//M�TODOS
		
	@Override
	public double costePublicacion() {
		return 0.02*this.npaginas + 1;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + this.isbn + " - P�ginas: " + this.npaginas + " - T�tulo: " + this.nombre_publicacion + " - Coste de publicaci�n: " + this.costePublicacion() + "�";
	}
		
}
