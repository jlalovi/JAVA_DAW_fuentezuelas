/**
 * Clase 'EcuSeg' (Ecuación de Segundo Grado)
 * crea objetos que representan los 3 coeficientes de una ecuación de segundo grado 'ax^2 + bx + c = 0'
 * y contiene métodos para modificar dichos coeficientes, saber si tienen solución y devolver resultado.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 19/01/2015
 *
 */
public class EcuSeg {
	
  //PROPIEDADES
	private int a;
	private int b;
	private int c;

  //CONSTRUCTORES
	/**
	 * Constructor 'EcuSeg()'
	 * crea un objeto que contiene los coefiecientes de una ecuación de segundo grado por defecto 
	 * con todos los coeficientes igual a 0.
	 */
	public EcuSeg() {
		this.a=0;
		this.b=0;
		this.c=0;
	}
	/**
	 * Constructor 'EcuSeg(a,b,c)'
	 * crea un objeto que contiene los coefiecientes de una ecuación de segundo grado especificados en
	 * los siguientes parámetros.
	 * 
	 * @param a 'int' del coeficiente a.
	 * @param b 'int' del coeficiente b.
	 * @param c 'int' del coeficiente c.
	 */
	public EcuSeg(int a, int b, int c) {     // Sobrecarga del constructor 'EcuSeg' en la que se puede modificar el valor de los coeficientes.
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
  //MÉTODOS
  //Getters and Setters:
	/**
	 * Método 'getA()'
	 * devuelve el valor del coeficiente a.
	 * 
	 * @return 'int' del coeficiente a.
	 */
	public int getA() {
		return a;
	}
	/**
	 * Método 'setA(a)'
	 * permite modificar el valor del coeficiente a.
	 */
	public void setA(int a) {
		this.a = a;
	}
	/**
	 * Método 'getB()'
	 * devuelve el valor del coeficiente b.
	 * 
	 * @return 'int' del coeficiente b.
	 */
	public int getB() {
		return b;
	}
	/**
	 * Método 'setB(b)'
	 * permite modificar el valor del coeficiente b.
	 */
	public void setB(int b) {
		this.b = b;
	}
	/**
	 * Método 'getC()'
	 * devuelve el valor del coeficiente c.
	 * 
	 * @return 'int' del coeficiente c.
	 */
	public int getC() {
		return c;
	}
	/**
	 * Método 'setC(c)'
	 * permite modificar el valor del coeficiente c.
	 */
	public void setC(int c) {
		this.c = c;
	}
	/**
	 * Método 'setABC(a,b,c)'
	 * permite cambiar todos los coeficientes con un sólo método en lugar de uno a uno con los métodos correspondientes
	 * 'setA', 'setB' y 'setC'.
	 * 
	 * @param a 'int' del coeficiente a en la ecuación de segundo grado.
	 * @param b 'int' del coeficiente b en la ecuación de segundo grado.
	 * @param c 'int' del coeficiente c en la ecuación de segundo grado.
	 */
	public void setABC(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Método 'delta()'
	 * devuelve el valor discriminante o delta del objeto ecucuón de segundo grado 'EcuSeg'
	 * 
	 * @return 'double' del valor delta o discriminante de la ecuación de segundo grado.
	 */
	private double delta() {
		return Math.pow(this.b, 2) - 4 * this.a * this.c;
	}
	
	/**
	 * Método 'solucionValida()'
	 * devuelve un booleano especificando si los coeficientes del objeto tiene solución.
	 * 
	 * @return 'boolean' 'true': Ecuación de 2ºgrado con solución 'false': Ecuación de 2ºgrado sin solución
	 */
	public boolean solucionValida() {
		boolean sol_valida=true;
		
		if (delta()<0 || a==0)
			sol_valida=false;   // Si el valor delta es negativo o a es 0, considero que la ecuación de segundo grado NO tiene solución.

		return sol_valida;
	}
	
	/**
	 * Método 'resultado()'
	 * devuelve un vector con las dos posibles soluciones  de la ecuación de segundo grado.
	 * En caso de no haber solución se mostrará un mensaje de error por consola.
	 * 
	 * @return 'double[]' con las dos posibles soluciones de la ecuación de segundo grado en las posiciones [0] y [1].
	 */
	public double[] resultado() {
		
		double x[] = new double[2];  // Vector que almacenará los dos valores de la ecuación de segundo grado: x1 y x2
		
		if (!solucionValida())
			System.out.println("La ecución de segundo grado no tiene solución.");
		
		x[0] = (-this.b + Math.sqrt( delta() )) / 2*this.a; // Valor de x1
		x[1] = (-this.b - Math.sqrt( delta() )) / 2*this.a; // Valor de x2
		
		return x;
	}
	
}
