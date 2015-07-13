package Tablero;

/**
 * Clase abstracta que contiene los métodos y propiedades comunes a todos los tipos de Piezas de juego:
 * 'PiezaAjedrez', 'PiezaBarquitos' y 'PiezaDamas'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 *
 */
public abstract class PiezaTablero {
	
	//PROPIEDADES
	protected int pos_x;            // Posición en el eje de coordenadas 'X' de la pieza de tablero.
	protected int pos_y;            // Posición en el eje de coordenadas 'Y' de la pieza de tablero.
	protected ColorPieza color;     // Color de la pieza de tablero (BLANCO o NEGRO).
	protected TipoPieza tipo_pieza; // Tipo de pieza (PEON, ALFIL, CABALLO, TORRE, REY, REINA, DAMAS o BARQUITOS).
	
	//CONTRUCTOR	
	/**
	 * Establece por defecto en los hijos de 'PiezaTablero' una posición (1,1) y un color blanco.
	 */
	public PiezaTablero() {
		this.pos_x=4;
		this.pos_y=4;
		this.color=ColorPieza.BLANCO;
	}


	//MÉTODOS (getters y setters)
	/**
	 * @return posición 'x' de la pieza sobre el tablero.
	 */
	public int getPos_x() {
		return pos_x;
	}
	/**
	 * Establece posición 'x' de la pieza sobre el tablero.
	 * @param pos_x
	 */
	public void setPos_x(int pos_x) throws PosicionNoValidaException {
		if (pos_x<=0 || pos_x>8)
			throw new PosicionNoValidaException("La pieza no puede estar fuera del tablero que es de 8x8.");
		else 
			this.pos_x = pos_x;
	}
	
	/**
	 * @return posición 'y' de la pieza sobre el tablero.
	 */
	public int getPos_y() {
		return pos_y;
	}
	/**
	 * Establece posición 'y' de la pieza sobre el tablero.
	 * @param pos_x
	 */
	public void setPos_y(int pos_y) throws PosicionNoValidaException {
		if (pos_y<=0 || pos_y>8)
			throw new PosicionNoValidaException("La pieza no puede estar fuera del tablero que es de 8x8.");
		else 
			this.pos_y = pos_y;
	}

	/**
	 * @return Color de la pieza del tablero
	 */
	public ColorPieza getColor() {
		return color;
	}

	/**
	 * @return Tipo de la pieza del tablero
	 */
	public TipoPieza getTipo_pieza() {
		return tipo_pieza;
	}

	
}
