package Temporizador;

import java.util.TimerTask;

/**
 * M�todo para crear tiempos de espera a trav�s del TimerTask de java.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 *
 */
public class Temporizador extends TimerTask{

	@Override
	/**
	 * M�todo para crear tiempos de espera en el proceso de ejecuci�n. Por defecto 1 segundo de espera.
	 */
	public void run() {
		try {
            Thread.sleep(1000); // 1 segundo por defecto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}	
	/**
	 * Sobrecarga del m�todo run() en el que se establece por par�metro el n�mero de milisegundos que
	 * se quiere establecer como tiempo de espera.
	 * @param ms
	 */
	public void run(int ms) {
		try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}

}
