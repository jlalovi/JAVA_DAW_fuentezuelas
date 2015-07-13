package MapPruebas;
import SetColeccionesObjetos.*;

import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.event.TreeWillExpandListener;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Alumno,	Alumno> misalumnos =new TreeMap<Alumno,Alumno>();
		
		misalumnos.put(new Alumno("Pepe", 25),new Alumno("Pepe", 25));
		misalumnos.put(new Alumno("Antonio", 45),new Alumno("Antonio", 45));
		misalumnos.put(new Alumno("Juan", 12),new Alumno("Juan", 12));
		misalumnos.put(new Alumno("Manuel", 80),new Alumno("Manuel", 80));
		
		Iterator it =misalumnos.keySet().iterator();
		
		while(it.hasNext())
		{
			Alumno aux=(Alumno)it.next();
			System.out.println(aux.toString());
			
		}
		
		TreeMap<Alumno,Alumno> otrosalumnos=new TreeMap<Alumno,Alumno>(new ComparaPersona());
		otrosalumnos.put(new Alumno("Pepe", 25),new Alumno("Pepe", 25));
		otrosalumnos.put(new Alumno("Antonio", 45),new Alumno("Antonio", 45));
		otrosalumnos.put(new Alumno("Juan", 12),new Alumno("Juan", 12));
		otrosalumnos.put(new Alumno("Manuel", 80),new Alumno("Manuel", 80));
		System.out.println("*************************************************************************");
		Iterator it2 =otrosalumnos.keySet().iterator();
		
		while(it2.hasNext())
		{
			Alumno aux=(Alumno)it2.next();
			System.out.println(aux.toString());
			
		}
		
	}

}
