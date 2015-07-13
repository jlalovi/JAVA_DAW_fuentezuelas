package MetodosEstaticos;

import Tablero.PosicionNoValidaException;
import Ajedrez.PiezaAjedrez;

/**
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 *
 */
public class AccionesPiezaAjedrez {
	
	/**
	 * Método para ahorrar la repetición de esta serie de líneas para cada tipo de pieza en el main.
	 * @param pieza
	 * @throws PosicionNoValidaException
	 */
	public static void preguntar(PiezaAjedrez pieza) throws PosicionNoValidaException {
		//Nueva coordenada para 'x'
		int x=Integer.parseInt((Preguntar.opciones("Nueva coordenada X para la pieza. Introduce un valor entero del 1 al 8","1,2,3,4,5,6,7,8")));
		//Nueva coordenada para 'y'
		int y=Integer.parseInt((Preguntar.opciones("Nueva coordenada Y para la pieza. Introduce un valor entero del 1 al 8","1,2,3,4,5,6,7,8")));
		if (pieza.esMovibleA(x, y))
			System.out.println(pieza.moverA(x, y));
		else
			System.out.println("La pieza de " + pieza.getTipo_pieza() + " [(" + pieza.getPos_x() + "," + pieza.getPos_y() + "), " + pieza.getColor() 
					+ "] no se puede mover a la posición (" + x + "," + y + ") desde (" + pieza.getPos_x() + "," + pieza.getPos_y() + ").");
	}
	
}
