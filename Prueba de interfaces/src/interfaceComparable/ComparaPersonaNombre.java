package interfaceComparable;

import java.util.Comparator;

public class ComparaPersonaNombre implements Comparator<OtraPersona>{

	@Override
	public int compare(OtraPersona p1, OtraPersona p2) {
		return p1.getEdad()>p2.getEdad() ? 1 : (p1.getEdad()==p2.getEdad() ? 0 : -1);
	}

}
