package SorteoMultibombo;
import java.util.ArrayList;
import java.util.EmptyStackException;

import MetodosGenerales.Calculos;

/**
 * Clase Bombo
 * crea objetos que representan bombos con capacidad para un determinado número de bolas y métodos que permite preparar las bolas
 * que habrán dentro y fuera del bombo así como interactuar con el bombo con acciones como extraer bola, remover, etc.
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 19/02/2015
 * @since 09/01/2015
 *
 */
public class Bombo {

	//PROPIEDADES
	private int nbolas;
	private int primerabola; // Índice que me indicará desde qué bola quiero empezar a crear objetos bolas con el método 'añadirBolas()'.
	private ArrayList<Bola> bolas_dentro_bombo;
	private ArrayList<Bola> bolas_fuera_bombo;
	
	//CONSTRUCTORES
	
	/**
	 * Crea un objeto bombo vacío, pero con capacidad para indicarle qué número de bolas podrá contener en el futuro.
	 */
	public Bombo() {
		this.nbolas=0;
		
		this.primerabola=0;
		this.bolas_fuera_bombo=new ArrayList<Bola>();
		this.bolas_dentro_bombo=new ArrayList<Bola>();
	}
	
	/**
	 * Crea un objeto bombo con capacidad para 'nbolas'.
	 * @param nbolas
	 */
	public Bombo(int nbolas) {
		this();
		this.nbolas=nbolas;
	}
	
	/**
	 * Crea un objeto bombo con capacidad para 'nbolas'. Éstas bolas están encaminadas a tener valores númericos y 'primera_bola',
	 * indica el valor a partir del que se empezarán a preparar las bolas.
	 * @param nbolas
	 * @param primera_bola
	 */
	public Bombo(int nbolas, int primera_bola) {
		this(nbolas);
		this.primerabola=primera_bola;
	}
	
	/**
	 * Constructor de copia. Copia un objeto bombo, considerando las propiedades 'nbolas', 'bolas_fuera_bombo' y 'bolas_dentro_bombo'.
	 * @param bola_a_copiar
	 */
	public Bombo(Bombo bola_a_copiar) {
		this.nbolas=bola_a_copiar.getNbolas();
		this.bolas_fuera_bombo=new ArrayList<Bola>();  // Aún sabiendo el número de bolas, inicializo las bolas fuera y dentro del bombo a 0.
		this.bolas_dentro_bombo=new ArrayList<Bola>(); // Cuando se ejecute el método privado 'bolasListas()', 'existirán' las bolas en estos ArrayList.
	}

	//METODOS
	
	//GETTERS Y SETTERS:
	/**
	 * @return número de bolas que se prepararán para este objeto bombo.
	 */
	public int getNbolas() {
		return nbolas;
	}
	/**
	 * Permite modificar el número de bolas que se prepararán para este objeto bombo.
	 * @param nbolas
	 */
	public void setNbolas(int nbolas) {
		this.nbolas = nbolas;
	}
	/**
	 * @return el primer valor a partir del cual se empezarán a crear bolas con el método generarBolas().
	 * @see generarBolas();
	 */
	public int getPrimerabola() {
		return primerabola;
	}
	/**
	 * Permite modificar el primer valor a partir del cual se empezarán a crear bolas con el método generarBolas().
	 * @param primerabola
	 * @see generarBolas();
	 */
	public void setPrimerabola(int primerabola) {
		this.primerabola = primerabola;
	}

	//MÉTODOS PRIVADOS
	
	/**
	 * Devuleve un error en proceso de ejecución con mensaje en el caso de que no hayan bolas preparadas para meter en el bombo.
	 * Este método se utiliza en los siguientes métodos:
	 * @see generarBolas();
	 * @see añadirExtraidas();
	 */
	private void hayBolasListas(){
		if (this.nbolas==0) {
			System.err.println("¡No hay bolas preparadas para meter en el bombo!");
			throw new EmptyStackException(); // Error en proceso de ejecución si al ejecutar este método no hay bolas preparadas para meter dentro del bombo.
		}		
	}
	
	/**
	 * Devuleve un error en proceso de ejecución con mensaje en el caso de que no hayan bolas dentro del bombo.
	 * Este método se utiliza en el siguientes método:
	 * @see extraerBola() ;
	 */
	private void hayBolasEnBombo(){
		if (this.bolas_dentro_bombo.isEmpty()) {
			System.err.println("¡No hay bolas dentro del bombo!");
			throw new EmptyStackException(); // Error en proceso de ejecución si al ejecutar este método no hay bolas dentro del bombo.
		}		
	}

	//MÉTODOS PÚBLICOS
	/**
	 * Método para generar tantas bolas (con valor numérico) como 'nbolas' fuera del bombo, ordenadas de menor a mayor, empezando por el valor de la primerabola.
	 */
	public void generarBolas() {
		this.hayBolasListas();
		Bola bola_nueva;
		for (int i=0, j=primerabola; i<nbolas; i++, j++) {	// Utilizo 'i' para iterar y 'j' para indicar el valor de la bola iterada.		
			bola_nueva = new Bola(j);   // Creo la bola con nombre igual al índice de la iteración
			this.bolas_fuera_bombo.add(bola_nueva); // Copio en cada posición del ArrayList la referencia de cada objeto bola creado.
		}
	}
	
