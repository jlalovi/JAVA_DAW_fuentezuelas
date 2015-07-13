package PruebaInterfaceFigura;

import java.util.ArrayList;

public class MainPruebaInterfaceFigura {

	public static void main(String[] args) {
		// Figura mifigura= new Figura();  // No se puede instanciar una interface.
		ArrayList<Figura> misfiguras= new ArrayList<Figura>(); // Sin embargo s� que se puede utilizar para, ArrayLists, m�todos como el de abajo...
		misfiguras.add(new Circulo(2));
		misfiguras.add(new Circulo(3));
		System.out.println(SumaAreasColeccion(misfiguras));
		
	}
	
	public static float SumaAreasColeccion(ArrayList<Figura> figuras) { // Este m�todo tiene que ser est�tico para acceder al Main que tambi�n es est�tico!!!!!
		float suma=0;
		for (Figura figura : figuras) {
			suma+=figura.Area();
		}
		return suma;
	}

}
