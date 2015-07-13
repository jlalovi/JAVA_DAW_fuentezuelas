import java.util.Scanner;

public class Comprobar_CB {

	public static void main(String[] args) {
		// Testeo:
		
		String cb = cbCorrecta();
		
		System.out.println(cb);

	}
	

/*
 * MÉTODO cbCorrecta():
   · Este método no necesita parámetros. Desencadenará una serie de procesos que imprimirá por pantalla los errores de la Cuenta Bancaria introducida,
     hasta introducir una correcta, que será la que devolverá el método.

*/
	private static String cbCorrecta() {
		
	 // DELARACIÓN DE VARIABLES
	 // =======================

		String CB;            // Cuenta Bancaria introducida por el usuario.
		int longitudCB;       // Longitud de la Cuenta Bancaria.
		boolean CBcorrecta;   // Cuenta Bancaria correcta (V o F).
		int sumatorio;        // Acumulador que me permitirá hacer operaciones para comprobar los dígitos de control.
		int modulo11;         // Otra variable que me permitirá hacer operaciones para comprobar los dígitos de control.
		int i;				  // Variable de iteración que me servirá en varios bucles.

	 // ENTRADA DE DATOS (INPUT)
	 // ========================

		// Inicialización de datos:
		longitudCB = 20;     // La longitud de la Cuenta Bancaria tiene que ser de 20 dígitos.
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nIntroduce número de Cuenta Bancaria:");
		CB = entrada.nextLine().trim();  // Leo la cuenta bancaria.

	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		do { // Este bucle engloba prácticamente todo el algoritmo.
			
			CBcorrecta = true;   // Presupondré que Cuenta Bancaria que se introducirá es verdadera desde el principio del bucle.

			// Número de dígitos es 20 (1ª Comprobación):
			if (CB.length()!=longitudCB) {
				System.out.println("Una cuenta bancaria posee 20 dígitos:");
				System.out.println("4 en Entidad, 4 en Sucursal, 2 de Control y 10 del número de cuenta.");
				System.out.println("Por favor, introduce los dígitos en este orden, sin puntos, guiones ni separaciones de ningún tipo.");
				CBcorrecta = false;
			}
			
			// Cuenta Bancaria compuesta por números (2ª Comprobación):
			if (CBcorrecta) {
				for (i=0; i<=longitudCB-1; i++) {			
					if (Integer.valueOf(CB.charAt(i))<48  || Integer.valueOf(CB.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
						CBcorrecta = false;
						System.out.printf("El carácter %s NO es un número\n", CB.charAt(i));
					}
				}
			}
			
			// Primer Dígito de Control (3ª Comprobación):
			if (CBcorrecta) {
				// El primer dígito de control depende de los 8 primeros dígitos (Entidad y Sucursal), con los que operaré a continuación.
				// Recordar que los 'castings' me devuelven el valor en ASCII. Resto 48 para obtener el valor numérico correspondiente al carácter.
				// Las operaciones dependen de cada dígito, su sumatorio y unas reglas con el módulo11 (http://www.grupoalquerque.es/ferias/2012/archivos/digitos/codigo_cuenta_corriente.pdf)
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
				
				if ((int)(CB.charAt(8)-48)!=11-modulo11) {  // Primer dígito de control es la posición 8.
					CBcorrecta = false;
					System.out.println("El primer dígito de control es incorrecto. Esto quiere decir que");
					System.out.println("alguno de los datos introducidos en Entidad y/o Sucursal son erróneos.");
				}
				
			}
			
			// Segundo Dígito de Control (4ª Comprobación):
			if (CBcorrecta) {
				// El primer dígito de control depende de los 8 primeros dígitos (Entidad y Sucursal), con los que operaré a continuación.
				// Recordar que los 'castings' me devuelven el valor en ASCII. Resto 48 para obtener el valor numérico correspondiente al carácter.
				// Las operaciones dependen de cada dígito, su sumatorio y unas reglas con el módulo11 (http://www.grupoalquerque.es/ferias/2012/archivos/digitos/codigo_cuenta_corriente.pdf)
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
				
				if ((int)(CB.charAt(9)-48)!=11-modulo11) {  // Segundo dígito de control es la posición 9.
					CBcorrecta = false;
					System.out.println("El segundo dígito de control es incorrecto. Esto quiere decir que");
					System.out.println("alguno de los datos introducidos en el Número de Cuenta son erróneos.");
				}
				
			}
			
			if (CBcorrecta==false) {
				System.out.println("\nIntroduce otra vez el número de Cuenta Bancaria:");
				CB = entrada.nextLine().trim();  // Si la CB no ha superado alguna de las comprobaciones, leo de nuevo la cuenta bancaria y reinicio el bucle en la siguiente sentencia.
			}
			
		} while (CBcorrecta==false); // Si la CB no ha superado alguna de las comprobaciones, se reinicia el bucle.
		

	 // SALIDA DE DATOS (OUTPUT)
	 // ========================

		return CB;
		
	}
	
/*
 * FIN MÉTODO cbCorrecta();
 */
}
