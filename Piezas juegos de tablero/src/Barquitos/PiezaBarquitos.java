package Barquitos;

import Tablero.ColorPieza;
import Tablero.PiezaTablero;
import Tablero.PosicionNoValidaException;
import Tablero.TipoPieza;

/**
 * Objeto 'PiezaBarquitos' que hereda de 'PiezaAjedrez', que a su vez hereda de 'PiezaTablero'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public class PiezaBarquitos extends PiezaTablero{
	
	//CONSTRUCTORES
	
	/**
	 * Constructor por defecto que construye un objeto 'PiezaBarquitos' en la posición (4,4) de color BLANCO.
	 */
	public PiezaBarquitos() {
		super();
		this.tipo_pieza=TipoPieza.BARQUITOS;
	}
	
	/**
	 * Constructor de objeto 'PiezaBarquitos' en la posición (x,y) y color que se indiquen en los parámetros.
	 * @param pos_x
	 * @param pos_y
	 * @param color
	 * @throws PosicionNoValidaException
	 */
	public PiezaBarquitos(int pos_x, int pos_y, ColorPieza color) throws PosicionNoValidaException {
		this.setPos_x(pos_x);
		this.setPos_y(pos_y);
		this.color=color;
		this.tipo_pieza=TipoPieza.BARQUITOS;
	}

	//MÉTODOS
	/**
	 * Método feo que da igual lo que metas en los parámetros. Va a devolver un String indicando que la pieza barquito
	 * no se puede mover. Me habría ahorrado este método y otros tantos si no me hubiese propuesto a seguir las
	 * indicaciones del ejercicio de crear una interface movible sólo para damas y fichas de ajedrez, ya que luego en el
	 * menú podría haber simplificado mucho más con un método estático para todas las opciones, como el realizado en 
	 * 'AccionesPiezaAjedrez'.
	 * @param x
	 * @param y
	 * @return
	 */
	public String moverA(int x, int y) { 

		return ("ERROR. La pieza de " + this.tipo_pieza + " [(" + this.pos_x + "," + this.pos_y + "), " + this.color + "] "
					+ "es una pieza NO movible.");
		
	}
}
