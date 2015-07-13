
public class Circulo {

	// PROPIEDADES/ATRIBUTOS/CAMPOS DE LA CLASE
	double radio;
	
	// CONSTRUCTORES DE LA CLASE
	Circulo() {
		this.radio = 1;  // Es una buena práctica añadir el 'this.' para indicar que la propiedad de la que se está haciendo referencia es la de la propia clase.
	}
	Circulo(double r) {  // Se puede sobrecargar un constructor (y claro está, también se pueden añadir parámetros)
		this.radio = r;
	}
	
	//constructor de copia
	public Circulo(Circulo circ){
		this.radio=circ.getRadio();
	}
	
	// MÉTODOS DE LA CLASE
	
	// getter y setter
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	// métodos
	public double longitud() {
		return 2 * Math.PI * this.radio;
	}
	
	public double area() {
		return Math.PI * Math.pow(this.radio, 2);
	}
	
}
