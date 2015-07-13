package matematicas;

public class Operaciones {

	public double suma (double a, double b) {
		return(a+b);
	}
	public double resta(double a, double b) {
		return(a-b);
	}
	public double multiplicacion(double a, double b) {
		return(a*b);
	}
	public double division(double a, double b) {
		if (b==0)
			return 0;  // Para esta prueba, devuelvo 0 si el divisor=0
		else
			return a/b;
	}
	public double exponenciacion(double a, double b) {
		return(Math.pow(a, b));
	}
}

/**
 * Para crear el jar:
 * - Click derecho sobre este paquete matemáticas y seleccionar 'export'
 * - Seleccionar Java/JAR file
 * - Operaciones Matematicas/src/matematicas > Operaciones.java
 * - Seleccionar ruta, en mi caso: 'C:\Users\Javier\Dropbox\Apuntes DAW\paquetes JAVA\operaciones.jar'
 * - Presionar botón finalizar.
 * 
 * Para aplicar el jar:
 * - Crear un nuevo proyecto donde se utilicen los métodos de la clase Operaciones.java (En el ejemplo 'Operaciones jar')
 * - Crear una clase Main para probar dichos métodos (En el ejemplo 'UsoOperacionesJar.java').
 * - Click derecho sobre carpeta del nuevo proyecto 'Operaciones jar' y 'Build path'>'add external file'
 * - Seleccionar archivo .jar creado anteriormente en la ruta especificada (en mi caso 'C:\Users\Javier\Dropbox\Apuntes DAW\paquetes JAVA\operaciones.jar')
 * @author Javier
 *
 */