import java.util.EmptyStackException;

/**
 * Clase 'Email'
 * crea objetos que representan correos electrónicos. Estos 'Emails' están formados por un remitente, un asunto,
 * un cuerpo de mensaje, un máximo de 5 destinatarios y un máximo de 5 destinatarios en CC.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 25/01/2015
 * 
 */
public class Email {

	//PROPIEDADES
	//============
	
	private String remitente;
	private String asunto;
	private String cuerpo_mensaje;
	private String[] destinatario;
	private String[] destinatarioCC;
	
	
	//CONSTRUCTORES
	//=============
	
	/**
	 * Constructor 'Email()'
	 * crea un objeto 'Email' con el remitente del usuario y con los vectores que contienen los destinatarios iniciados a
	 * una capacidad de 5 posiciones para destinatarios normales y otras 5 posiciones para destinatarios en CC.
	 * Inicio todas las propiedades con un valor de cadena vacía por defecto, algunas obligatorias  para el método 'emailValido()'
	 * y otras para mostrar por defecto texto vacío en el método 'enviarEmail()'m
	 * 
	 * @see emailValido();
	 * @see enviarEmail();
	 */
	public Email() {
		this.remitente="jlalovi@gmail.com";
		this.destinatario = new String[5];
		this.destinatarioCC = new String[5];
		for (int i=0; i<5; i++) {
			this.destinatario[i]="";
			this.destinatarioCC[i]="";
		}
		this.asunto="";
		this.cuerpo_mensaje="";
	}
	
	/**
	 * Constructor 'Email(mensaje,destinatario)'
	 * crea un objeto 'Email' con los valores por defecto citados a continuación:
	 * 
	 * @param mensaje 'String' del cuerpo del mensaje del Email.
	 * @param destinatario 'String[]' de cada uno de los destinatarios del Email hasta un máximo de 5.
	 */
	public Email(String mensaje, String ... destinatario) {
		this();
		this.cuerpo_mensaje = mensaje;
		for (int i=0; i<destinatario.length; i++) {
			this.destinatario[i]=destinatario[i];
		}
	}

	//METODOS
	//=======
	
	/**
	 * Método 'setAsunto(asunto)'
	 * establece el asunto que el usuario desea indicar en el 'Email'
	 * 
	 * @param asunto 'String' del asunto del Email.
	 */
	public void setAsunto(String asunto) {
		this.asunto=asunto;
	}
	
	/**
	 * Método 'setMensaje(mensaje)'
	 * establece el mensaje que el usuario desea indicar en el 'Email'
	 * 
	 * @param asunto 'String' del mensaje del Email.
	 */
	public void setMensaje(String mensaje) {
		this.cuerpo_mensaje=mensaje;
	}
	
	/**
	 * Método 'setDestinatarios(destinatario)'
	 * establece los destinatarios que se enviarán en el Email. Los destinatarios que anteriormente hubiesen establecidos, si
	 * los hubiese, serán sustituidos y eliminados.
	 * 
	 * @param destinatario 'String[]' de cada uno de los destinatarios hasta un máximo de 5.
	 */
	public void setDestinatarios(String ... destinatario) {
		for (int i=0; i<destinatario.length; i++) {
			this.destinatario[i]=destinatario[i];
		}
	}
	
	/**
	 * Método 'setDestinatariosCC(destinatario)'
	 * establece los destinatarios en CC que se enviarán en el Email. Los destinatarios que anteriormente hubiesen establecidos, si
	 * los hubiese, serán sustituidos y eliminados.
	 * 
	 * @param destinatarioCC 'String[]' de cada uno de los destinatarios en CC hasta un máximo de 5.
	 */
	public void setDestinatariosCC(String ... destinatarioCC) {
		for (int i=0; i<destinatarioCC.length; i++) {
			this.destinatarioCC[i]=destinatarioCC[i];
		}
	}
	
	/**
	 * Método 'emailValido()'
	 * comprueba que se cumplen el mínimo de condiciones para que se envíe un Email. Estas son: Cuerpo de mensaje con contenido y al
	 * menos un destinatario en la primera posición.
	 * 
	 * @return 'boolean' 'true': Se cumplen las condiciones para enviar Email 'false': No e cumplen las condiciones para enviar Email.
	 */
	private boolean emailValido(){
		boolean valido=true;		
			if (this.cuerpo_mensaje.equals("")|| this.destinatario[0].equals(""))
				valido=false;
		return valido;
	}
	
	/**
	 * Método 'enviarEmail()'
	 * muestra por pantalla el simulacro de enviar un mensaje a través de las propiedades del objeto creado 'Email'.
	 * En caso de no haber iniciado los valores de 'Destinatario' y 'Cuerpo del mensaje', el método devolverá un error
	 * en proceso de ejecución.
	 */
	public void enviarEmail() {
		if (!emailValido()) {
			System.err.println("¡Para enviar el correo se deben rellenar los campos 'Destinatario' y 'Cuerpo del mensaje' obligatoriamente!");
			throw new EmptyStackException(); // Error en proceso de ejecución si el email no es válido.
		}
		for (int j = 0; j < 5; j++) {
			if (j==0)
				System.out.printf("\nPara: %s",destinatario[j]);
			else if (!destinatario[j].equals(""))
				System.out.printf(", %s",destinatario[j]);
		}
		for (int j = 0; j < 5; j++) {
			if (j==0 && !destinatarioCC[j].equals(""))
				System.out.printf("\nPara Cc: %s",destinatarioCC[j]);
			else if (!destinatarioCC[j].equals(""))
				System.out.printf(", %s",destinatarioCC[j]);
		}
		System.out.printf("\n\nDe: %s", remitente);
		System.out.printf("\n\nAsunto: %s", asunto);
		System.out.printf("\n\n%s", cuerpo_mensaje);
	}
	
}
