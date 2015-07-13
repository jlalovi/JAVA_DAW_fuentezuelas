
public class MainRectangulo2 {

	public static void main(String[] args) {
	
		//TESTEO
		
		//Rectangulo r2 = new Rectangulo(0,0,0,0);  // Prueba para ver funcionar el 'EmptyStackException();'
		
		Rectangulo r1 = new Rectangulo(0,0,20,5);
		r1.mostrarCoor();
		System.out.printf("Área: %d\n",r1.area());
		System.out.printf("Perímetro: %d\n",r1.perimetro());
		System.out.println("Muevo 2 arriba");
		r1.moverArriba(2);
		r1.mostrarCoor();
		System.out.println("Muevo -2 arriba");
		r1.moverArriba(-2);
		r1.mostrarCoor();
		System.out.println("Muevo 2 izquierda");
		r1.moverIzq(-2);
		r1.mostrarCoor();
		System.out.println("Muevo -2 izquierda");
		r1.moverIzq(2);
		r1.mostrarCoor();
		System.out.println("Muevo 10 derecha y arriba");
		r1.mover(10, 10);
		r1.mostrarCoor();
		System.out.println("Desplazo a coordenadas originales");
		r1.desplazarA(0, 0);
		r1.mostrarCoor();
		System.out.println("Dibujo del rectángulo en puntos de los ocupa");
		r1.mostrar();
	}

}
