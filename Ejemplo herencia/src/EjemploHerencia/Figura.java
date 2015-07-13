package EjemploHerencia;
import java.awt.Color; // Clase de Objetos 'Color' (investigar)


public abstract class Figura { // Clase abstracta porque tiene métodos abstractos 
							   // (Un método abstracto es aquel que está declarado pero no implementado,
	                           // además de que fuerza su implemenzatión/declaración en las clases 'hijas')

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
	
	//MÉTODOS                             
	
	public abstract double Area();
	public abstract double Perimetro();
	
}
