package Publicaciones;

public abstract class PublicacionPeriodica extends Publicacion{
	//PROPIEDADES:
	
	protected String nombre_publicacion;
		
	//CONSTRUCTORES:
	
	protected PublicacionPeriodica(String isbn, int npaginas, String nombre_publicacion) {
		super(isbn, npaginas);
		this.nombre_publicacion=nombre_publicacion;
	}
		
}
