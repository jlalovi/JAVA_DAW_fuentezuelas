package EjemploHerencia;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		double suma_area=0;
		
		Figura cuadrado1 = new Cuadrado();
		Figura cuadrado2 = new Cuadrado();
		
		Figura circulo1 = new Circulo();
		Figura circulo2 = new Circulo();
		
		ArrayList <Figura> lista_figuras = new ArrayList();

		lista_figuras.add(cuadrado1);
		lista_figuras.add(cuadrado2);
		lista_figuras.add(circulo1);
		lista_figuras.add(circulo2);
		
		for (Figura t:lista_figuras) {  // Para cada una de las figuras del ArrayList, temporalmente le llamo 't' en cada iteración.
			suma_area+=t.Area();
		}
		
		System.out.println(suma_area);
		
	}

}
