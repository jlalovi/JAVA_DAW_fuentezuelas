
public class MainRectangulo1 {

	public static void main(String[] args) {
	
		//TESTEO
		
		//Rectangulo r1 = new Rectangulo(0,0,0,0);  // Prueba para saber si funciona el 'EmptyStackException();'
		
		Rectangulo r1 = new Rectangulo(0,0,2,4);
		r1.mostrarCoor();
		System.out.printf("Área: %.2f\n",r1.area());
		System.out.printf("Perímetro: %.2f\n",r1.perimetro());
		System.out.println("Muevo 2 abajo");
		r1.moverAbajo(2);
		r1.mostrarCoor();
		System.out.println("Muevo -2 abajo");
		r1.moverAbajo(-2);
		r1.mostrarCoor();
		System.out.println("Muevo 2 derecha");
		r1.moverDcha(2);
		r1.mostrarCoor();
		System.out.println("Muevo -2 derecha");
		r1.moverDcha(-2);
		r1.mostrarCoor();
		System.out.println("Muevo 2 izquierda y arriba");
		r1.mover(-2, 2);
		r1.mostrarCoor();
		System.out.println("Desplazo a coordenadas originales");
		r1.desplazarA(0, 0);
		r1.mostrarCoor();
		Rectangulo r2 = new Rectangulo(0,0,2,4);
		Rectangulo r3 = new Rectangulo(0,0,2,4);
		System.out.println("Número de Rectángulos");
		System.out.println(Rectangulo.contar());
		Rectangulo r4 = new Rectangulo(0,0,2,4);
		Rectangulo r5 = new Rectangulo(0,0,2,4);
		Rectangulo r6 = new Rectangulo(0,0,2,4);
		System.out.println("Número de Rectángulos");
		System.out.println(Rectangulo.contar());
	}

}
