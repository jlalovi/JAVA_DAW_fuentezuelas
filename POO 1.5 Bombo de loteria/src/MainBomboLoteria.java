
public class MainBomboLoteria {

	public static void main(String[] args) {
		
		// TESTEO DE LA CLASE BOMBO
		
		// Creo los 5 bombos, los cuatro primeros con la intenci�n de rellenarlos con 'x' bolas.
		Bombo b1 = new Bombo(2);
		Bombo b2 = new Bombo(7);
		Bombo b3 = new Bombo(5);
		Bombo b4 = new Bombo(9);
		Bombo b5 = new Bombo();
		
		// b5.llenar();   // Prueba de error en el proceso en ejecuci�n cuando NO hay bolas.
		
		b5.setNbolas(10); // Establezco que el bombo 5 tenga 10 bolas.
		
		// b3.extraer(); // Prueba de error en el proceso en ejecuci�n cuando NO se ha llenado el bombo.
		
		// Lleno el bombo 5	(Con este m�todo utilizo el m�todo remover(); de manera impl�cita)	
		b5.llenar();
		// Muestro el orden en el que saldr�n las bolas y voy extrayendo �stas una a una.
		System.out.println("Prueba 1. Extraigo todas las bolas de un bombo una a una.");
		System.out.println("El resultado debe de ser los n�meros del 0 al 9 sin repetirse y ordenados aleatoriamente:");
		for (int i=0; i<10; i++) {  // Si cambio 'i<10' por alg�n n�mero mayor a 10, dar� el error en proceso en ejecuci�n que se ha testeado en la l�nea 19.
			System.out.printf("%d ",b5.extraer());
		}
		
		// Prueba vector de bombos y constructor de copia:
		
		Bombo[] bombo = new Bombo[5]; // Vector de objetos 'Bombo' creado.
		
		bombo[0]= new Bombo(b1); // Uso de constructor copia en esta posici�n y las siguientes
		bombo[1]= new Bombo(b2);
		bombo[2]= new Bombo(b3);
		bombo[3]= new Bombo(b4);
		bombo[4]= new Bombo(b5);
		
		System.out.println("\n\nPrueba 2: Imprimir nbolas de cada bombo en un vector de bombos. Deben imprimirse los n�meros: \n'2 7 5 9 10'");
		for (int i=0; i<bombo.length; i++){
			System.out.printf("%d ",bombo[i].getNbolas());
		}
		
		// =========================================
		// PRUEBA DE LOTERIA NACIONAL DE LOS S�BADOS
		// =========================================
		System.out.println("\n\n=========================================");
		System.out.println("PRUEBA DE LOTER�A NACIONAL DE LOS S�BADOS");
		System.out.println("=========================================\n");
		System.out.printf("El primer premio ganador es: ");
		for (int i=0; i<bombo.length; i++){
			bombo[i].setNbolas(10);  // Cada bombo tendr� 10 bolas.
			bombo[i].llenar();       // Lleno cada uno de los bombos con esas 10 bolas.
			System.out.printf("%d ", bombo[i].extraer()); // Extraigo una bola de cada bombo y muestro su valor.
		}
		System.out.printf("\n\nEl segundo premio ganador es: ");
		for (int i=0; i<bombo.length; i++){
			bombo[i].llenar();       // Lleno cada uno de los bombos con esas 10 bolas.
			System.out.printf("%d ", bombo[i].extraer()); // Extraigo una bola de cada bombo y muestro su valor.
		}
		
	}

}
