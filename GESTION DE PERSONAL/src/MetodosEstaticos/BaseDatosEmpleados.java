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
 * Conjunto de métodos estáticos para cargar y salvar los datos de los empleados al ejecutar y al salir de la ejecución
 * del main del proyecto 'GESTIÓN DE PERSONAL'
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 13/04/2015
 * @since 19/02/2015
 */
public class BaseDatosEmpleados {
	
	/**
	 * Este método estático te permite cargar todos los datos de los empleados almacenados en el documento de texto
	 * "BaseDatosEmpleados.txt". El orden y formato (caracteres que separan las propiedades) TIENE que ser:
	 * 'dni·centro_trabajo·ape1·ape2·nombre·puesto_trabajo', para administrativos y
	 * 'dni·centro_trabajo·ape1·ape2·nombre·puesto_trabajo·capacidad1¬capacidad2¬...', para el resto de empleados
	 * 
	 * @param empresa
	 * @throws IOException
	 */
	public static void cargar(Empresa empresa) throws IOException {
		//Propiedades de empleados que se almacenarán en "BaseDatosEmpleados.txt"
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
		
		// Cada posición almacenará una línea leída por el 'BufferedReader', que a su vez corresponde con las propiedades de un empleado.
		ArrayList<String> lineas_empleados; 
		
		
		try {
			archivo = new FileReader("BaseDatosEmpleados.txt");
			entrada = new BufferedReader(archivo);
			
			String linea; // El BufferedReader lee línea a línea. Sino se lee una línea, se devolverá un null.

			lineas_empleados = new ArrayList<String>(); // Inicializo el ArrayList
			
			while ((linea=entrada.readLine())!=null) {
				lineas_empleados.add(linea); // Almaceno cada línea (propiedades de un empleado), en una posición del ArrayList
			}
			
			// Bucle para construir los empleados uno a uno y registrarlos en el objeto 'Empresa'.
			for (int empleado=0; empleado<lineas_empleados.size(); empleado++) {
				 
				// Descompongo cada línea (empleado), en sus propiedades y las almaceno en un Array de Strings.
				String[] propiedades_empleado = lineas_empleados.get(empleado).split("·"); // Propiedades separadas por el carácter '·'
					// Cada posición de 'propiedades_empleado', corresponde, evidentemente, a una propiedad del empleado en este orden:
					dni = propiedades_empleado[0];
					centro_trabajo = propiedades_empleado[1];
					ape1 = propiedades_empleado[2];
					ape2 = propiedades_empleado[3];
					nombre = propiedades_empleado[4];
					puesto_trabajo = propiedades_empleado[5];
				
				if ("Administrativo".equals(puesto_trabajo)) { // Si el puesto de trabajo es Administrativo, añado el nuevo empleado con sus propiedades
					empresa.añadirEmpleado(new Administrativo(nombre, ape1, ape2, dni, centro_trabajo));
				}
				else { // En caso contrario, el empleado será un Técnico, con una o más capacidades que descompondré en otro Array de Strings
					
					Tecnico empleado_nuevo;
					
					if (propiedades_empleado.length==6){ // En caso de que el técnico no tenga capacidades
						capacidades = new String[1];
						capacidades[0]="";
					}
					else {
						// La posición 6 corresponde a un String de todas las capacidades separadas por el carácter '¬'
						capacidades = propiedades_empleado[6].split("¬");
					}
					
					// Dependiendo del puesto de trabajo, creo un empleado con un contructor u otro:
					if (puesto_trabajo.equals("Programador")) {
						empleado_nuevo = new Programador(nombre, ape1, ape2, dni, centro_trabajo);
						empleado_nuevo.setCapacidades(capacidades);
						empresa.añadirEmpleado(empleado_nuevo);
					}
					else if (puesto_trabajo.equals("Analista")) {
						empleado_nuevo = new Analista(nombre, ape1, ape2, dni, centro_trabajo);
						empleado_nuevo.setCapacidades(capacidades);
						empresa.añadirEmpleado(empleado_nuevo);
					}					
					else if (puesto_trabajo.equals("Becario")) {
						empleado_nuevo = new Becario(nombre, ape1, ape2, dni, centro_trabajo);
						empleado_nuevo.setCapacidades(capacidades);
						empresa.añadirEmpleado(empleado_nuevo);
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
	 * Método que una sobreescribe el documento "BaseDatosEmpleadosBorrados.txt" a partir del ArrayList de empleados
	 * del objeto 'Empresa'.
	 * 
	 * @param empresa
	 * @throws FileNotFoundException
	 */
	public static void salvarCambios(Empresa empresa) throws FileNotFoundException {

		// Propiedad necesaria para crear/sobreescribir el archivo "BaseDatosEmpleados.txt"
		PrintWriter salida=null;
		
		try {
			
			// Una vez terminado de ejecutar el programa, preguntaré si quiero guardar todos los cambios realizados y si la respuesta es afirmativa, sobreescribiré el archivo
			salida = new PrintWriter("BaseDatosEmpleados.txt"); 
			
			// En esta String cada linea (propiedades de un empleado) que se añadirá al archvo 'BaseDatosEmpleados.txt'
			String linea_empleado; 

			for  (int empleado=0; empleado<empresa.getEmpleados().size(); empleado++ ){
				// Añado las propiedades básicas de empleado a 'linea_empleado'
				linea_empleado = empresa.getEmpleados().get(empleado).getDNI()+"·"+empresa.getEmpleados().get(empleado).getCentro_trabajo()
						+"·"+empresa.getEmpleados().get(empleado).getApe1()+"·"+empresa.getEmpleados().get(empleado).getApe2()
						+"·"+empresa.getEmpleados().get(empleado).getNombre()+"·"+empresa.getEmpleados().get(empleado).getPuesto_trabajo();
				// En caso de no ser Administrativo, añado también las capacidades a la 'línea_empleado' con esta locura de métodos concatenados y castings
				if(!"Administrativo".equals(empresa.getEmpleados().get(empleado).getPuesto_trabajo()))
					if (!"".equals(((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().get(0))) {
						linea_empleado+="·";
						for (int capacidad=0; capacidad<((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().size(); capacidad++) {
							if (capacidad==((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().size()-1)
								linea_empleado+=((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().get(capacidad);
							else
								linea_empleado+=((Tecnico)empresa.getEmpleados().get(empleado)).getCapacidades().get(capacidad)+"¬";
						}
					}
					else { //En caso de que no hubiese capacidades aún a pesar de tratarse de un Empleado Técnico.
						linea_empleado+="";
					}
				// Finalmente, después de cada iteración con todo este proceso, imprimo la línea con las propiedades del empleado:
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
	 * Método que una sobreescribe el documento "BaseDatosEmpleadosBorrados.txt" a partir del ArrayList de empleados borrados
	 * del objeto 'Empresa'.
	 * 
	 * @param empresa
	 * @throws FileNotFoundException
	 */
	public static void salvarBorrados(Empresa empresa) throws FileNotFoundException {
		// Propiedad necesaria para crear/sobreescribir el archivo "BaseDatosEmpleados.txt"
				PrintWriter salida=null;
				
				try {
					
					// Una vez terminado de ejecutar el programa, preguntaré si quiero guardar todos los cambios realizados y si la respuesta es afirmativa, sobreescribiré el archivo
					salida = new PrintWriter("BaseDatosEmpleadosBorrados.txt"); 
					
					// En esta String cada linea (propiedades de un empleado) que se añadirá al archvo 'BaseDatosEmpleadosBorrados.txt'
					String linea_empleado; 

					for  (int empleado=0; empleado<empresa.getEmpleados_borrados().size(); empleado++ ){
						// Añado las propiedades básicas de empleado a 'linea_empleado'
						linea_empleado = empresa.getEmpleados_borrados().get(empleado).getDNI()+"·"+empresa.getEmpleados_borrados().get(empleado).getCentro_trabajo()
								+"·"+empresa.getEmpleados_borrados().get(empleado).getApe1()+"·"+empresa.getEmpleados_borrados().get(empleado).getApe2()
								+"·"+empresa.getEmpleados_borrados().get(empleado).getNombre()+"·"+empresa.getEmpleados_borrados().get(empleado).getPuesto_trabajo();
						// En caso de no ser Administrativo, añado también las capacidades a la 'línea_empleado' con esta locura de métodos concatenados y castings
						if(!"Administrativo".equals(empresa.getEmpleados_borrados().get(empleado).getPuesto_trabajo()))
							if (!"".equals(((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().get(0))) {
								linea_empleado+="·";
								for (int capacidad=0; capacidad<((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().size(); capacidad++) {
									if (capacidad==((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().size()-1)
										linea_empleado+=((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().get(capacidad);
									else
										linea_empleado+=((Tecnico)empresa.getEmpleados_borrados().get(empleado)).getCapacidades().get(capacidad)+"¬";
								}
							}
							else { //En caso de que no hubiese capacidades aún a pesar de tratarse de un Empleado Técnico.
								linea_empleado+="";
							}
						// Finalmente, después de cada iteración con todo este proceso, imprimo la línea con las propiedades del empleado:
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
