package Tablero;

/**
 * Interface 'Movible' con dos métodos: 'esMovibleA' y 'moverA'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public interface Movible {

	/**
	 * Este método indicará si es posible mover la pieza a las coordenadas que se le indican.
	 * @param x
	 * @param y
	 * @return true: es posible mover la pieza; false: no es posible. 
	 */
	public boolean esMovibleA(int x, int y);
	
	/**
	 * Este método moverá (si es posible) la pieza a las coordenadas que se le indican. Si no le es posible, 
	 * lanzará una excepción de tipo 'IllegalArgumentException'.
	 * @param x
	 * @param y
	 * @throws PosicionNoValidaException
	 */
	public String moverA(int x, int y) throws PosicionNoValidaException;
	
}
