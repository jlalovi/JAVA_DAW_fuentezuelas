import java.util.EmptyStackException;


public class Bombo {

	//PROPIEDADES
	private int nbolas;
	private int[] bombo;
	
	private int topebolas=100;    // Establezco una capacidad máxima del bombo de 100 por ejemplo.
	private boolean lleno=false;  // Cualquier objeto bombo que se cree comienza sin bolas en su interior (aunque se sepa cuántas se van a meter). Hay que llenarlo antes.
	
	//CONSTRUCTORES	
	
	public Bombo() {
		this.nbolas=0;
		this.bombo=new int[topebolas];
	}
	
	public Bombo(int bolas) {
		this();
		this.nbolas=bolas;
	}
	
	public Bombo(Bombo b) {
		this.nbolas=b.getNbolas();
		this.bombo=new int[topebolas];
	}

	//METODOS
	//getters y setters:

	public int getNbolas() {
		return nbolas;
	}
	
	public void setNbolas(int nbolas) {
		this.nbolas = nbolas;
	}

	//Otros métodos:
	private void hayBolas(){
		if (this.nbolas==0) {
			System.err.println("¡No hay bolas en el bombo!");
			throw new EmptyStackException(); // Error en proceso de ejecución si al ejecutar este método no hay bolas.
		}		
	}
	
	private void ordenar() {
		this.hayBolas();
		for (int i=0; i<nbolas; i++) {  // Relleno el bombo con las bolas del 0 hasta nbolas.
			bombo[i]=i;
		}
	}
	
	public void remover() {
		this.hayBolas();
		int aux=0;
		int random=0;
		for (int i=0; i<nbolas; i++) {                  // Intercambio cada una de las posiciones aleatoriamente con otra.
			random=Calculos.numAleatorio(0, nbolas-1);
			aux = bombo[i];
			bombo[i]=bombo[random];
			bombo[random]=aux;
		}
	}
	
	public void llenar() {	
		this.ordenar();
		this.remover();
		lleno=true;
	}
	
	public int extraer(){
		this.hayBolas();
		if (lleno==false) {
			System.err.println("¡No se ha llenado el bombo todavía con las bolas!");
			throw new EmptyStackException(); // Error en proceso de ejecución si al ejecutar este método no se ha llenado el bombo.
		}
		int bola_extraida=bombo[0];
		for (int i=1;i<nbolas;i++) {
			bombo[i-1]=bombo[i];     // Desplazo el orden de las bolas en el bombo al quitar la primera bola.
		}
		nbolas--;                    // Al extraer una bola, el bombo se queda con una bola menos.	
		return bola_extraida;
	}
	


	
}
