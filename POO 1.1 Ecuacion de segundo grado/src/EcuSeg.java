/**
 * Clase 'EcuSeg' (Ecuaci�n de Segundo Grado)
 * crea objetos que representan los 3 coeficientes de una ecuaci�n de segundo grado 'ax^2 + bx + c = 0'
 * y contiene m�todos para modificar dichos coeficientes, saber si tienen soluci�n y devolver resultado.
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
	 * crea un objeto que contiene los coefiecientes de una ecuaci�n de segundo grado por defecto 
	 * con todos los coeficientes igual a 0.
	 */
	public EcuSeg() {
		this.a=0;
		this.b=0;
		this.c=0;
	}
	/**
	 * Constructor 'EcuSeg(a,b,c)'
	 * crea un objeto que contiene los coefiecientes de una ecuaci�n de segundo grado especificados en
	 * los siguientes par�metros.
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
	
  //M�TODOS
  //Getters and Setters:
	/**
	 * M�todo 'getA()'
	 * devuelve el valor del coeficiente a.
	 * 
	 * @return 'int' del coeficiente a.
	 */
	public int getA() {
		return a;
	}
	/**
	 * M�todo 'setA(a)'
	 * permite modificar el valor del coeficiente a.
	 */
	public void setA(int a) {
		this.a = a;
	}
	/**
	 * M�todo 'getB()'
	 * devuelve el valor del coeficiente b.
	 * 
	 * @return 'int' del coeficiente b.
	 */
	public int getB() {
		return b;
	}
	/**
	 * M�todo 'setB(b)'
	 * permite modificar el valor del coeficiente b.
	 */
	public void setB(int b) {
		this.b = b;
	}
	/**
	 * M�todo 'getC()'
	 * devuelve el valor del coeficiente c.
	 * 
	 * @return 'int' del coeficiente c.
	 */
	public int getC() {
		return c;
	}
	/**
	 * M�todo 'setC(c)'
	 * permite modificar el valor del coeficiente c.
	 */
	public void setC(int c) {
		this.c = c;
	}
	/**
	 * M�todo 'setABC(a,b,c)'
	 * permite cambiar todos los coeficientes con un s�lo m�todo en lugar de uno a uno con los m�todos correspondientes
	 * 'setA', 'setB' y 'setC'.
	 * 
	 * @param a 'int' del coeficiente a en la ecuaci�n de segundo grado.
	 * @param b 'int' del coeficiente b en la ecuaci�n de segundo grado.
	 * @param c 'int' del coeficiente c en la ecuaci�n de segundo grado.
	 */
	public void setABC(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * M�todo 'delta()'
	 * devuelve el valor discriminante o delta del objeto ecucu�n de segundo grado 'EcuSeg'
	 * 
	 * @return 'double' del valor delta o discriminante de la ecuaci�n de segundo grado.
	 */
	private double delta() {
		return Math.pow(this.b, 2) - 4 * this.a * this.c;
	}
	
	/**
	 * M�todo 'solucionValida()'
	 * devuelve un booleano especificando si los coeficientes del objeto tiene soluci�n.
	 * 
	 * @return 'boolean' 'true': Ecuaci�n de 2�grado con soluci�n 'false': Ecuaci�n de 2�grado sin soluci�n
	 */
	public boolean solucionValida() {
		boolean sol_valida=true;
		
		if (delta()<0 || a==0)
			sol_valida=false;   // Si el valor delta es negativo o a es 0, considero que la ecuaci�n de segundo grado NO tiene soluci�n.

		return sol_valida;
	}
	
	/**
	 * M�todo 'resultado()'
	 * devuelve un vector con las dos posibles soluciones  de la ecuaci�n de segundo grado.
	 * En caso de no haber soluci�n se mostrar� un mensaje de error por consola.
	 * 
	 * @return 'double[]' con las dos posibles soluciones de la ecuaci�n de segundo grado en las posiciones [0] y [1].
	 */
	public double[] resultado() {
		
		double x[] = new double[2];  // Vector que almacenar� los dos valores de la ecuaci�n de segundo grado: x1 y x2
		
		if (!solucionValida())
			System.out.println("La ecuci�n de segundo grado no tiene soluci�n.");
		
		x[0] = (-this.b + Math.sqrt( delta() )) / 2*this.a; // Valor de x1
		x[1] = (-this.b - Math.sqrt( delta() )) / 2*this.a; // Valor de x2
		
		return x;
	}
	
}
