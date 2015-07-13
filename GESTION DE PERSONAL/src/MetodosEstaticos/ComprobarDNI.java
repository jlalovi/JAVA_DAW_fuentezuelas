package MetodosEstaticos;

/**
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 *
 */
public class ComprobarDNI {

	/**
	 * Siguiendo los criterios del m�tod 'ComprobarDNI.TipoError(dni)', muestra si el dni es correcto o no.
	 * @see ComprobarDNI.TipoError(dni)
	 * @param dni
	 * @return true: dni correcto - false: dni incorrecto
	 */
	public static boolean esCorrecto(String dni) {	
		return tipoError(dni)==0 ? true : false;
	}
	
	/**
	 * Devuelve un n�mero entero del 0 al 4 que indica el tipo de error del dni a comprobar.
	 * @param dni introducido en el m�todo como cadena de texto
	 * @return
	 * <ul>
	 *     <li>0: El DNI es correcto.</li>
	 *     <li>1: El DNI debe estar formado al menos por 2 caracteres y un m�ximo de 9.</li>
	 *     <li>2: Uno o m�s n�meros del DNI NO son n�meros, sino alg�n otro car�cter.</li>
	 *     <li>3: No se ha introducido una letra al final del DNI.</li>
	 *     <li>4: La letra control del n�mero del DNI no es correcta</li>
	 * </ul>
	 */
	public static int tipoError(String dni) {
				
		boolean DNIcorrecto = true;                        // Presupondr� que el DNI que se introducir� es verdadero desde el principio.
		int tipo_error=0;                                  // ERROR 0: "El DNI es correcto."
		int longitud;                                      // Almaceno la longitud del DNI en esta variable.
		String numero="";								   // El valor por defecto de 'numero' ser� sobreescrito si dni!="" (l�nea 21)
		char letra='?';									   // El valor por defecto de 'letra' ser� sobreescrito si dni!="" (l�nea 22)
		
		if (dni.equals(""))
			longitud=0;
		else {
			longitud = dni.length();
			numero=dni.substring(0, longitud-1);           // La cadena 'numero' ser� el DNI menos el �ltimo car�cter que presupondr� que es una letra correcta.
			letra=dni.toUpperCase().charAt(longitud-1);    // Para el caracter 'letra' presupondr� que ser� el �ltimo introducido en la cadena (adem�s lo convierto en may�scula).
		}
		
		// PASO 1: Compruebo que la longitud del DNI completo no es menor de 2 ni supera los 9 caracteres.
		if (longitud<2 || longitud>9) {
			DNIcorrecto = false;
			tipo_error=1;                                  // ERROR 1: "El DNI debe estar formado al menos por 2 caracteres y un m�ximo de 9."
		}
		
		// PASO 2: Si la longitud del DNI no es superior a 9 caracteres, compruebo que los n�meros del dni son n�meros:
		if (DNIcorrecto) {  
			for (int i=0; i<=longitud-2; i++) {            // Compruebo n�mero a n�mero si de verdad lo son:
				
				if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los n�meros del 0 al 9)
					DNIcorrecto = false;                   // Si alguno de estos n�meros comprobados queda fuera de rango especificado, NO es un n�mero, por lo que el DNI es incorrecto.
					tipo_error=2;                          // ERROR 2: "Uno o m�s n�meros del DNI NO son n�meros, sino alg�n otro car�cter."
				}
			}
		}
		
		// PASO 3: Si he pasado los pasos anteriores, compruebo que el �ltimo caracter NO es un n�mero.
		if (DNIcorrecto) {
			if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un n�mero.
				DNIcorrecto = false;
				tipo_error=3;                              // ERROR 3: "No se ha introducido una letra al final del DNI."
			}
		}
		
		// PASO 4: Si el �ltimo car�cter del DNI no es un n�mero, compruebo que sea la letra control correcta correspondiente al n�mero del DNI.
		if (DNIcorrecto) {			
			int modulo23DNI = Integer.valueOf(numero)%23;  // M�dulo 23 del n�mero del DNI, que ser� un n�mero entre el 0 y el 22:
			String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";  // 23 letras posibles en el DNI, en orden del resultado del m�dulo23DNI.
			if (letra!=letrasDNI.charAt(modulo23DNI)) {
				DNIcorrecto = false;
				tipo_error=4;                              // ERROR 4: "La letra control del n�mero del DNI no es correcta"
			}	
		}
		
		return tipo_error;
	}
	
}
