package Ajedrez;

import Tablero.ColorPieza;
import Tablero.PosicionNoValidaException;
import Tablero.TipoPieza;

/**
 * Objeto 'Torre' que hereda de 'PiezaAjedrez', que a su vez hereda de 'PiezaTablero'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public class Torre extends PiezaAjedrez {
	
	//CONSTRUCTORES
	
	/**
	 * Constructor por defecto que construye un objeto 'Rey' en la posición (4,4) de color BLANCO.
	 */
	public Torre() {
		super();
		this.tipo_pieza=TipoPieza.TORRE;
	}
	
	/**
	 * Constructor de objeto 'Reina' en la posición (x,y) y color que se indiquen en los parámetros.
	 * @param pos_x
	 * @param pos_y
	 * @param color
	 * @throws PosicionNoValidaException
	 */
	public Torre(int pos_x, int pos_y, ColorPieza color) throws PosicionNoValidaException {
		this.setPos_x(pos_x);
		this.setPos_y(pos_y);
		this.color=color;
		this.tipo_pieza=TipoPieza.TORRE;
	}
		
	//MÉTODO
	@Override
	public boolean esMovibleA(int x, int y) {
		boolean es_movible=false;
		if (this.pos_x>0 && this.pos_y>0 && this.pos_x<=8 && this.pos_y<=8)
			// La torre está dentro del tablero, por lo que se puede mover.
			if (x>0 && y>0 && x<=8 && y<=8)
				// Las nuevas posiciones también están dentro del tablero, por lo que se consideran correctas
				if ((this.pos_x==x && this.pos_y!=y) || (this.pos_y==y && this.pos_x!=x))
					//El movimiento de la torre es correcto
					es_movible=true;
		return es_movible;
	}
}
