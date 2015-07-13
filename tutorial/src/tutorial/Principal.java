package tutorial;

import java.util.Scanner; // Clase Scanner que se encuentra en el paquete java.util

public class Principal {

	public static void main(String[] args) { // Inicio
		
  	// APARTADOS DE UN ALGORITMO:

	 // DELARACI�N DE VARIABLES
	 // =======================

   	 // ENTRADA DE DATOS (INPUT)
	 // ========================
			
	 // PROCESAMIENTO DE DATOS
	 // ======================
			
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		// DECLRACI�N DE VARIABLES (Primitive Data Types)
		
		// N�meros Enteros
		byte numero1;     // 2^8 bits     (-128 to 127)
		short numero2;    // 2^16 bits    (-32,768 to 32,767)
		int numero3;      // 2^32 bits    (-2,147,483,648 to 2,147,483,647)
		long numero4;     // 2^64 bits    (-9,223,372,036,854,775,808 to +9,223,372,036,854,775,807)
		
		// N�meros Reales
		float decimal1;   // 2^32 bits    (1.40129846432481707e-45 to 3.40282346638528860e+38 (positive or negative))
		double decimal2;  // 2^64 bits    (4.94065645841246544e-324d to 1.79769313486231570e+308d (positive or negative))
		
		// Valor de car�cter
		char letra;       // 2^16 bits    (S�lo un car�cter)
		
		// Valores l�gicos
		boolean si_no;    // 1 bit (True or False)
		
		// DECLARACI�N DE CADENAS (String es un Objeto de Datos Simple, Simple Data Object)
		
		String cadena = new String("");  // String es una clase, por lo que hay que utilizar un
										 // constructor para que se cree el objeto cadena.
		
		// ASIGNACI�N DE DATOS
		
		// Valores asignados por el programa:
		
		numero1 = 127;
		numero2 = 32_767;           // El '_' se utiliza por cuestiones est�ticas en n�meros grandes, para leerlos
		numero3 = 2_147_483_647;    // m�s f�cilmente.
		numero4 = 9_999_999_999l;   // Un valor de tipo long necesita la letra 'l' al final para registrar el valor.
									// valor de un 'integer'.
		
		decimal1 = 3.1415f;         // Al asignar un valor float, debe de terminarse con 'f'.
		decimal2 = 7.123456789d;    // El valor double puede terminarse en 'd', pero no es obligatorio.
		
		letra = 'j';                // Representado por comillas simples ''.
		cadena = "Pepe";			// Representada por comillas dobles "".
		
		si_no = true;               // Boleeanos s�lo pueden ser asignados por 'true' or 'false'.
		
		// Valores asignados por el usuario:
		
		Scanner entrada = new Scanner(System.in);         // Clase que facilita la lectura de datos en JAVA.
											              // S�lo hay que escribirlo una vez.
		
		System.out.println("Introduce el n�mero 1: ");
		numero1 = entrada.nextByte();                     // Leer Byte	
		System.out.println("Introduce el n�mero 2: ");
		numero2 = entrada.nextShort();	                  // Leer Short
		System.out.println("Introduce el n�mero 3: ");
		numero3 = entrada.nextInt();                      // Leer Int
		System.out.println("Introduce el n�mero 4: ");
		numero4 = entrada.nextLong();                     // Leer Long
		
		System.out.println("Introduce el decimal 1: ");
		decimal1 = entrada.nextFloat();                   // Leer Float
		System.out.println("Introduce el decimal 2: ");
		decimal2 = entrada.nextDouble();                  // Leer Double
		
		System.out.println("Introduce una frase: ");
		cadena = entrada.next();                          // Leer una cadena
		
		System.out.println("�Quieres que el valor de 'si_no' sea Verdadero? Pulsa (s)i o (n)o: ");
		letra = entrada.next().charAt(0);                 // Leer s�lo una letra
			if (letra == 's') {
				si_no = true;
			}
			if (letra == 'n') {
				si_no = false;
			}
		
		entrada.close(); // Fin Scanner
		
		// MOSTRAR EN CONSOLA
		
		// Imprimir cadenas que no se han asignado en ning�n objeto de la clase String.
		System.out.println("El valor de la variable si_no es: "+si_no);
		System.out.println("El valor de los n�meros introducidos en orden son: "+numero1+" "+numero2+" "+numero3+" "+numero4);
		System.out.println("La letra introducida es: "+letra+" y el de la cadena: "+cadena);
		
		System.out.println("Estoy impimiendo en consola y salto de l�nea");
		System.out.print("Estoy en la siguiente l�nea y ");
		System.out.print("aunque en el c�digo divida esta frase ");
		System.out.print("en"+" "+"l�neas"+" "+"de"+" "+"c�digo, ");
		System.out.println("en consola aparece todo seguido sin salto de l�nea");
		
		
		for (int i=1; i<=30; i++)  {     // for(Iniciaci�n; Condici�n de repetici�n; Incremento)
			System.out.print(i);
		}
			
	}

}