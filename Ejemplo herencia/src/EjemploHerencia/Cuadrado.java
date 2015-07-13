package EjemploHerencia;

import java.awt.Color;

public class Cuadrado extends Figura {

	//PROPIEDADES
	
	private int lado;
	
	//CONSTRUCTORES
	
	public Cuadrado() {
		super();
		this.lado=1;
	}
	
	public Cuadrado(int grosorBorde, Color colorBorde, Color colorRelleno) {
		super(grosorBorde, colorBorde, colorRelleno);
	}
	
	//MÉTODOS

	@Override
	public double Area(){
		return lado * lado;
	}
	
	@Override
	public double Perimetro() {
		return 4 * lado;
	}
	
}