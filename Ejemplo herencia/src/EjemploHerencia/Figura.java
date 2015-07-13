package EjemploHerencia;
import java.awt.Color; // Clase de Objetos 'Color' (investigar)


public abstract class Figura { // Clase abstracta porque tiene m�todos abstractos 
							   // (Un m�todo abstracto es aquel que est� declarado pero no implementado,
	                           // adem�s de que fuerza su implemenzati�n/declaraci�n en las clases 'hijas')

	//PROPIEDADES
	
	private int grosor_borde;
	private Color color_borde;
	private Color color_relleno;
	
	
	//CONSTRUCTORES
	
	public Figura() {
		this.grosor_borde=1;
		this.color_borde=Color.BLACK;
		this.color_relleno=Color.WHITE;
	}
	
	public Figura(int grosorBorde, Color colorBorde, Color colorRelleno) {
		this.grosor_borde=grosorBorde;
		this.color_borde=colorBorde;
		this.color_relleno=colorRelleno;
	}
	
	//M�TODOS                             
	
	public abstract double Area();
	public abstract double Perimetro();
	
}
