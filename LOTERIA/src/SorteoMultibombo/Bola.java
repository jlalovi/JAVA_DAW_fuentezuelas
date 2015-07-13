package SorteoMultibombo;

/**
 * Clase Bola
 * crea objetos que representan bolas con un valor como etiqueta.
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 19/02/2015
 * @since 09/01/2015
 *
 */
public class Bola {

	//PROPIEDADES:
	
	private String valor;
	
	//CONSTRUCTORES:
	
	/**
	 * Crea un objeto bola con un valor nulo para representar una bola plana, sin valor escrito sobre ella.
	 */
	public Bola() {
		this.valor=null; // Este valor no es necesario especificarlo, ya que por defecto es null.
	}
	
	/**
	 * Crea un objeto bola con un valor especificado en la lista de parámetros.
	 * Este valor puede ser numérico o no numérico.
	 * @param valor
	 */
	public Bola(String valor) {
		this.valor = valor;
	}
	
	/**
	 * Crea un objeto bola con un valor especificado en la lista de parámetros.
	 * Este valor sólo puede ser numérico de tipo entero.
	 * @param valor
	 */
	public Bola(int valor) {
		this.valor = valor + ""; // Constructor de bolas con el nombre igual al número entero que se especifíque como parámetro.
	}
	
	/**
	 * Constructor de copia, que copia el valor de una bola a otra, evidentemente teniendo en cuenta la propiedad 'valor'.
	 * @param bola_a_copiar
	 */
	public Bola(Bola bola_a_copiar) {
		this.valor=bola_a_copiar.getValor();
	}
	
	//MÉTODOS:
	//GETTERS Y SETTERS
	
	/**
	 * @return el valor de la bola (cadena de texto).
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Modifica el valor de la bola (cadena de texto).
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	/**
	 * @return el valor de la bola (cadena de texto).
	 */
	@Override
	public String toString() {
		return valor.toString();
	}
	
}
