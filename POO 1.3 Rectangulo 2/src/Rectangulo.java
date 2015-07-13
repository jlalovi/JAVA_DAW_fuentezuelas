import java.util.EmptyStackException;

/**
 * Clase 'Rectangulo'
 * crea objetos que representan las dos coordenadas necesarias para formar un rectángulo en un eje de coordenadas.
 * El eje de coordenadas representa una pantalla, por lo que los valores, que representan pixeles, son de tipo
 * entero y siempre positivos.
 * La clase contiene métodos para modificar dichas coordenadas, devolver el valor de su perímetro y área, mover el 
 * rectángulo por las diferentes posiciones del eje de coordenadas y mostrar las coordenadas actuales.
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
	 * crea un objeto rectángulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rectángulo con las siguientes coordenadas por defecto (0.0,0.0),(1.0,1.0).
	 */
	public Rectangulo() {
		this.x1=0;
		this.y1=0;
		this.x2=1;
		this.y2=1;
	}
	
	/**
	 * Constructor 'Rectangulo(x1, y1, x2, y2)'
	 * crea un objeto rectángulo con las coordenadas necesarios para que exista. Las coordenadas representan dos puntos
	 * que forman la diagonal del rectángulo. Estas coordenadas son añadidas por el usuario (x1,y1),(x2,y2).
	 * 
	 * @param x1 'int' de la coordenada x1.
	 * @param y1 'int' de la coordenada y1.
	 * @param x2 'int' de la coordenada x2.
	 * @param y2 'int' de la coordenada y2.
	 */
	public Rectangulo(int x1, int y1, int x2, int y2) {		
		nuevosVal(x1, y1, x2, y2);		
	}
	
  //MÉTODOS
	
	/**
	 * Método privado 'base()'
	 * calcula y devuelve el valor de la base del objeto 'Rectangulo'.
	 * 
	 * @return 'int' de la base del rectángulo.
	 */
	private int base() {
		return x2-x1;
	}
	
	/**
	 * Método privado 'altura()'
	 * calcula y devuelve el valor de la altura del objeto 'Rectangulo'.
	 * 
	 * @return 'int' de la altura del rectángulo.
	 */
	private int altura() {
		return y2-y1;
	}
	
	/**
	 * Método 'perimetro()'
	 * calcula y devuelve el valor del perímetro del objeto 'Rectangulo'.
	 * 
	 * @return 'int' del perímetro del rectángulo.
	 */
	public int perimetro() {
		return base()*2 + altura()*2;
	}
	
	/**
	 * Método 'area()'
	 * calcula y devuelve el valor del área del objeto 'Rectangulo'.
	 * 
	 * @return 'int' del área del rectángulo.
	 */
	public int area() {
		return base() * altura();
	}
	
	/**
	 * Método privado 'esValido()'
	 * indica si el objeto 'Rectangulo' creado tiene las dimensiones válidas en píxeles para una pantalla 1024x768
	 * 
	 * @return 'boolean' 'true': Es válido. 'false': No es válido. 
	 */
	private boolean esValido() {
		boolean esValido=true;
			if (x1>=x2 || y1>=y2 || x1<0 || y1<0 || x2<0 || y2<0 || x2>1024 || y2>768)
				esValido=false;
		return esValido;
	}
	
	/**
	 * Método 'nuevosVal(x1, y1, x2, y2)'
	 * modifica/define los valores de las coordenadas del objeto 'Rectangulo'.
	 * <p>Si los valores introducidos no cumplen las condiciones para que el objeto sea un rectángulo '(x1>=x2 || y1>=y2)', 
	 * se recibirá un error en proceso de ejecución.</p>
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
			System.err.println("¡El objeto creado NO cumple las condiciones para ser un rectángulo!");
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condición, fuerzo un error en proceso de ejecución
		}
	}
	
	/**
	 * Método 'mover(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas, indicándose el valor que se desea desplazar por el
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
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condición, fuerzo un error en proceso de ejecución
	}
	
	/**
	 * Método 'desplazarA(x,y)'
	 * desplaza el objeto 'Rectangulo' por el eje de coordenadas al punto indicado, que será el nuevo valor
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
			throw new EmptyStackException(); // Si los valores iniciados no corresponden con la condición, fuerzo un error en proceso de ejecución
	}
	
	/**
	 * Método 'moverArriba(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indicándose el valor que se desea desplazar
	 * hacia arriba.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia abajo en el eje vertical.
	 * 
	 * @param y 'int' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverArriba(int y) {
		mover(0,y);
	}
	
	/**
	 * Método 'moverAbajo(y)'
	 * desplaza el objeto 'Rectangulo' por el eje vertical, indicándose el valor que se desea desplazar
	 * hacia abajo.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia arriba en el eje vertical.
	 * 
	 * @param y 'int' del valor que se quiere desplazar por el eje vertical o de ordenadas.
	 */
	public void moverAbajo(int y) {
		mover(0,-y);
	}
	
	/**
	 * Método 'moverIzq(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indicándose el valor que se desea desplazar
	 * hacia la izquierda.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia la derecha en el eje horizontal.
	 * 
	 * @param x 'int' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverIzq(int x) {
		mover(-x,0);
	}
	
	/**
	 * Método 'moverDcha(x)'
	 * desplaza el objeto 'Rectangulo' por el eje horizontal, indicándose el valor que se desea desplazar
	 * hacia la derecha.
	 * Si se introduce un valor negativo, evidentemente el desplazamiento será hacia la izquierda en el eje horizontal.
	 * 
	 * @param x 'int' del valor que se quiere desplazar por el eje horizontal o de abcisas.
	 */
	public void moverDcha(int x) {
		mover(x,0);
	}
	
	/**
	 * Método 'mostrarCoor()'
	 * muestra por consola las coordenadas actuales de los puntos que forman la diagonal del objeto 'Rectangulo'.
	 */
	public void mostrarCoor() {
		System.out.printf("(%d , %d),(%d , %d)\n",x1,y1,x2,y2);
	}
	/**
	 * Método 'mostrar()'
	 * muestra por consola un dibujo del objeto 'Rectangulo' simbolizado por el número de puntos que ocupa (NO pixeles).
	 */
	public void mostrar() {
		for (int i=0; i<altura()-1;i++) {
			for (int j=0; j<base()-1;j++) {
				System.out.printf("· ");					
			}
			System.out.println("");
		}
		
	}
}