	/**
	 * Añade dentro del bombo todas las bolas que existan fuera del bombo.
	 */
	public void añadirExtraidas() {
		this.hayBolasListas();
		int nbolas_preparadas = bolas_fuera_bombo.size();
		for (int i=0; i<nbolas_preparadas; i++) {
			this.bolas_dentro_bombo.add(this.bolas_fuera_bombo.get(0)); // Añado de una en una y en orden las bolas de fuera del bombo.
			this.bolas_fuera_bombo.remove(0); // La misma bola que he metido en el bombo deja de existir fuera del bombo.
		}
	}
	
	/**
	 * Incluye en la lista de bolas fuera del bombo, bolas creadas y almacenadas en un el vector 'bolas_personalizadas'.
	 * @param bolas_personalizadas
	 */
	public void incluirPersonalizadas(Bola ... bolas_personalizadas) { // Genero tantas bolas como 'Bolas' personalizadas almacenadas en un vector.
		Bola bola_nueva;
		for (int i=0; i<nbolas; i++) {
			bola_nueva = new Bola(bolas_personalizadas[i]);         // Copio la referencia de la bola iterada en el array de bolas importado
			this.bolas_fuera_bombo.add(bola_nueva); // Copio en cada posición del ArrayList la referencia de cada objeto bola copiado.
		}
	}
	
	/**
	 * Desordena el orden de las bolas dentro del objeto bombo.
	 * El bombo se podrá 'remover' incluso cuando esté vacío.
	 */
	public void remover() {
		Bola aux;
		int random=0;
		int nbolasbombo = bolas_dentro_bombo.size();
		for (int i=0; i<nbolasbombo; i++) {                                 // Intercambio cada una de las posiciones aleatoriamente con otra.
			random=Calculos.numAleatorio(0, bolas_dentro_bombo.size()-1);   // En cada iteración genero un número aleatorio entre 0 y el número de bolas dentro del bombo.
			aux = new Bola(bolas_dentro_bombo.get(random));                 // Copio la referencia de una de las bolas dentro del bombo aleatoriamente.
			bolas_dentro_bombo.remove(random);                              // Borro la posición original con esa referencia
			bolas_dentro_bombo.add(i, aux);                                 // Añado esa referencia en la posición correspondiente a la iteración.			
		}
	}
	
	/**
	 * Extrae la primera bola de la lista de bolas que están dentro del bombo, devuelve su valor y añade la bola a la lista de bolas fuera del bombo.
	 * @return el valor de la bola extraida.
	 */
	public Bola extraerBola() {
		this.hayBolasEnBombo();
		Bola bola_extraida=new Bola(bolas_dentro_bombo.get(0));
		bolas_dentro_bombo.remove(0);
		bolas_fuera_bombo.add(bola_extraida);
		
		return bola_extraida;
	}
	
	/**
	 * Vacía el bombo y añade todas las bolas extraídas a la lista de bolas extraídas (fuera del bombo).
	 */
	public void vaciar() {
		int nbolas_bombo = bolas_dentro_bombo.size();
		for (int i=0; i<nbolas_bombo; i++) {
			this.bolas_fuera_bombo.add(this.bolas_dentro_bombo.get(0)); // Saco una a una las bolas del bombo para vaciarlo.
			this.bolas_dentro_bombo.remove(0); // La misma bola que he sacado del bombo deja de existir dentro de este.
		}
	}
	
	/**
	 * Elimina completamente las bolas que hay tanto fuera como dentro del bombo.
	 */
	public void destruirBolas() {
		this.bolas_fuera_bombo.clear();
		this.bolas_dentro_bombo.clear();
	}
	
	/**
	 * Elimina completamente las bolas que hay tanto fuera como dentro del bombo, después genera 'nbolas' con valores numéricos y las almacena
	 * dentro del bombo.
	 */
	public void reiniciarBombo() {
		this.destruirBolas();       // Si el bombo tuviese bolas tanto dentro como fuera, estas serán destruídas.
		this.generarBolas();        // Ejecuto el método 'generarBolas()' para preparar las 'nbolas' que voy a meter en el bombo.
		this.añadirExtraidas();     // Añado todas las bolas que he generado en el método anterior.
	}
	
		
	/**
	 * @return una cadena con el número de bolas dentro y fuera del bombo con el siguiente formato: 
	 * <p>"Bolas fuera del bombo: [x, x, x, ..., N]"</p>
	 * <p>"Bolas dentro del bombo: [x, x, x, ..., N]"</p>
	 */
	@Override
	public String toString() {
		return "Bolas fuera del bombo: " + this.bolas_fuera_bombo.toString() + "\n" + "Bolas dentro del bombo: " + this.bolas_dentro_bombo.toString();
	}
}
