package MetodosEstaticos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Empleados.Administrativo;
import Empleados.Analista;
import Empleados.Becario;
import Empleados.Programador;
import Empleados.Tecnico;
import GestionPersonal.Empresa;

/**
 * Conjunto de m�todos est�ticos para cargar y salvar los datos de los empleados al ejecutar y al salir de la ejecuci�n
 * del main del proyecto 'GESTI�N DE PERSONAL'
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 13/04/2015
 * @since 19/02/2015
 */
public class BaseDatosEmpleados {
	
	/**
	 * Este m�todo est�tico te permite cargar todos los datos de los empleados almacenados en el documento de texto
	 * "BaseDatosEmpleados.txt". El orden y formato (caracteres que separan las propiedades) TIENE que ser:
	 * 'dni�centro_trabajo�ape1�ape2�nombre�puesto_trabajo', para administrativos y
	 * 'dni�centro_trabajo�ape1�ape2�nombre�puesto_trabajo�capacidad1�capacidad2�...', para el resto de empleados
	 * 
	 * @param empresa
	 * @throws IOException
	 */
	public static void cargar(Empresa empresa) throws IOException {
		//Propiedades de empleados que se almacenar�n en "BaseDatosEmpleados.txt"
		String nombre;
		String ape1;
		String ape2;
		String dni;
		String centro_trabajo;
		String puesto_trabajo;
		String[] capacidades;
		
		//Propiedades para crear el objeto que representa el archivo a leer y el objeto que 
		FileReader archivo;
		BufferedReader entrada=null;
		
		// Cada posici�n almacenar� una l�nea le�da por el 'BufferedReader', que a su vez corresponde con las propiedades de un empleado.
		ArrayList<String> lineas_empleados; 
		
		
		try {
			archivo = new FileReader("BaseDatosEmpleados.txt");
			entrada = new BufferedReader(archivo);
			
			String linea; // El BufferedReader lee l�nea a l�nea. Sino se lee una l�nea, se devolver� un null.

			lineas_empleados = new ArrayList<String>(); // Inicializo el ArrayList
			
			while ((linea=entrada.readLine())!=null) {
				lineas_empleados.add(linea); // Almaceno cada l�nea (propiedades de un empleado), en una posici�n del ArrayList
			}
			
			// Bucle para construir los empleados uno a uno y registrarlos en el objeto 'Empresa'.
			for (int empleado=0; empleado<lineas_empleados.size(); empleado++) {
				 
				// Descompongo cada l�nea (empleado), en sus propiedades y las almaceno en un Array de Strings.
				String[] propiedades_empleado = lineas_empleados.get(empleado).split("�"); // Propiedades separadas por el car�cter '�'
					// Cada posici�n de 'propiedades_empleado', corresponde, evidentemente, a una propiedad del empleado en este orden:
					dni = propiedades_empleado[0];
					centro_trabajo = propiedades_empleado[1];
					ape1 = propiedades_empleado[2];
					ape2 = propiedades_empleado[3];
					nombre = propiedades_empleado[4];
					puesto_trabajo = propiedades_empleado[5];
				
				if ("Administrativo".equals(puesto_trabajo)) { // Si el puesto de trabajo es Administrativo, a�ado el nuevo empleado con sus propiedades
					empresa.a�adirEmpleado(new Administrativo(nombre, ape1, ape2, dni, centro_trabajo));
				}
				else { // En caso contrario, el empleado ser� un T�cnico, con una o m�s capacidades que descompondr� en otro Array de Strings
					
					Tecnico empleado_nuevo;
					
					if (propiedades_empleado.length==6){ // En caso de que el t�cnico no tenga capacidades
						capacidades = new String[1];
						capacidades[0]="";
					}
					else {
						// La posici�n 6 corresponde a un String de todas las capacidades separadas por el car�cter '�'
						capacidades = propiedades_empleado[6].split("�");
					}
					
					// Dependiendo del puesto de trabajo, creo un empleado con un contructor u otro:
					if (puesto_trabajo.equals("Programador")) {
						empleado_nuevo = new Programador(nombre, ape1, ape2, dni, centro_trabajo);
						empleado_nuevo.setCapacidades(capacidades);
						empresa.a�adirEmpleado(empleado_nuevo);
					}
					else if (puesto_trabajo.equals("Analista")) {
						empleado_nuevo = new Analista(nombre, ape1, ape2, dni, centro_trabajo);
						empleado_nuevo.setCapacidades(capacidades);
						empresa.a�adirEmpleado(empleado_nuevo);
					}					
					else if (puesto_trabajo.equals("Becario")) {
						empleado_nuevo = new Becario(nombre, ape1, ape2, dni, centro_trabajo);
						empleado_nuevo.setCapacidades(capacidades);
						empresa.a�adirEmpleado(empleado_nuevo);
					}
				}	
			}
		}
		finally {
			if (entrada!=null) {
				entrada.close();
			}
		}
		
	}
	
