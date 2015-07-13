package Damas;

import Tablero.ColorPieza;
import Tablero.Movible;
import Tablero.PiezaTablero;
import Tablero.PosicionNoValidaException;
import Tablero.TipoPieza;

/**
 * Objeto 'PiezaDamas' que hereda de 'PiezaTablero'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public class PiezaDamas extends PiezaTablero implements Movible{

	//PROPIEDADES
	private boolean dama; // No la voy a utilizar por ahora, pero en posible futura mejora sí.
	
	//CONSTRUCTORES
	
	/**
	 * Constructor por defecto que construye un objeto 'PiezaDamas' en la posición (4,4) de color BLANCO.
	 */
	public PiezaDamas() {
		super();
		this.tipo_pieza=TipoPieza.DAMAS;
	}
	
	/**
	 * Constructor de objeto 'PiezaDamas' en la posición (x,y) y color que se indiquen en los parámetros.
	 * @param pos_x
	 * @param pos_y
	 * @param color
	 * @throws PosicionNoValidaException
	 */
	public PiezaDamas(int pos_x, int pos_y, ColorPieza color) throws PosicionNoValidaException {
		this.setPos_x(pos_x);
		this.setPos_y(pos_y);
		this.color=color;
		this.tipo_pieza=TipoPieza.DAMAS;
	}
	
	//METODOS
		
	@Override
	public boolean esMovibleA(int x, int y) {
		boolean es_movible=false;
		if (this.pos_x>0 && this.pos_y>0 && this.pos_x<=8 && this.pos_y<=8)
			// La ficha está dentro del tablero, por lo que se puede mover.
			if ((y-this.pos_y==1 && x-this.pos_x==1) || (y-this.pos_y==1 && x-this.pos_x==-1))
				// La ficha realiza un movimiento correcto (una casilla hacia adelante o hacia los diagonales de adelante)
				if (this.pos_x+(x-this.pos_x)>0 && this.pos_y+1>0 && this.pos_x+(x-this.pos_x)<=8 && this.pos_y+1<=8)
					//Al moverse la ficha de damas, no se sale del tablero
					es_movible=true;
		return es_movible;
	}

	@Override
	public String moverA(int x, int y) throws PosicionNoValidaException { // Este throw no hace falta ponerlo aquí, ya que se hereda del método abstracto.
		if (esMovibleA(x,y)==false) {
			throw new PosicionNoValidaException("La pieza de " + this.tipo_pieza + " [(" + this.pos_x + "," + this.pos_y + "), " + this.color + "] "
					+ "no se puede mover a la posición (" + x + "," + y + ") desde (" + this.pos_x + "," + this.pos_y + ").");
		}
		else {
			this.pos_x=x;
			this.pos_y=y;
		}
		return "La pieza de " + this.tipo_pieza + " [(" + this.pos_x + "," + this.pos_y + "), " + this.color + "] movida.";
	}

}
