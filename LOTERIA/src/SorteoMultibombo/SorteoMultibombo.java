package SorteoMultibombo;
import java.util.ArrayList;

/**
 * Subclase 'SorteoMultibombo'
 * crea objetos que representan posibles sorteos relacionados con el caso hipot�tico que indica el ejercicio.
 *  
 * @author Javier Latorre - jlalovi@gmail.com
 * @version 19/02/2015
 * @since 09/01/2015
 * 
 * @see Sorteo.java
 *
 */
public class SorteoMultibombo extends Sorteo {

	//PROPIEDADES
	
	private ArrayList<Decimo> decimos_premiados; // Contendr� los 3 d�cimos premiados, cuyo �ltimo n�mero ser� el reintegro premiado.
	private int reintegro_premiado;              // Puesto que el reintegro ganador ser� el mismo para todos los posibles n�meros ganadores, lo almaceno en una variable a parte.
	private ArrayList<Decimo> decimos_comprados; // Contendr� los d�cimos que el usuario compre en el 'MainBomboLoteria'.
	
	//CONSTRUCTORES
	
	/**
	 * Crea un objeto 'SorteoMultibombo' que hereda del constructor 'Sorteo()' 6 bombos vac�os.
	 */
	public SorteoMultibombo() {
		super(6); // Llamo al constructor padre para que me 'prepare' 6 bombos.
		this.decimos_comprados=new ArrayList<Decimo>(); // Inicio el ArrayList de d�cimos comprados que contendr� este sorteo.
	}
	
	//M�TODOS
	
	//GETTERS
	
	/**
	 * @return el ArrayList de los d�cimos premiados.
	 */
	public ArrayList<Decimo> getDecimos_premiados() {
		return decimos_premiados;
	}
	
	/**
	 * @return el ArrayList de los d�cimos comprados por el usuario.
	 */
	public ArrayList<Decimo> getDecimos_comprados() {
		return decimos_comprados;
	}

	/**
	 * @return el Reintegro premiado en el Sorteo Multibombo.
	 */
	public int getReintegro_premiado() {
		return reintegro_premiado;
	}

	//M�TODOS PRIVADOS
	
	/**
	 * Prepara los 6 bombos del sorteo multibombo, todos con 10 bolas del 0 al 9. Las bolas dentro del bombo estar�n desordenadas.
	 */
	private void prepararBombos() {
		for (int i=0; i<6; i++) {
			super.getBombo_sorteo().get(i).setNbolas(10);     // A los 6 bombos del sorteo les indico que tendr�n 10 bolas cada uno.
			super.getBombo_sorteo().get(i).generarBolas();    // Genero esas 10 bolas para cada bombo (numeradas del 0 al 9).
			super.getBombo_sorteo().get(i).a�adirExtraidas(); // A�ado a cada bombo las 10 bolas creadas.
			super.getBombo_sorteo().get(i).remover();         // Remuevo cada uno de los bombos, para que las bolas est�n desordenadas.
		}
	}
	
	/**
	 * Extrae una bola del bombo de reintegros, lee su valor y lo convierte en n�mero entero para almacenarlo en 'reintegro_premiado'.
	 */
	private void reintegroPremiado() {
		this.reintegro_premiado=Integer.parseInt(super.getBombo_sorteo().get(5).extraerBola().getValor());		
		
	}
	
