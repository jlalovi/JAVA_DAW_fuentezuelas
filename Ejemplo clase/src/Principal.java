
public class Principal {

	public static void main(String[] args) {

		Circulo c1 = new Circulo();    // Crear el objeto 'c1' de la clase círculo (A esto se le denomina "instanciar una clase" -> crear un objeto de esa clase)
		Circulo c2 = new Circulo(7);   // Crear el objeto 'c2' de la clase círculo
		Circulo c3 = new Circulo(c2);  // Copio objeto círculo c2 con el constructor copia.
		
		// Si se escribe ahora 'c1.', podemos visualizar todos los miembros y 
		// métodos que podemos aplicar al objeto 'c1' creado.
		// Ejemplo:
		
		System.out.println(c1.radio);  // Esto va a imprimir '1'
		c1.radio = 3;
		System.out.println(c1.radio);  // Esto va a imprimir '3', evidentemente.
		
		System.out.println(c2.radio);  // Esto va a imprimir '7'
		
		System.out.println(c3.radio);  // Esto también va a imprimir '7', ya que es una copia de c2.
		System.out.println(c1.equals(c2));  // false
		System.out.println(c3.equals(c2));  // true
	}

}
