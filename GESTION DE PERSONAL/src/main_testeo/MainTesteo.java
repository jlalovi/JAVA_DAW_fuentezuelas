package main_testeo;

import java.io.IOException;

import Empleados.Administrativo;
import Empleados.Analista;
import Empleados.Becario;
import Empleados.Empleado;
import Empleados.Programador;
import Empleados.Tecnico;
import GestionPersonal.Empresa;
import MetodosEstaticos.BaseDatosEmpleados;

/**
 * ��IMPORTANTE!!
 * 
 * Esta clase principal la utilizo para hacer testeos de los m�todos creados en el proyecto 'GESTI�N DE PERSONAL'
 * 
 * Existen 2 Main m�s del programa que se encuentran en el paquete 'main':
 * - 'MainGestionPersonal.java': Ejecuta el programa en la consola.
 * - 'MainGestionPersonalGUI.java': Ejecuta el programa en una Interfaz Gr�fica.
 * 
 * @author Javier Latorre -> jlalovi@gmail.com
 * @version 15/05/2015
 * @since 19/02/2015
 */
public class MainTesteo {

	public static void main(String[] args) throws IOException {
		//TESTEO
		
//		//DNI
//		System.out.println(ComprobarDNI.esCorrecto("77349150n")); // DNI correcto
//		System.out.println(ComprobarDNI.esCorrecto("77349150N")); // DNI correcto
//		System.out.println(ComprobarDNI.esCorrecto("77349150f")); // DNI incorrecto
//		
//		System.out.println(ComprobarDNI.tipoError("77349150f"));  // DNI incorrecto ERROR 4
//		System.out.println(ComprobarDNI.tipoError("77349150"));   // DNI incorrecto ERROR 3
//		System.out.println(ComprobarDNI.tipoError("77E49150n"));  // DNI incorrecto ERROR 2
//		System.out.println(ComprobarDNI.tipoError("773491500n")); // DNI incorrecto ERROR 1
//		System.out.println(ComprobarDNI.tipoError(""));           // DNI incorrecto ERROR 1
//		System.out.println(ComprobarDNI.tipoError("77349150n"));  // DNI incorrecto ERROR 0
//		
//		//FECHA
//		System.out.println(Fecha.diasEn(2, 1600)); // 29 d�as
//		System.out.println(Fecha.diasEn(2, 2000)); // 29 d�as
//		System.out.println(Fecha.diasEn(2, 1900)); // 28 d�as
//		System.out.println(Fecha.diasEn(2, 2100)); // 28 d�as
//		System.out.println(Fecha.diasEn(2, 2015)); // 28 d�as
//		System.out.println(Fecha.diasEn(1, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(3, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(4, 2015)); // 30 d�as
//		System.out.println(Fecha.diasEn(5, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(6, 2015)); // 30 d�as
//		System.out.println(Fecha.diasEn(7, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(8, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(9, 2015)); // 30 d�as
//		System.out.println(Fecha.diasEn(10, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(11, 2015)); // 30 d�as
//		System.out.println(Fecha.diasEn(12, 2015)); // 31 d�as
//		System.out.println(Fecha.diasEn(13, 2015)); // 0 d�as
//		
		//EMPLEADOS (Con dni correcto comprobado)
		Administrativo e1 = new Administrativo("Pepe","Moreno","Rubio", "11111111H", "1");
		Tecnico e2 = new Programador("Josefa","L�pez","Pereira", "22222222J", "1");
		Tecnico e3 = new Analista("Laura","Ru�z","de la Casa", "33333333P", "1");
		Tecnico e4 = new Becario("Miguel","Latorre","Ramiro", "44444444A", "1");
		Tecnico e5 = new Becario("Antonio","Puebla","Domingo", "55555555K", "1");
		Administrativo e6 = new Administrativo("Manuel","Moreno","Rubio", "66666666Q", "1");
		Tecnico e7 = new Programador("Ra�l","L�pez","Ru�z", "77777777B", "1");
		Tecnico e8 = new Analista("Gema","Ru�z","de la Casa", "88888888Y", "1");
		Tecnico e9 = new Becario("Antonio","Ru�z","Carrasco", "99999999R", "1");
		Tecnico e10 = new Becario("Catarina","Puebla","Domingo", "12345678Z", "1");
		
		//CAPACIDADES EN T�CNICOS
		e2.setCapacidades("PHP", "JavaScript", "JAVA", "C++", "Ruby", "Rails", "SCSS", "HTML & CSS", "GitHub");
		e3.setCapacidades("Photoshop","PHP", "JavaScript", "JAVA", "C++", "SCSS", "HTML & CSS", "GitHub", "Project Manager");
		e4.setCapacidades("Photoshop", "SCSS", "HTML & CSS", "GitHub");
		e5.setCapacidades("JavaScript", "SCSS", "HTML & CSS", "GitHub");
		e7.setCapacidades("PHP", "JavaScript", "JAVA", "C++", "Ruby", "Rails", "SCSS", "HTML & CSS", "GitHub");
		e8.setCapacidades("PHP", "JavaScript", "JAVA", "C++", "Ruby", "Rails", "SCSS", "HTML & CSS", "GitHub", "Project Manager");
		e9.setCapacidades("PHP", "JavaScript", "HTML & CSS", "GitHub");
		e10.setCapacidades("JavaScript", "Photoshop", "HTML & CSS", "GitHub");

		
		
		//EMPRESA (A�ADIR EMPLEADOS)
		Empresa empresa_prueba = new Empresa();
		empresa_prueba.a�adirEmpleado(e1);
		empresa_prueba.a�adirEmpleado(e2);
		empresa_prueba.a�adirEmpleado(e3);
		empresa_prueba.a�adirEmpleado(e4);
		empresa_prueba.a�adirEmpleado(e5);
		empresa_prueba.a�adirEmpleado(e6);
		empresa_prueba.a�adirEmpleado(e7);
		empresa_prueba.a�adirEmpleado(e8);
		empresa_prueba.a�adirEmpleado(e9);
		empresa_prueba.a�adirEmpleado(e10);

//		// Prueba de comprobaci�n de subclase
//		Empleado e_temp = empresa_prueba.getEmpleados().get(empresa_prueba.posicionEmpleadoDNI("22222222J"));
//		Empleado e_temp2 = empresa_prueba.getEmpleados().get(empresa_prueba.posicionEmpleadoDNI("11111111H"));
//		
//		System.out.println("Es "+ e_temp.getClass().getSuperclass().getSimpleName()); // Devuelve "T�cnico"
//		System.out.println("Es "+ e_temp.getClass().getSimpleName()); // Devuelve "Programador"
//		
//		System.out.println("No es t�cnico");
//		if (e_temp2.getClass().getSuperclass().getSimpleName().equals("Tecnico"))
//			System.out.println("true");
//		else
//			System.out.println("false");
//        
//			
//		// Pueba de casting de empleado a t�cnico utilizando una variable de tipo t�cnico temporal:
//		
//		Tecnico tec_temp = (Tecnico) empresa_prueba.getEmpleados().get(empresa_prueba.posicionEmpleadoDNI("22222222J"));
//		tec_temp.a�adirCapacidad("capacidad_nueva");
		
		// Comprobaci�n m�todo split
		String seleccion = "11/2014";
		System.out.println(seleccion.indexOf('/'));
		String[] mes_a�o= seleccion.split("/");
		System.out.println(mes_a�o[0] + " " + mes_a�o[1]); // 11 2014

		
		
//		//IMPRESIONES POR PANTALLA DE OBJETO EMPLEADO
//		System.out.println(e1.toString());
//		System.out.println(e1.toStringDNI());
//		System.out.println(e1.toStringNomina(2, 2000));
//		System.out.println(e1.mostrarDatosCompletos());
//		System.out.println(e2.mostrarDatosCompletos());
//		System.out.println(e3.mostrarDatosCompletos());
//		System.out.println(e4.mostrarDatosCompletos());
//		System.out.println(e5.mostrarDatosCompletos());
//		System.out.println(e6.mostrarDatosCompletos());
//		System.out.println(e7.mostrarDatosCompletos());
//		System.out.println(e8.mostrarDatosCompletos());
//		System.out.println(e9.mostrarDatosCompletos());
//		System.out.println(e10.mostrarDatosCompletos());
//				
//		//LISTADOS:
//		System.out.println("Ordenados por Nombre:");
//		System.out.println(empresa_prueba.listarEmpleadosNombre());
//		System.out.println("Ordenados por DNI:");
//		System.out.println(empresa_prueba.listarEmpleadosDNI());
//		System.out.println("Ordenados por N�mina:");
//		System.out.println(empresa_prueba.listarEmpleadosNomina(3, 2015));
//		
//		//B�SQUEDAS:
//		System.out.println(empresa_prueba.buscarEmpleadoDNI("12345678Z"));
//		System.out.println(empresa_prueba.buscarEmpleadoDNI("66666666Q"));
//		System.out.println(empresa_prueba.buscarEmpleadoDNI("44444444a"));
//		System.out.println(empresa_prueba.buscarEmpleadoDNI("44444444c"));
//		System.out.println(empresa_prueba.buscarEmpleados("l�"));
//		System.out.println(empresa_prueba.buscarEmpleados("lo"));
//		System.out.println(empresa_prueba.buscarEmpleados("IZ"));
//		System.out.println(empresa_prueba.buscarEmpleados("antonio"));
//		System.out.println(empresa_prueba.buscarEmpleados("RU"));
//		
//		//BORRAR-RECUPERAR EMPLEADOS:
//		System.out.println("Empleados borrados:");
//		System.out.println(empresa_prueba.borrarEmpleado("12345678Z")); //true
//		System.out.println(empresa_prueba.borrarEmpleado("12345678Z")); //false
//		System.out.println(empresa_prueba.borrarEmpleado("11111111H")); //true
//		System.out.println(empresa_prueba.borrarEmpleado("22222222J")); //true
//		System.out.println("por dni:");
//		System.out.println(empresa_prueba.listarEmpleadosBorradosDNI());
//		System.out.println("por nombre:");
//		System.out.println(empresa_prueba.listarEmpleadosBorradosNombre());
//		System.out.println("No borrados por dni:");
//		System.out.println(empresa_prueba.listarEmpleadosDNI());
//		
//		System.out.println("Recuperar empleado '12345678Z':");
//		System.out.println(empresa_prueba.recuperarEmpleado("12345678Z")); //true
//		System.out.println(empresa_prueba.recuperarEmpleado("12345678Z")); //false
//		System.out.println("listado borrados por DNI:");
//		System.out.println(empresa_prueba.listarEmpleadosBorradosDni());
//		System.out.println("No borrados por dni:");
//		System.out.println(empresa_prueba.listarEmpleadosDNI());

	}

}
