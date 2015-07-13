package MapPruebas;

import java.util.Comparator;

import SetColeccionesObjetos.Alumno;

public class ComparaPersona implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		// TODO Auto-generated method stub
		
		return (o1.getNombre().compareTo(o2.getNombre()))*(-1);
	}

}
