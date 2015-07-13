package SetColeccionesObjetos;

public class Alumno implements Comparable<Alumno> {
	private String Nombre;
	private int Edad;
	
	public Alumno(String nom, int ed)
	{
		Nombre=nom;
		Edad=ed;
	}
	
	public void setNombre(String n)
	{
		this.Nombre=n;
	}
	public String getNombre()
	{
		return this.Nombre;
	}
	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		int r=-1;
		if(this.Nombre.equals(o.Nombre) && this.Edad==o.Edad)
		{
			r=0;
		}
		else if (this.Edad>o.Edad) {
			r=1;
			
		}
		return r;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.Nombre+"-"+this.Edad;
	}
	
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return this.Edad*this.Nombre.length();
//	}
	
}
