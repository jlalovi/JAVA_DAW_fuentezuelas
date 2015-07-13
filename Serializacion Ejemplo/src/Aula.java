import java.io.Serializable;
import java.util.ArrayList;


public class Aula implements Serializable{

	//PROPIEDADES
	private String nombre;
	private ArrayList<Alumno> lista;
	
	//CONSTRUCTOR
	public Aula(String nombre) {
		this.nombre=nombre;
		lista=new ArrayList<Alumno>();
	}
	
	//MÉTODOS	
	public void añadeAñumno(Alumno a) {
		lista.add(a);
	}
	
	public String toString() {
		return this.nombre +"\n"+lista.toString();
	}
	
}
