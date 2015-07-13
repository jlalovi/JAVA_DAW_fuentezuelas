package SetColeccionesObjetos;

import java.util.HashSet;
import java.util.TreeSet;

public class Ejecutable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Alumno> misalumnos=new HashSet<Alumno>();
		Alumno a1=new Alumno("Pepe", 18);
		Alumno a2=new Alumno("Juan", 25);
		Alumno a3=new Alumno("Antonio", 55);
		Alumno a4=new Alumno("Juan", 25);
		misalumnos.add(a1);
		misalumnos.add(a2);
		misalumnos.add(a3);
		misalumnos.add(a4);
		
		
		TreeSet<Alumno> misalumnosordenados=new TreeSet<Alumno>();
		misalumnosordenados.add(a1);
		misalumnosordenados.add(a2);
		misalumnosordenados.add(a3);
		misalumnosordenados.add(a4);
							
		System.out.println(misalumnos);
		a1=null;
		System.out.println(misalumnos);
		System.out.println(misalumnosordenados);
	}

}
