import java.util.Scanner;

public class Comprobar_CB {

	public static void main(String[] args) {
		// Testeo:
		
		String cb = cbCorrecta();
		
		System.out.println(cb);

	}
	

/*
 * M�TODO cbCorrecta():
   � Este m�todo no necesita par�metros. Desencadenar� una serie de procesos que imprimir� por pantalla los errores de la Cuenta Bancaria introducida,
     hasta introducir una correcta, que ser� la que devolver� el m�todo.

*/
	private static String cbCorrecta() {
		
	 // DELARACI�N DE VARIABLES
	 // =======================

		String CB;            // Cuenta Bancaria introducida por el usuario.
		int longitudCB;       // Longitud de la Cuenta Bancaria.
		boolean CBcorrecta;   // Cuenta Bancaria correcta (V o F).
		int sumatorio;        // Acumulador que me permitir� hacer operaciones para comprobar los d�gitos de control.
		int modulo11;         // Otra variable que me permitir� hacer operaciones para comprobar los d�gitos de control.
		int i;				  // Variable de iteraci�n que me servir� en varios bucles.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicializaci�n de datos:
		longitudCB = 20;     // La longitud de la Cuenta Bancaria tiene que ser de 20 d�gitos.
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nIntroduce n�mero de Cuenta Bancaria:");
		CB = entrada.nextLine().trim();  // Leo la cuenta bancaria.

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		do { // Este bucle engloba pr�cticamente todo el algoritmo.
			
			CBcorrecta = true;   // Presupondr� que Cuenta Bancaria que se introducir� es verdadera desde el principio del bucle.

			// N�mero de d�gitos es 20 (1� Comprobaci�n):
			if (CB.length()!=longitudCB) {
				System.out.println("Una cuenta bancaria posee 20 d�gitos:");
				System.out.println("4 en Entidad, 4 en Sucursal, 2 de Control y 10 del n�mero de cuenta.");
				System.out.println("Por favor, introduce los d�gitos en este orden, sin puntos, guiones ni separaciones de ning�n tipo.");
				CBcorrecta = false;
			}
			
			// Cuenta Bancaria compuesta por n�meros (2� Comprobaci�n):
			if (CBcorrecta) {
				for (i=0; i<=longitudCB-1; i++) {			
					if (Integer.valueOf(CB.charAt(i))<48  || Integer.valueOf(CB.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
						CBcorrecta = false;
						System.out.printf("El car�cter %s NO es un n�mero\n", CB.charAt(i));
					}
				}
			}
			
			// Primer D�gito de Control (3� Comprobaci�n):
			if (CBcorrecta) {
				// El primer d�gito de control depende de los 8 primeros d�gitos (Entidad y Sucursal), con los que operar� a continuaci�n.
				// Recordar que los 'castings' me devuelven el valor en ASCII. Resto 48 para obtener el valor num�rico correspondiente al car�cter.
				// Las operaciones dependen de cada d�gito, su sumatorio y unas reglas con el m�dulo11 (http://www.grupoalquerque.es/ferias/2012/archivos/digitos/codigo_cuenta_corriente.pdf)
				sumatorio  = (int)(CB.charAt(0)-48) * 4;
				sumatorio += (int)(CB.charAt(1)-48) * 8;
				sumatorio += (int)(CB.charAt(2)-48) * 5;
				sumatorio += (int)(CB.charAt(3)-48) * 10;
				sumatorio += (int)(CB.charAt(4)-48) * 9;
				sumatorio += (int)(CB.charAt(5)-48) * 7;
				sumatorio += (int)(CB.charAt(6)-48) * 3;
				sumatorio += (int)(CB.charAt(7)-48) * 6;
				
				modulo11 = sumatorio%11;
				if (modulo11==1)
					modulo11=10;
				
				if ((int)(CB.charAt(8)-48)!=11-modulo11) {  // Primer d�gito de control es la posici�n 8.
					CBcorrecta = false;
					System.out.println("El primer d�gito de control es incorrecto. Esto quiere decir que");
					System.out.println("alguno de los datos introducidos en Entidad y/o Sucursal son err�neos.");
				}
				
			}
			
			// Segundo D�gito de Control (4� Comprobaci�n):
			if (CBcorrecta) {
				// El primer d�gito de control depende de los 8 primeros d�gitos (Entidad y Sucursal), con los que operar� a continuaci�n.
				// Recordar que los 'castings' me devuelven el valor en ASCII. Resto 48 para obtener el valor num�rico correspondiente al car�cter.
				// Las operaciones dependen de cada d�gito, su sumatorio y unas reglas con el m�dulo11 (http://www.grupoalquerque.es/ferias/2012/archivos/digitos/codigo_cuenta_corriente.pdf)
				sumatorio  = (int)(CB.charAt(10)-48) * 1;
				sumatorio += (int)(CB.charAt(11)-48) * 2;
				sumatorio += (int)(CB.charAt(12)-48) * 4;
				sumatorio += (int)(CB.charAt(13)-48) * 8;
				sumatorio += (int)(CB.charAt(14)-48) * 5;
				sumatorio += (int)(CB.charAt(15)-48) * 10;
				sumatorio += (int)(CB.charAt(16)-48) * 9;
				sumatorio += (int)(CB.charAt(17)-48) * 7;
				sumatorio += (int)(CB.charAt(18)-48) * 3;
				sumatorio += (int)(CB.charAt(19)-48) * 6;
				
				modulo11 = sumatorio%11;
				if (modulo11==1)
					modulo11=10;
				
				if ((int)(CB.charAt(9)-48)!=11-modulo11) {  // Segundo d�gito de control es la posici�n 9.
					CBcorrecta = false;
					System.out.println("El segundo d�gito de control es incorrecto. Esto quiere decir que");
					System.out.println("alguno de los datos introducidos en el N�mero de Cuenta son err�neos.");
				}
				
			}
			
			if (CBcorrecta==false) {
				System.out.println("\nIntroduce otra vez el n�mero de Cuenta Bancaria:");
				CB = entrada.nextLine().trim();  // Si la CB no ha superado alguna de las comprobaciones, leo de nuevo la cuenta bancaria y reinicio el bucle en la siguiente sentencia.
			}
			
		} while (CBcorrecta==false); // Si la CB no ha superado alguna de las comprobaciones, se reinicia el bucle.
		

	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		return CB;
		
	}
	
/*
 * FIN M�TODO cbCorrecta();
 */
}
