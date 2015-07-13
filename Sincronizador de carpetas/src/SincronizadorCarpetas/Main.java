package SincronizadorCarpetas;

import java.io.IOException;
import Temporizador.Temporizador;

/**
 * Programa contenedor del método 'Sincronizar' y 'Temporizador'. Las rutas de las carpetas a sincronizar son 'ruta1' y 'ruta2'
 * en la carpeta principal del proyecto 'Sincronizador de carpetas'.
 * 
 * Una vez ejecutado el programa se iniciará un bucle infinito que terminará manualmente a través de la consola.
 * 
 * En la consola se mostrarán unos puntos que indicarán que el programa está en proceso. Por cada tres puntos '...', se
 * ejecutará de nuevo el método sincronizar de manera bidireccional (ambas rutas como origen y destino). Por cada punto,
 * existirá una pausa de un segundo para mayor legibilidad de los mensajes de archivos copiados mostrados por consola.
 * 
 * @author Javier
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		boolean bucle_infinito=true;
		
		Sincronizador sync = new Sincronizador();
		Temporizador temp = new Temporizador();
		
		System.out.println("Sincronizando carpetas a tiempo real.");
		System.out.println("Para salir, 'terminar' sesión de la consola manualmente.");
		
		while (bucle_infinito) {
			sync.sincronizar("ruta1", "ruta2");
			sync.sincronizar("ruta2", "ruta1");
			for (int i=0; i<3;i++) {
				System.out.print(".");
				// Cada 'x' milisegundos aparece un punto. Una vez aparezcan 3, se realizará otra comprobación para la sincronización
				temp.run(1000);
			}
			System.out.println("");
		}

	}

}
