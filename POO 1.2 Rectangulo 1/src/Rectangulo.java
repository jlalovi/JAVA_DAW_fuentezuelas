import java.util.EmptyStackException;

/**
 * Clase 'Rectangulo'
 * crea objetos que representan las dos coordenadas necesarias para formar un rect�ngulo en un eje de coordenadas.
 * La clase contiene m�todos para modificar dichas coordenadas, devolver el valor de su per�metro y �rea, mover el 
 * rect�ngulo por las diferentes posiciones del eje de coordenadas y mostrar las coordenadas actuales.
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
	 * crea un objeto rect�ngulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rect�ngulo con las siguientes coordenadas por defecto (0.0,0.0),(1.0,1.0).
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
	 * crea un objeto rect�ngulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rect�ngulo. Estas coordenadas son a�adidas por el usuario (x1,y1),(x2,y2).
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
	
  //M�TODOS
	
	/**
	 * M�todo privado y est�tico 'contar()'
	 * cuenta el n�mero de objetos rect�ngulo que se han creado durante la ejecuci�n del Main que haga uso de estos objetos, hasta la finalizaci�n
	 * de dicha ejecuci�n.
	 * 
	 * @return 'int' del n�mero de objetos 'Rect�ngulo' que se han creado.
	 */
	public static int contar() {
		return contador;
	}
	
	/**
	 * M�todo privado 'base()'
	 * calcula y devuelve el valor de la base del objeto 'Rectangulo'.
	 * 
	 * @return 'double' de la base del rect�ngulo.
	 */
	private double base() {
		return x2-x1;
	}
	
	/**
	 * M�todo privado 'altura()'
	 * calcula y devuelve el valor de la altura del objeto 'Rectangulo'.
	 * 
	 * @return 'double' de la altura del rect�ngulo.
	 */
	private double altura() {
		return y2-y1;
	}
	
	/**
	 * M�todo 'perimetro()'
	 * calcula y devuelve el valor del per�metro del objeto 'Rectangulo'.
	 * 
	 * @return 'double' del per�metro del rect�ngulo.
	 */
	public double perimetro() {
		return base()*2 + altura()*2;
	}
	
	/**
	 * M�todo 'area()'
	 * calcula y devuelve el valor del �rea del objeto 'Rectangulo'.
	 * 
	 * @return 'double' del �rea del rect�ngulo.
	 */
	public double area() {
		return base() * altura();
	}
	
	/**
	 * M�todo privado 'esRectangulo()'
	 * indica si el objeto 'Rectangulo' creado se considera rect�ngulo. Los cuadrados tambi�n son considerados
	 * rect�ngulos en este ejercicio.
	 * 
	 * @return 'boolean' 'true': Es un rect�ngulo. 'false': No es un rect�ngulo. 
	 */
	private boolean esRectangulo() {
		boolean esRectangulo=true;
			if (x1>=x2 || y1>=y2)
				esRectangulo=false;
		return esRectangulo;
	}
	
	/**
	 * M�todo 'nuevosVal(x1, y1, x2, y2)'
	 * modifica/define los valores de las coordenadas del objeto 'Rectangulo'.
	 * <p>Si los valores introducidos no cumplen las condiciones para que el objeto sea un rect�ngulo '(x1>=x2 || y1>=y2)', 
	 * se recibir� un error en proceso de ejecuci�n.</p>
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
			System.err.println("�El objeto creado NO cumple las condiciones para ser un rect�ngulo!");
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condici�n, fuerzo un error en proceso de ejecuci�n
		}
	}
	
	/**
	 * M�todo 'mover(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas, indic�ndose el valor que se desea desplazar por el
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
	 * M�todo 'desplazarA(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas al punto indicado, que ser� el nuevo valor
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
	 * M�todo 'moverArriba(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indic�ndose el valor que se desea desplazar
	 * hacia arriba.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia abajo en el eje vertical.
	 * 
	 * @param y 'double' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverArriba(double y) {
		mover(0,y);
	}
	
	/**
	 * M�todo 'moverAbajo(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indic�ndose el valor que se desea desplazar
	 * hacia abajo.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia arriba en el eje vertical.
	 * 
	 * @param y 'double' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverAbajo(double y) {
		mover(0,-y);
	}
	
	/**
	 * M�todo 'moverIzq(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indic�ndose el valor que se desea desplazar
	 * hacia la izquierda.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia la derecha en el eje horizontal.
	 * 
	 * @param x 'double' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverIzq(double x) {
		mover(-x,0);
	}
	
	/**
	 * M�todo 'moverDcha(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indic�ndose el valor que se desea desplazar
	 * hacia la derecha.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia la izquierda en el eje horizontal.
	 * 
	 * @param x 'double' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverDcha(double x) {
		mover(x,0);
	}
	
	/**
	 * M�todo 'mostrarCoor()'
	 * muestra por consola las coordenadas actuales de los puntos que forman la diagonal del objeto 'Rectangulo'.
	 */
	public void mostrarCoor() {
		System.out.printf("(%.2f , %.2f),(%.2f , %.2f)\n",x1,y1,x2,y2);
	}
}