	/**
	 * Realiza todo el proceso del sorteo de extraer una bola por bombo para crear un objeto d�cimo con los n�meros acertantes para el premio en cuesti�n.
	 * @return un objeto d�cimo premiado.
	 */
	private Decimo premiado() {
		Decimo decimo_premiado = new Decimo(5,1); // Creo un objeto d�cimo con capacidad para 5 n�meros y 1 reintegro (ambos del 0 al 9).
		int[] numeros_extraidos = new int[6];
		for (int i=0; i<5; i++) {
			numeros_extraidos[i]=Integer.parseInt(super.getBombo_sorteo().get(i).extraerBola().getValor()); // Extraigo una bola por bombo (salvo el del reintegro), de la que leo su valor y lo convierto en n�mero entero para almacenarlo en el vector de enteros
			super.getBombo_sorteo().get(i).a�adirExtraidas(); // Vuelvo a meter en el bombo cada una de las bolas extra�das.			
		}
		numeros_extraidos[5]=this.reintegro_premiado;
		decimo_premiado.rellenar(numeros_extraidos); // A�ado los n�meros extra�dos al d�cimo premiado (Objeto Decimo, creado a trav�s de un constructor).
		
		return decimo_premiado;
	}

	//M�TODOS P�BLICOS
	
	/**
	 * @return un ArrayList con los 3 premios del Sorteo Multibombo, ordenados del primer premio al tercero.
	 */
	public ArrayList<Decimo> realizarSorteo() {
		this.prepararBombos();
		this.reintegroPremiado();
		
		this.decimos_premiados=new ArrayList<Decimo>();		
		Decimo primer_premio=new Decimo(premiado());
		this.decimos_premiados.add(primer_premio);
		Decimo segundo_premio=new Decimo(premiado());
		this.decimos_premiados.add(segundo_premio);
		Decimo tercer_premio=new Decimo(premiado());
		this.decimos_premiados.add(tercer_premio);
		
		return decimos_premiados;
	}
	
	/**
	 * A�ade al ArrayList un nuevo objeto d�cimo comprado por el usuario en el programa ejecutado por 'MainBomboLoteria'.
	 * @param decimo_comprado
	 */
	public void comprarDecimo(Decimo decimo_comprado) {
		this.decimos_comprados.add(decimo_comprado);
	}
	
	/**
	 * Realiza todas las operaciones necesarias para obtener el resultado final de lo gastado y ganado (en euros) por el usuario una vez ejecutado
	 * el programa 'MainBomboLoteria'.
	 * @return un array con el dinero gastado (primera posici�n) y el dinero gastado (segunda posici�n) por el usuario.
	 */
	public int[] comprobarPremios(){
		int[] gastado_ganado=new int[2]; // Vector con dos posiciones, una para el dinero gastado en d�cimos y otra para el dinero ganado en premios.			
			gastado_ganado[0]=this.decimos_comprados.size()*10; // 10 � por d�cimo comprado.
			gastado_ganado[1]=0; // Inicializo el valor de dinero ganado a 0.
			for (Decimo dc:this.decimos_comprados) {
				if (dc.equalsReintegro(decimos_premiados.get(0)))
					gastado_ganado[1]+=10; // Si el reintegro del d�cimo comprado es igual a cualquiera de los reintegros de los premiados, se recuperan los 10� gastados en ese d�cimo.
				if (dc.equalsNumero(decimos_premiados.get(0)))
					gastado_ganado[1]+=10000; // Si el n�mero del d�cimo comprado es igual al n�mero del primer premio, sumo 1000� x 10� gastados en ese d�cimo.
				if (dc.equalsNumero(decimos_premiados.get(1)))
					gastado_ganado[1]+=5000; // Si el n�mero del d�cimo comprado es igual al n�mero del segundo premio, sumo 500� x 10� gastados en ese d�cimo.
				if (dc.equalsNumero(decimos_premiados.get(2)))
					gastado_ganado[1]+=1000; // Si el n�mero del d�cimo comprado es igual al n�mero del tercer premio, sumo 100� x 10� gastados en ese d�cimo.
			}
		return gastado_ganado;
	}
	
	@Override
	/**
	 * @return una cadena con el n�mero completo de cada uno de los d�cimos comprados con el siguiente formato: 
	 * "[Numero: x x x ... n Reintegro/s: x x ... n], [Numero: x x x ... n Reintegro/s: x x ... n], ..."
	 */	
	public String toString() {
		return this.decimos_premiados.toString();
	}
	
}
