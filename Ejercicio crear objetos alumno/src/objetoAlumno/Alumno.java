package objetoAlumno;

public class Alumno {

 // PROPIEDADES/ATRIBUTOS/CAMPOS DE LA CLASE
	private String nombre;     // A estas propiedades se les a�ade el 'Modificador de aceso' 'private' (buscar diferencias entre public, private y protected)
	private String apellido1;
	private String apellido2;
	
	private char sexo;
	
	private double[] nota;
	
	Fecha fecha_nac;   // Declaraci�n de un objeto llamado 'fecha_nac' de la clase 'Fecha'
	
 // CONSTRUCTORES DE LA CLASE
	public Alumno(int numNotas) {          // A los constructores es una buena pr�ctica a�adirle el 'Modificador de aceso' 'public', si queremos acceder a ellos fuera del proyecto (o en un diferente paquete dentro de un mismo proyecto)
		this.sexo = 'M';
		this.fecha_nac = new Fecha();
		this.nota= new double[numNotas];
	}
	public Alumno(String nombre, String apellido1, int numNotas) {
		this(numNotas); // Esto ejecuta el constructor por defecto Alumno();
		this.nombre = nombre;
		this.apellido1 = apellido1; 
		this.apellido2 = ""; // Por si acaso inicializo el apellido2 con un valor vac�o.
	}
	public Alumno(String nombre, String apellido1, String apellido2, int numNotas) {
		this(nombre,apellido1,numNotas); // Esto ejecuta el constructor anterior, que incluye el por defecto
		this.apellido2 = apellido2;
	}
	public Alumno(String nombre, String apellido1, String apellido2, int diaNac, int mesNac, int a�oNac, int numNotas) {
		this(nombre, apellido1, apellido2, numNotas);  // Siguiendo los ejemplos anteriores sucesivamente
		this.fecha_nac.dia = diaNac;
		this.fecha_nac.mes = mesNac;
		this.fecha_nac.a�o = a�oNac;
	}
	
 // M�TODOS DE LA CLASE
	
	// Para acceder a las propiedades 'private' de esta clase, se crear�n m�todos. 
	// Cuando una propiedad se hace 'private' se le llama encapsulaci�n y la acci�n 
	// de los m�todos que acceden a estas propiedades se le denomina exposici�n.

	// Los 'getter' y 'setter' se pueden generar autom�ticamente en 'Source'>'Generate Getters and Setters'
	// Es una buena pr�ctica generar los 'Getters' y 'Setters' al principio de este apartado 'M�TODOS DE LA CLASE'.
	
    // 'Getters' y 'Setters' 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public double[] getNota() {
		return nota;
	}
	public void setNota(double[] nota) {
		this.nota = nota;
	}

	
	public double notaMedia() {
		double sumatorio=0;
		for (int i=0; i<this.nota.length; i++) {
			sumatorio += nota[i];
		}
		return sumatorio/this.nota.length;		
	}
	
	public String nombreCompleto() {
		if (this.apellido2.equals("")==false)
			return this.apellido1 + " " + this.apellido2 + ", " + this.nombre;
		else
			return this.apellido1 + ", " + this.nombre;
	}
	

}
