package SorteoMultibombo;

import MetodosGenerales.Preguntar;

/**
 * Clase principal de del ejercicio SorteoMultibombo.
 * 
 * Al final del ejercicio se pueden ver comentadas varias líneas que he ido utilizando para tetear las clases que conciernen al ejercicio.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 19/02/2015
 */
public class MainBomboLoteria {

	public static void main(String[] args) {
		
		//DECLARACIÓN DE VARIABLES
		
		int opcion_menu;
		int opcion_comprar_decimos;
		boolean sorteo_realizado;
		boolean mas_de_10;          // Booleano para comprobar que NO se compran más de 10 boletos de un mismo número y reintegro.
		Decimo nuevo_decimo;
		int numero_decimos;

		//PROGRAMA
		
		sorteo_realizado=false;
		SorteoMultibombo sorteo = new SorteoMultibombo(); // Creo el objeto sorteo de 'SorteoMultibombo'. Para iniciar un nuevo sorteo se tendrá que reiniciar el programa.
		
		do {
		
			opcion_menu=Integer.parseInt(Preguntar.opciones("\nElige una de las siguientes opciones: "
											+ "\n   1. Comprar décimos (10€ por décimo)."
											+ "\n   2. Realizar sorteo."
											+ "\n   3. Comprobar décimos."
											+ "\n   4. Salir.", "1,2,3,4"));
		
			//COMPRAR DÉCIMOS
			//===============
			if (opcion_menu==1) {
				do {
					if (sorteo_realizado) {
						System.out.println("\n¡No puedes comprar décimos! ¡El sorteo ya ha sido realizado!");
						opcion_comprar_decimos=3;
					}
					else {
						opcion_comprar_decimos=Integer.parseInt(Preguntar.opciones("\nElige una de las siguientes opciones: "
																+ "\n1. Comprar décimos rellenados manualmente."
																+ "\n2. Comprar décimos rellenados aleatoriamente."
																+ "\n3. Volver a menú principal.", "1,2,3"));
					}
					//COMPRAR DÉCIMOS MANUALMENTE
					//===========================
					if(opcion_comprar_decimos==1) {
						int[] nuevo_decimo_aux = new int[6]; // Creo un vector normal con los números que contendrá el décimo para luego pasarlo al constructor Decimo.
						mas_de_10 = false; 
						do {
							for (int i=0; i<6; i++) {
								if (i!=5) {
									System.out.println("Número " + (i+1) + ":");
									nuevo_decimo_aux[i]=Integer.parseInt(Preguntar.opciones("Introduce un número del 0 al 9", "1,2,3,4,5,6,7,8,9,0"));
								}
								else {
									System.out.println("Reintegro:");
									nuevo_decimo_aux[i]=Integer.parseInt(Preguntar.opciones("Introduce un número del 0 al 9", "1,2,3,4,5,6,7,8,9,0"));
								}
							}
							nuevo_decimo = new Decimo(5,1);
							nuevo_decimo.rellenar(nuevo_decimo_aux); // Indico el valor del objeto Decimo a partir del vector de números rellenado por el usuario.
							numero_decimos=Integer.parseInt(Preguntar.opciones("¿Cuantos décimos del número elegido desea comprar? (de 1 a 10).", "1,2,3,4,5,6,7,8,9,10"));
							int contador=0;
							for (int i=0; i<sorteo.getDecimos_comprados().size(); i++) {								
								if (sorteo.getDecimos_comprados().get(i).equals(nuevo_decimo)) // Por cada vez que el décimo completo se repita, aumento el contador.
									contador++;
							}
							if (numero_decimos+contador>10) { // Evidentemente, si el número de décimos comprados excede en 10, obligo a repetir la operación.
								mas_de_10=true;
								System.out.printf("\n¡Sólo puedes comprar 10 décimos! ¡De ahí que se llamen 'décimos'!\n "
										+ "Ya has comprado anteriormente %d décimos y has elegido comprar %d décimos del mismo número y reintegro.\n"
										+ "Sino se te dan mal las matemáticas, sabrás que no puedes comprar más de %d décimos con esos valores. "
										+ "Introduce de nuevo los números:\n", contador, numero_decimos, 10-contador);
							}
						}while(mas_de_10);
						
						for (int i=0; i<numero_decimos; i++) { // Si todo ha ido bien en las comprobaciones anteriores, compro los décimos y los almaceno.
							sorteo.comprarDecimo(nuevo_decimo);
						}
						System.out.printf("\nEl número comprado de décimos es %d y tienen el siguiente valor:\n", numero_decimos);
						System.out.println(nuevo_decimo);
					}
					//COMPRAR DÉCIMOS ALEATORIAMENTE
					//==============================
					if(opcion_comprar_decimos==2) {
						String si_no="s";						
						while (si_no.equalsIgnoreCase("s")){
							mas_de_10 = false; 
							do {
								nuevo_decimo = new Decimo(5,1);
								nuevo_decimo.aleatorio(); // Relleno aleatoriamente un décimo y paso a comprobar cuántas veces se ha comprado ese décimo.								
								int contador=0;
								for (int i=0; i<sorteo.getDecimos_comprados().size(); i++) {								
									if (sorteo.getDecimos_comprados().get(i).equals(nuevo_decimo)) // Por cada vez que el décimo completo se repita, aumento el contador.
										contador++;
								}
								if (contador==10)  // Si el décimo se ha comprado 10 veces (el máximo), genero un décimo nuevo.
									mas_de_10=true;
							}while(mas_de_10);
							
							sorteo.comprarDecimo(nuevo_decimo); // Si todo ha ido bien en las comprobaciones anteriores, compro el décimo y lo almaceno.
							
							System.out.println("\nEl décimo comprado ha sido:");
							System.out.println(nuevo_decimo);
							
							si_no=Preguntar.siNo("¿Deseas comprar otro décimo al azar? s/n");	
						}
					}
				}while(opcion_comprar_decimos!=3);
			}
			
			//REALIZAR SORTEO
			//===============
			if (opcion_menu==2) {
				if (sorteo_realizado) {
					System.out.println("\n¡El sorteo ya ha sido realizado! Para realizar un nuevo sorteo, sal del programa y reinicialo.");
				}
				else {
					
					System.out.println("\nLos décimos preimiados son (primer, segundo y tercer premios, siendo el reintegro igual para todos):");
					System.out.println(sorteo.realizarSorteo());					
					sorteo_realizado=true; // Ya se ha realizado el sorteo.
				}
				
			}
			
			//COMPROBAR DECIMOS COMPRADOS
			//===========================
			if (opcion_menu==3) {
				if (sorteo_realizado==false) {
					System.out.println("\n¡El sorteo todavía no ha sido realizado! ¡Pulsa la opción 2 para realizar el sorteo antes!");
				}
				else {
					System.out.println("\nDecimos comprados:");
					System.out.println(sorteo.getDecimos_comprados());
					int[] gastado_ganado = sorteo.comprobarPremios();
					System.out.printf("\nHas comprado un total de %d décimos, que equivale a %d€ gastados.\n"
										+ "Has ganado un total de %d€ en premios, haciendo eso un total de %d€ ganados.\n"
										+ "", gastado_ganado[0]/10, gastado_ganado[0], gastado_ganado[1], gastado_ganado[1]-gastado_ganado[0]);
				}
			}
			
		}while(opcion_menu!=4);
		
		System.out.println("\n¡Gracias por utilizar el programa!");
		
		// =======================================================================================
		
		// TESTEO DE LAS CLASES

//		Bombo bombo1 = new Bombo(10);
//		bombo1.toString();
//		
//		System.out.println("Añadir bolas");
//		bombo1.reiniciarBombo();
//		System.out.println(bombo1+"\n");
//		
//		bombo1.remover(); // Prueba de método remover
//		System.out.println("Prueba método remover");
//		System.out.println(bombo1+"\n");
//		
//		
//		System.out.println("Método extraer");
//		bombo1.extraerBola();
//		System.out.println(bombo1+"\n");
//		
//		System.out.println("Método vaciar");
//		bombo1.vaciar();
//		System.out.println(bombo1+"\n");
		
//		System.out.println("Método extraer");
//		bombo1.extraerBola();
//		System.out.println(bombo1+"\n");
		
//		SorteoMultibombo sorteo1 = new SorteoMultibombo();
//		
//		System.out.println("Prueba SorteoMultibombo");
//		sorteo1.decimosPremiados();
//		System.out.println(sorteo1);

		
//		Decimo decimo1 = new Decimo(6,3);
//		
//		System.out.println("Prueba Decimo");
//		decimo1.rellenar(1,2,3,4,5,6,8,9,0);
//		System.out.println(decimo1);
//		
//		Decimo decimo2 = new Decimo(6,3);
//		
//		System.out.println("Prueba Decimo");
//		decimo2.rellenar(1,2,3,4,5,6,8,9,0);
//		System.out.println(decimo2);
//		
//		System.out.println(decimo1.equalsReintegro(decimo2));
		
//		Sorteo sorteox = new Sorteo(6);
//		
//		System.out.println("Prueba Sorteo");
//		System.out.println(sorteox);		

	}

}
