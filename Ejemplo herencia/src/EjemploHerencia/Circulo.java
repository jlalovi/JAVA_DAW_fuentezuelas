package EjemploHerencia;

import java.awt.Color;

public class Circulo extends Figura {

	//PROPIEDADES
	
	private int radio;
	
	//CONSTRUCTORES
	
	public Circulo() {
		super();
		this.radio=1;
	}
	
	public Circulo(int grosorBorde, Color colorBorde, Color colorRelleno) {
		super(grosorBorde, colorBorde, colorRelleno);
	}
	
	//MÉTODOS
	
	@Override
	public double Area(){
		return Math.pow(this.radio, 2) * Math.PI;
	}
	
	@Override
	public double Perimetro() {
		return 2 * Math.PI * this.radio;
	}
	
}
