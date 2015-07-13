package Ajedrez;

import Tablero.Movible;
import Tablero.PiezaTablero;
import Tablero.PosicionNoValidaException;

/**
 * Esta clase cumple la funci�n de heredar de la superclase 'PiezaTablero' e implementar la interface 'Movible', modificando
 * el m�todo 'moverA' para devolver una cadena con una mensaje de actualizaci�n de movimiento de la pieza de ajedrez en caso
 * de que la comprobaci�n del m�todo 'esMovible' sea true.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public abstract class PiezaAjedrez extends PiezaTablero implements Movible{
		
	//M�TODOS
		
		@Override
		public String moverA(int x, int y) throws PosicionNoValidaException { // Este throw no hace falta ponerlo aqu�, ya que se hereda del m�todo abstracto.
			if (esMovibleA(x,y)==false) {
				throw new PosicionNoValidaException("La pieza de " + this.tipo_pieza + " [(" + this.pos_x + "," + this.pos_y + "), " + this.color + "] "
						+ "no se puede mover a la posici�n (" + x + "," + y + ") desde (" + this.pos_x + "," + this.pos_y + ").");
			}
			else {
				this.pos_x=x;
				this.pos_y=y;
			}
			return "La pieza de " + this.tipo_pieza + " [(" + this.pos_x + "," + this.pos_y + "), " + this.color + "] movida.";
		}
	
}
