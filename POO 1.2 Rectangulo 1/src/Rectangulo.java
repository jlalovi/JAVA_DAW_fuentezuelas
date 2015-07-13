import java.util.EmptyStackException;

/**
 * Clase 'Rectangulo'
 * crea objetos que representan las dos coordenadas necesarias para formar un rectángulo en un eje de coordenadas.
 * La clase contiene métodos para modificar dichas coordenadas, devolver el valor de su perímetro y área, mover el 
 * rectángulo por las diferentes posiciones del eje de coordenadas y mostrar las coordenadas actuales.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 22/01/2015
 * 
 */
public class Rectangulo {

  //PROPIEDADES
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private static int contador=0;
		
	
  //CONSTRUCTORES
	/**
	 * Constructor 'Rectangulo()'
	 * crea un objeto rectángulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rectángulo con las siguientes coordenadas por defecto (0.0,0.0),(1.0,1.0).
	 */
	public Rectangulo() {
		this.x1=0;
		this.y1=0;
		this.x2=1;
		this.y2=1;
		contador++;
	}
	
	/**
	 * Constructor 'Rectangulo(x1, y1, x2, y2)'
	 * crea un objeto rectángulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rectángulo. Estas coordenadas son añadidas por el usuario (x1,y1),(x2,y2).
	 * 
	 * @param x1 'double' de la coordenada x1.
	 * @param y1 'double' de la coordenada y1.
	 * @param x2 'double' de la coordenada x2.
	 * @param y2 'double' de la coordenada y2.
	 */
	public Rectangulo(double x1, double y1, double x2, double y2) {
		this();
		nuevosVal(x1, y1, x2, y2);		
	}
	
  //MÉTODOS
	
	/**
	 * Método privado y estático 'contar()'
	 * cuenta el número de objetos rectángulo que se han creado durante la ejecución del Main que haga uso de estos objetos, hasta la finalización
	 * de dicha ejecución.
	 * 
	 * @return 'int' del número de objetos 'Rectángulo' que se han creado.
	 */
	public static int contar() {
		return contador;
	}
	
	/**
	 * Método privado 'base()'
	 * calcula y devuelve el valor de la base del objeto 'Rectangulo'.
	 * 
	 * @return 'double' de la base del rectángulo.
	 */
	private double base() {
		return x2-x1;
	}
	
	/**
	 * Método privado 'altura()'
	 * calcula y devuelve el valor de la altura del objeto 'Rectangulo'.
	 * 
	 * @return 'double' de la altura del rectángulo.
	 */
	private double altura() {
		return y2-y1;
	}
	
	/**
	 * Método 'perimetro()'
	 * calcula y devuelve el valor del perímetro del objeto 'Rectangulo'.
	 * 
	 * @return 'double' del perímetro del rectángulo.
	 */
	public double perimetro() {
		return base()*2 + altura()*2;
	}
	
	/**
	 * Método 'area()'
	 * calcula y devuelve el valor del área del objeto 'Rectangulo'.
	 * 
	 * @return 'double' del área del rectángulo.
	 */
	public double area() {
		return base() * altura();
	}
	
	/**
	 * Método privado 'esRectangulo()'
	 * indica si el objeto 'Rectangulo' creado se considera rectángulo. Los cuadrados también son considerados
	 * rectángulos en este ejercicio.
	 * 
	 * @return 'boolean' 'true': Es un rectángulo. 'false': No es un rectángulo. 
	 */
	private boolean esRectangulo() {
		boolean esRectangulo=true;
			if (x1>=x2 || y1>=y2)
				esRectangulo=false;
		return esRectangulo;
	}
	
	/**
	 * Método 'nuevosVal(x1, y1, x2, y2)'
	 * modifica/define los valores de las coordenadas del objeto 'Rectangulo'.
	 * <p>Si los valores introducidos no cumplen las condiciones para que el objeto sea un rectángulo '(x1>=x2 || y1>=y2)', 
	 * se recibirá un error en proceso de ejecución.</p>
	 * 
	 * @param x1 'double' de la coordenada x1.
	 * @param y1 'double' de la coordenada y1.
	 * @param x2 'double' de la coordenada x2.
	 * @param y2 'double' de la coordenada y2.
	 */
	public void nuevosVal (double x1, double y1, double x2, double y2) {		
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;		
		if (!esRectangulo()) {
			System.err.println("¡El objeto creado NO cumple las condiciones para ser un rectángulo!");
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condición, fuerzo un error en proceso de ejecución
		}
	}
	
	/**
	 * Método 'mover(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas, indicándose el valor que se desea desplazar por el
	 * eje horizontal 'x' y vertical 'y'.
	 * 
	 * @param x 'double' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 * @param y 'double' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void mover(double x, double y) {
		this.x1=this.x1 + x;
		this.y1=this.y1 + y;
		this.x2=this.x2 + x;
		this.y2=this.y2 + y;
	}
	
	/**
	 * Método 'desplazarA(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas al punto indicado, que será el nuevo valor
	 * tomado por las coordenadas de la diagonal inferior del objeto 'Rectangulo' '(x1,y1)'.
	 * 
	 * @param x 'double' del nuevo valor 'x1'.
	 * @param y 'double' del nuevo valor 'y1'.
	 */
	public void desplazarA(double x, double y) {
		double altura = altura();
		double base = base();
		this.x1= x;
		this.y1= y;
		this.x2= x + base;
		this.y2= y + altura;
	}
	
	/**
	 * Método 'moverArriba(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indicándose el valor que se desea desplazar
	 * hacia arriba.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia abajo en el eje vertical.
	 * 
	 * @param y 'double' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverArriba(double y) {
		mover(0,y);
	}
	
	/**
	 * Método 'moverAbajo(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indicándose el valor que se desea desplazar
	 * hacia abajo.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia arriba en el eje vertical.
	 * 
	 * @param y 'double' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverAbajo(double y) {
		mover(0,-y);
	}
	
	/**
	 * Método 'moverIzq(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indicándose el valor que se desea desplazar
	 * hacia la izquierda.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia la derecha en el eje horizontal.
	 * 
	 * @param x 'double' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverIzq(double x) {
		mover(-x,0);
	}
	
	/**
	 * Método 'moverDcha(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indicándose el valor que se desea desplazar
	 * hacia la derecha.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia la izquierda en el eje horizontal.
	 * 
	 * @param x 'double' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverDcha(double x) {
		mover(x,0);
	}
	
	/**
	 * Método 'mostrarCoor()'
	 * muestra por consola las coordenadas actuales de los puntos que forman la diagonal del objeto 'Rectangulo'.
	 */
	public void mostrarCoor() {
		System.out.printf("(%.2f , %.2f),(%.2f , %.2f)\n",x1,y1,x2,y2);
	}
}
