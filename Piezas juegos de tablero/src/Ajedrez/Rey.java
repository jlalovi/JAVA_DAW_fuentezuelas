package Ajedrez;

import Tablero.ColorPieza;
import Tablero.PosicionNoValidaException;
import Tablero.TipoPieza;

/**
 * Objeto 'Rey' que hereda de 'PiezaAjedrez', que a su vez hereda de 'PiezaTablero'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public class Rey extends PiezaAjedrez {
	
	//CONSTRUCTORES
	
	/**
	 * Constructor por defecto que construye un objeto 'Rey' en la posición (4,4) de color BLANCO.
	 */
	public Rey() {
		super();
		this.tipo_pieza=TipoPieza.REY;
	}
	
	/**
	 * Constructor de objeto 'Reina' en la posición (x,y) y color que se indiquen en los parámetros.
	 * @param pos_x
	 * @param pos_y
	 * @param color
	 * @throws PosicionNoValidaException
	 */
	public Rey(int pos_x, int pos_y, ColorPieza color) throws PosicionNoValidaException {
		this.setPos_x(pos_x);
		this.setPos_y(pos_y);
		this.color=color;
		this.tipo_pieza=TipoPieza.REY;
	}
	
	//MÉTODO
	@Override
	public boolean esMovibleA(int x, int y) {
		boolean es_movible=false;
		if (this.pos_x>0 && this.pos_y>0 && this.pos_x<=8 && this.pos_y<=8)
			// El rey está dentro del tablero, por lo que se puede mover.
			if (x>0 && y>0 && x<=8 && y<=8)
				// Las nuevas posiciones también están dentro del tablero, por lo que se consideran correctas
				if ((Math.abs(this.pos_x-x)==1 && Math.abs(this.pos_y-y)==1) || (this.pos_x-x==0 && Math.abs(this.pos_y-y)==1) || (Math.abs(this.pos_x-x)==1 && this.pos_y-y==0))
					//El movimiento del rey es correcto
					es_movible=true;
		return es_movible;
	}
}
