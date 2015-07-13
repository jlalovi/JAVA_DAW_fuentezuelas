package Temporizador;

import java.util.TimerTask;

/**
 * Método para crear tiempos de espera a través del TimerTask de java.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 *
 */
public class Temporizador extends TimerTask{

	@Override
	/**
	 * Método para crear tiempos de espera en el proceso de ejecución. Por defecto 1 segundo de espera.
	 */
	public void run() {
		try {
            Thread.sleep(1000); // 1 segundo por defecto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}	
	/**
	 * Sobrecarga del método run() en el que se establece por parámetro el número de milisegundos que
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
