package discoteca;

import java.util.ArrayList;

public class Discoteca {

	// PROPIEDAD
	private ArrayList<Disco> discos;
	
	//GETTER/SETTER
	public ArrayList<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(ArrayList<Disco> discos) {
		this.discos = discos;
	}
	
	//CONSTRUCTOR
	public Discoteca(){
		this.discos = new ArrayList<Disco>();
	}
	
	//MÉTODOS
	/**
	 * Añade un objeto 'Disco' nuevo al ArrayList de discos de 'Discoteca'
	 * @param disco_nuevo es un objeto Disco
	 */
	public void añadirDisco(Disco disco_nuevo){
		discos.add(disco_nuevo);
	}
	
	//MÉTODOS (para testeo)
	@Override
	public String toString() {
		return this.discos.toString();
	}
	
}
