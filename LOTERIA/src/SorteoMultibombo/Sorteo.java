package SorteoMultibombo;
import java.util.ArrayList;

/**
 * Superclase Sorteo
 * crea objetos que representan posibles sorteos.
 * De momento la superclase est� incompleta, ya que la inici� con intenci�n de poner en pr�ctica la herencia y para la posible
 * incorporaci�n de sorteos diferentes a 'SorteoMultibombo'.
 * 
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 19/02/2015
 * @since 09/01/2015
 * 
 * @see SorteoMultibombo.java
 *
 */
public class Sorteo {

	//PROPIEDADES
	
	private ArrayList<Bombo> bombo_sorteo;  // ArrayList que almacenar� los bombos que utilizar� el sorteo.
	
	
	//CONSTRUCTORES
	
	/**
	 * Constructor privado al cu�l se puede acceder s�lo en la clase para no poder acceder a la propiedad 'bombo_sorteo'
	 */
	private Sorteo() {
		this.bombo_sorteo= new ArrayList<Bombo>();
	}
	
	/**
	 * Crea un objeto sorteo que contendr� 'nbombos' vac�os.
	 * @param nbombos
	 */
	public Sorteo(int nbombos) {
		this();
		Bombo bombo_nuevo;
		for (int i=0; i<nbombos; i++) {
			bombo_nuevo=new Bombo();
			bombo_sorteo.add(bombo_nuevo);
		}
	}

	//M�TODOS
	
	/**
	 * @return el ArrayList con los bombos que contiene el sorteo.
	 */
	public ArrayList<Bombo> getBombo_sorteo() {
		return bombo_sorteo;
	}
	
	@Override
	/**
	 * @return una cadena con el n�mero de bolas dentro y fuera de cada uno de los bombos de 'bombo_sorteo' con el siguiente formato:
	 * <p>Bombo 1</p>
	 * <p>"Bolas fuera del bombo: [x, x, x, ..., N]"</p>
	 * <p>"Bolas dentro del bombo: [x, x, x, ..., N]"</p>
	 * <p>Bombo 2</p>
	 * <p>"Bolas fuera del bombo: [y, y, y, ..., N]"</p>
	 * <p>"Bolas dentro del bombo: [y, y, y, ..., N]"</p>
	 * <p>...</p>
	 * <p>Bombo N</p>
	 * <p>"Bolas fuera del bombo: [z, z, z, ..., N]"</p>
	 * <p>"Bolas dentro del bombo: [z, z, z, ..., N]"</p>
	 */
	public String toString() {
		String resultado="";
		for (int i=0; i<bombo_sorteo.size(); i++) {
			resultado+= "\nBombo" + (i+1) + "\n" + bombo_sorteo.get(i);
		}
		return resultado;
	}
}
