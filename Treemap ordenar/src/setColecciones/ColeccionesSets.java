package setColecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class ColeccionesSets {
	private ArrayList<String> NumerosRepe;
	private HashSet<String> Numeros;
	private TreeSet<String> NumerosOrdenados;
	
	public ColeccionesSets()
	{
		NumerosRepe=new ArrayList<String>();
		Numeros=new HashSet<String>();
		NumerosOrdenados=new TreeSet<String>();
		LLenarColecciones();
	}

	private void LLenarColecciones()
	{
		String cadena;
		for(int i=0;i<20;i++)
		{
			Random rnd = new Random();
			int aux=rnd.nextInt(15);
			cadena=String.valueOf(aux);
			NumerosRepe.add(cadena);
			Numeros.add(cadena);
			NumerosOrdenados.add(cadena);
			
		}
	}
	
	public ArrayList<String> getNumerosRepe()
	{
		return NumerosRepe;
	}
	
	public HashSet<String> getNumeros() {
		return Numeros;
	}

	public TreeSet<String> getNumerosOrdenados() {
		return NumerosOrdenados;
	}
	
}
