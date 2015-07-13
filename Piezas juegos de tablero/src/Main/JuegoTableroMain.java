package Main;

import Tablero.*;
import Ajedrez.*;
import Barquitos.PiezaBarquitos;
import Damas.PiezaDamas;
import MetodosEstaticos.AccionesPiezaAjedrez;
import MetodosEstaticos.Preguntar;

/**
 * Clase principal de del ejercicio 'Piezas de juegos de tablero'.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/04/2015
 * @since 19/03/2015
 */
public class JuegoTableroMain {

	public static void main(String[] args) throws PosicionNoValidaException {

		int x; // Nueva coordenada x.
		int y; // Nueva coordenada y.
		int opcion_menu; // Opciones posibles para el menú.
		boolean salir; // Pregunta para continuar de sí o no.
		
		// Creación cada una de las piezas de juegos de tablero que voy a utilizar en el ejercicio:
		PiezaBarquitos barco = new PiezaBarquitos();
		PiezaDamas dama = new PiezaDamas();
		Peon peon = new Peon();
		Torre torre = new Torre();
		Caballo caballo = new Caballo();
		Alfil alfil = new Alfil();
		Rey rey = new Rey();
		Reina reina = new Reina();
		
		//Menú del programa
		do {
			salir=false;
			opcion_menu=Integer.parseInt((Preguntar.opciones(
				"TRABAJO CON PIEZAS DE JUEGOS DE TABLERO.\n"
			  + "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"
			  + "Introduzca un número de pieza para mover, introduciendo el número y presionando intro:\n"
			  + "  1.- PiezaBarquitos [("+barco.getPos_x()+","+barco.getPos_y()+"), BLANCO]\n"
			  + "  2.- PiezaDamas [("+dama.getPos_x()+","+dama.getPos_y()+"), BLANCO]\n"
			  + "  3.- Peon [("+peon.getPos_x()+","+peon.getPos_y()+"), BLANCO]\n"
			  + "  4.- Torre [("+torre.getPos_x()+","+torre.getPos_y()+"), BLANCO]\n"
			  + "  5.- Alfil [("+alfil.getPos_x()+","+alfil.getPos_y()+"), BLANCO]\n"
			  + "  6.- Caballo [("+caballo.getPos_x()+","+caballo.getPos_y()+"), BLANCO]\n"
			  + "  7.- Reina [("+reina.getPos_x()+","+reina.getPos_y()+"), BLANCO]\n"
			  + "  8.- Rey [("+rey.getPos_x()+","+rey.getPos_y()+"), BLANCO]\n\n"
			  + "  0.- Salir del programa.\n", "1,2,3,4,5,6,7,8,0")));
			
			//Mover barquito
			if (opcion_menu==1) {
				do {
					//Nueva coordenada para 'x'
					x=Integer.parseInt((Preguntar.opciones("Nueva coordenada X para la pieza. Introduce un valor entero del 1 al 8","1,2,3,4,5,6,7,8")));
					//Nueva coordenada para 'y'
					y=Integer.parseInt((Preguntar.opciones("Nueva coordenada Y para la pieza. Introduce un valor entero del 1 al 8","1,2,3,4,5,6,7,8")));
					//Método mover
					System.out.println(barco.moverA(x, y));
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover dama
			if (opcion_menu==2) {
				do {
					//Nueva coordenada para 'x'
					x=Integer.parseInt((Preguntar.opciones("Nueva coordenada X para la pieza. Introduce un valor entero del 1 al 8","1,2,3,4,5,6,7,8")));
					//Nueva coordenada para 'y'
					y=Integer.parseInt((Preguntar.opciones("Nueva coordenada Y para la pieza. Introduce un valor entero del 1 al 8","1,2,3,4,5,6,7,8")));
					if (dama.esMovibleA(x, y))
						System.out.println(dama.moverA(x, y));
					else
						System.out.println("La pieza de " + dama.getTipo_pieza() + " [(" + dama.getPos_x() + "," + dama.getPos_y() + "), " + dama.getColor() 
								+ "] no se puede mover a la posición (" + x + "," + y + ") desde (" + dama.getPos_x() + "," + dama.getPos_y() + ").");
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover peón
			if (opcion_menu==3) {
				do {
					AccionesPiezaAjedrez.preguntar(peon);
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover torre
			if (opcion_menu==4) {
				do {
					AccionesPiezaAjedrez.preguntar(torre);
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover alfil
			if (opcion_menu==5) {
				do {
					AccionesPiezaAjedrez.preguntar(alfil);
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover caballo
			if (opcion_menu==6) {
				do {
					AccionesPiezaAjedrez.preguntar(caballo);
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover reina
			if (opcion_menu==7) {
				do {
					AccionesPiezaAjedrez.preguntar(reina);
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
			//Mover rey
			if (opcion_menu==8) {
				do {
					AccionesPiezaAjedrez.preguntar(rey);
					if (Preguntar.siNo("¿Deseas realizar otra operación? s/n").equalsIgnoreCase("n"))
						salir=true;				
				}while(salir==false);
			}
			
		}while(opcion_menu!=0); // Salir del programa si se ha presionado 0.
		
		System.out.println("¡Gracias por utilizar el programa!\n"
				+ "Javier Latorre - jlalovi@gmail.com");
		
	}

}