	/**
	 * M�todo que una sobreescribe el documento "BaseDatosEmpleadosBorrados.txt" a partir del ArrayList de empleados
	 * del objeto 'Empresa'.
	 * 
	 * @param empresa
	 * @throws FileNotFoundException
	 */
	public static void salvarCambios(Empresa empresa) throws FileNotFoundException {

		// Propiedad necesaria para crear/sobreescribir el archivo "BaseDatosEmpleados.txt"
		PrintWriter salida=null;
		
		try {
			
			// Una vez terminado de ejecutar el programa, preguntar� si quiero guardar todos los cambios realizados y si la respuesta es afirmativa, sobreescribir� el archivo
			salida = new PrintWriter("BaseDatosEmpleados.txt"); 
			
			// En esta String cada linea (propiedades de un empleado) que se a�adir� al archvo 'BaseDatosEmpleados.txt'
			String linea_empleado; 

			for  (int empleado=0; empleado<empresa.getEmpleados().size(); empleado++ ){
				// A�ado las propiedades b�sicas de empleado a 'linea_empleado'
				linea_empleado = empresa.getEmpleados().get(empleado).getDNI()+"�"+empresa.getEmpleados().get(empleado).getCentro_trabajo()
						+"�"+empresa.getEmpleados().get(empleado).getApe1()+"�"+empresa.getEmpleados().get(empleado).getApe2()
						+"�"+empresa.getEmpleados().get(empleado).getNombre()+"�"+empresa.getEmpleados().get(empleado).getPuesto_trabajo();
				// En caso de no ser Administrativo, a�ado tambi�n las capacidades a la 'l�nea_empleado' con esta locura de m�todos concatenados y castings
				if(!"Administrativo".equals(empresa.getEmpleados().get(empleado).getPuesto_trabajo()))
					if (!"".equals(((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().get(0))) {
						linea_empleado+="�";
						for (int capacidad=0; capacidad<((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().size(); capacidad++) {
							if (capacidad==((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().size()-1)
								linea_empleado+=((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().get(capacidad);
							else
								linea_empleado+=((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().get(capacidad)+"�";
						}
					}
					else { //En caso de que no hubiese capacidades a�n a pesar de tratarse de un Empleado T�cnico.
						linea_empleado+="";
					}
				// Finalmente, despu�s de cada iteraci�n con todo este proceso, imprimo la l�nea con las propiedades del empleado:
				salida.println(linea_empleado);
				
			}
		}
		finally {

			if (salida!=null) {
				salida.close();
			}
		}
		
	}
	
	/**
	 * M�todo que una sobreescribe el documento "BaseDatosEmpleadosBorrados.txt" a partir del ArrayList de empleados borrados
	 * del objeto 'Empresa'.
	 * 
	 * @param empresa
	 * @throws FileNotFoundException
	 */
	public static void salvarBorrados(Empresa empresa) throws FileNotFoundException {
		// Propiedad necesaria para crear/sobreescribir el archivo "BaseDatosEmpleados.txt"
				PrintWriter salida=null;
				
				try {
					
					// Una vez terminado de ejecutar el programa, preguntar� si quiero guardar todos los cambios realizados y si la respuesta es afirmativa, sobreescribir� el archivo
					salida = new PrintWriter("BaseDatosEmpleadosBorrados.txt"); 
					
					// En esta String cada linea (propiedades de un empleado) que se a�adir� al archvo 'BaseDatosEmpleadosBorrados.txt'
					String linea_empleado; 

					for  (int empleado=0; empleado<empresa.getEmpleados_borrados().size(); empleado++ ){
						// A�ado las propiedades b�sicas de empleado a 'linea_empleado'
						linea_empleado = empresa.getEmpleados_borrados().get(empleado).getDNI()+"�"+empresa.getEmpleados_borrados().get(empleado).getCentro_trabajo()
								+"�"+empresa.getEmpleados_borrados().get(empleado).getApe1()+"�"+empresa.getEmpleados_borrados().get(empleado).getApe2()
								+"�"+empresa.getEmpleados_borrados().get(empleado).getNombre()+"�"+empresa.getEmpleados_borrados().get(empleado).getPuesto_trabajo();
						// En caso de no ser Administrativo, a�ado tambi�n las capacidades a la 'l�nea_empleado' con esta locura de m�todos concatenados y castings
						if(!"Administrativo".equals(empresa.getEmpleados_borrados().get(empleado).getPuesto_trabajo()))
							if (!"".equals(((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().get(0))) {
								linea_empleado+="�";
								for (int capacidad=0; capacidad<((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().size(); capacidad++) {
									if (capacidad==((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().size()-1)
										linea_empleado+=((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().get(capacidad);
									else
										linea_empleado+=((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().get(capacidad)+"�";
								}
							}
							else { //En caso de que no hubiese capacidades a�n a pesar de tratarse de un Empleado T�cnico.
								linea_empleado+="";
							}
						// Finalmente, despu�s de cada iteraci�n con todo este proceso, imprimo la l�nea con las propiedades del empleado:
						salida.println(linea_empleado);
						
					}
				}
				finally {

					if (salida!=null) {
						salida.close();
					}
				}
	}
}
