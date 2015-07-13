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
	 * Siguiendo los criterios del métod 'ComprobarDNI.TipoError(dni)', muestra si el dni es correcto o no.
	 * @see ComprobarDNI.TipoError(dni)
	 * @param dni
	 * @return true: dni correcto - false: dni incorrecto
	 */
	public static boolean esCorrecto(String dni) {	
		return tipoError(dni)==0 ? true : false;
	}
	
	/**
	 * Devuelve un número entero del 0 al 4 que indica el tipo de error del dni a comprobar.
	 * @param dni introducido en el método como cadena de texto
	 * @return
	 * <ul>
	 *     <li>0: El DNI es correcto.</li>
	 *     <li>1: El DNI debe estar formado al menos por 2 caracteres y un máximo de 9.</li>
	 *     <li>2: Uno o más números del DNI NO son números, sino algún otro carácter.</li>
	 *     <li>3: No se ha introducido una letra al final del DNI.</li>
	 *     <li>4: La letra control del número del DNI no es correcta</li>
	 * </ul>
	 */
	public static int tipoError(String dni) {
				
		boolean DNIcorrecto = true;                        // Presupondré que el DNI que se introducirá es verdadero desde el principio.
		int tipo_error=0;                                  // ERROR 0: "El DNI es correcto."
		int longitud;                                      // Almaceno la longitud del DNI en esta variable.
		String numero="";								   // El valor por defecto de 'numero' será sobreescrito si dni!="" (línea 21)
		char letra='?';									   // El valor por defecto de 'letra' será sobreescrito si dni!="" (línea 22)
		
		if (dni.equals(""))
			longitud=0;
		else {
			longitud = dni.length();
			numero=dni.substring(0, longitud-1);           // La cadena 'numero' será el DNI menos el último carácter que presupondré que es una letra correcta.
			letra=dni.toUpperCase().charAt(longitud-1);    // Para el caracter 'letra' presupondré que será el último introducido en la cadena (además lo convierto en mayúscula).
		}
		
		// PASO 1: Compruebo que la longitud del DNI completo no es menor de 2 ni supera los 9 caracteres.
		if (longitud<2 || longitud>9) {
			DNIcorrecto = false;
			tipo_error=1;                                  // ERROR 1: "El DNI debe estar formado al menos por 2 caracteres y un máximo de 9."
		}
		
		// PASO 2: Si la longitud del DNI no es superior a 9 caracteres, compruebo que los números del dni son números:
		if (DNIcorrecto) {  
			for (int i=0; i<=longitud-2; i++) {            // Compruebo número a número si de verdad lo son:
				
				if (Integer.valueOf(numero.charAt(i))<48  || Integer.valueOf(numero.charAt(i))>57) {    // ASCII 48-57 (Los números del 0 al 9)
					DNIcorrecto = false;                   // Si alguno de estos números comprobados queda fuera de rango especificado, NO es un número, por lo que el DNI es incorrecto.
					tipo_error=2;                          // ERROR 2: "Uno o más números del DNI NO son números, sino algún otro carácter."
				}
			}
		}
		
		// PASO 3: Si he pasado los pasos anteriores, compruebo que el último caracter NO es un número.
		if (DNIcorrecto) {
			if (Integer.valueOf(letra)>=48 && Integer.valueOf(letra)<=57) {  // Compruebo que la letra NO es un número.
				DNIcorrecto = false;
				tipo_error=3;                              // ERROR 3: "No se ha introducido una letra al final del DNI."
			}
		}
		
		// PASO 4: Si el último carácter del DNI no es un número, compruebo que sea la letra control correcta correspondiente al número del DNI.
		if (DNIcorrecto) {			
			int modulo23DNI = Integer.valueOf(numero)%23;  // Módulo 23 del número del DNI, que será un número entre el 0 y el 22:
			String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";  // 23 letras posibles en el DNI, en orden del resultado del módulo23DNI.
			if (letra!=letrasDNI.charAt(modulo23DNI)) {
				DNIcorrecto = false;
				tipo_error=4;                              // ERROR 4: "La letra control del número del DNI no es correcta"
			}	
		}
		
		return tipo_error;
	}
	
}
