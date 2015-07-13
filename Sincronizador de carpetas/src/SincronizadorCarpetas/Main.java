package SincronizadorCarpetas;

import java.io.IOException;
import Temporizador.Temporizador;

/**
 * Programa contenedor del m�todo 'Sincronizar' y 'Temporizador'. Las rutas de las carpetas a sincronizar son 'ruta1' y 'ruta2'
 * en la carpeta principal del proyecto 'Sincronizador de carpetas'.
 * 
 * Una vez ejecutado el programa se iniciar� un bucle infinito que terminar� manualmente a trav�s de la consola.
 * 
 * En la consola se mostrar�n unos puntos que indicar�n que el programa est� en proceso. Por cada tres puntos '...', se
 * ejecutar� de nuevo el m�todo sincronizar de manera bidireccional (ambas rutas como origen y destino). Por cada punto,
 * existir� una pausa de un segundo para mayor legibilidad de los mensajes de archivos copiados mostrados por consola.
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
		System.out.println("Para salir, 'terminar' sesi�n de la consola manualmente.");
		
		while (bucle_infinito) {
			sync.sincronizar("ruta1", "ruta2");
			sync.sincronizar("ruta2", "ruta1");
			for (int i=0; i<3;i++) {
				System.out.print(".");
				// Cada 'x' milisegundos aparece un punto. Una vez aparezcan 3, se realizar� otra comprobaci�n para la sincronizaci�n
				temp.run(1000);
			}
			System.out.println("");
		}

	}

}
