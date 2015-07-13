package main;
import java.io.IOException;
import java.util.ArrayList;

import Empleados.*;
import GestionPersonal.Empresa;
import MetodosEstaticos.*;

/**
 * Clase principal de del ejercicio de evaluaci�n 'GestionPersonal'.
 * 
 * <p>He minimizado los comentarios en este main para no 'ensuciar' el c�digo que creo que es lo suficientemente
 * sem�ntico como para hacerse de entender f�cilmente sin necesidad de explicaciones extra.</p>
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
		
		System.out.println("PROYECTO EVALUABLE 2. GESTI�N DE PERSONAL");
		System.out.println("=========================================\n");
		Empresa empresa= new Empresa();
		BaseDatosEmpleados.cargar(empresa); // Cargo la base de datos de los empleados "BaseDatosEmpleados.txt"
		do {
			opcion_menu=Integer.parseInt((Preguntar.opciones(
				"Men� principal. Gesti�n de personal de la empresa.\n"
			  + "��������������������������������������������������\n"
			  + "Elige una de las siguientes opciones introduciendo el n�mero y presionando intro:\n"
			  + "  1.- A�adir empleados.\n"
			  + "  2.- Borrar empleados.\n"
			  + "  3.- Recuperar empleado borrado.\n"
			  + "  4.- Listar ficha de empleado.\n"
			  + "  5.- Buscar empleados.\n"
			  + "  6.- Listar empleados.\n"
			  + "  7.- Salir del programa.\n", "1,2,3,4,5,6,7")));
			
			//1.- A�adir empleados:
			if (opcion_menu==1){
				
				boolean a�adir_empleado=true;
				do {
					
					// Controlo que no se inserten los caracteres '�' o '�', para que sean de uso exclusivo
					// para el control de los archivos "BaseDatosEmpleados.txt" y "BaseDatosEmpleadosBorrados.txt"
					do {
						nombre=Preguntar.cadena("Nombre:", 20);
						System.out.println("Los caracteres '�' o '�', no son v�lidos.");
					}while(nombre.indexOf('�')!=-1||nombre.indexOf('�')!=-1);
					do {
						ape1=Preguntar.cadena("Primer apellido:", 20);
						System.out.println("Los caracteres '�' o '�', no son v�lidos.");
					}while(ape1.indexOf('�')!=-1||ape1.indexOf('�')!=-1);
					do {
						ape2=Preguntar.cadena("Segundo apellido:", 20);
						System.out.println("Los caracteres '�' o '�', no son v�lidos.");
					}while(ape2.indexOf('�')!=-1||ape2.indexOf('�')!=-1);
					
					
					do {
						dni=Preguntar.cadena("DNI:", 9);
						if (ComprobarDNI.tipoError(dni)==1)
							System.out.println("El DNI debe estar formado al menos por 2 caracteres. Introduce de nuevo un valor.");
						else if (ComprobarDNI.tipoError(dni)==2)
							System.out.println("Uno o m�s n�meros del DNI NO son n�meros, sino alg�n otro car�cter. Introduce de nuevo un valor.");
						else if (ComprobarDNI.tipoError(dni)==3)
							System.out.println("No se ha introducido una letra al final del DNI. Introduce de nuevo un valor.");
						else if (ComprobarDNI.tipoError(dni)==4)
							System.out.println("La letra control del n�mero del DNI no es correcta. Introduce de nuevo un valor.");
						else if (empresa.existeEmpleadoDNI(dni))
							System.out.println("El DNI introducido ya existe en la Base de Datos y este debe ser �nico por empleado. Introduce de nuevo un valor.");
					} while(ComprobarDNI.tipoError(dni)!=0 || empresa.existeEmpleadoDNI(dni));
					
					centro_trabajo=Preguntar.opciones("Centro de trabajo: 1, 2 o 3", "1,2,3");							
					puesto_trabajo=Preguntar.opciones("Puesto de trabajo: (ad)ministrativo, (p)rogramador, (an)alista o (b)ecario", "ad,AD,p,P,an,AN,b,B");
					
					if (puesto_trabajo.equalsIgnoreCase("ad")) { // Empleados administrativos
						puesto_trabajo = "Administrativo"; // Para que BaseDatosEmpleados.txt sea m�s legible
						empresa.a�adirEmpleado(new Administrativo(nombre, ape1, ape2, dni, centro_trabajo));
					}
					
					else { //Empleados t�cnicos
						
						String capacidad="";
						capacidades = new ArrayList<String>();
						Tecnico empleado_nuevo;
						
						do {
							do {
								capacidad=Preguntar.cadena("A�adir capacidad: (Introduce '-' para dejar de a�adir capacidades)", 20);
								System.out.println("Los caracteres '�' o '�', no son v�lidos.");
							}while(capacidad.indexOf('�')!=-1||capacidad.indexOf('�')!=-1);							
							if (!"-".equals(capacidad))
								capacidades.add(capacidad);
						}while(!"-".equals(capacidad)); // Parece ser que esto es mejor que '!capacidad.equals("-")', para evitar un 'NullPointerException' si capacidad=null (Aunque esto �ltimo tambi�n lo tengo controlado con el m�todo 'Preguntar.cadena()')
						
						if (puesto_trabajo.equalsIgnoreCase("p")) { // programadores
							puesto_trabajo = "Programador"; // Para que BaseDatosEmpleados.txt sea m�s legible
							empleado_nuevo = new Programador(nombre, ape1, ape2, dni, centro_trabajo);
							empleado_nuevo.setCapacidades(capacidades);
							empresa.a�adirEmpleado(empleado_nuevo);
						}
						
						else if (puesto_trabajo.equalsIgnoreCase("an")) { // analistas
							puesto_trabajo = "Analista"; // Para que BaseDatosEmpleados.txt sea m�s legible
							empleado_nuevo = new Analista(nombre, ape1, ape2, dni, centro_trabajo);
							empleado_nuevo.setCapacidades(capacidades);
							empresa.a�adirEmpleado(empleado_nuevo);
						}
						
						else if (puesto_trabajo.equalsIgnoreCase("b")) { // becarios
							puesto_trabajo = "Becario"; // Para que BaseDatosEmpleados.txt sea m�s legible
							empleado_nuevo = new Becario(nombre, ape1, ape2, dni, centro_trabajo);
							empleado_nuevo.setCapacidades(capacidades);
							empresa.a�adirEmpleado(empleado_nuevo);
						}								
					}
							
					if (Preguntar.siNo("�Deseas a�adir otro empleado? s/n").equalsIgnoreCase("n"))
						a�adir_empleado=false;
					
				} while(a�adir_empleado==true);

			}
			
			//2.- Borrar empleados:
			else if (opcion_menu==2){
				String dni_empleado_a_eliminar = Preguntar.cadena("Introduce el DNI completo del usuario que desea eliminar.", 9);
				boolean empleado_borrado;
				empleado_borrado = empresa.borrarEmpleado(dni_empleado_a_eliminar);
				if (empleado_borrado)
					System.out.println("El empleado ha sido borrado con exito.\n");
				else
					System.out.println("El dni '" + dni_empleado_a_eliminar + "' es err�neo o no corresponde con ninguno de los empleados almacenados en la BBDD.\n");
				Preguntar.continuar();
			}
			
			//3.- Recuperar empleado borrado:
			else if (opcion_menu==3){
				do {
					opcion_empleados_borrados=Integer.parseInt((Preguntar.opciones(
						"Men� 'Recuperar empleado borrado'.\n"
					  + "����������������������������������\n"
					  + "Elige una de las siguientes opciones introduciendo el n�mero y presionando intro:\n"
					  + "  1.- Listar empleados borrados alfab�ticamente.\n"
					  + "  2.- Listar empleados borrados por DNI.\n"
					  + "  3.- Recuperar empleado borrado.\n"
					  + "  4.- Volver al men� principal.", "1,2,3,4")));
					
					//3.1.- Listar empleados borrados alfab�ticamente.
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
							System.out.println("El dni '" + dni_empleado_a_recuperar + "' es err�neo o no corresponde con ninguno de los empleados almacenados en la BBDD de empleados borrados.\n");
					Preguntar.continuar();
					}
					
				//3.4.- Volver al men� principal.
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
				String fragmento_busqueda = Preguntar.cadena("Introduce el fragmento de b�squeda para buscar entre el nombre completo de los empleados", 10);
				System.out.println(empresa.buscarEmpleados(fragmento_busqueda));
				Preguntar.continuar();
			}
			
			//6.- Listar empleados:
			else if (opcion_menu==6){
				do {
					opcion_listar_empleado=Integer.parseInt((Preguntar.opciones(
						"Men� 'Listar empleados'.\n"
					  + "������������������������\n"
					  + "Elige una de las siguientes opciones introduciendo el n�mero y presionando intro:\n"
					  + "  1.- Listar alfab�ticamente.\n"
					  + "  2.- Listar por DNI.\n"
					  + "  3.- Listar por n�mina.\n"
					  + "  4.- Volver al men� principal.", "1,2,3,4")));
					
					//6.1.- Listar alfab�ticamente.
					if (opcion_listar_empleado==1) {
						System.out.println(empresa.listarEmpleadosNombre());
					}
					//6.2.- Listar por DNI.
					else if (opcion_listar_empleado==2) {
						System.out.println(empresa.listarEmpleadosDNI());
					}
					//6.3.- Listar por n�mina.
					else if (opcion_listar_empleado==3) {
						int a�o = Preguntar.intervalo("A�o de la n�mina (Entre el 2000 y el 3000)", 2000, 3000);
						int mes = Preguntar.intervalo("Mes de la n�mina", 1, 12);
						System.out.println(empresa.listarEmpleadosNomina(mes, a�o));
					}
				
				//6.4.- Volver al men� principal.	
				} while(opcion_listar_empleado!=4);
			}
			
		//7.- Salir del programa:
		} while(opcion_menu!=7);
		
		if (Preguntar.siNo("�Deseas salvar los cambios realizados? s/n").equalsIgnoreCase("s")) {
			BaseDatosEmpleados.salvarBorrados(empresa); // Guardo en "BaseDatosEmpleadosBorrados.txt" una copia de seguridad de los empleados borrados.
			BaseDatosEmpleados.salvarCambios(empresa); // Guardo en "BaseDatosEmpleados.txt" los cambios que se hayan realizado en empleados.
		}		
		
		System.out.println("�Gracias por utilizar el programa!\n"
				+ "Javier Latorre - jlalovi@gmail.com");		

	}

}
