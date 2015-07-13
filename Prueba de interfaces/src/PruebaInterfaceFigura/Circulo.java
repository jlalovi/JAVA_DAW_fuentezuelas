package PruebaInterfaceFigura;

public class Circulo implements Figura{  // 'Utilizando implements'

	//PROPIEDADES
	
	private float radio;
	
	//CONSTRUCTORES
	public Circulo(float radio) {
		this.radio=radio;
	}
	
	//MÉTODOS
	@Override
	public float Area() {
		// TODO Auto-generated method stub
		return (float)(Math.pow(this.radio, 2)*Math.PI);
	}

	@Override
	public float Perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Pintate() {
		// TODO Auto-generated method stub
		
	}

}
