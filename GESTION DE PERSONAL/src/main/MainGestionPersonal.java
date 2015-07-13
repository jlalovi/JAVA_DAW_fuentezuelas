package main;
import java.io.IOException;
import java.util.ArrayList;

import Empleados.*;
import GestionPersonal.Empresa;
import MetodosEstaticos.*;

/**
 * Clase principal de del ejercicio de evaluación 'GestionPersonal'.
 * 
 * <p>He minimizado los comentarios en este main para no 'ensuciar' el código que creo que es lo suficientemente
 * semántico como para hacerse de entender fácilmente sin necesidad de explicaciones extra.</p>
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 08/03/2015
 * @since 19/02/2015
 */
public class MainGestionPersonal {

	public static void main(String[] args) throws IOException {
		
		int opcion_menu=0;
			// propiedades necesarias para crear nuevos empleados
			String nombre;
			String ape1;
			String ape2;
			String dni;
			String centro_trabajo;
			String puesto_trabajo;
			ArrayList<String> capacidades;
		int opcion_listar_empleado=0;
		int opcion_empleados_borrados=0;
		
		System.out.println("PROYECTO EVALUABLE 2. GESTIÓN DE PERSONAL");
		System.out.println("=========================================\n");
		Empresa empresa= new Empresa();
		BaseDatosEmpleados.cargar(empresa); // Cargo la base de datos de los empleados "BaseDatosEmpleados.txt"
		do {
			opcion_menu=Integer.parseInt((Preguntar.opciones(
				"Menú principal. Gestión de personal de la empresa.\n"
			  + "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"
			  + "Elige una de las siguientes opciones introduciendo el número y presionando intro:\n"
			  + "  1.- Añadir empleados.\n"
			  + "  2.- Borrar empleados.\n"
			  + "  3.- Recuperar empleado borrado.\n"
			  + "  4.- Listar ficha de empleado.\n"
			  + "  5.- Buscar empleados.\n"
			  + "  6.- Listar empleados.\n"
			  + "  7.- Salir del programa.\n", "1,2,3,4,5,6,7")));
			
			//1.- Añadir empleados:
			if (opcion_menu==1){
				
				boolean añadir_empleado=true;
				do {
					
					// Controlo que no se inserten los caracteres '·' o '¬', para que sean de uso exclusivo
					// para el control de los archivos "BaseDatosEmpleados.txt" y "BaseDatosEmpleadosBorrados.txt"
					do {
						nombre=Preguntar.cadena("Nombre:", 20);
						System.out.println("Los caracteres '·' o '¬', no son válidos.");
					}while(nombre.indexOf('·')!=-1||nombre.indexOf('¬')!=-1);
					do {
						ape1=Preguntar.cadena("Primer apellido:", 20);
						System.out.println("Los caracteres '·' o '¬', no son válidos.");
					}while(ape1.indexOf('·')!=-1||ape1.indexOf('¬')!=-1);
					do {
						ape2=Preguntar.cadena("Segundo apellido:", 20);
						System.out.println("Los caracteres '·' o '¬', no son válidos.");
					}while(ape2.indexOf('·')!=-1||ape2.indexOf('¬')!=-1);
					
					
					do {
						dni=Preguntar.cadena("DNI:", 9);
						if (ComprobarDNI.tipoError(dni)==1)
							System.out.println("El DNI debe estar formado al menos por 2 caracteres. Introduce de nuevo un valor.");
						else if (ComprobarDNI.tipoError(dni)==2)
							System.out.println("Uno o más números del DNI NO son números, sino algún otro carácter. Introduce de nuevo un valor.");
						else if (ComprobarDNI.tipoError(dni)==3)
							System.out.println("No se ha introducido una letra al final del DNI. Introduce de nuevo un valor.");
						else if (ComprobarDNI.tipoError(dni)==4)
							System.out.println("La letra control del número del DNI no es correcta. Introduce de nuevo un valor.");
						else if (empresa.existeEmpleadoDNI(dni))
							System.out.println("El DNI introducido ya existe en la Base de Datos y este debe ser único por empleado. Introduce de nuevo un valor.");
					} while(ComprobarDNI.tipoError(dni)!=0 || empresa.existeEmpleadoDNI(dni));
					
					centro_trabajo=Preguntar.opciones("Centro de trabajo: 1, 2 o 3", "1,2,3");							
					puesto_trabajo=Preguntar.opciones("Puesto de trabajo: (ad)ministrativo, (p)rogramador, (an)alista o (b)ecario", "ad,AD,p,P,an,AN,b,B");
					
					if (puesto_trabajo.equalsIgnoreCase("ad")) { // Empleados administrativos
						puesto_trabajo = "Administrativo"; // Para que BaseDatosEmpleados.txt sea más legible
						empresa.añadirEmpleado(new Administrativo(nombre, ape1, ape2, dni, centro_trabajo));
					}
					
					else { //Empleados técnicos
						
						String capacidad="";
						capacidades = new ArrayList<String>();
						Tecnico empleado_nuevo;
						
						do {
							do {
								capacidad=Preguntar.cadena("Añadir capacidad: (Introduce '-' para dejar de añadir capacidades)", 20);
								System.out.println("Los caracteres '·' o '¬', no son válidos.");
							}while(capacidad.indexOf('·')!=-1||capacidad.indexOf('¬')!=-1);							
							if (!"-".equals(capacidad))
								capacidades.add(capacidad);
						}while(!"-".equals(capacidad)); // Parece ser que esto es mejor que '!capacidad.equals("-")', para evitar un 'NullPointerException' si capacidad=null (Aunque esto último también lo tengo controlado con el método 'Preguntar.cadena()')
						
						if (puesto_trabajo.equalsIgnoreCase("p")) { // programadores
							puesto_trabajo = "Programador"; // Para que BaseDatosEmpleados.txt sea más legible
							empleado_nuevo = new Programador(nombre, ape1, ape2, dni, centro_trabajo);
							empleado_nuevo.setCapacidades(capacidades);
							empresa.añadirEmpleado(empleado_nuevo);
						}
						
						else if (puesto_trabajo.equalsIgnoreCase("an")) { // analistas
							puesto_trabajo = "Analista"; // Para que BaseDatosEmpleados.txt sea más legible
							empleado_nuevo = new Analista(nombre, ape1, ape2, dni, centro_trabajo);
							empleado_nuevo.setCapacidades(capacidades);
							empresa.añadirEmpleado(empleado_nuevo);
						}
						
						else if (puesto_trabajo.equalsIgnoreCase("b")) { // becarios
							puesto_trabajo = "Becario"; // Para que BaseDatosEmpleados.txt sea más legible
							empleado_nuevo = new Becario(nombre, ape1, ape2, dni, centro_trabajo);
							empleado_nuevo.setCapacidades(capacidades);
							empresa.añadirEmpleado(empleado_nuevo);
						}								
					}
							
					if (Preguntar.siNo("¿Deseas añadir otro empleado? s/n").equalsIgnoreCase("n"))
						añadir_empleado=false;
					
				} while(añadir_empleado==true);

			}
			
			//2.- Borrar empleados:
			else if (opcion_menu==2){
				String dni_empleado_a_eliminar = Preguntar.cadena("Introduce el DNI completo del usuario que desea eliminar.", 9);
				boolean empleado_borrado;
				empleado_borrado = empresa.borrarEmpleado(dni_empleado_a_eliminar);
				if (empleado_borrado)
					System.out.println("El empleado ha sido borrado con exito.\n");
				else
					System.out.println("El dni '" + dni_empleado_a_eliminar + "' es erróneo o no corresponde con ninguno de los empleados almacenados en la BBDD.\n");
				Preguntar.continuar();
			}
			
			//3.- Recuperar empleado borrado:
			else if (opcion_menu==3){
				do {
					opcion_empleados_borrados=Integer.parseInt((Preguntar.opciones(
						"Menú 'Recuperar empleado borrado'.\n"
					  + "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"
					  + "Elige una de las siguientes opciones introduciendo el número y presionando intro:\n"
					  + "  1.- Listar empleados borrados alfabéticamente.\n"
					  + "  2.- Listar empleados borrados por DNI.\n"
					  + "  3.- Recuperar empleado borrado.\n"
					  + "  4.- Volver al menú principal.", "1,2,3,4")));
					
					//3.1.- Listar empleados borrados alfabéticamente.
					if (opcion_empleados_borrados==1) {
						System.out.println(empresa.listarEmpleadosBorradosNombre());
						Preguntar.continuar();
					}
					//3.2.- Listar empleados borrados por DNI.
					else if (opcion_empleados_borrados==2) {
						System.out.println(empresa.listarEmpleadosBorradosDNI());
						Preguntar.continuar();
					}
					//3.3.- Recuperar empleado borrado.
					else if (opcion_empleados_borrados==3) {
						String dni_empleado_a_recuperar = Preguntar.cadena("Introduce el DNI completo del usuario que desea recuperar.", 9);
						boolean empleado_recuperado;
						empleado_recuperado = empresa.recuperarEmpleado(dni_empleado_a_recuperar);
						if (empleado_recuperado)
							System.out.println("El empleado ha sido recuperado con exito.\n");
						else
							System.out.println("El dni '" + dni_empleado_a_recuperar + "' es erróneo o no corresponde con ninguno de los empleados almacenados en la BBDD de empleados borrados.\n");
					Preguntar.continuar();
					}
					
				//3.4.- Volver al menú principal.
				} while(opcion_empleados_borrados!=4);
			}
			
			//4.- Listar ficha de empleado:
			else if (opcion_menu==4){
				String dni_empleado_a_listar = Preguntar.cadena("Introduce el DNI del empleado de que quiere obtener su ficha", 9);
				System.out.println(empresa.buscarEmpleadoDNI(dni_empleado_a_listar));
				System.out.println("");
				Preguntar.continuar();
			}
			
			//5.- Buscar empleados:
			else if (opcion_menu==5){
				String fragmento_busqueda = Preguntar.cadena("Introduce el fragmento de búsqueda para buscar entre el nombre completo de los empleados", 10);
				System.out.println(empresa.buscarEmpleados(fragmento_busqueda));
				Preguntar.continuar();
			}
			
			//6.- Listar empleados:
			else if (opcion_menu==6){
				do {
					opcion_listar_empleado=Integer.parseInt((Preguntar.opciones(
						"Menú 'Listar empleados'.\n"
					  + "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"
					  + "Elige una de las siguientes opciones introduciendo el número y presionando intro:\n"
					  + "  1.- Listar alfabéticamente.\n"
					  + "  2.- Listar por DNI.\n"
					  + "  3.- Listar por nómina.\n"
					  + "  4.- Volver al menú principal.", "1,2,3,4")));
					
					//6.1.- Listar alfabéticamente.
					if (opcion_listar_empleado==1) {
						System.out.println(empresa.listarEmpleadosNombre());
					}
					//6.2.- Listar por DNI.
					else if (opcion_listar_empleado==2) {
						System.out.println(empresa.listarEmpleadosDNI());
					}
					//6.3.- Listar por nómina.
					else if (opcion_listar_empleado==3) {
						int año = Preguntar.intervalo("Año de la nómina (Entre el 2000 y el 3000)", 2000, 3000);
						int mes = Preguntar.intervalo("Mes de la nómina", 1, 12);
						System.out.println(empresa.listarEmpleadosNomina(mes, año));
					}
				
				//6.4.- Volver al menú principal.	
				} while(opcion_listar_empleado!=4);
			}
			
		//7.- Salir del programa:
		} while(opcion_menu!=7);
		
		if (Preguntar.siNo("¿Deseas salvar los cambios realizados? s/n").equalsIgnoreCase("s")) {
			BaseDatosEmpleados.salvarBorrados(empresa); // Guardo en "BaseDatosEmpleadosBorrados.txt" una copia de seguridad de los empleados borrados.
			BaseDatosEmpleados.salvarCambios(empresa); // Guardo en "BaseDatosEmpleados.txt" los cambios que se hayan realizado en empleados.
		}		
		
		System.out.println("¡Gracias por utilizar el programa!\n"
				+ "Javier Latorre - jlalovi@gmail.com");		

	}

}
