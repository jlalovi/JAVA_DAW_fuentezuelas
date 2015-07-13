import java.util.EmptyStackException;

/**
 * Clase 'Rectangulo'
 * crea objetos que representan las dos coordenadas necesarias para formar un rect�ngulo en un eje de coordenadas.
 * El eje de coordenadas representa una pantalla, por lo que los valores, que representan pixeles, son de tipo
 * entero y siempre positivos.
 * La clase contiene m�todos para modificar dichas coordenadas, devolver el valor de su per�metro y �rea, mover el 
 * rect�ngulo por las diferentes posiciones del eje de coordenadas y mostrar las coordenadas actuales.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 22/01/2015
 * 
 */
public class Rectangulo {

  //PROPIEDADES
	private int x1;
	private int y1;
	private int x2;
	private int y2;
		
	
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
	}
	
	/**
	 * Constructor 'Rectangulo(x1, y1, x2, y2)'
	 * crea un objeto rect�ngulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rect�ngulo. Estas coordenadas son a�adidas por el usuario (x1,y1),(x2,y2).
	 * 
	 * @param x1 'int' de la coordenada x1.
	 * @param y1 'int' de la coordenada y1.
	 * @param x2 'int' de la coordenada x2.
	 * @param y2 'int' de la coordenada y2.
	 */
	public Rectangulo(int x1, int y1, int x2, int y2) {		
		nuevosVal(x1, y1, x2, y2);		
	}
	
  //M�TODOS
	
	/**
	 * M�todo privado 'base()'
	 * calcula y devuelve el valor de la base del objeto 'Rectangulo'.
	 * 
	 * @return 'int' de la base del rect�ngulo.
	 */
	private int base() {
		return x2-x1;
	}
	
	/**
	 * M�todo privado 'altura()'
	 * calcula y devuelve el valor de la altura del objeto 'Rectangulo'.
	 * 
	 * @return 'int' de la altura del rect�ngulo.
	 */
	private int altura() {
		return y2-y1;
	}
	
	/**
	 * M�todo 'perimetro()'
	 * calcula y devuelve el valor del per�metro del objeto 'Rectangulo'.
	 * 
	 * @return 'int' del per�metro del rect�ngulo.
	 */
	public int perimetro() {
		return base()*2 + altura()*2;
	}
	
	/**
	 * M�todo 'area()'
	 * calcula y devuelve el valor del �rea del objeto 'Rectangulo'.
	 * 
	 * @return 'int' del �rea del rect�ngulo.
	 */
	public int area() {
		return base() * altura();
	}
	
	/**
	 * M�todo privado 'esValido()'
	 * indica si el objeto 'Rectangulo' creado tiene las dimensiones v�lidas en p�xeles para una pantalla 1024x768
	 * 
	 * @return 'boolean' 'true': Es v�lido. 'false': No es v�lido. 
	 */
	private boolean esValido() {
		boolean esValido=true;
			if (x1>=x2 || y1>=y2 || x1<0 || y1<0 || x2<0 || y2<0 || x2>1024 || y2>768)
				esValido=false;
		return esValido;
	}
	
	/**
	 * M�todo 'nuevosVal(x1, y1, x2, y2)'
	 * modifica/define los valores de las coordenadas del objeto 'Rectangulo'.
	 * <p>Si los valores introducidos no cumplen las condiciones para que el objeto sea un rect�ngulo '(x1>=x2 || y1>=y2)', 
	 * se recibir� un error en proceso de ejecuci�n.</p>
	 * 
	 * @param x1 'int' de la coordenada x1.
	 * @param y1 'int' de la coordenada y1.
	 * @param x2 'int' de la coordenada x2.
	 * @param y2 'int' de la coordenada y2.
	 */
	public void nuevosVal (int x1, int y1, int x2, int y2) {		
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;		
		if (!esValido()) {
			System.err.println("�El objeto creado NO cumple las condiciones para ser un rect�ngulo!");
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condici�n, fuerzo un error en proceso de ejecuci�n
		}
	}
	
	/**
	 * M�todo 'mover(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas, indic�ndose el valor que se desea desplazar por el
	 * eje horizontal 'x' y vertical 'y'.
	 * 
	 * @param x 'int' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 * @param y 'int' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void mover(int x, int y) {
		this.x1=this.x1 + x;
		this.y1=this.y1 + y;
		this.x2=this.x2 + x;
		this.y2=this.y2 + y;
		if (!esValido())
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condici�n, fuerzo un error en proceso de ejecuci�n
	}
	
	/**
	 * M�todo 'desplazarA(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas al punto indicado, que ser� el nuevo valor
	 * tomado por las coordenadas de la diagonal inferior del objeto 'Rectangulo' '(x1,y1)'.
	 * 
	 * @param x 'int' del nuevo valor 'x1'.
	 * @param y 'int' del nuevo valor 'y1'.
	 */
	public void desplazarA(int x, int y) {
		int altura = altura();
		int base = base();
		this.x1= x;
		this.y1= y;
		this.x2= x + base;
		this.y2= y + altura;
		if (!esValido())
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condici�n, fuerzo un error en proceso de ejecuci�n
	}
	
	/**
	 * M�todo 'moverArriba(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indic�ndose el valor que se desea desplazar
	 * hacia arriba.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia abajo en el eje vertical.
	 * 
	 * @param y 'int' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverArriba(int y) {
		mover(0,y);
	}
	
	/**
	 * M�todo 'moverAbajo(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indic�ndose el valor que se desea desplazar
	 * hacia abajo.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia arriba en el eje vertical.
	 * 
	 * @param y 'int' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverAbajo(int y) {
		mover(0,-y);
	}
	
	/**
	 * M�todo 'moverIzq(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indic�ndose el valor que se desea desplazar
	 * hacia la izquierda.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia la derecha en el eje horizontal.
	 * 
	 * @param x 'int' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverIzq(int x) {
		mover(-x,0);
	}
	
	/**
	 * M�todo 'moverDcha(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indic�ndose el valor que se desea desplazar
	 * hacia la derecha.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento ser� hacia la izquierda en el eje horizontal.
	 * 
	 * @param x 'int' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverDcha(int x) {
		mover(x,0);
	}
	
	/**
	 * M�todo 'mostrarCoor()'
	 * muestra por consola las coordenadas actuales de los puntos que forman la diagonal del objeto 'Rectangulo'.
	 */
	public void mostrarCoor() {
		System.out.printf("(%d , %d),(%d , %d)\n",x1,y1,x2,y2);
	}
	/**
	 * M�todo 'mostrar()'
	 * muestra por consola un dibujo del objeto 'Rectangulo' simbolizado por el n�mero de puntos que ocupa (NO pixeles).
	 */
	public void mostrar() {
		for (int i=0; i<altura()-1;i++) {
			for (int j=0; j<base()-1;j++) {
				System.out.printf("� ");					
			}
			System.out.println("");
		}
		
	}
}
